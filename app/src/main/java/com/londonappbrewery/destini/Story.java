package com.londonappbrewery.destini;

class Story {

    private int storyId;
    private Answer ans1;
    private Answer ans2;

    Story(int story, int answer1, int answer2){
        storyId = story;
        ans1 = new Answer(answer1);
        ans2 = new Answer(answer2);
    }

    Story(int end){
        storyId = end;
        ans1 = null;
        ans2 = null;
    }

    int getStoryId() {
        return storyId;
    }

    Answer getAns1() {
        return ans1;
    }

    Answer getAns2() {
        return ans2;
    }
}
