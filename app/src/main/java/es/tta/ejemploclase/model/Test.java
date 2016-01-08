package es.tta.ejemploclase.model;

import java.lang.reflect.Array;
import java.text.ChoiceFormat;
import java.util.ArrayList;

/**
 * Created by maitane on 28/12/15.
 */
public class Test {
    private String wording;

    /**
     *
     * public class Test {

     public static final String ADVICE_MIME_HTML="text/html";
     public static final String ADVICE_MIME_AUDIO="video/mp4";
     public static final String ADVICE_MIME_VIDEO="audio/mpeg";

     private String w;

     public Test(String wording, int [] choicesId, String [] choicesAdvise, String [] choicesAnswer,
     boolean [] choicesCorrect, String [] choicesResourceType){

     w=wording;


     }

     }

     */

    private ArrayList Choices;
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public ArrayList getChoices() {
        return Choices;
    }

    public void setChoices(ArrayList choices) {
        Choices = choices;
    }

   /*     private int id;
        private String advise;
        private String mime;
        private boolean correct;
        private String wording;


        private ArrayList Choices;
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

        public boolean iscorrect() {
            return correct;
        }

        public void setcorrect(boolean correct) {
            this.correct = correct;
        }

    }*/
    //public static ArrayList Choice;

    public Test(){

    }









}