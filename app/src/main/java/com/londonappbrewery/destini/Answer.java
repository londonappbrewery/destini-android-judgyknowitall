package com.londonappbrewery.destini;

import android.util.Log;

class Answer {

    private int ansId;
    private int nextState;

    Answer(int answer){
        ansId = answer;
        calculateNextState();
    }

    int getAnsId() {
        return ansId;
    }

    int getNextState() {
        return nextState;
    }

    private void calculateNextState(){
        switch(ansId){
            case (R.string.T1_Ans2):
                nextState = 1;          // Next state Story - 1
                break;
            case (R.string.T3_Ans1):
                nextState = 5;
                break;
            case (R.string.T3_Ans2):
                nextState = 4;
                break;
            case (R.string.T2_Ans2):
                nextState = 3;
                break;
            // cases of T1_Ans1 and T2_Ans1    
            default:
                nextState = 2;
        }
    }
}
