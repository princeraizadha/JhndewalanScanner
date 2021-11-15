package com.jhandewalan.scanner.Activity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jhandewalan.scanner.Adapter.UserDetailAdapter;
import com.jhandewalan.scanner.Database.DBOperation;
import com.jhandewalan.scanner.Database.Database_Utils;
import com.jhandewalan.scanner.Pojo.OpeningBeans;
import com.jhandewalan.scanner.R;
import com.jhandewalan.scanner.Support.DateMaster;
import com.jhandewalan.scanner.Support.RootActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class EntryDetailPage extends RootActivity {
    RecyclerView rcv_userEntry_listing;
    Context con;
    UserDetailAdapter UserDetailMasterAdapter;

    Button btn_export;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterydetail_page);
        con = EntryDetailPage.this;
        createIds();
        getdataFromDB();
        clickEvent();


    }

    private void clickEvent() {
        btn_export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                copyDatabase(EntryDetailPage.this, Database_Utils.DB_NAME);

            }
        });
    }

    private void getdataFromDB() {
        ArrayList<OpeningBeans> data = new ArrayList<>();
        data = DBOperation.getUserListing(EntryDetailPage.this, Database_Utils.tbl_gate_entery_day_1);
        Log.e("DB Size", "Data Size : " + data.size());


        UserDetailMasterAdapter = new UserDetailAdapter(con, data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(con);
        mLayoutManager.setAutoMeasureEnabled(true);
        rcv_userEntry_listing.setLayoutManager(mLayoutManager);
        rcv_userEntry_listing.setItemAnimator(new DefaultItemAnimator());
        rcv_userEntry_listing.setAdapter(UserDetailMasterAdapter);


    }

    public void copyDatabase(Context c, String DATABASE_NAME) {
        String databasePath = c.getDatabasePath(DATABASE_NAME).getPath();
        String DB_PATH = "/data/data/com.jhandewalan.scanner/";

        String DB_NAME = Database_Utils.DB_NAME;
        databasePath = DB_PATH + DB_NAME;
        File f = new File(databasePath);
        OutputStream myOutput = null;
        InputStream myInput = null;
        Log.d("testing", " testing db path " + databasePath);
        Log.d("testing", " testing db exist " + f.exists());

        if (f.exists()) {
            try {
                String mHomePath;
                //  File directory = new File("/mnt/sdcard/Vistraka_prince");
                mHomePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/admin_jhandewalan/";
                //  File directory = new File(mHomePath);
                ContextWrapper contextwrap = new ContextWrapper(EntryDetailPage.this);
                File pdfDirectory = contextwrap.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

                //    mPath = file.getPath();

                if (!pdfDirectory.exists()) {
                    Boolean can_creatdve = pdfDirectory.mkdirs();
                    Boolean can_create = pdfDirectory.mkdir();

                }


                myOutput = new FileOutputStream(pdfDirectory.getAbsolutePath()
                        + "/" + DateMaster.currentDateTime(false) + DATABASE_NAME);
                myInput = new FileInputStream(databasePath);

                File file = new File(pdfDirectory, DateMaster.currentDateTime(false)+DATABASE_NAME);
                String mPath = file.getPath();
                Log.e("mpath", "" + mPath);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();

                // Share intent
                // Uri uri = Uri.fromFile(file);
                Uri uri = FileProvider.getUriForFile(
                        EntryDetailPage.this,
                        "com.jhandewalan.scanner.fileprovider", //(use your app signature + ".provider" )
                        file);


                Intent intentShareFile = new Intent(Intent.ACTION_SEND);
                //File fileWithinMyDir = new File(myFilePath);
                Log.e("i am heree", "i am here  222 : " + file.exists());

                if (file.exists()) {

                    Log.e("i am heree", "i am here");
                    intentShareFile.setType("application/octet-stream");
                    intentShareFile.putExtra(Intent.EXTRA_STREAM, uri);

                    intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                            "Sharing File...");
                    intentShareFile.putExtra(Intent.EXTRA_TEXT, "Sharing File...");

                    startActivity(Intent.createChooser(intentShareFile, "Share File"));
                }

                /*Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("application/pdf");
                share.putExtra(Intent.EXTRA_STREAM, uri);
                //share.setPackage("com.whatsapp");

                startActivity(share);
*/
                Toast.makeText(EntryDetailPage.this, "Export Succesfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (myOutput != null) {
                        myOutput.close();
                        myOutput = null;
                    }
                    if (myInput != null) {
                        myInput.close();
                        myInput = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void createIds() {
        rcv_userEntry_listing = findViewById(R.id.rcv_userEntry_listing);
        btn_export = findViewById(R.id.btn_export);

    }

}
