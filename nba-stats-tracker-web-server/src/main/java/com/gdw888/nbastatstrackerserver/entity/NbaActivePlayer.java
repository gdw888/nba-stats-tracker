package com.gdw888.nbastatstrackerserver.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class NbaActivePlayer {

    private String name;
    private String url;

    public NbaActivePlayer() {}

    public NbaActivePlayer(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @DynamoDbPartitionKey
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
