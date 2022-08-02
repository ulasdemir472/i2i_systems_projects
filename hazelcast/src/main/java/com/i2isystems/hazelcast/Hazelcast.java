package com.i2isystems.hazelcast;

import java.util.Map.Entry;
import java.util.Random;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class Hazelcast {
	
	public void HazelcastOperations()
	{
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.setClusterName("dev");
		   		
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		IMap<Integer, Integer> map = client.getMap("numbers");
		
		System.out.println("Put 20000 Data  Time Hazelcast: " + putData(map) + " ms");
		System.out.println("Get 20000 Data  Time Hazelcast: " + getData(map) + " ms");
		
		client.shutdown();
		
	}
	
	private long putData(IMap<Integer, Integer> map) {
		
	    long start = System.currentTimeMillis();
	    
	    for (int i = 0; i <20000; i++) {
	    	Random rand = new Random();
	        int rand_int = rand.nextInt();
			map.put(i,rand_int);
	    }

	    long end = System.currentTimeMillis();
	    
	    long millisec = end - start;   
	    return millisec;
	    
	}
	
	public long getData(IMap<Integer, Integer> map) {
		
		long start = System.currentTimeMillis();
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			map.get(entry.getValue());
	    }
		
		long end = System.currentTimeMillis();
	    
	    long millisec = end - start;
	    return millisec;
		
	}
	
   
	
}
