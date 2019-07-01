package com.adaptionsoft.games.trivia.runner;

public class Player {
    public int place;
    public int purse;
    public boolean inPenaltyBox;
    public String name;

    public Player(String name) {
        place = 0;
        purse = 0;
        inPenaltyBox = false;
        this.name = name;
    }
}
