package com.example.selfel_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        TextView t=findViewById(R.id.res);
        if(intValue==0) t.setText("Congratulations! You are not suffering from Stress!");
        else if(intValue>0&&intValue<=5)t.setText("You are suffering from level 1 Stress!");
        else if(intValue>5&&intValue<=10)t.setText("You are suffering from level 2 Stress!!");
        else if(intValue>10&&intValue<=15) t.setText("You are suffering from level 3 Stress!!!");
        else t.setText("You are suffering from level 5 Stress!");;
    }


}
