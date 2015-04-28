package com.cloudmunch.demo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * DataAccess.
 *
 * Created by hugo on 4/24/15.
 */
public class DataAccess implements IDataAccess {
    /**
     * connectionSource.
     */
    private ConnectionSource connectionSource = null;

    /**
     * dao.
     */
    private Dao<LogMessage, Integer> dao = null;

    /**
     * DataAccess.
     *
     * @throws SQLException this is an exception
     */
    public DataAccess() throws SQLException {
        connectionSource = new JdbcConnectionSource(
                "jdbc:mysql://localhost/restlogger"
        );

        ((JdbcConnectionSource) connectionSource).setUsername("root");
        ((JdbcConnectionSource) connectionSource).setPassword("cloudmunch");

        dao = DaoManager.createDao(connectionSource, LogMessage.class);
    }

    /**
     * insertLogMessage.
     * @param msg the message
     * @return true if OK
     * @throws SQLException an exception
     */
    @Override
    public final boolean insertLogMessage(final LogMessage msg)
            throws SQLException {
        dao.create(msg);

        return true;
    }

    /**
     * dump.
     * @param appName The name of the app
     * @return all log messages
     */
    @Override
    public final List<LogMessage> dump(final String appName) {
        return null;
    }
}
