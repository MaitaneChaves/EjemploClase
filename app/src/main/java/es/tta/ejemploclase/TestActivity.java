package es.tta.ejemploclase;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView pregunta=(TextView)findViewById(R.id.pregunta_test);
        Button enviar =(Button)findViewById(R.id.button_send_test);
        RadioGroup respuestas =(RadioGroup)findViewById(R.id.test_choices);

        pregunta.setText(R.string.pregunta_test);

        String[] opciones = {
                "Versión de la aplicación",
                "Listado de componentes de la aplicación",
                "Opciones del menú de ajustes",
                "Nivel mínimo de la API Android requerida",
                "Nombre del paquete java de la aplicación"
        };

        int i;

        for (i=0;i<opciones.length;i++){
            RadioButton radio = new RadioButton(this);
            radio.setText(opciones[i]);
            radio.setId(i);
            radio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
                }
            });
            respuestas.addView(radio);
        }
    }


    public void send(View view){
        Button enviar = (Button)findViewById(R.id.button_send_test);
        Button ayuda = (Button) findViewById(R.id.button_advice);
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);

        final int correct = 2;

        enviar.setVisibility(View.GONE);


        int choices = group.getChildCount();
        for (int i = 0; i < choices; i++) {
            group.getChildAt(i).setEnabled(false);
        }

        int selected = group.getCheckedRadioButtonId();

        group.getChildAt(correct).setBackgroundColor(Color.GREEN);

        if (selected != correct) {
            Toast.makeText(getApplicationContext(), "Has fallado", Toast.LENGTH_SHORT).show();
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            ayuda.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
        }

    }

    public void help(View view){
        Toast.makeText(getApplicationContext(), "Cargo la ayuda", Toast.LENGTH_SHORT).show();

    }



    //RELLENAR TEST

    @Override
    public void onClick(View v) {

        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

}
