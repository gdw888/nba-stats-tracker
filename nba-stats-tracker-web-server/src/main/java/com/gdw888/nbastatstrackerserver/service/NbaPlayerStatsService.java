package com.gdw888.nbastatstrackerserver.service;

import com.gdw888.nbastatstrackerserver.entity.NbaPlayerInfo;
import com.gdw888.nbastatstrackerserver.entity.NbaPlayerStats;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NbaPlayerStatsService {

    private final DynamoDbTable<NbaPlayerStats> nbaPlayerStatsTable;

    public NbaPlayerStatsService(DynamoDbEnhancedClient dynamoDbEnhancedClient, @Value("${dynamo.tables.nba-player-stats}") String nbaPlayerStatsTableName) {
        this.nbaPlayerStatsTable = dynamoDbEnhancedClient.table(nbaPlayerStatsTableName, TableSchema.fromBean(NbaPlayerStats.class));
    }

    public List<NbaPlayerStats> getAllNbaPlayerStats() {
        return StreamSupport.stream(nbaPlayerStatsTable.scan().items().spliterator(), false)
                .collect(Collectors.toList());
    }

    public NbaPlayerStats getNbaPlayerStats(String playerName, String date) {
        return nbaPlayerStatsTable.getItem(r -> r.key(k -> k.partitionValue(playerName).sortValue(date)));
    }

    public void saveNbaPlayerStats(NbaPlayerStats playerStats) {
        nbaPlayerStatsTable.putItem(playerStats);
    }

    public void deleteNbaPlayerStats(NbaPlayerStats playerStats) {
        nbaPlayerStatsTable.deleteItem(playerStats);
    }

    public void deleteNbaPlayerStatsByPlayerNameAndDate(String playerName, String date) {
        NbaPlayerStats playerStats = new NbaPlayerStats();
        playerStats.setPlayerName(playerName);
        playerStats.setDate(date);
        nbaPlayerStatsTable.deleteItem(playerStats);
    }
}