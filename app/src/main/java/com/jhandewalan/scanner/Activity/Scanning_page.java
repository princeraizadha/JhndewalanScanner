package com.jhandewalan.scanner.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jhandewalan.scanner.Database.DBOperation;
import com.jhandewalan.scanner.Database.Database_Utils;
import com.jhandewalan.scanner.Pojo.OpeningBeans;
import com.jhandewalan.scanner.R;
import com.jhandewalan.scanner.Support.CharchitDecription;
import com.jhandewalan.scanner.Support.DateMaster;
import com.jhandewalan.scanner.Support.Itag;
import com.jhandewalan.scanner.Support.RootActivity;
import com.jhandewalan.scanner.Support.SavedData;

public class Scanning_page extends RootActivity {

    Context mContext;
    private TextView txt_registertion_no, txt_person_name, txt_date_of_registration, txt_no_of_person, txt_sr_citizen, txt_ladies, txt_child, txt_time_slot, txt_status, txt_sewadar_id, txt_batch_no;
    private LinearLayout lnt_status_line, lnt_detail_box;
    private Button btn_refresh, btn_start_scan, btn_done, btn_cancel, btn_Admin;
    int CurrentStage;
    OpeningBeans UserDetail;

    Toolbar toolbar;
    TextView txt_marking;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanning_page);
        mContext = Scanning_page.this;

        CreateIds();
        setToolBar();
        refreshView();
        clickEvent();


    }

    private void setToolBar() {

        toolbar = findViewById(R.id.toolbar_main);
        /*Drawable drawable = ContextCompat.getDrawable(Scanning_page.this, R.mipmap.ic_launcher_tool);
        toolbar.setNavigationIcon(drawable);*/
        setSupportActionBar(toolbar);
    }


    private void clickEvent() {
        btn_Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Scanning_page.this, EntryDetailPage.class);
                startActivity(i);

            }
        });
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshView();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshView();
            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserDetail.getIsSevadar()) {
                    verifyandSaveSewadar();
                } else {
                    verifyandSave();
                }
            }
        });
        btn_start_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScan();
            }
        });

    }

    private void verifyandSaveSewadar() {
        boolean isSave = DBOperation.insertSewadarEntry(Scanning_page.this, UserDetail, SavedData.getUserID(), DateMaster.currentTime(false), DateMaster.currentDate(false)
                , "456", "456");

        Log.e("i am here ", "1 : is Data Save Sewadar " + isSave);

        if (isSave) {
            refreshView();

        }
    }

    private void verifyandSave() {


        boolean isSave = DBOperation.insertUserEntry(Scanning_page.this, UserDetail, SavedData.getUserID(), DateMaster.currentTime(false), DateMaster.currentDate(false)
                , "123", "123");

        Log.e("i am here ", "1 : is Data Save " + isSave);

        if (isSave) {
            refreshView();

        }
    }

    private void startScan() {


        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(Scanning_page.this)
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withBackfacingCamera()
                .withCenterTracker()
                .withBleepEnabled(true)

                .withText("Scanning...")

                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResult(Barcode barcode) {
                        // Barcode barcodeResult = barcode;c

                        Log.e("Value : ", "Bar Code value: - " + barcode.displayValue);
                        Log.e("Value : ", "Bar Code row : - " + barcode.rawValue);
                        //       Toast.makeText(getApplicationContext(), "Bar Code : " + barcode.rawValue, Toast.LENGTH_SHORT).show();
                        //      Log.e("Value : ","Bar Code : - "+barcode.url);

                        //   result.setText(barcode.rawValue);

                        //  txt_result.setText(barcode.rawValue);
                        if (barcode.rawValue != null) {
                            try {
                                CharchitDecription handler = new CharchitDecription();
                                String decryptvalue = handler.decrypt(barcode.rawValue);

                                //String decryptvalue= barcode.rawValue;

                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                Log.e("DecryptJson", "dcrypt json " + decryptvalue);
                                UserDetail = gson.fromJson(decryptvalue, OpeningBeans.class);
                                Log.e("Is Sewadar ", "IsSevadar  Name : " + UserDetail.getName());
                                Log.e("Is Sewadar ", "IsSevadar : " + UserDetail.getIsSevadar());

                                if (UserDetail.getIsSevadar()) {
                                    Log.e("in Sewadar","in sewadar");

                                    ValidateSewadar(UserDetail);
                                } else {
                                    Log.e("in bhakt","in Bhakt");

                                    ValidateBhakt(UserDetail);

                                }


                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            // Set Data and hide

                        } else {
                            // redirect to invalid Screen;
                        }
                    }
                })
                .build();
        materialBarcodeScanner.startScan();
    }

    private void ValidateSewadar(OpeningBeans userDetail) {
        boolean isSewadarEnter = DBOperation.isSewadarAlreadyEnter(Scanning_page.this, UserDetail.getId());
        Log.e("i am here", "is Sewadar Enter : " + isSewadarEnter);
        validatSewadarJson(userDetail, isSewadarEnter);
    }

    private void validatSewadarJson(OpeningBeans values, boolean isSewadarEnter) {


        txt_registertion_no.setText(" :  " + values.getId());
        txt_date_of_registration.setText("" + values.getBookingDate());
        txt_no_of_person.setText("" + 1);
        txt_person_name.setText("" + values.getSevadarName());

        txt_sr_citizen.setText("N.A"  );
        txt_ladies.setText("N.A");
        txt_child.setText("N.A");
        txt_time_slot.setText("N.A");

        txt_sewadar_id.setText("" + values.getSevadarId());
        txt_batch_no.setText("" + values.getBatchNo());


        if (!DateMaster.currentDateIndian(false).equalsIgnoreCase(values.getBookingDate())) {
            txt_status.setText("Sewadar Qr code is not of Todays Date");
            lnt_status_line.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            Log.e("current Date " + DateMaster.currentDate(false), " qr date  : " + values.getBookingDate());
            rejectView();

        } else if (isSewadarEnter) {
            txt_status.setText("Sewadar Already Enter in Temple");
            lnt_status_line.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            rejectView();


        } else {
            txt_status.setText("Succesfull");
            lnt_status_line.setBackgroundColor(getResources().getColor(R.color.green_bright));

            Successview();

        }
    }

    private void ValidateBhakt(OpeningBeans userDetail) {
        boolean isUserEnter = DBOperation.isuserAlreadyEnter(Scanning_page.this, UserDetail.getId());
        Log.e("i am here 22", "isUserEnter : " + isUserEnter);
        validateJson(userDetail, isUserEnter);


    }

    private void validateJson(OpeningBeans values, boolean isuserEnter) {
        txt_registertion_no.setText(" :  " + values.getId());
        txt_date_of_registration.setText("" + values.getBookingDate());
        txt_no_of_person.setText("" + values.getNoOfPerson());
        txt_person_name.setText("" + values.getFname());
        txt_sr_citizen.setText("" + values.getSenior());
        txt_ladies.setText("" + values.getLadies());
        txt_child.setText("" + values.getChildren());
        txt_time_slot.setText("" + values.getName());

        txt_sewadar_id.setText("N.A" );
        txt_batch_no.setText("N.A");

        if (!DateMaster.currentDate(false).equalsIgnoreCase(values.getBookingDate())) {
            txt_status.setText("Qr code is not of Todays Date");
            lnt_status_line.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            Log.e("current Date " + DateMaster.currentDate(false), " qr date  : " + values.getBookingDate());
            rejectView();

        } else if (isuserEnter) {
            txt_status.setText("user Already Enter in Temple");
            lnt_status_line.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            rejectView();


        } else {
            txt_status.setText("Succesfull");
            lnt_status_line.setBackgroundColor(getResources().getColor(R.color.green_bright));

            Successview();

        }


    }

    private void Successview() {
        btn_refresh.setVisibility(View.GONE);
        btn_start_scan.setVisibility(View.GONE);
        btn_cancel.setVisibility(View.VISIBLE);
        btn_done.setVisibility(View.VISIBLE);
        lnt_detail_box.setVisibility(View.VISIBLE);
    }

    private void rejectView() {
        btn_refresh.setVisibility(View.VISIBLE);
        btn_start_scan.setVisibility(View.GONE);
        btn_cancel.setVisibility(View.VISIBLE);
        btn_done.setVisibility(View.GONE);
        lnt_detail_box.setVisibility(View.VISIBLE);
    }

    private void refreshView() {

        txt_registertion_no.setText("N.A");
        txt_person_name.setText("N.A");
        txt_date_of_registration.setText("N.A");
        txt_no_of_person.setText("N.A");
        txt_status.setText("Online Booking Scanner");
        txt_sr_citizen.setText("N.A");
        txt_ladies.setText("N.A");
        txt_child.setText("N.A");
        txt_time_slot.setText("N.A");
        CurrentStage = Itag.Stage1;
        btn_done.setVisibility(View.GONE);
        btn_cancel.setVisibility(View.GONE);
        btn_start_scan.setVisibility(View.VISIBLE);
        btn_refresh.setVisibility(View.VISIBLE);

        lnt_status_line.setBackgroundColor(getResources().getColor(R.color.blue));
        lnt_detail_box.setVisibility(View.INVISIBLE);
        int Bhakt_Entry_count = 0;
        Bhakt_Entry_count = GetBhaktCount();

        txt_marking.setText("" + Bhakt_Entry_count);
    }

    private int GetBhaktCount() {

        int Count = 0;

        int value = DBOperation.getUserListing(Scanning_page.this, Database_Utils.tbl_gate_entery_day_1).size();

        if (value > 0) {
            return value;
        } else {
            return Count;
        }
    }

    private void CreateIds() {
        txt_registertion_no = findViewById(R.id.txt_registertion_no);
        txt_person_name = findViewById(R.id.txt_person_name);
        txt_date_of_registration = findViewById(R.id.txt_date_of_registration);
        txt_no_of_person = findViewById(R.id.txt_no_of_person);
        txt_sr_citizen = findViewById(R.id.txt_sr_citizen);
        txt_ladies = findViewById(R.id.txt_ladies);
        txt_child = findViewById(R.id.txt_child);
        txt_time_slot = findViewById(R.id.txt_time_slot);
        txt_marking = findViewById(R.id.txt_marking);
        txt_sewadar_id = findViewById(R.id.txt_sewadar_id);
        txt_batch_no = findViewById(R.id.txt_batch_no);


        txt_status = findViewById(R.id.txt_status);
        lnt_status_line = findViewById(R.id.lnt_status_line);

        btn_refresh = findViewById(R.id.btn_refresh);
        btn_start_scan = findViewById(R.id.btn_start_scan);
        btn_done = findViewById(R.id.btn_done);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_Admin = findViewById(R.id.btn_Admin);

        lnt_detail_box = findViewById(R.id.lnt_detail_box);
        lnt_status_line = findViewById(R.id.lnt_status_line);

        if (SavedData.getUserID().equalsIgnoreCase("prince_admin")) {

            btn_Admin.setVisibility(View.VISIBLE);
        } else {
            btn_Admin.setVisibility(View.GONE);

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SavedData.getUserID().equalsIgnoreCase("")) {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            SavedData.setUserID("");
            SavedData.ClearAll();
            Intent i = new Intent(Scanning_page.this, LoginPage.class);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
