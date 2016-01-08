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

import es.tta.prof.comms.NetworkReceiver;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_LOGIN = "es.tta.ejemplo31.login";
    public final static String EXTRA_PASSWD = "es.tta.ejemplo31.passwd";
    public String PREF_LOGIN;
    public NetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkReceiver();
        this.registerReceiver(receiver, filter);


        EditText editLogin = (EditText) findViewById(R.id.login);
        String l = loadLogin();
        if (l != null || !l.isEmpty()) {
            editLogin.setText(l);
        }
    }

    public void login (View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        EditText editLogin = (EditText) findViewById(R.id.login);
        EditText editPasswd = (EditText) findViewById(R.id.passwd);
        intent.putExtra(EXTRA_LOGIN, editLogin.getText().toString());
        intent.putExtra(EXTRA_PASSWD, editPasswd.getText().toString());
        Toast.makeText(getApplicationContext(),editLogin.getText().toString() ,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),editPasswd.getText().toString() ,Toast.LENGTH_SHORT).show();
        saveLogin(editLogin.getText().toString());

        if(editPasswd.getText().toString().equals("tta")&&editLogin.getText().toString().equals("12345678A"))
            startActivity(intent);

        else
            Toast.makeText(getApplicationContext(),"Login erroneo",Toast.LENGTH_SHORT).show();
    }


    private String loadLogin() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        return prefs.getString(PREF_LOGIN, null);
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
/*




    public void login(View view) {

        EditText passwd = (EditText) findViewById(R.id.passwd);
        String pwd = passwd.getText().toString();

        //Comprobamos que el password es el correcto
        if (!pwd.equals("tta")) {
            Toast.makeText(this, R.string.badPassword, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MenuActivity.class);
            EditText editLogin = (EditText) findViewById(R.id.login);
            putLogin(editLogin.getText().toString());
            intent.putExtra(EXTRA_LOGIN, editLogin.getText().toString());
            intent.putExtra(EXTRA_PASSWD, pwd);
            startActivity(intent);
        }
    }


}

 */
