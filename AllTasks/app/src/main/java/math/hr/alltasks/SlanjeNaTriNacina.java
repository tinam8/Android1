package math.hr.alltasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SlanjeNaTriNacina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slanje_na_tri_nacina);

        TextView textViewString = (TextView) findViewById(R.id.string);
        TextView textViewInt = (TextView) findViewById(R.id.intic);
        Intent intent = getIntent();

        // primanje extra
//        int broj = intent.getIntExtra("br1", 30);
//        textViewInt.setText(Integer.toString(broj));

        // primanje extras
        Bundle bundle = intent.getExtras();
        int broj = bundle.getInt("br1", 5);
        String string = bundle.getString("string1", "default");
        textViewInt.setText(Integer.toString(broj));
        textViewString.setTextSize(35);
        textViewString.setText(string);
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

        //primanje Uri
        string = intent.getData().toString();
        textViewString.setText(string);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_slanje_na_tri_nacina, menu);
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
