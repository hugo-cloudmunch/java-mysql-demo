package com.cloudmunch.demo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hugo on 4/24/15.
 */
public interface IDataAccess {
    boolean insertLogMessage(LogMessage msg) throws SQLException;
    List<LogMessage> dump(String appName);
}
