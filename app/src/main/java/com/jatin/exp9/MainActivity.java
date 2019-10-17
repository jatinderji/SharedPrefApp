package com.jatin.exp9;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    CheckBox chb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chb = findViewById(R.id.rem);
        btnGo = findViewById(R.id.btnGo);

        if(checkStatus()) {
            startActivity(new Intent(MainActivity.this, Welcome.class));
            finish();
        }
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chb.isChecked())
                    saveData();
                startActivity(new Intent(MainActivity.this,Welcome.class));
                finish();
            }
        });


    }

    private boolean checkStatus()
    {
        SharedPreferences sp = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        String n = sp.getString("remember", null);
        if(n==null)
            return false;
        else
            return true;
    }

    void saveData()
    {
        SharedPreferences sp =    getSharedPreferences("myPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("remember","yes");
        editor.commit();
    }

}
