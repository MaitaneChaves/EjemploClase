package es.tta.ejemploclase.model;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import es.tta.prof.comms.RestClient;

/**
 * Created by maitane on 28/12/15.
 */
public class Businness {
    private final static String EXTRA_TEST = "es.tta.ejemploclase.test";
    private final RestClient rest;
    private Bundle bundle;
    public final static String server = "http://u017633.ehu.es:18080/AlumnoTta/rest/tta";
    private Status s=new Status();
    String pathTest = "getTest?id=%d";
    String pathExercise = "getExercise?id=%d";
    String pathStatus = "getStatus?dni=%s";

    public Businness (RestClient rest){this.rest=rest;}

    /*public Test getTest(int id) throws IOException, JSONException{
        try{
            Test test=new Test();
            JSONObject json=rest.getJson(String.format(pathTest, id));
            test.setWording(json.getString("wording"));
            JSONArray array=json.getJSONArray("choices");
            for(int i=0;i<array.length();i++){
                JSONObject item=array.getJSONObject(i);
                Test.Choice choice= new Test.Choice();
                choice.setId(item.getInt("id"));
                choice.setWording(item.getString("wording"));
                choice.setcorrect(item.getBoolean("correct"));
                choice.setAdvise(item.optString("advise",null));
                choice.setMime(item.optString("mime",null));
                test.getChoices().add(choice);
            }
            return test;
        }catch(JSONException e){
            return null;
        }
    }*/

     /*public void putTest(Test test){
        try{
            JSONObject json=new JSONObject();
            json.put("wording", test.getWording());
            JSONArray array = new JSONArray();
            for (Test.Choice choice : test.getChoices()) {
                JSONObject item=new JSONObject();
                item.put("id",choice.getId());
                item.put("wording",choice.getWording());
                item.put("correct",choice.iscorrect());
                item.put("advise",choice.getAdvise());
                item.put("mime",choice.getMime());
                array.put(item);
            }
            json.put("choices",array);
            bundle.putString(EXTRA_TEST, json.toString());
        }catch (JSONException e){
            e.printStackTrace();
        }
    }*/

    public Exercise getExercise(int id)throws IOException, JSONException{
        rest.setHttpBasicAuth("12345678A","tta");
        JSONObject json=rest.getJson(String.format(pathExercise,id));
        Exercise exercise=new Exercise();
        exercise.setId(json.getInt("id"));
        exercise.setWording(json.getString(("wording")));
        return exercise;
    }

    public void uploadSolution(int userId, int exerciseId, InputStream is, String filename) throws IOException{
        String pathExercise = "postExercise?user="+userId+"&id="+exerciseId;
        rest.postFile(pathExercise, is, filename);
    }

    public void uploadChoice (int userId, int choiceId) throws  JSONException, IOException{
        JSONObject json =new JSONObject();
        json.put("userId",userId);
        json.put("choiceId", choiceId);
        rest.postJson(json, "postChoice");
    }

    public Status getStatus (String dni, String password) throws IOException, JSONException{
        rest.setHttpBasicAuth("12345678A","tta");
        JSONObject json = rest.getJson("getStatus?dni=12345678A");
        s.setId(json.getInt("id"));
        s.setUser(json.getString("user"));
        System.out.println(s.getUser());
        s.setLesson(json.getInt("lessonNumber"));
        s.setLessonTitle(json.getString("lessonTitle"));
        s.setNextTest(json.getInt("nextTest"));
        s.setNextExercise(json.getInt("nextExercise"));
        s.setUserDni(dni);
        s.setUserPassword(password);
        return s;
    }


}

