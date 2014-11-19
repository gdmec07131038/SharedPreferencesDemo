package cn.edu.gdmec.s07131038.sharedpreferencesdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText etName,etAge,etHeight;
	private final static String PREFERENCES_NAME="personal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=(EditText) findViewById(R.id.editText1);
        etAge=(EditText) findViewById(R.id.editText2);
        etHeight=(EditText) findViewById(R.id.editText3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void read(View v){
    	SharedPreferences mypre=getSharedPreferences(PREFERENCES_NAME, Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
    	String name=mypre.getString("name", "xie");
    	int age=mypre.getInt("age", 19);
    	float height=mypre.getFloat("height", 145444f);
    	etName.setText(name);
    	etAge.setText(String.valueOf(age));
    	etHeight.setText(String.valueOf(height));
    }
    public void write(View v){
    	SharedPreferences mypre=getSharedPreferences(PREFERENCES_NAME, Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
    	SharedPreferences.Editor myEditor =mypre.edit();
    	myEditor.putString("name",etName.getText().toString());
    	myEditor.putInt("age",Integer.parseInt(etAge.getText().toString()));
    	myEditor.putFloat("height",Float.parseFloat(etHeight.getText().toString()));
    	myEditor.commit();
    }
}
