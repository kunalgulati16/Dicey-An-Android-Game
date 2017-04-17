package com.example.ajesh.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView name, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=(TextView)findViewById(R.id.tvp1fscore);
        Email=(TextView)findViewById(R.id.tvp2fscore);

        String n = getIntent().getStringExtra("Name_key");
        String e = getIntent().getStringExtra("Email_key");
        name.setText(n);
        Email.setText(e);


    }
}
