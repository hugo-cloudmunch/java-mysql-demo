package com.cloudmunch.demo;

import com.google.gson.Gson;
import java.sql.SQLException;

public class RestLogger {
	private static final Gson gson = new Gson();
    private static IDataAccess dataAccess;

    public RestLogger() throws SQLException {
        dataAccess = new DataAccess();
    }

    public RestLogger(IDataAccess dataAccess){
        this.dataAccess = dataAccess;
    }

	public String echo(String param){
		return param;
	}

	public boolean info(String jsonMsg) throws SQLException {
		LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.INFO.toString());

        dataAccess.insertLogMessage(message);

        return true;
	}

	public boolean warn(String jsonMsg) throws SQLException {
        LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.WARN.toString());

        dataAccess.insertLogMessage(message);

        return true;
	}

	public boolean error(String jsonMsg) throws SQLException {
        LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.ERROR.toString());

        System.out.println(gson.toJson(message));

        dataAccess.insertLogMessage(message);

        return true;}

	public boolean fatal(String jsonMsg) throws SQLException {
        LogMessage message = gson.fromJson(jsonMsg, LogMessage.class);

        message.setLevel(LogLevels.FATAL.toString());

        System.out.println(gson.toJson(message));

        dataAccess.insertLogMessage(message);

        return true;}
}
