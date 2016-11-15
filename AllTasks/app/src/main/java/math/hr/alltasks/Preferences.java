package math.hr.alltasks;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Preferences extends AppCompatActivity {

    public final String MYPREFS = "Moje preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        savePreferences();
        loadPreferences();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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

    protected void savePreferences(){
        //stvorimo shared preference
        int mode=MODE_PRIVATE;
        SharedPreferences mySharedPreferences=getSharedPreferences(MYPREFS,mode);

        //editor za modificiranje shared preference
        SharedPreferences.Editor editor=mySharedPreferences.edit();

        //spremamo vrijednosti u shared preference
        editor.putBoolean("isTrue", true);
        editor.putFloat("lastFloat",1f);
        editor.putInt("wholeNumber", 5);
        editor.putLong("aNumber", 35);
        editor.putString("textEntryValue", "Neki tekst");

        //commit promjene
        editor.commit();
    }

    public void loadPreferences(){
        // dohvatimo preference
        int mode=MODE_PRIVATE;
        SharedPreferences mySharedPreferences=getSharedPreferences(MYPREFS,mode);

        //dohvatimo vrijednosti
        boolean isTrue=mySharedPreferences.getBoolean("isTrue", false);
        float lastFloat=mySharedPreferences.getFloat("lastFloat", 0f);
        int wholeNumber=mySharedPreferences.getInt("WholeNumber", 7);
        long aNumber=mySharedPreferences.getLong("aNumber", 0);
        String stringPreference=mySharedPreferences.getString("textEntryValue", "nista");

        //ispisemo string da se nesto ispise...
        Toast.makeText(getBaseContext(),
                stringPreference,
                Toast.LENGTH_SHORT).show();

        Toast.makeText(getBaseContext(),
                Integer.toString(wholeNumber),
                Toast.LENGTH_SHORT).show();

    }

}
