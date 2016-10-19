package com.example.aileen.welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayBoo(View view) {
        TextView booText = (TextView)findViewById(R.id.message);
        EditText name = (EditText) findViewById(R.id.editText);
        String nameValue = name.getText().toString();
        booText.setText("Happy Halloween " + nameValue + "!");
        ImageView ghost = (ImageView)findViewById(R.id.imageView);
        ghost.setImageResource(R.drawable.ghost);
    }
}
