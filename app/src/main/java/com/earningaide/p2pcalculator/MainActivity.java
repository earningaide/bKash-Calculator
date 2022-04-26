package com.earningaide.p2pcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult; EditText edtAmount, edtPercent; Button btnCalculate;
    Float fAmount, fPercent, fCost, fTotal;
    String inputAmount,inputPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        edtAmount = findViewById(R.id.edtAmount);
        edtPercent = findViewById(R.id.edtPercent);
        btnCalculate = findViewById(R.id.btnCalculate);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Storing Date
                inputAmount = edtAmount.getText().toString();
                inputPercent = edtPercent.getText().toString();

                //Condition
                if (inputAmount.equals("") || inputPercent.equals("")){
                    Toast.makeText(MainActivity.this,"ADs Loading...",Toast.LENGTH_SHORT).show();
                }else {

                    //Converting Date
                    fAmount = Float.parseFloat(inputAmount);
                    fPercent = Float.parseFloat(inputPercent);

                    // Calculation
                    fCost = fAmount*fPercent/100;
                    fTotal = fAmount+fCost;

                    // Showing Data
                    tvResult.setText("Your Ordered Amount = Tk."+fAmount+"\nTransection Fee "+fPercent+"% = Tk."+fCost+"\n>> Total Amount = Tk."+fTotal);
                }
                //Copy Text
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("mText",tvResult.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(MainActivity.this,"Text Copied",Toast.LENGTH_SHORT).show();
            }
        });



    }
}