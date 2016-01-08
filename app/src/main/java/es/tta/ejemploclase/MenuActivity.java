package es.tta.ejemploclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

import es.tta.ejemploclase.model.Businness;
import es.tta.ejemploclase.model.Status;
import es.tta.prof.comms.RestClient;

public class MenuActivity extends AppCompatActivity {

    String server = "http://u017633.ehu.es:18080/AlumnoTta/rest/tta/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Intent intent = getIntent();

        final RestClient rest = new RestClient("http://u017633.ehu.eus:18080/AlumnoTta/rest/tta/");
        rest.setHttpBasicAuth("12345678A", "tta");

        new Thread(new Runnable() {
            public void run()
            {

            try
            {
                Businness businness=new Businness(rest);
                final Status s = businness.getStatus(intent.getStringExtra(MainActivity.EXTRA_LOGIN), intent.getStringExtra(MainActivity.EXTRA_PASSWD));
                                final TextView menu_login=(TextView)findViewById(R.id.menu_login);
                final TextView lesson_title=(TextView)findViewById(R.id.lesson_title);
                menu_login.post(new Runnable() {
                    public void run() {

                        menu_login.setText("Bienvenido " + s.getUser());
                    }
                });

                lesson_title.post(new Runnable()
                {
                    public void run()
                    {

                        lesson_title.setText("Lección  " + s.getLesson() + ": " + s.getLessonTitle());
                    }
                });

            } catch (IOException e) {
            } catch (JSONException e) {
            }
            }
        }).start();
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
