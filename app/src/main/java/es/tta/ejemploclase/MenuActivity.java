package es.tta.ejemploclase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        TextView textLogin= (TextView)findViewById(R.id.menu_login);
        textLogin.setText("Bienvenido "+intent.getStringExtra (MainActivity.EXTRA_LOGIN));


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