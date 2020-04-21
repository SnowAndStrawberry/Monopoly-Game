package com.unimelb.swen30006.monopoly;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MonopolyGame {
	public static final int ROUNDS_TOTAL = 20;
	public static final int MIN_NUM_OF_PLAYER = 2;
	public static final int MAX_NUM_OF_PLAYER = 8;
	public static final int NUM_OF_DICE = 2;
	
	private List<Player> players;
	private Board board = new Board();
	
	private cashObserver cashObs;
	private ownedSquareObserver ownObs;
	
	private String filenameCash;
	private String filenameOwned;
	/**
	 * initialize the system with number of Players
	 * @param numOfPlayers number of Players
	 */
	public MonopolyGame(int numOfPlayers){
		ownObs = new ownedSquareObserver();
		cashObs = new cashObserver();
		
		Cup.initialize(NUM_OF_DICE);
		players = new ArrayList<Player>(numOfPlayers);
		
		for(int i = 0; i < numOfPlayers;i++){
			Player p;
			p = new Player("Player " + (i+1), board);

			players.add(p);
			createCashfile("Player " + (i+1));
			createCashfile("Player " + (i+1));
		}
	}
	
	/**
	 * start the game simulation
	 */
	public void playGame(){
		for(int i = 0; i < ROUNDS_TOTAL; i++){
			playRound();
		}
	}
	
	public void createOwnedfile(String filename) {
		// For Cash Transaction Logger: Create a new file
		try {
		FileWriter outStream = new FileWriter(filename);
		outStream.write("OwnedSquares_" + filename + ".txt\n");
		outStream.close();
		} catch (IOException e) {
		e.printStackTrace();
		System.exit(1);
		}
	}
	
	public void createCashfile(String filename) {
		// For Cash Transaction Logger: Create a new file
		try {
		FileWriter outStream = new FileWriter(filename);
		outStream.write("CashTransaction_" + filename + ".txt\n");
		outStream.close();
		} catch (IOException e) {
		e.printStackTrace();
		System.exit(1);
		}
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	private void playRound(){
		for(Iterator<Player> it = players.iterator(); it.hasNext(); ){
			Player player = (Player) it.next();
			player.takeTurn();
			filenameCash = "CashTransaction_" + player.getName();
			filenameOwned = "OwnedSquares_" + player.getName();
			cashObs.update(filenameCash, ""+player.getCash());
			ownObs.update(filenameOwned, ""+player.getRRCount());
		}
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int numOfPlayer = 0;
		while (numOfPlayer > MAX_NUM_OF_PLAYER || numOfPlayer < MIN_NUM_OF_PLAYER){
			System.out.print("Please enter the number of players (between 2 - 8): ");
			numOfPlayer = scanner.nextInt();
		}
		scanner.close();
		
		MonopolyGame game = new MonopolyGame(numOfPlayer);
		game.playGame();
	}
}
