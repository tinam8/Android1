package math.hr.alltasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DataFiles extends AppCompatActivity {

    EditText textBox;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_files);

        textBox = (EditText) findViewById(R.id.txtText1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_files, menu);
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

    public void onClickSave(View view) {
        String str = textBox.getText().toString();
        try
        {

            FileOutputStream fOut =  openFileOutput("textfile.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            //---write the string to the file---
            osw.write(str);
            osw.flush();
            osw.close();

            //---display file saved message---
            Toast.makeText(getBaseContext(),
                    "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

            //---clears the EditText---
            textBox.setText("");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void onClickLoad(View view) {
        try
        {

            FileInputStream fIn =  openFileInput("textfile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);


            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";

            int charRead;
            while ((charRead = isr.read(inputBuffer))>0)
            {
                //---convert the chars to a String---
                String readString =
                        String.copyValueOf(inputBuffer, 0,
                                charRead);
                s += readString;

                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            //---set the EditText to the text that has been
            // read---
            textBox.setText(s);

            Toast.makeText(getBaseContext(),
                    "File loaded successfully!",
                    Toast.LENGTH_SHORT).show();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void readStatic(View view) {
        InputStream is=this.getResources().openRawResource(R.raw.primjer);
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String str=null;
        try{
            while((str=br.readLine())!=null){
                Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG).show();
            }
            is.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
