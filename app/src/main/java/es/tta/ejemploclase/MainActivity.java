package es.tta.ejemploclase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_LOGIN = "es.tta.ejemplo31.login";
    public final static String EXTRA_PASSWD = "es.tta.ejemplo31.passwd";
    public String PREF_LOGIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText editLogin = (EditText) findViewById(R.id.login);
        String l = loadLogin();
        if (l != null || l.isEmpty()) {
            editLogin.setText(l);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void login (View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        EditText editLogin = (EditText) findViewById(R.id.login);
        EditText editPasswd = (EditText) findViewById(R.id.passwd);
        intent.putExtra(EXTRA_LOGIN, editLogin.getText().toString());
        intent.putExtra(EXTRA_PASSWD, editPasswd.getText().toString());
        saveLogin(editLogin.getText().toString());
        startActivity(intent);



        /*

    public void login(View view) {

        EditText passwd = (EditText) findViewById(R.id.passwd);
        String pwd = passwd.getText().toString();

        if (!pwd.equals("tta") || pwd.isEmpty()) {
            Toast.makeText(this, "ContraseÃ±a errÃ³nea", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MenuActivity.class);
            EditText editLogin = (EditText) findViewById(R.id.login);
            EditText editPasswd = (EditText) findViewById(R.id.passwd);
            saveLogin(editLogin.getText().toString());
            intent.putExtra(EXTRA_LOGIN, editLogin.getText().toString());
            intent.putExtra(EXTRA_PASSWD, editPasswd.getText().toString());
            startActivity(intent);
        }
    }
*/
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
}
