package com.example.ex071;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double summary;
    double secondInput;
    char currentSign;
    int i;
    EditText layout;
    String layoutString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        summary = secondInput = Double.NaN;
        layout = findViewById(R.id.layout);
        i = 0;
        layoutString = "";
    }

    public void plus(View view) {
        if (!(layout.getText().toString().isEmpty())) {
            if (i == 0) {
                summary = Double.parseDouble(layout.getText().toString());
                layout.setText("");
                i++;
            } else {
                secondInput = Double.parseDouble(layout.getText().toString());
                layout.setText("");
                summary += secondInput;
                i = 0;
            }
        }
    }

    public void minus(View view) {
        if (!(layout.getText().toString().isEmpty())) {
            if (i == 0) {
                summary = Double.parseDouble(layout.getText().toString());
                layout.setText("");
                i++;
            } else {
                secondInput = Double.parseDouble(layout.getText().toString());
                layout.setText("");
                summary -= secondInput;
                i = 0;
            }
        }
    }

    public void mul(View view) {
        if (!(layout.getText().toString().isEmpty())) {
            if (i == 0) {
                summary = Double.parseDouble(layout.getText().toString());
                layout.setText("");
                i++;
            } else {
                secondInput = Double.parseDouble(layout.getText().toString());
                layout.setText("");
                summary *= secondInput;
                i = 0;
            }
        }
    }

    public void divide(View view) {
        if (!(layout.getText().toString().isEmpty())) {
            if (i == 0) {
                summary = Double.parseDouble(layout.getText().toString());
                layout.setText("");
                i++;
            } else {
                secondInput = Double.parseDouble(layout.getText().toString());
                if (((summary == 0) && (secondInput == 0)) || ((secondInput == 0 && summary != 0))){
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }
                else{
                    layout.setText("");
                    summary /= secondInput;
                    i = 0;
                }
            }
        }
    }

    public void clearAll(View view) {
        layout.setText("");
        summary = secondInput = Double.NaN;
    }

    public void toCreditLayout(View view) {
        Intent si = new Intent(this, creditLayout.class);
        si.putExtra("lastResult", summary);
        startActivity(si);
    }

    public void showResult(View view) {
        if (!(layout.getText().toString().isEmpty()) && Double.isNaN(summary)) {
            summary = Double.parseDouble(layout.getText().toString());
            if (((summary - (int) summary) > 0.0) && ((summary - (int) summary) < 1)){
                layout.setText(String.valueOf(summary));
            }
            else{
                layout.setText(String.valueOf((int) summary));
            }
            layout.setSelection(layout.getText().toString().length());
        }
        else if (!(Double.isNaN(summary)) && layout.getText().toString().isEmpty()){
            if (((summary - (int) summary) > 0.0) && ((summary - (int) summary) < 1)){
                layout.setText(String.valueOf(summary));
            }
            else{
                layout.setText(String.valueOf((int) summary));
            }
            layout.setSelection(layout.getText().toString().length());
        }
        else{
            Toast.makeText(this, "Enter numbers first", Toast.LENGTH_SHORT).show();
        }
    }
}