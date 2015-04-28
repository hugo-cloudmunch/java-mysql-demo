package com.cloudmunch.demo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * LogMessage.
 */
@DatabaseTable(tableName = "LogMessage")
public class LogMessage {
    /**
     * id.
     */
    @DatabaseField(generatedId = true)
    private int id;

    /**
     * level.
     */
    @DatabaseField(columnName = "level")
    private String level;

    /**
     * message.
     */
    @DatabaseField(columnName = "message")
    private String message;

    /**
     * appName.
     */
    @DatabaseField(columnName = "appName")
    private String appName;

    /**
     * timestamp.
     */
    @DatabaseField(columnName = "timestamp", canBeNull = true)
    private Date timestamp;

    /**
     * LogMessage.
     */
    public LogMessage() {
    }

    /**
     * getId.
     * @return int
     */
    public final int getId() {
        return id;
    }

    /**
     * setId.
     * @param msgID message Id
     */
    public final void setId(final int msgID) {
        this.id = msgID;
    }

    /**
     * getLevel.
     * @return String
     */
    public final String getLevel() {
        return level;
    }

    /**
     * setLevel.
     * @param msgLevel message level
     */
    public final void setLevel(final String msgLevel) {
        this.level = msgLevel;
    }

    /**
     * getMessage.
     * @return String
     */
    public final String getMessage() {
        return message;
    }

    /**
     * setMessage.
     * @param msgText message Text
     */
    public final void setMessage(final String msgText) {
        this.message = msgText;
    }

    /**
     * getAppName.
     * @return String
     */
    public final String getAppName() {
        return appName;
    }

    /**
     * setAppName.
     * @param msgAppName Message App Name
     */
    public final void setAppName(final String msgAppName) {
        this.appName = msgAppName;
    }

    /**
     * getTimestamp.
     * @return Date
     */
    public final Date getTimestamp() {
        return timestamp;
    }

    /**
     * setTimestamp.
     * @param msgTimeStamp message timestamp
     */
    public final void setTimestamp(final Date msgTimeStamp) {
        this.timestamp = msgTimeStamp;
    }
}
