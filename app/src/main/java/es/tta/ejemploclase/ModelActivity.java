package es.tta.ejemploclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.tta.ejemploclase.model.Businness;
import es.tta.ejemploclase.presentation.Data;
import es.tta.ejemploclase.presentation.Preferences;
import es.tta.prof.comms.RestClient;

/**
 * Created by maitane on 28/12/15.
 */
public abstract class ModelActivity extends AppCompatActivity {
    public static final String URL = "http://server:8080/ServidorTta";
    protected RestClient rest;
    protected Businness server;
    protected Preferences prefs;
    protected Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        data =new Data(getIntent().getExtras());
        rest = new RestClient(URL);
        String auth = data.getAuthToken();
        if(auth!=null)
            rest.setAuthorization(auth);
        server=new Businness(rest);
        prefs=new Preferences(this);


    }

    protected <T> void startModelActivity(Class<T> cls){
        Intent intent=newIntent(cls);
        startActivity(intent);
    }

    protected <T> void startModelActivityForResult(Class<T> cls, int requestCode){
        Intent intent=newIntent(cls);
        startActivityForResult(intent, requestCode);
    }

    protected <T> Intent newIntent(Class<T> cls){
        Intent intent=new Intent(getApplicationContext(), cls);
        intent.putExtras(data.getBundle());
        return intent;

    }

}


