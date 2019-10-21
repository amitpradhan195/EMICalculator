package com.example.a170171_emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    EditText etAmt, etInterest, etTime;
    Button btnCalc;
    TextView tvRes;
    DecimalFormat output = new DecimalFormat("#.00");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmt = (EditText)findViewById(R.id.etAmt);
        etInterest = (EditText)findViewById(R.id.etInterest);
        etTime = (EditText)findViewById(R.id.etTime);
        tvRes = (TextView)findViewById(R.id.tvRes);
        btnCalc = (Button)findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etAmt.getText().length()==0 && etInterest.getText().length()==0 && etTime.getText().length()==0){
                    etAmt.setError("Field cannot be left blank");
                    etInterest.setError("Field cannot be left blank");
                    etTime.setError("Field cannot be left blank");
                }

                else if(etAmt.getText().length()==0) {
                    etAmt.setError("Field cannot be left blank");
                }

                else if(etInterest.getText().length()==0) {
                    etInterest.setError("Field cannot be left blank");
                }

                else if(etTime.getText().length()==0) {
                    etTime.setError("Field cannot be left blank");
                }

                else{
                    double amt = Double.parseDouble(etAmt.getText().toString());
                    float ratePercent = Float.parseFloat(etInterest.getText().toString());
                    float time = Float.parseFloat(etTime.getText().toString());

////     Without using Class:
//                    double rate = (ratePercent/100)/12;
//                    double month = time*12;
//                    double res = (amt * rate * Math.pow(1 + rate, month)) / (Math.pow(1 + rate,month) - 1);

                    EMICalculation res = new EMICalculation(amt, ratePercent, time);


                    tvRes.setText("EMI = " + output.format(res.getEmi()));
                    tvRes.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
