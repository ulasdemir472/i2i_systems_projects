package com.mycompany.app;
import java.sql.Connection;


import java.sql.SQLException;


public class App {
    public static void main(String[] args) throws SQLException{

        VoltDB voltDB = new VoltDB();
        voltDB.VoltDBOperations();

        Oracle oracleTime =new Oracle();

        Connection conn = oracleTime.connection("system","oracle");


        System.out.println("Oracle insert 25000 users time : "+oracleTime.insert(conn)+" ms");
        oracleTime.closeConnection(conn);
    }
}