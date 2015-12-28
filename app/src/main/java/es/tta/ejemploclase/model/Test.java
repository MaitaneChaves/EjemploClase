package es.tta.ejemploclase.model;

import java.util.ArrayList;

/**
 * Created by maitane on 28/12/15.
 */
public class Test {
    //public ArrayList Choice;
    private String wording;
    private int id;
    private String advise;
    private String mime;
    private boolean correct;
    private ArrayList Choice;

    public Test(){

    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }







}