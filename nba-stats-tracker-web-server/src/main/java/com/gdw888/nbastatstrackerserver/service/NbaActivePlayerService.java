package com.gdw888.nbastatstrackerserver.service;

import com.gdw888.nbastatstrackerserver.entity.NbaActivePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class NbaActivePlayerService {

    @Value("${dynamo.tables.nba-active-players}")
    private String nbaActivePlayerTable;

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public List<NbaActivePlayer> getAllActivePlayers() {
        try {
            DynamoDbTable<NbaActivePlayer> table = dynamoDbEnhancedClient.table(nbaActivePlayerTable, TableSchema.fromBean(NbaActivePlayer.class));
            return StreamSupport.stream(table.scan().items().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error fetching data from DynamoDB", e);
        }
    }

    public NbaActivePlayer getActivePlayer(NbaActivePlayer activePlayerName) {
        try {
            DynamoDbTable<NbaActivePlayer> table = dynamoDbEnhancedClient.table(nbaActivePlayerTable, TableSchema.fromBean(NbaActivePlayer.class));
            return table.getItem(activePlayerName);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error fetching data from DynamoDB", e);
        }
    }

    public void saveActivePlayer(NbaActivePlayer nbaActivePlayer) {
        try {
            DynamoDbTable<NbaActivePlayer> table = dynamoDbEnhancedClient.table(nbaActivePlayerTable, TableSchema.fromBean(NbaActivePlayer.class));
            table.putItem(nbaActivePlayer);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error saving data to DynamoDB", e);
        }
    }

    public void deleteActivePlayerByName(String nbaActivePlayer) {
        try {
            NbaActivePlayer deletePlayer = new NbaActivePlayer(nbaActivePlayer,"");
            DynamoDbTable<NbaActivePlayer> table = dynamoDbEnhancedClient.table(nbaActivePlayerTable, TableSchema.fromBean(NbaActivePlayer.class));
            table.deleteItem(deletePlayer);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error saving data to DynamoDB", e);
        }
    }
}