package com.cloudmunch.demo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class RestLoggerTest
{
    private static IDataAccess dataAccess;
    private RestLogger restLogger;

    @BeforeClass
    public static void setup(){
        IDataAccess dataAccess = mock(DataAccess.class);
    }


    @Before
    public void beforeEachTest() throws SQLException {

        restLogger = new RestLogger(dataAccess);
    }


    @Test
    public void echo_returnsSameString_returnsSameString(){
        String echoMessage = "This is a Message";

        String returnedString = restLogger.echo(echoMessage);

        assertEquals(echoMessage, returnedString);
    }

    @Test
    public void info_getsJsonPayloadAndStoresIt_returnsTrue() throws SQLException {
        IDataAccess da = mock(DataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.INFO.toString());

        when(da.insertLogMessage(logMessage)).thenReturn(true);

        restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\", \"message\": \"Test Message\" }");

        assertTrue(returned);
    }

    @Test
    public void warn_getsJsonPayloadAndStoresIt_returnsTrue() throws SQLException {
        IDataAccess da = mock(DataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.WARN.toString());

        when(da.insertLogMessage(logMessage)).thenReturn(true);

        restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\", \"message\": \"Test Message\" }");

        assertTrue(returned);
    }

    @Test
    public void error_getsJsonPayloadAndStoresIt_returnsTrue() throws SQLException {
        IDataAccess da = mock(DataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.ERROR.toString());

        when(da.insertLogMessage(logMessage)).thenReturn(true);

        restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\", \"message\": \"Test Message\" }");

        assertTrue(returned);
    }

    @Test
    public void fatal_getsJsonPayloadAndStoresIt_returnsTrue() throws SQLException {
        IDataAccess da = mock(DataAccess.class);
        LogMessage logMessage = new LogMessage();

        logMessage.setAppName("RestLogger");
        logMessage.setMessage("Test Message");
        logMessage.setLevel(LogLevels.FATAL.toString());

        when(da.insertLogMessage(logMessage)).thenReturn(true);

        restLogger = new RestLogger(da);

        Boolean returned = restLogger.info("{ \"appName\": \"RestLogger\", \"message\": \"Test Message\" }");

        assertTrue(returned);
    }


}
