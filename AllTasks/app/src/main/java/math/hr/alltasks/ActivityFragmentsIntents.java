package math.hr.alltasks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ActivityFragmentsIntents extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "www.math.hr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_fragments_intents);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_fragments_intents, menu);
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

    // slanje podataka preko intenta
    public void slanjePodataka(View view) {
        Intent intent = new Intent(this, SlanjeTeksta.class);
        EditText editText = (EditText) findViewById(R.id.unos_teksta);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void showSlanjeNaTriNacina(View view) {
        Intent intent = new Intent(this, SlanjeNaTriNacina.class);

        // extra
        //intent.putExtra("br1", 25);

        // extras
        Bundle extras = new Bundle();
        extras.putString("string1", "Ovo je prvi String");
        extras.putInt("br1", 35);
        intent.putExtras(extras);

        // uri
        intent.setData(Uri.parse("string drugi"));

        startActivity(intent);
    }

    public void showIntentsBrowser (View view) {
        Intent intent = new Intent(this, IntentsBrowser.class);
        startActivity(intent);
    }

    public void showFragments (View view) {
        Intent intent = new Intent(this, Fragments.class);
        startActivity(intent);
    }

}
