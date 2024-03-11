package com.example.cc10624triviaapp;

import java.security.PrivateKey;

public class TrueFalse {
    //declare all the attributes / logic
    private int idxQuestion;
    private boolean keyAnswer;
    //constructor
    public TrueFalse(int idxQuestion, boolean keyAnswer)
    {
       this.idxQuestion = idxQuestion;
       this.keyAnswer = keyAnswer;

    }
    //Mutator and accessor methods

    public int getIdxQuestion() {
        return idxQuestion;
    }

    public void setIdxQuestion(int idxQuestion) {
        this.idxQuestion = idxQuestion;
    }

    public boolean isKeyAnswer() {
        return keyAnswer;
    }

    public void setKeyAnswer(boolean keyAnswer) {
        this.keyAnswer = keyAnswer;
    }

}
