package math.hr.alltasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class ViewElements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_elements);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_elements, menu);
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

    /*public void btnSaved_clicked(View view) {
        Toast.makeText(this, "Kliknuli ste save", Toast.LENGTH_SHORT).show();
    }*/

    private void DisplayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void btnSaved_clicked(View view) {
        DisplayToast("kliknuli ste Save");
    }

    public void checkboxClicked(View view) {
        if (((CheckBox) view).isChecked())
            DisplayToast("CheckBox je oznacen");
        else
            DisplayToast("CheckBox nije oznacen");
    }

    public void starClicked(View view) {
        if (((CheckBox) view).isChecked())
            DisplayToast("Star je oznacen");
        else
            DisplayToast("Star nije oznacen");
    }

    public void radioButtonClicked(View view) {
        if (((RadioButton) view).isChecked())
            DisplayToast("Option je oznacen");
        else
            DisplayToast("Option nije oznacen");
    }

    

}
