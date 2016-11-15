package math.hr.alltasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SlanjeTeksta extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "www.math.hr";
    public int len;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slanje_teksta);

        // primanje poruke od intenta

        // prvi nacin
/*      Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.sadrzaj_poruke);
        textView.setText(message);*/

        // drugi nacin
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        len = message.length();

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setText(message);

        setContentView(textView);

    }

    public void onStop() {
        super.onStop();  // mora se zvati super.onStop()
        Toast.makeText(this, Integer.toString(len), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_slanje_teksta, menu);
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
}
