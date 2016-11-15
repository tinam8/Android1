package math.hr.alltasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.net.Inet4Address;

public class UserInterface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_interface, menu);
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

    public void showLayouts(View view) {
        Intent intent = new Intent(this, Layouts.class);
        startActivity(intent);
    }

    public void showViewElements(View view) {
        Intent intent = new Intent(this, ViewElements.class);
        startActivity(intent);
    }

    public void showProgressBar(View view) {
        Intent intent = new Intent(this, ViewProgressBar.class);
        startActivity(intent);
    }

    public void showDateAndTimePicker(View view) {
        Intent intent = new Intent(this, DateAndTimePicker.class);
        startActivity(intent);
    }

    public void showListView(View view) {
        Intent intent = new Intent(this, ViewList.class);
        startActivity(intent);
    }

    public void showImages(View view) {
        Intent intent = new Intent(this, ViewImages.class);
        startActivity(intent);
    }

    public void showOptionsContexMenu(View view) {
        Intent intent = new Intent(this, OptionsContexMenu.class);
        startActivity(intent);
    }



}
