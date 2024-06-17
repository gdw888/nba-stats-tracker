package com.gdw888.nbastatstrackerserver.service;

import com.gdw888.nbastatstrackerserver.entity.NbaActivePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class NbaActivePlayerService {

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public List<NbaActivePlayer> getData() {
        try {
            DynamoDbTable<NbaActivePlayer> table = dynamoDbEnhancedClient.table("nba_active_player", TableSchema.fromBean(NbaActivePlayer.class));
            return StreamSupport.stream(table.scan().items().spliterator(), false)
                    .collect(Collectors.toList());
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error fetching data from DynamoDB", e);
        }
    }

    public void saveData(NbaActivePlayer nbaActivePlayer) {
        try {
            DynamoDbTable<NbaActivePlayer> table = dynamoDbEnhancedClient.table("nba_active_player", TableSchema.fromBean(NbaActivePlayer.class));
            table.putItem(nbaActivePlayer);
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error saving data to DynamoDB", e);
        }
    }
}