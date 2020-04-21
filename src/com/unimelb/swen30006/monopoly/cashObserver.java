package com.unimelb.swen30006.monopoly;

import java.io.FileWriter;
import java.io.IOException;

public class cashObserver implements Observer {

	@Override
	public void update(String filename, String data) {
		try {
			FileWriter outStream = new FileWriter(filename, true);
			outStream.write(data + "\n");
			outStream.close();
			} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			}
		
	}
}
