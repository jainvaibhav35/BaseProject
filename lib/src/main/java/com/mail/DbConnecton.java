package com.mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class DbConnecton {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://173.237.190.11/";
    static final String DB_NAME = "lptpltk_marketing_data";

    // Database credentials
    static final String USER = "lptpltk_travel_2";
    static final String PASS = "travel@123";
    ArrayList<AppData> listAppData;

    /**
     * Method to get the AppDetails form DB
     *
     * @return
     */
    public AppData getAppDetails() {

        int position = 0;
        getEntriesFromDB();

        if (listAppData != null && listAppData.size() > 0) {
            position = getRandomNumberInRange(0, listAppData.size() - 1);
            return listAppData.get(position);
        } else {
            return null;
        }

    }

    /**
     * Method to generate a random number between range min to max
     *
     * @param min -- min value of random number
     * @param max -- max value of random number
     * @return -- Generated Number
     */

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Method to get Entries from Database
     */

    private void getEntriesFromDB() {

        Connection conn = null;
        Statement statement = null;
        listAppData = new ArrayList<AppData>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            // Connecting to database
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);

            // Creating Statement
            statement = conn.createStatement();

            // SQL Query
            String sql = "SELECT * FROM marketing_data";

            ResultSet resultset = statement.executeQuery(sql);

            // Extract data from result set

            // Retrieve by column name

            while (resultset.next()) {

                listAppData.add(new AppData(resultset.getInt("id"), resultset
                        .getString("app_name"),
                        resultset.getString("installs"), resultset
                        .getString("in_app"), resultset
                        .getString("email"), resultset
                        .getString("updated")));
            }

            System.out.println("Database created successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// end finally try
        }// end try

    }

    /**
     * Method to Update the updated time in
     *
     * @param id
     * @param updatedTime
     */

    public void UpdateEntriesInDB(int id, String updatedTime) {

        Connection conn = null;
        PreparedStatement statement = null;
        listAppData = new ArrayList<AppData>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            // Connecting to database
            conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);


            // SQL Query
            String sql = "UPDATE marketing_data" +
                    " SET updated=" + updatedTime +
                    " WHERE id=" + id;

            // Creating Statement
            statement = conn.prepareStatement(sql);

            int resultset = statement.executeUpdate();

            if (resultset >= 1) {
                System.out.print("Updated");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// end finally try
        }// end try

    }


}