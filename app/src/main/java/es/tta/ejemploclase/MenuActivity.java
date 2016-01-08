package es.tta.ejemploclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import es.tta.ejemploclase.model.Businness;
import es.tta.ejemploclase.model.Status;
import es.tta.ejemploclase.presentation.Data;
import es.tta.prof.comms.RestClient;
import es.tta.prof.view.ProgressTask;

public class MenuActivity extends ModelActivity {

    private String dni, pass;
    private TextView userView, lessonView;
    private JSONObject s;
    private String name, lessonNumber, lessonTitle;
    private int nextTest, nextExercise;
    private Data data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        data=new Data(savedInstanceState);
        Status status=data.getStatus();

        System.out.println(name+lessonTitle+lessonNumber+nextExercise+nextTest);


        final TextView menu_login=(TextView)findViewById(R.id.menu_login);
        final TextView lesson_title=(TextView)findViewById(R.id.lesson_title);

        menu_login.setText("Bienvenido " + status.getUser());

        lesson_title.setText("Lección  " + status.getLesson() + ": " + status.getLessonTitle());




    }




    public void tests(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    public void ejercicios(View view) {
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }

    public void seguimiento(View view) {
        //Intent intent = new Intent(this, SeguimientoActivity.class);
        //startActivity(intent);
    }

}
