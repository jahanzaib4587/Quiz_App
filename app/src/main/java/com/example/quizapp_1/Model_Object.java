package com.example.quizapp_1;

public class Model_Object {
    String Question;
    String Opt1,Opt2,Opt3,Opt4;
    String answer;

    public Model_Object(String question, String opt1, String opt2, String opt3, String opt4, String answer) {
        Question = question;
        Opt1 = opt1;
        Opt2 = opt2;
        Opt3 = opt3;
        Opt4 = opt4;
        this.answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOpt1() {
        return Opt1;
    }

    public void setOpt1(String opt1) {
        Opt1 = opt1;
    }

    public String getOpt2() {
        return Opt2;
    }

    public void setOpt2(String opt2) {
        Opt2 = opt2;
    }

    public String getOpt3() {
        return Opt3;
    }

    public void setOpt3(String opt3) {
        Opt3 = opt3;
    }

    public String getOpt4() {
        return Opt4;
    }

    public void setOpt4(String opt4) {
        Opt4 = opt4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
