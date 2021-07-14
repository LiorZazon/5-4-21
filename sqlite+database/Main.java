package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    private static Connection conn;


    public static void main(String[] args) {
        // write your code here

        MoviesDAO moviesDAO = new MoviesDAO
                ( "jdbc:sqlite:D:/Users/ליאור/Downloads/קורס בודקי תוכנה QA/JAVA/SQL/SQLTEST2.db");

        ArrayList<Movies> movies = moviesDAO.getAllMovies();
        Iterator<Movies> iter = movies.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}

