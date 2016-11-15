package math.hr.alltasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Layouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_layouts, menu);
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

    public void showLinearLayout (View view) {
        Intent intent = new Intent(this, LinearLayout.class);
        startActivity(intent);
    }

    public void showRelativeLayout (View view) {
        Intent intent = new Intent(this, RelativeLayout.class);
        startActivity(intent);
    }

    public void showTableLayout (View view) {
        Intent intent = new Intent(this, TableLayout.class);
        startActivity(intent);
    }

    public void showFrameLayout (View view) {
        Intent intent = new Intent(this, FrameLayout.class);
        startActivity(intent);
    }

    public void showAnchoring (View view) {
        Intent intent = new Intent(this, Anchoring.class);
        startActivity(intent);
    }

}
