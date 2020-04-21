package com.unimelb.swen30006.monopoly;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ownedSquareObserver implements Observer {

	
	@Override
	public void update(String filename, String data) {
		// TODO Auto-generated method stub
		try {
			FileWriter outStream = new FileWriter(filename);
			Map<Object, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
			for(Entry<Object, Long> entry: counts.entrySet()) {
			outStream.write(entry.getKey()+" x "+entry.getValue()+"\n");
			}
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			}
		
	}

}
