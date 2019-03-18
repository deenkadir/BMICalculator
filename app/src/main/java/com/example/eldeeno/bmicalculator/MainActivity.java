package com.example.eldeeno.bmicalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new
            View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //handling height-related data
                    final EditText heightText = (EditText) findViewById(R.id.heightInput);
                    String heightStr = heightText.getText().toString();
                    double height = Double.parseDouble(heightStr);

                    //handling weight-related data
                    final EditText weightText = (EditText) findViewById(R.id.weightInput);
                    String weightStr = weightText.getText().toString();
                    double weight = Double.parseDouble(weightStr);

                    //equation for calculating BMI
                    double BMI = (weight)/(height*height);
                    DecimalFormat df = new DecimalFormat("#.#");
                    double BMI_trimmed = Double.parseDouble(df.format(BMI));


                    //setting BMI result to control
                    final EditText BMIResult = (EditText) findViewById(R.id.BMIInput);
                    BMIResult.setText(Double.toString(BMI_trimmed));

                    //BMI category-related data
                    String BMI_Cat;
                    if (BMI < 15)
                        BMI_Cat = "Very severely udnerweight";
                    else if(BMI < 16)
                        BMI_Cat = "Severly underweight";
                    else if(BMI < 18.5)
                        BMI_Cat = "Underweight";
                    else if(BMI < 25)
                        BMI_Cat = "Normal";
                    else if(BMI < 30)
                        BMI_Cat = "Overweight";
                    else if(BMI < 35)
                        BMI_Cat = "Obese Class 1 - Moderately obese";
                    else if(BMI < 40)
                        BMI_Cat = "Obese Class 2 - Severely obese";
                    else
                        BMI_Cat = "Obese Class 3 - Very severely obese";

                    final TextView BMICategory = (TextView) findViewById(R.id.BMICategory);
                    BMICategory.setTextColor(Color.GREEN);
                    BMICategory.setText(BMI_Cat);

                }
            });
    }
}
