package com.earningaide.p2pcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTvResult;
    Button btnBkash1, btnNagad2, btnRocket3, btnOther4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.mEditText);
        mTvResult = findViewById(R.id.mTvResult);
        btnBkash1 = findViewById(R.id.btnPayment1);
        btnNagad2 = findViewById(R.id.btnPayment2);
        btnRocket3 = findViewById(R.id.btnPayment3);
        btnOther4 = findViewById(R.id.btnPayment4);


        btnBkash1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sValue = mEditText.getText().toString();
                if(sValue.isEmpty()){
                    mTvResult.setText("Please Input Amount");
                }else {
                    float fValue = Float.parseFloat(sValue);
                    float fCost = fValue * 0.0185f;
                    float fTotal = fValue + fCost;
                    mTvResult.setText("Ordered Amount = " + fValue + "\nCash out Fee 1.85% = " + fCost + " \nTotal Amount = " + fTotal);
                }
            }
        });
        btnNagad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sValue = mEditText.getText().toString();
                float fValue = Float.parseFloat(sValue);
                float fCost= fValue*0.015f;
                float fTotal = fValue+fCost;
                mTvResult.setText("Ordered Amount = "+fValue+"\nCash out Fee 1.50% = "+fCost+" \nTotal Amount = "+fTotal);
            }
        });
        btnRocket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sValue = mEditText.getText().toString();
                float fValue = Float.parseFloat(sValue);
                float fCost= fValue*0.0185f;
                float fTotal = fValue+fCost;
                mTvResult.setText("Ordered Amount = "+fValue+"\nCash out Fee 1.85% = "+fCost+" \nTotal Amount = "+fTotal);
            }
        });
        btnOther4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sValue = mEditText.getText().toString();
                float fValue = Float.parseFloat(sValue);
                float fCost= fValue*0.0185f;
                float fTotal = fValue+fCost;
                mTvResult.setText("Ordered Amount = "+fValue+"\nCash out Fee 1.85% = "+fCost+" \nTotal Amount = "+fTotal);
            }
        });






    }
}