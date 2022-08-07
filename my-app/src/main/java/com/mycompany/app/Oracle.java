package com.mycompany.app;
import java.sql.*;


import java.util.Random;

public class Oracle {
    public Connection connection(String username,String password) throws SQLException{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url= "jdbc:oracle:thin:@localhost:49162:xe";




            return DriverManager.getConnection(url,username,password);



        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }


    public long insert(Connection conn) throws SQLException {
        Random random = new Random();
        String[] paketNames = new String[]{"'cheap'","'expensive'","'student'","'boss'","'animal'","'bird'","'gold'"
                ,"'Thor'","'Ironman'","'Spiderman'"};

        String SQL = "INSERT INTO abone(TELNO,KALANMIK,PAKETAD,USAGE) VALUES(?,?,?,?)";

        Connection connection = conn;
        PreparedStatement statement;

        long startTime = System.currentTimeMillis();

        try{
            statement = connection.prepareStatement(SQL);
            for (int i = 0; i <25000; i++) {
                int telno = random.nextInt(1000000000) + 1;
                int usage = random.nextInt(10)+1;
                int kalanMik =random.nextInt(10)+1;
                int paketNo =random.nextInt(10);
                statement.setInt(1,telno);
                statement.setInt(2,kalanMik);
                statement.setString(3,paketNames[paketNo]);
                statement.setInt(4,usage);
                statement.executeUpdate();
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;

    }

    public long selectNumbers(Connection conn) throws SQLException {


        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from numbers2");

        long startTime = System.currentTimeMillis();

        while (rs.next()) {
            rs.getInt(1);
            rs.getInt(2);
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public String truncateUsersTable(Connection conn) {

        String SQL = "truncate table users";
        Connection connection = conn;
        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Users table truncated";

    }

    public void closeConnection(Connection conn) throws SQLException {
        conn.close();

    }
}
