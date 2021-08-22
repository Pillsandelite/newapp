package com.example.sine;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtAge;
    TextView display, Hyperlink;
    Button btnDisplay;
    Spanned Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.name);
        txtAge = findViewById(R.id.age);

        display = findViewById(R.id.tvDisplay);
        btnDisplay = findViewById(R.id.btnDisplay);

        Hyperlink = (TextView)findViewById(R.id.textView1);

        Text = Html.fromHtml("click on this link <br />" +
                "<a href='https://internship.zuri.team//'>https://internship.zuri.team</a>");

        Hyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        Hyperlink.setText(Text);

        btnDisplay.setOnClickListener(view -> {
            if (txtName.getText().toString().isEmpty() || txtAge.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
            }else{
                String name = txtName.getText().toString();
                String age = txtAge.getText().toString();
                display.setText(MessageFormat.format("{0}\n{1}", name, age));
            }
        });
    }
}