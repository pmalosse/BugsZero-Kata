package com.adaptionsoft.games.trivia.runner;

import java.util.LinkedList;

public class Questions {

    public LinkedList popQuestions = new LinkedList();
    public LinkedList scienceQuestions = new LinkedList();
    public LinkedList sportsQuestions = new LinkedList();
    public LinkedList rockQuestions = new LinkedList();

    public Questions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(createQuestion(i, "Pop"));
            scienceQuestions.addLast(createQuestion(i, "Science"));
            sportsQuestions.addLast(createQuestion(i, "Sports"));
            rockQuestions.addLast(createQuestion(i, "Rock"));
        }
    }

    public String createQuestion(int index, String theme){
        return theme + " Question " + index;
    }
}
