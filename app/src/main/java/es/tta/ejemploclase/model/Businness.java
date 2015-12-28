package es.tta.ejemploclase.model;

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
    private final RestClient rest;

    public Businness (RestClient rest ){this.rest=rest;}

    public Status getStatus(String dni) throws IOException,JSONException{

    }

    public Test getTest(int id) throws IOException, JSONException{

    }

    public void putTest(Test test){
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
    }

    public Exercise getExercise(int id)throws IOException, JSONException{
        JSONObject json=rest.getJson(String.format("getExercise?id=%d", id));
        Exercise exercise=new Exercise();
        exercise.setId(json.getInt("id"));
        exercise.setWording(json.getString(("wording")));
        return exercise;
    }

    public void uploadSolution(int userId, int exerciseId, InputStream is, String filename) throws IOException{

    }

    public void uploadChoice (int userId, int choiceId) throws  JSONException, IOException{
        JSONObject json =new JSONObject();
        json.put("userId",userId);
        json.put("choiceId", choiceId);
        rest.postJson(json, "postChoice");
    }


}
