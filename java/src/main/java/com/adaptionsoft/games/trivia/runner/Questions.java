package com.adaptionsoft.games.trivia.runner;

import java.util.ArrayList;
import java.util.LinkedList;

public class Questions {

    public LinkedList popQuestions = new LinkedList();
    public LinkedList scienceQuestions = new LinkedList();
    public LinkedList sportsQuestions = new LinkedList();
    public LinkedList rockQuestions = new LinkedList();
    public ArrayList cases = new ArrayList();

    public Questions() {
        for (int q=0; q < 3; q++){
            cases.add("Pop");
            cases.add("Science");
            cases.add("Sports");
            cases.add("Rock");
        }
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
