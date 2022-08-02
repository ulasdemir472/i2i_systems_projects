package com.i2isystems.hazelcast;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Map.Entry;
import java.util.Random;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	Hazelcast hazelcastTime = new Hazelcast();
		hazelcastTime.HazelcastOperations();
	
		Oracle oracleTime =new Oracle();
		
		Connection conn = oracleTime.connection("system","oracle");
		
		System.out.println("Oracle insert 20000 users time : "+oracleTime.insertNumbers(conn)+" ms"); 
		System.out.println("Oracle select 20000 users time : "+oracleTime.selectNumbers(conn)+" ms");       
		
		
//		String message = oracleTimePerformans.truncateUsersTable(conn);
//		System.out.println(message);
		
		oracleTime.closeConnection(conn);
		
    }

    	
    	
    
}
