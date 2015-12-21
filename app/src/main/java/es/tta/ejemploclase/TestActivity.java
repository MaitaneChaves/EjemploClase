package es.tta.ejemploclase;

import android.content.Intent;
import android.graphics.Color;

import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;;
import android.widget.MediaController;

import java.io.IOException;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    protected String advice;
    public LinearLayout layout;

    public int AYUDA=0;
    //public static final int HTML=1;
    //public static final int VIDEO=2;
    //public static final int AUDIO=3;



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
            layout=(LinearLayout)findViewById(R.id.layoutTest);
            switch (selected){
                case 0:
                    advice="https://es.wikipedia.org/wiki/Android";
                    AYUDA=1;
                    break;
                case 1:
                    advice="<p>Esto es una prueba</p>";
                    AYUDA=2;
                    break;
                case 2:
                    advice="NADA";
                    break;
                case 3:
                    advice="/storage/emulated/0/DCIM/Camera/VID_20151219_175554.mp4";
                    AYUDA=3;
                    break;
                case 4:
                    advice="/storage/emulated/0/Recording/record20151218181259.3gpp";
                    AYUDA=4;
                    break;
            }

        }
        else {
            Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
        }

    }

    public void showHTML(String advice){
        if(AYUDA==1){
        //if(advice.substring(0,10).contains("://")){
            Uri uri= Uri.parse(advice);
            Intent intent=new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (AYUDA==1){
            Toast.makeText(getApplicationContext(), advice, Toast.LENGTH_SHORT).show();
            WebView web=new WebView(this);
            web.loadData(advice, "text/html", null);
            web.setBackgroundColor(Color.TRANSPARENT);
            web.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);

            layout.addView(web);
        }
    }

    public void help(View view){
        if(AYUDA==1||AYUDA==2)
            showHTML(advice);
        else if (AYUDA==3)
            showVideo(advice);
        else if(AYUDA==4){
            hearAudio();
        }


    }
    public void showVideo(String advice){
        VideoView video =new VideoView(this);
        video.setVideoURI(Uri.parse(advice));
        ViewGroup.LayoutParams params =new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        video.setLayoutParams(params);

        MediaController controller=new MediaController(this){
            @Override
            public void hide(){

          }
            @Override
            public boolean dispatchKeyEvent(KeyEvent event){
                if(event.getKeyCode()== KeyEvent.KEYCODE_BACK)
                    finish();
                return super.dispatchKeyEvent(event);
            }

        };
        controller.setAnchorView(video);
        video.setMediaController(controller);

        layout.addView(video);
        video.start();
    }

    public void hearAudio(){
        View view = new View(this);

        AudioPlayer audio = new AudioPlayer(view);

        Uri uri = Uri.parse(advice);
        try {
            audio.setAudioUri(uri);
        }catch(IOException e){

        }
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);

        layout.addView(view);
        audio.start();
    }
    @Override
    public void onClick(View v) {

        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

}
