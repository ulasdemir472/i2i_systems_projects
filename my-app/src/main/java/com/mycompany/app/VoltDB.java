package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class VoltDB {
    public void VoltDBOperations() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:voltdb://localhost:49153");

        String[] paketNames = new String[]{"'cheap'","'expensive'","'student'","'boss'","'animal'","'bird'","'gold'"
                ,"'Thor'","'Ironman'","'Spiderman'"};
        Random random = new Random();
        int telno =0;
        int usage=0;
        int kalanMik=0;
        int paketNo=0;

        long start = System.currentTimeMillis();

        for (int i = 0; i <25000 ; i++) {

            telno = random.nextInt(1000000000) + 1;
            usage = random.nextInt(10)+1;
            kalanMik =random.nextInt(10)+1;
            paketNo =random.nextInt(10);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO abone(TELNO,KALANMIK,PAKETAD,USAGE) VALUES(?,?,?,?)");
            statement.setInt(1,telno);
            statement.setInt(2,kalanMik);
            statement.setString(3,paketNames[paketNo]);
            statement.setInt(4,usage);
            statement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("Put 25000 data time in VoltDB : "+result+" ms");

        connection.close();

    }
}
