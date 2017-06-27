package com.epam.services;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;


/**
 * Created by Администратор on 27.05.2017.
 */
public class ConnectionFactory {
    private static ConnectionFactory instance = null;
    private List<Connection> connections;
    private ResourceBundle properties = null;
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ConnectionFactory.class);
    private static final int SIZE = 100;

    /**
     * Getting manager object
     *
     * @return Manager object
     */
    public synchronized static ConnectionFactory getInstance() {
        if (instance == null)
            instance = new ConnectionFactory();
        return instance;
    }

    /**
     * Creating queue connections to the database
     */
    private ConnectionFactory() {

        properties = ResourceBundle.getBundle("settings");
        connections = new ArrayList<Connection>();
        String url = properties.getString("url");
        String user = properties.getString("user");
        String password = properties.getString("password");

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            for (int i = 0; i < SIZE; i++) {
                try {
                    connections.add(
                            DriverManager.getConnection(url, user, password));
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        } catch (SQLException e1) {
            logger.error(e1);
        }

    }

    /**
     * Getting the connection to database from queue
     *
     * @return Database connection
     */
    public synchronized Connection getConnection() {
        if (connections.size() != 0) {
            return connections.remove(0);
        }else {

        }
        return null;
    }

    /**
     * Placing the connection to the database in queue
     *
     * @param cn Database connection
     */
    public synchronized void putConnection(Connection cn) {
        if (connections.size() < 10)
            connections.add(cn);
    }
}
