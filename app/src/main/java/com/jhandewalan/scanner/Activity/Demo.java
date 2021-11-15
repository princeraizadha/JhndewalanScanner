package com.jhandewalan.scanner.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.jhandewalan.scanner.R;
import com.jhandewalan.scanner.Support.CharchitDecription;
import com.jhandewalan.scanner.Support.CryptoHandler;

public class  Demo extends AppCompatActivity {

    Button btn_press, btn_decrypt;
    TextView txt_dummy;
    EditText edt_enter_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_layout);
        createids();
        clickEvent();
    }

    private void clickEvent() {
        btn_press.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                try {


                    CryptoHandler handler = new CryptoHandler();
                    String aa = handler.encrypt("{\n" +
                            "  \"user_id\": \"22\",\n" +
                            "  \"kramank_no\": \"1726\",\n" +
                            "  \"name\": \"prince\",\n" +
                            "  \"sewana vivran\": \"pani pramukh\"\n" +
                            "}");
                    Log.e("aa", "EncryptData :  " + aa);

                   // String test = "SC+eatdjFEURBtJVLHo5IlRg1RyjrugZvtU7E4hpvFB7E2e6clmV6TCiViY8rCqAl1bRpbULS1cq35yE8Mv23LHf+FpU9r78WEBrzU8M7DE=";
                   String test = "CA0a+hxR50P3GlW+ZtUmLA3/x/ScBgiBH08f9ZSlPgafOHJdpfg4KabPkDw16n95I18+rtsS3pxLdgrYSnijuhPIJ9ooCjumI+mpuIS3AGI4HXl9JdhUPa4elA7Lz+HrGfS0kBcgBT9q9tGNointtJq3V8bQRIITbKOl6eqaQyBNjt43bvsAtS7Si7PNp2wFcqISNIKAKR15z/2yKcSISMdqAepTgioInmAl8Kz9x0yvzk7+W22m32ZLM1KA9okb35mBLB0LWmgfMmsnw/2J7YXtyzRmSuedBTUMb9S220ebuVAx0v5FF1JCY1VFG5+0b7lFQdTGo8szn8nVY5Vu/w4YWrsn9jkz6cW3bhF3DqJErvaA46EQoZ0908UFE2Yl5o+zbj1mvPfaXZ7twlfLEu8cIpagvTdcbp5Zp11ayiqA1w/ce3n9A4Oe1C6rn2Y/msgwzxgdnbvkCGf8hVlrXGinV3eOwN7ocj7SVjDYgkzWY6a4iqtfM/RNHefDqCpFENJtJAw2TXObCw8CZJM0qStnhqozmZl8Cbqn3Ebq2P3hxVS0+/yPh6jY+fCF0hFy8ocpfSJpNg5Pn5NErDhki/aqmwF/OvLb3NlchgHtdFc9ZJjt/JEVW7FDnIdxUAciB6sxtmq5sKOQJxehCBOV2cT5YNPQGjYzuRvFsr1OFsY3Tau6w4Nt0gfbRe+ar9fk";

                    txt_dummy.setText(test);

/*

                    CryptoHandler handler = new CryptoHandler();

                    String aa = handler.encrypt(edt_enter_text.getText().toString());
                    txt_dummy.setText(aa);
                    Log.e("encode ", "encode prince : " + aa);
*/
                    //  LoadCitiesDB();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });

        btn_decrypt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                try {
                   /* String decrypted = AESUtils.decrypt(txt_dummy.getText().toString());
                    Log.e("TEST", "decrypted:  " + decrypted);
                    txt_dummy.setText(decrypted);*/

                  /*  String aa = AESEncyption.decrypt(txt_dummy.getText().toString());
                    txt_dummy.setText(aa);*/

                    // Part 1
/*
                    CryptoHandler handler = new CryptoHandler();

                    String aa = handler.decrypt(txt_dummy.getText().toString());
                    txt_dummy.setText(aa);
*/


                    CharchitDecription handler = new CharchitDecription();


                    String aa = handler.decrypt(txt_dummy.getText().toString());

                    Log.e("DDDencode ", "DDDencode  prince : " + aa);
                    txt_dummy.setText(aa);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }


    private void createids() {

        btn_press = findViewById(R.id.btn_press);
        btn_decrypt = findViewById(R.id.btn_decrypt);
        txt_dummy = findViewById(R.id.txt_dummy);
        edt_enter_text = findViewById(R.id.edt_enter_text);
    }
}
