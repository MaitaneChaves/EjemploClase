package es.tta.ejemploclase;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import es.tta.ejemploclase.model.Businness;
import es.tta.ejemploclase.model.Exercise;
import es.tta.ejemploclase.model.Status;
import es.tta.ejemploclase.model.Test;
import es.tta.prof.comms.NetworkReceiver;
import es.tta.prof.comms.RestClient;
import es.tta.prof.view.ProgressTask;

public class MainActivity extends ModelActivity {
    public final static String EXTRA_LOGIN = "es.tta.ejemplo31.login";
    public final static String EXTRA_PASSWD = "es.tta.ejemplo31.passwd";
    public String PREF_LOGIN;
    public NetworkReceiver receiver;
    public RestClient rest=new RestClient("http://u017633.ehu.eus:18080/AlumnoTta/rest/tta");
    public Businness bus;
    public Status s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkReceiver();
        this.registerReceiver(receiver, filter);


        EditText editLogin = (EditText) findViewById(R.id.login);
        //String l= loadLogin();
        String l = "12345678A";
        if (l != null || !l.isEmpty()) {
            editLogin.setText(l);
        }
    }

    public void login (View view) {
        final Intent intent = new Intent(this, MenuActivity.class);
        EditText editLogin = (EditText) findViewById(R.id.login);
        EditText editPasswd = (EditText) findViewById(R.id.passwd);
        intent.putExtra(EXTRA_LOGIN, editLogin.getText().toString());
        intent.putExtra(EXTRA_PASSWD, editPasswd.getText().toString());
        saveLogin(editLogin.getText().toString());


        if(editPasswd.getText().toString().equals("tta")&&editLogin.getText().toString().equals("12345678A")) {

            rest.setHttpBasicAuth(editLogin.getText().toString(), editPasswd.getText().toString());
            bus=new Businness(rest);
            Toast.makeText(getApplicationContext(), "El login es correcto", Toast.LENGTH_SHORT).show();
            new ProgressTask<Status>(this) {
                @Override
                protected es.tta.ejemploclase.model.Status work() throws Exception {
                    s = bus.getStatus("12345678A", "tta");
                    //System.out.println("TENGO EL JSON EN MAIN ACTIVITY");
                    return s;

                }

                @Override
                protected void onFinish(es.tta.ejemploclase.model.Status s) {
                    data.putStatus(s);
                    startModelActivity(MenuActivity.class);

                }
            }.execute();
            //startActivity(intent);

        }
        else
            Toast.makeText(getApplicationContext(),"Login erroneo",Toast.LENGTH_SHORT).show();
    }


    private String loadLogin() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if(PREF_LOGIN!=null)
            return prefs.getString(PREF_LOGIN, null);
        else
            return null;
    }

    private void saveLogin(String login) {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_LOGIN, login);
        editor.commit();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(receiver!=null)
            this.unregisterReceiver(receiver);
    }
}
