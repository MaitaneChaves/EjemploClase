package es.tta.ejemploclase.presentation;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import es.tta.ejemploclase.model.Exercise;
import es.tta.ejemploclase.model.Status;
import es.tta.ejemploclase.model.Test;
import es.tta.prof.comms.RestClient;

/**
 * Created by maitane on 28/12/15.
 */
public class Data {
    private final static String EXTRA_USER = "es.tta.ejemploclase.user";
    private final static String EXTRA_PASSWD = "es.tta.ejemploclase.passwd";
    private final static String EXTRA_AUTH = "es.tta.ejemploclase.auth";
    private final static String EXTRA_NAME = "es.tta.ejemploclase.name";
    private final static String EXTRA_NEXT_TEST = "es.tta.ejemploclase.nextTest";
    private final static String EXTRA_LESSON = "es.tta.ejemploclase.Lesson";
    private final static String EXTRA_LESSON_TITLE = "es.tta.ejemploclase.lessonTitle";
    private final static String EXTRA_EXERCISE_ID = "es.tta.ejemploclase.exerciseId";
    private final static String EXTRA_EXERCISE_WORDING = "es.tta.ejemploclase.exerciseWording";
    private final static String EXTRA_ID = "es.tta.ejemploclase.userid";

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

    public void putStatus(Status status){
        status.setLesson(bundle.getInt(EXTRA_LESSON));
        status.setUser(bundle.getString(EXTRA_NAME));
        status.setLessonTitle(bundle.getString(EXTRA_LESSON_TITLE));
        status.setNextTest(bundle.getInt(EXTRA_NEXT_TEST));
        //status.setUserDni(bundle.getString(EXTRA_USER));
        //status.setUserPassword(bundle.getString(EXTRA_PASSWD));
        status.setId(bundle.getInt(EXTRA_ID));
    }

    public Status getStatus(){
        Status status =new Status();
        bundle.putInt(EXTRA_LESSON,status.getLesson());
        bundle.putInt(EXTRA_ID,status.getId());
        bundle.putString(EXTRA_USER,status.getUser());
        bundle.putString(EXTRA_LESSON_TITLE,status.getLessonTitle());
        bundle.putInt(EXTRA_EXERCISE_ID,status.getNextExercise());
        bundle.putInt(EXTRA_NEXT_TEST,status.getNextTest());
        return status;
    }

/*


    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
 */



}


