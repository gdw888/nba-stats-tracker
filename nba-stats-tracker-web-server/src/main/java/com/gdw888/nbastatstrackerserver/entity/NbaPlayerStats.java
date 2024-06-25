package com.gdw888.nbastatstrackerserver.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class NbaPlayerStats {
    private String playerName;
    private String date;
    private String assists;
    private String blocks;
    private String defensiveRebounds;
    private String fieldGoals;
    private String fieldGoalAttempts;
    private String fieldGoalPercentage;
    private String freeThrows;
    private String freeThrowAttempts;
    private String freeThrowPercentage;
    private String gameScore;
    private String minutesPlayed;
    private String offensiveRebounds;
    private String opponent;
    private String personalFouls;
    private String plusMinus;
    private String points;
    private String result;
    private String steals;
    private String team;
    private String threePointFieldGoals;
    private String threePointFieldGoalAttempts;
    private String threePointFieldGoalPercentage;
    private String totalRebounds;
    private String turnovers;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("player_name")
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDbAttribute("assists")
    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    @DynamoDbAttribute("blocks")
    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    @DynamoDbAttribute("defensive_rebounds")
    public String getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(String defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    @DynamoDbAttribute("field_goals")
    public String getFieldGoals() {
        return fieldGoals;
    }

    public void setFieldGoals(String fieldGoals) {
        this.fieldGoals = fieldGoals;
    }

    @DynamoDbAttribute("field_goal_attempts")
    public String getFieldGoalAttempts() {
        return fieldGoalAttempts;
    }

    public void setFieldGoalAttempts(String fieldGoalAttempts) {
        this.fieldGoalAttempts = fieldGoalAttempts;
    }

    @DynamoDbAttribute("field_goal_percentage")
    public String getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(String fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    @DynamoDbAttribute("free_throws")
    public String getFreeThrows() {
        return freeThrows;
    }

    public void setFreeThrows(String freeThrows) {
        this.freeThrows = freeThrows;
    }

    @DynamoDbAttribute("free_throw_attempts")
    public String getFreeThrowAttempts() {
        return freeThrowAttempts;
    }

    public void setFreeThrowAttempts(String freeThrowAttempts) {
        this.freeThrowAttempts = freeThrowAttempts;
    }

    @DynamoDbAttribute("free_throw_percentage")
    public String getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(String freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    @DynamoDbAttribute("game_score")
    public String getGameScore() {
        return gameScore;
    }

    public void setGameScore(String gameScore) {
        this.gameScore = gameScore;
    }

    @DynamoDbAttribute("minutes_played")
    public String getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(String minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    @DynamoDbAttribute("offensive_rebounds")
    public String getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(String offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    @DynamoDbAttribute("opponent")
    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    @DynamoDbAttribute("personal_fouls")
    public String getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(String personalFouls) {
        this.personalFouls = personalFouls;
    }

    @DynamoDbAttribute("plus_minus")
    public String getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(String plusMinus) {
        this.plusMinus = plusMinus;
    }

    @DynamoDbAttribute("points")
    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @DynamoDbAttribute("result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @DynamoDbAttribute("steals")
    public String getSteals() {
        return steals;
    }

    public void setSteals(String steals) {
        this.steals = steals;
    }

    @DynamoDbAttribute("team")
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @DynamoDbAttribute("three_point_field_goals")
    public String getThreePointFieldGoals() {
        return threePointFieldGoals;
    }

    public void setThreePointFieldGoals(String threePointFieldGoals) {
        this.threePointFieldGoals = threePointFieldGoals;
    }

    @DynamoDbAttribute("three_point_field_goal_attempts")
    public String getThreePointFieldGoalAttempts() {
        return threePointFieldGoalAttempts;
    }

    public void setThreePointFieldGoalAttempts(String threePointFieldGoalAttempts) {
        this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
    }

    @DynamoDbAttribute("three_point_field_goal_percentage")
    public String getThreePointFieldGoalPercentage() {
        return threePointFieldGoalPercentage;
    }

    public void setThreePointFieldGoalPercentage(String threePointFieldGoalPercentage) {
        this.threePointFieldGoalPercentage = threePointFieldGoalPercentage;
    }

    @DynamoDbAttribute("total_rebounds")
    public String getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(String totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    @DynamoDbAttribute("turnovers")
    public String getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(String turnovers) {
        this.turnovers = turnovers;
    }
}