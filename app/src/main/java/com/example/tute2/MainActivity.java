package com.example.tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_value;
    RadioButton btn_celsius;
    RadioButton btn_farenhite;
    Button btn_calculate;
    TextView  Text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value=findViewById(R.id.et_value);
        btn_celsius=findViewById(R.id.btn_celsius);
        btn_farenhite=findViewById(R.id.btn_farenhite);
        btn_calculate=findViewById(R.id.btn_calculate);
        Text_view=findViewById(R.id.Text_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculations calculations = new Calculations();
        String temp_value = et_value.getText().toString();

        if (TextUtils.isEmpty(temp_value)) {
            Toast.makeText(this, "Please enter a temperature value!", Toast.LENGTH_LONG).show();
        } else {
            Float temp = Float.parseFloat(temp_value);

            if (btn_celsius.isChecked()) {
                temp = calculations.convertCelciusToFahrenheit(temp);
            } else if (btn_farenhite.isChecked()) {
                temp = calculations.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "Please select a radio!", Toast.LENGTH_LONG).show();
            }
            Text_view.setText(new Float(temp).toString());
        }
    }

}