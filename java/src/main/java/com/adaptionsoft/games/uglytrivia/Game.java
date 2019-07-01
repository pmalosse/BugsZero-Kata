package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.runner.Player;
import com.adaptionsoft.games.trivia.runner.Questions;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList players = new ArrayList();

    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

	Questions questions = new Questions();
	ArrayList<Player> playersList = new ArrayList();
    public  Game(){
	}

	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
		Player player = new Player(playerName);
		playersList.add(player);
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + playersList.size());
		return true;
	}
	
	public int howManyPlayers() {
		return playersList.size();
	}

	public void roll(int roll) {
		System.out.println(playersList.get(currentPlayer).name + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (playersList.get(currentPlayer).inPenaltyBox) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(playersList.get(currentPlayer).name + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				System.out.println(playersList.get(currentPlayer).name + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {

			movePlayerAndAskQuestion(roll);
		}
		
	}

	private void movePlayerAndAskQuestion(int roll) {
		playersList.get(currentPlayer).place = playersList.get(currentPlayer).place + roll;
		if (playersList.get(currentPlayer).place > 11) playersList.get(currentPlayer).place = playersList.get(currentPlayer).place - 12;

		System.out.println(playersList.get(currentPlayer).name
                + "'s new location is "
                + playersList.get(currentPlayer).place);
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(questions.popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(questions.scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(questions.sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(questions.rockQuestions.removeFirst());
	}
	
	
	private String currentCategory() {
 		return questions.cases.get(playersList.get(currentPlayer).place).toString();
	}

	public boolean wasCorrectlyAnswered() {
		if (playersList.get(currentPlayer).inPenaltyBox){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer++;
				if (currentPlayer == playersList.size()) currentPlayer = 0;
				playersList.get(currentPlayer).purse++;
				System.out.println(playersList.get(currentPlayer).name
						+ " now has "
						+ playersList.get(currentPlayer).purse
						+ " Gold Coins.");

				boolean winner = didPlayerWin();

				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == playersList.size()) currentPlayer = 0;
				return false;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			playersList.get(currentPlayer).purse++;
			System.out.println(playersList.get(currentPlayer).name
					+ " now has "
					+ playersList.get(currentPlayer).purse
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == playersList.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(playersList.get(currentPlayer).name+ " was sent to the penalty box");
		playersList.get(currentPlayer).inPenaltyBox = true;
		
		currentPlayer++;
		if (currentPlayer == playersList.size()) currentPlayer = 0;
		return false;
	}


	private boolean didPlayerWin() {
		return (playersList.get(currentPlayer).purse == 6);
	}
}
