package com.cloudmunch.demo;

import com.google.gson.Gson;

import java.sql.SQLException;

/**
 * RestLogger.
 */
public class RestLogger {
    /**
     * gson.
     */
    private final Gson gson = new Gson();

    /**
     * dataAccess.
     */
    private static IDataAccess dataAccess;

    /**
     * RestLogger.
     * @throws SQLException an exception
     */
    public RestLogger() throws SQLException {
        dataAccess = new DataAccess();
    }

    /**
     * RestLogger.
     * @param loggerDataAccess dataAccess.
     */
    public RestLogger(final IDataAccess loggerDataAccess) {
        this.dataAccess = loggerDataAccess;
    }

    /**
     * echo.
     * @param param The param
     * @return what you sent
     */
    public final String echo(final String param) {
        return param;
    }

    /**
     * info.
     * @param jsonMsg The message
     * @return True if OK
     * @throws SQLException an exception
     */
    public final boolean info(final String jsonMsg) throws SQLException {
        LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.INFO.toString());

        dataAccess.insertLogMessage(message);

        return true;
    }

    /**
     * warn.
     * @param jsonMsg the message
     * @return True if OK
     * @throws SQLException an exception
     */
    public final  boolean warn(final String jsonMsg) throws SQLException {
        LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.WARN.toString());

        dataAccess.insertLogMessage(message);

        return true;
    }

    /**
     * error.
     * @param jsonMsg the message
     * @return True if OK
     * @throws SQLException an exception
     */
    public final boolean error(final String jsonMsg) throws SQLException {
        LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.ERROR.toString());

        System.out.println(gson.toJson(message));

        dataAccess.insertLogMessage(message);

        return true;
    }

    /**
     * fatal.
     * @param jsonMsg the message
     * @return True if OK
     * @throws SQLException an exception
     */
    public final boolean fatal(final String jsonMsg) throws SQLException {
        LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.FATAL.toString());

        System.out.println(gson.toJson(message));

        dataAccess.insertLogMessage(message);

        return true;
    }
}
