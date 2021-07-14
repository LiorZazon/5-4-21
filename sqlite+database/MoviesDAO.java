package com.company;

import java.sql.*;
import java.util.ArrayList;

public class MoviesDAO {


        private String m_conn; // connection string

        public MoviesDAO(String m_conn) {
            this.m_conn = m_conn;
        }

        // Remove to different class
        public void createDatabase(String name) {
            String url = "jdbc:sqlite:D:/Users/ליאור/Downloads/קורס בודקי תוכנה QA/JAVA/SQL/" + name;
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public ArrayList<Movies> getAllMovies() {
            // fire select query
            // create Employee instance per record
            // create array list of all employees
            // try to connect to db

            ArrayList<Movies> movies = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(m_conn)) {
                // check if connection succeed
                if (conn != null) {

                    // prepare query string
                    String sql = "SELECT * FROM MOVIES";

                    // prepare statement
                    Statement stmt = conn.createStatement();

                    // fire query
                    ResultSet rs = stmt.executeQuery(sql);

                    // read results
                    while (rs.next()) {
                        Movies m = new Movies(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("actor"),
                                rs.getInt("price"));
                                movies.add(m);
                    }
                }
            }
            catch (SQLException m) {
                System.out.println(m.getMessage());
            }

            return movies;
        }

        public void select(String query) {

            // try to connect to db
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                // check if connection succeed
                if (conn != null) {

                    // prepare query string
                    String sql = query;

                    // prepare statement
                    Statement stmt = conn.createStatement();

                    // fire query
                    ResultSet rs = stmt.executeQuery(sql);

                    // read results
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" +
                                rs.getString("title") + "\t" +
                                rs.getInt("price") + "\t" +
                                rs.getString("actor"));
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void update(String query) {

            // try to connect to db
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                // check if connection succeed
                if (conn != null) {

                    // prepare query
                    String sql = query;

                    // prepare statement
                    Statement stmt = conn.createStatement();

                    // fire query
                    int result = stmt.executeUpdate(sql); // not expect result
                    System.out.println(result + " record updated.");
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}
