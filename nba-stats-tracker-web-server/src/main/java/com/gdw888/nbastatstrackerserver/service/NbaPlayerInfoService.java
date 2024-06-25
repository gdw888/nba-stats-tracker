package com.gdw888.nbastatstrackerserver.service;

import com.gdw888.nbastatstrackerserver.entity.NbaPlayerInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NbaPlayerInfoService {

    private final DynamoDbTable<NbaPlayerInfo> nbaPlayerInfoTable;

    public NbaPlayerInfoService(DynamoDbEnhancedClient dynamoDbEnhancedClient, @Value("${dynamo.tables.nba-player-info}") String nbaPlayerInfoTableName) {
        this.nbaPlayerInfoTable = dynamoDbEnhancedClient.table(nbaPlayerInfoTableName, TableSchema.fromBean(NbaPlayerInfo.class));
    }

    public List<NbaPlayerInfo> getAllNbaPlayerInfo() {
        return StreamSupport.stream(nbaPlayerInfoTable.scan().items().spliterator(), false)
                .collect(Collectors.toList());
    }

    public NbaPlayerInfo getNbaPlayerInfo(String playerName) {
        return nbaPlayerInfoTable.getItem(r -> r.key(k -> k.partitionValue(playerName)));
    }

    public void saveNbaPlayerInfo(NbaPlayerInfo playerInfo) {
        nbaPlayerInfoTable.putItem(playerInfo);
    }

    public void deleteNbaPlayerInfo(NbaPlayerInfo playerInfo) {
        nbaPlayerInfoTable.deleteItem(playerInfo);
    }

    public void deleteNbaPlayerInfoByPlayerName(String playerName) {
        NbaPlayerInfo playerInfo = new NbaPlayerInfo();
        playerInfo.setPlayerName(playerName);
        nbaPlayerInfoTable.deleteItem(playerInfo);
    }
}