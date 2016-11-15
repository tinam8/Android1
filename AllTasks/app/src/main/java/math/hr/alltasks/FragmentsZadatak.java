package math.hr.alltasks;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class FragmentsZadatak extends AppCompatActivity {

    static final String FRAGMENT_ONE = "fragment_one";
    static final String FRAGMENT_TWO = "fragment_two";

    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_zadatak);

        final Button btn = (Button) findViewById(R.id.btn_f2);

        removeFragment1();
        removeFragment2();

        //---get the current display info---
        WindowManager wm = getWindowManager();
        Display d = wm.getDefaultDisplay();
        if ((d.getRotation()== Surface.ROTATION_0)||(d.getRotation()==Surface.ROTATION_180))
        {
            //---portrait mode---
            showFragment1();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showFragment2();
                    btn.setVisibility(View.GONE);
                }
            });
        }
        else
        {
            //---landscape mode---
            btn.setVisibility(View.GONE);
            showFragment1();
            showFragment2();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragments_zadatak, menu);
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

    private Fragment1 getFragment1() {
        if (fragment1 == null) {
            fragment1 = new Fragment1();
        }
        return fragment1;
    }

    private Fragment2 getFragment2() {
        if (fragment2 == null) {
            fragment2 = new Fragment2();
        }
        return fragment2;
    }

    public void showFragment1() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_one, getFragment1(), FRAGMENT_ONE);

        //---add to the back stack---
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void removeFragment1() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = fragmentManager.findFragmentByTag(FRAGMENT_ONE);
        if (fragment != null) {
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
    }

    public void showFragment2() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_two, getFragment2(), FRAGMENT_TWO);

        //---add to the back stack---
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void removeFragment2() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = fragmentManager.findFragmentByTag(FRAGMENT_TWO);
        if (fragment != null) {
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
    }



}
