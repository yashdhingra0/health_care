package com.example.selfel_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import static com.example.selfel_1.Ques_1.count;

public class Ques_2 extends AppCompatActivity {
    RadioGroup g1,g2,g3,g4,g5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ques_2);

        g1 = findViewById(R.id.radio_grp);
        g2=findViewById(R.id.radio_grp2);
        g3=findViewById(R.id.radio_grp3);
        g4=findViewById(R.id.radio_grp4);
        g5=findViewById(R.id.radio_grp5);

        g1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //  boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (i) {
                    case R.id.ques_1a:

                        count += 0;
                        break;
                    case R.id.ques_1b:

                        count += 1;
                        break;
                    case R.id.ques_1c:

                       count += 2;
                        break;
                    case R.id.ques_1d:

                        count += 3;
                        break;
                    case R.id.ques_1e:

                        count += 4;
                        break;
                }
            }
        });

        //g2

        g2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //  boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (i) {
                    case R.id.ques_2a:

                        count += 0;
                        break;
                    case R.id.ques_2b:

                        count += 1;
                        break;
                    case R.id.ques_2c:

                        count += 2;
                        break;
                    case R.id.ques_2d:

                        count += 3;
                        break;
                    case R.id.ques_2e:

                        count += 4;
                        break;
                }
            }
        });


        //g3
        g3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //  boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (i) {
                    case R.id.ques_3a:

                        count += 0;
                        break;
                    case R.id.ques_3b:

                        count += 1;
                        break;
                    case R.id.ques_3c:

                        count += 2;
                        break;
                    case R.id.ques_3d:

                        count += 3;
                        break;
                    case R.id.ques_3e:
                        count += 4;
                        break;
                }
            }
        });

        //g4
        g4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //  boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (i) {
                    case R.id.ques_4a:

                        count += 0;
                        break;
                    case R.id.ques_4b:

                        count += 1;
                        break;
                    case R.id.ques_4c:

                        count += 2;
                        break;
                    case R.id.ques_4d:

                        count += 3;
                        break;
                    case R.id.ques_4e:

                        count += 5;
                        break;
                }
            }
        });

        //g5
        g5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //  boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (i) {
                    case R.id.ques_5a:

                        count += 0;
                        break;
                    case R.id.ques_5b:

                        count += 1;
                        break;
                    case R.id.ques_5c:

                        count += 2;
                        break;
                    case R.id.ques_5d:

                        count += 3;
                        break;
                    case R.id.ques_5e:

                        count += 5;
                        break;
                }
            }
        });
    }
    public void submit(View v){
        Intent intent=new Intent(this,Result.class);
        intent.putExtra("intVariableName", count);
        startActivity(intent);
    }
}
