package com.cloudmunch.demo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hugo on 4/24/15.
 */
public class DataAccess implements IDataAccess {
    ConnectionSource connectionSource = null;
    Dao<LogMessage, Integer> dao = null;

    public DataAccess() throws SQLException {
        connectionSource = new JdbcConnectionSource("jdbc:mysql://localhost/restlogger");

        ((JdbcConnectionSource)connectionSource).setUsername("root");
        ((JdbcConnectionSource)connectionSource).setPassword("cloudmunch");

        dao = DaoManager.createDao(connectionSource, LogMessage.class);
    }

    @Override
    public boolean insertLogMessage(LogMessage msg) throws SQLException {
        dao.create(msg);

        return true;
    }

    @Override
    public List<LogMessage> dump(String appName) {
        return null;
    }
}
