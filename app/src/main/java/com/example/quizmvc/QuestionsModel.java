package com.example.quizmvc;

public class QuestionsModel {

    private int quesRid;
    private boolean answer;

    public QuestionsModel(int quesRid, boolean answer) {
        this.quesRid = quesRid;
        this.answer = answer;
    }

    public int getQuesRid() {
        return quesRid;
    }

    public void setQuesRid(int quesRid) {
        this.quesRid = quesRid;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
