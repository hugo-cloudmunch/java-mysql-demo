package com.cloudmunch.demo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "LogMessage")
public class LogMessage {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "level")
    private String level;
    @DatabaseField(columnName="message")
    private String message;
    @DatabaseField(columnName = "appName")
    private String appName;
    @DatabaseField(columnName = "timestamp", canBeNull = true)
    private Date timestamp;

    public LogMessage(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
