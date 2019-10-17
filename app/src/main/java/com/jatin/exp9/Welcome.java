package com.jatin.exp9;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    CheckBox chbReset;
    Button btnSave,btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        chbReset = findViewById(R.id.chReset);

        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                changeSettings();
            }
        });
    }

    private void changeSettings()
    {
        SharedPreferences sp = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(chbReset.isChecked())
        {
            editor.remove("remember");
            editor.commit();
        }
        Toast.makeText(this,"Settings Updated..",Toast.LENGTH_SHORT).show();
    }
}
