package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare Constants
    private final boolean TOP_CHOICE = true;
    private final boolean BOT_CHOICE = false;

    // Declare member variables
    private TextView mStoryTV;
    private Button mTopButton;
    private Button mBottomButton;
    private int mStoryIndex;

    // Story and answers array
    private Story[] plot ={
      new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Story(R.string.T4_End),
            new Story(R.string.T5_End),
            new Story(R.string.T6_End),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire up the 3 views from the layout to the member variables
        mStoryTV = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mStoryIndex = 0; // Reset state every time

        // First display
        displayStory();

        // Set a listener on the top button
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateState(TOP_CHOICE);
                displayStory();
            }
        });
        // Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateState(BOT_CHOICE);
                displayStory();
            }
        });
    }

    private void displayStory(){
        mStoryTV.setText(plot[mStoryIndex].getStoryId());

        // Have we reached the End?
        if (plot[mStoryIndex].getAns1() == null) {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
        else {
            mTopButton.setText(plot[mStoryIndex].getAns1().getAnsId());
            mBottomButton.setText(plot[mStoryIndex].getAns2().getAnsId());
        }
    }

    private void updateState(boolean choice){
        int newIndex;
        if (plot[mStoryIndex].getAns1() == null){
            return;
        }
        if (choice == TOP_CHOICE){
            newIndex = plot[mStoryIndex].getAns1().getNextState();
        } else{
            newIndex = plot[mStoryIndex].getAns2().getNextState();
        }
        mStoryIndex = newIndex;
    }
}
