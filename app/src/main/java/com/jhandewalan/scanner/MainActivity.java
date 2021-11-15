package com.jhandewalan.scanner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jhandewalan.scanner.Pojo.OpeningBeans;

public class MainActivity extends AppCompatActivity {

    Button btn_scanStart;
    TextView txt_result, txt_member;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_scanStart = findViewById(R.id.btn_startscan);
        txt_result = findViewById(R.id.txt_result);
        txt_member = findViewById(R.id.txt_member);


        btn_scanStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScan();
            }
        });


    }

    private void startScan() {


        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(MainActivity.this)
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withBackfacingCamera()
                .withCenterTracker()
                .withBleepEnabled(true)

                .withText("Scanning...")

                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {
                        // Barcode barcodeResult = barcode;c

                        Log.e("Value : ", "Bar Code value: - " + barcode.displayValue);
                        Log.e("Value : ", "Bar Code row : - " + barcode.rawValue);
                      //  Toast.makeText(getApplicationContext(), "Bar Code : " + barcode.rawValue, Toast.LENGTH_SHORT).show();
                        //      Log.e("Value : ","Bar Code : - "+barcode.url);

                        //   result.setText(barcode.rawValue);

                        txt_result.setText(barcode.rawValue);
                        if (barcode.rawValue != null) {
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            //gson.fromJson(barcode.rawValue, OpeningBeans.class);

                            OpeningBeans values = gson.fromJson(barcode.rawValue, OpeningBeans.class);
                            txt_member.setText("no of member :  " + values.getNoOfPerson());


                        } else {
                            // redirect to invalid Screen;
                        }
                    }
                })
                .build();
        materialBarcodeScanner.startScan();
    }

}