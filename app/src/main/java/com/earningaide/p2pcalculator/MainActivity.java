package com.earningaide.p2pcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    TextView tvResult; EditText edtAmount, edtPercent; Button btnCalculate;
    Float fAmount, fPercent, fCost, fTotal;
    String inputAmount,inputPercent;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        edtAmount = findViewById(R.id.edtAmount);
        edtPercent = findViewById(R.id.edtPercent);
        btnCalculate = findViewById(R.id.btnCalculate);

        edtPercent.setText("1.85");

        //ads-------------------------------
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //On Click Event----------------------
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Storing Date
                inputAmount = edtAmount.getText().toString();
                inputPercent = edtPercent.getText().toString();

                //Condition------------------------------------------
                    if ( inputAmount.equals("")  ){
                        edtAmount.setError("Enter Amount");
                        tvResult.setText("Input Data Missing...\n>> Enter Amount");

                        }else if ( inputPercent.equals("")  ){
                            edtPercent.setError("Enter Percent");
                            tvResult.setText("Input Data Missing...\n>> Enter Percent");

                            } else {

                                    //Convert String to Float------------------------------
                                    fAmount = Float.parseFloat(inputAmount);
                                    fPercent = Float.parseFloat(inputPercent);

                                    // Calculation---------------------------------------
                                    fCost = fAmount*fPercent/100;
                                    fTotal = fAmount+fCost;

                                    // Showing Data-------------------------------------
                                    tvResult.setText("Your Ordered Amount = Tk."+fAmount+"\nTransection Fee "+fPercent+"% = Tk."+fCost+"\n>> Total Amount = Tk."+fTotal+"\nType Last 4 Digit After Payment.");
                                    edtAmount.setText(""+fAmount);

                                    // SharedPreferences
                                    SharedPreferences sharedPreferences = getSharedPreferences("spStore", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("mPercent",inputPercent);
                                    editor.commit();
                                    if (sharedPreferences.contains("mPercent")){
                                        String spPercent = sharedPreferences.getString("mPercent","1.85");
                                        edtPercent.setText(spPercent);
                                    }
                                    //Copy Text---------------------------
                                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clipData = ClipData.newPlainText("mText",tvResult.getText().toString());
                                    clipboardManager.setPrimaryClip(clipData);
                                    Toast.makeText(MainActivity.this,"Text Copied",Toast.LENGTH_LONG).show();
                        }
            }
        });

    }
}