package com.cloudmunch.demo;

import java.sql.SQLException;
import java.util.List;

/**
 *  IDataAccess.
 */
public interface IDataAccess {

    /**
     * insertLogMessage.
     *
     * @param msg The message
     * @return True if OK
     * @throws SQLException an exception
     */
    boolean insertLogMessage(LogMessage msg) throws SQLException;

    /**
     * dump.
     *
     * @param appName The name of the app
     * @return A list of log messages
     */
    List<LogMessage> dump(String appName);
}
