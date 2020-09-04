package com.example.ex071;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class creditLayout extends AppCompatActivity {
    double sum;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_layout);

        Intent gi = getIntent();
        result = findViewById(R.id.result);
        sum = gi.getDoubleExtra("lastResult",Double.NaN);

        if (Double.isNaN(sum)){
            result.setText("You didn't use me yet :)");
        }
        else {
            if (((sum - (int) sum) > 0.0) && ((sum - (int) sum) < 1)){
                result.setText("The latest calculation result is " + String.valueOf(sum));
            }
            else{
                result.setText("The latest calculation result is " + String.valueOf((int) sum));
            }
        }
    }
}