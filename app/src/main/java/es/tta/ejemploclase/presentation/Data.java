package es.tta.ejemploclase.presentation;

import android.os.Bundle;

import es.tta.ejemploclase.model.Exercise;
import es.tta.ejemploclase.model.Test;

/**
 * Created by maitane on 28/12/15.
 */
public class Data {
    private final static String EXTRA_USER = "es.tta.ejemploclase.user";
    private final static String EXTRA_AUTH = "es.tta.ejemploclase.auth";
    private final static String EXTRA_NAME = "es.tta.ejemploclase.name";
    private final static String EXTRA_EXERCISE_ID = "es.tta.ejemploclase.exerciseId";
    private final static String EXTRA_EXERCISE_WORDING = "es.tta.ejemploclase.exerciseWording";

    private final Bundle bundle;

    public Data(Bundle bundle){
        if (bundle==null)
            bundle=new Bundle();
        this.bundle=bundle;
    }

    public Bundle getBundle(){return bundle;}

    public void putUserId(int id){bundle.putInt(EXTRA_USER,id);}

    public int getUserId(){return bundle.getInt(EXTRA_USER);}

    public void putAuthToken(String auth){bundle.putString(EXTRA_AUTH,auth);}

    public String getAuthToken(){return bundle.getString(EXTRA_AUTH);}

    public void putUserName(String name){bundle.putString(EXTRA_NAME,name);}

    public String getUserName(){return bundle.getString(EXTRA_NAME);}

    public void putExercise(Exercise exercise){
        bundle.putInt(EXTRA_EXERCISE_ID, exercise.getId());
        bundle.putString(EXTRA_EXERCISE_WORDING,exercise.getWording());
    }

    public Exercise getExercise(){
        Exercise exercise = new Exercise();
        exercise.setId(bundle.getInt(EXTRA_EXERCISE_ID));
        exercise.setWording(bundle.getString(EXTRA_EXERCISE_WORDING));
        return exercise;
    }




}


