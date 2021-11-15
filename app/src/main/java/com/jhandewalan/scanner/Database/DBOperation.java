package com.jhandewalan.scanner.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.jhandewalan.scanner.Pojo.OpeningBeans;

import java.util.ArrayList;

public class DBOperation {
    final static String PREFS_NAME = "MyPrefsFile";


//////////////// DBCount/////////////////


    public static int getFTL_count(Context c) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);
        Cursor cur = null;
        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            {

                cur = database.rawQuery("select * from " + Database_Utils.FTL_table, null);

            }
            int len = 0;
            len = cur.getCount();
            System.out.println("lenght " + len);
            if (len > 0) {
                SharedPreferences pageNumPref = c.getSharedPreferences(
                        PREFS_NAME, 0);
                pageNumPref.edit().putInt("dbsize", len).commit();

            } else {
                cur.close();
                DatabaseHelper.closedatabase();
            }
            cur.moveToNext();
            cur.close();
            DatabaseHelper.closedatabase();
            return len;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static int getDBCount(Context c, String Table_Name) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);
        Cursor cur = null;
        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            {

                cur = database.rawQuery("select * from " + Table_Name, null);

            }
            int len = 0;
            len = cur.getCount();
            System.out.println("lenght " + len);
            if (len > 0) {


            } else {
                cur.close();
                DatabaseHelper.closedatabase();
            }
            cur.moveToNext();
            cur.close();
            DatabaseHelper.closedatabase();
            return len;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //////////////// End DBCount/////////////////

/////////////Insert Data im db////////////////////

/*

    public static boolean insertFTL(Context c, List<FTLPojo.Response> billingType) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);


        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();

            for (int i = 0; i < billingType.size(); i++) {
                ContentValues newValues = new ContentValues();
                newValues.put(Database_Utils.code_id, billingType.get(i).getCodeId());
                newValues.put(Database_Utils.code_desc, billingType.get(i).getCodeDesc());

                // Insert the row into your table
                database.insert(Database_Utils.FTL_table, null, newValues);

            }
            database.close();
            DatabaseHelper.closedatabase();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
*/


    public static boolean DeleteTableData(Context c, String table_name) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);
        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();

            String sql = "delete from " + table_name;
            database.execSQL(sql);
            database.close();
            DatabaseHelper.closedatabase();
            Log.e("Delete", "Remove : " + true);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param c
     * @param userDetail
     * @param scan_by
     * @param scan_time
     * @param scan_date
     * @param latitude
     * @param longitude
     * @return
     */
    public static boolean insertUserEntry(Context c, OpeningBeans userDetail, String scan_by, String scan_time, String
            scan_date, String latitude, String longitude) {


        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);


        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            ContentValues newValues = new ContentValues();
            newValues.put(Database_Utils.booking_id, userDetail.getId());
            newValues.put(Database_Utils.devotee_id, userDetail.getDevoteeId());
            newValues.put(Database_Utils.booking_date, userDetail.getBookingDate());
            newValues.put(Database_Utils.no_of_person, userDetail.getNoOfPerson());
            newValues.put(Database_Utils.scanned_by, scan_by);
            newValues.put(Database_Utils.slot_name, userDetail.getName());
            newValues.put(Database_Utils.Scanned_timing, scan_time);
            newValues.put(Database_Utils.scan_date, scan_date);
            newValues.put(Database_Utils.latitude, latitude);
            newValues.put(Database_Utils.longitude, longitude);
            newValues.put(Database_Utils.senior, userDetail.getSenior());
            newValues.put(Database_Utils.ladies, userDetail.getLadies());
            newValues.put(Database_Utils.childern, userDetail.getChildren());
            newValues.put(Database_Utils.created_at, userDetail.getCreatedAt());
            newValues.put(Database_Utils.user_name, userDetail.getFname());


            // Insert the row into your table
            database.insert(Database_Utils.tbl_gate_entery_day_1, null, newValues);

            database.close();
            DatabaseHelper.closedatabase();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    ////////////////////// END Table Data DELETE /////////////////////////

/////////////////// get Data Operation///////////////////////


    // Chalan Drop Down
   /* public static ArrayList<GetterSetter_Basic_drop> getFTL(Context c, String table_name) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);
        Cursor cur = null;
        ArrayList<GetterSetter_Basic_drop> ListModals;
        ListModals = new ArrayList<>();
        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            {
                //cur = database.rawQuery("select Quotes from LoveQuotes where isFav =1", null);
                cur = database.rawQuery("select * from " + table_name, null);

            }
            int len = cur.getCount();
            System.out.println("lenght " + len);
            if (len > 0) {

            } else {
                cur.close();
                DatabaseHelper.closedatabase();
            }

            cur.moveToNext();

            for (int i = 0; i < len; i++) {

                ListModals.add(new GetterSetter_Basic_drop(cur.getString(cur.getColumnIndex(Database_Utils.code_id)),
                        cur.getString(cur.getColumnIndex(Database_Utils.code_desc))));

                cur.moveToNext();

                //	System.out.println(data[i]);

            }
            cur.close();
            DatabaseHelper.closedatabase();
            return ListModals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

*/

/// Sewadar  DB Maintanance

    public static boolean isSewadarAlreadyEnter(Context c, String booking_id) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);
        Cursor cur = null;
        boolean isuserEnter = false;

        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            {
                cur = database.rawQuery("select * from tbl_sevadar where booking_id =" + booking_id, null);

            }


            int len = cur.getCount();
            System.out.println("lenght " + len);
            if (len > 0) {
                isuserEnter = true;

            } else {
                isuserEnter = false;
                cur.close();
                DatabaseHelper.closedatabase();
            }

            cur.moveToNext();


            DatabaseHelper.closedatabase();
            return isuserEnter;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @param c
     * @param userDetail
     * @param scan_by
     * @param scan_time
     * @param scan_date
     * @param latitude
     * @param longitude
     * @return
     */
    public static boolean insertSewadarEntry(Context c, OpeningBeans userDetail, String scan_by, String scan_time, String
            scan_date, String latitude, String longitude) {


        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);


        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            ContentValues newValues = new ContentValues();
            newValues.put(Database_Utils.booking_id, userDetail.getId());
           // newValues.put(Database_Utils.devotee_id, userDetail.getDevoteeId());
            newValues.put(Database_Utils.booking_date, userDetail.getBookingDate());
            newValues.put(Database_Utils.no_of_person, userDetail.getNoOfPerson());
            newValues.put(Database_Utils.scanned_by, scan_by);

            newValues.put(Database_Utils.Scanned_timing, scan_time);
            newValues.put(Database_Utils.scan_date, scan_date);
            newValues.put(Database_Utils.latitude, latitude);
            newValues.put(Database_Utils.longitude, longitude);

            newValues.put(Database_Utils.created_at, userDetail.getCreatedAt());
            newValues.put(Database_Utils.user_name, userDetail.getSevadarName());
            newValues.put(Database_Utils.sewadar_id, userDetail.getSevadarId());
            newValues.put(Database_Utils.batch_id, userDetail.getBatchNo());
            // Insert the row into your table
           database.insert(Database_Utils.tbl_sevadar, null, newValues);

            database.close();
            DatabaseHelper.closedatabase();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    /// Bhakt DB Maintanance
    public static boolean isuserAlreadyEnter(Context c, String booking_id) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);
        Cursor cur = null;
        boolean isuserEnter = false;

        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            {
                cur = database.rawQuery("select * from tbl_gate_entery_day_1 where booking_id =" + booking_id, null);

            }


            int len = cur.getCount();
            System.out.println("lenght " + len);
            if (len > 0) {
                isuserEnter = true;

            } else {
                isuserEnter = false;
                cur.close();
                DatabaseHelper.closedatabase();
            }

            cur.moveToNext();


            DatabaseHelper.closedatabase();
            return isuserEnter;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static ArrayList<OpeningBeans> getUserListing(Context c, String table_name) {
        DatabaseHelper dbhelperShopCart = new DatabaseHelper(c);
        Cursor cur = null;
        ArrayList<OpeningBeans> ListModals;
        ListModals = new ArrayList<>();
        try {
            dbhelperShopCart.createDataBase();
            SQLiteDatabase database = DatabaseHelper.openDataBase();
            {
                //cur = database.rawQuery("select Quotes from LoveQuotes where isFav =1", null);
                cur = database.rawQuery("select * from " + table_name, null);

            }
            int len = cur.getCount();
            System.out.println("lenght " + len);
            if (len > 0) {

            } else {
                cur.close();
                DatabaseHelper.closedatabase();
            }

            cur.moveToNext();

            for (int i = 0; i < len; i++) {

                Log.e("SQLITE", "Booking id  : " + cur.getString((cur.getColumnIndex(Database_Utils.booking_id))));


                ListModals.add(new OpeningBeans(cur.getString(cur.getColumnIndex(Database_Utils.booking_id)),
                        cur.getString(cur.getColumnIndex(Database_Utils.booking_id)),
                        cur.getString(cur.getColumnIndex(Database_Utils.booking_date)),
                        cur.getString(cur.getColumnIndex(Database_Utils.no_of_person))
                        , cur.getString(cur.getColumnIndex(Database_Utils.senior)),
                        cur.getString(cur.getColumnIndex(Database_Utils.ladies)),
                        cur.getString(cur.getColumnIndex(Database_Utils.childern)),
                        "", "", ""
                        , cur.getString(cur.getColumnIndex(Database_Utils.Scanned_timing)),
                        cur.getString(cur.getColumnIndex(Database_Utils.scanned_by)),
                        cur.getString(cur.getColumnIndex(Database_Utils.created_at)),
                        cur.getString(cur.getColumnIndex(Database_Utils.scan_date)),
                        cur.getString(cur.getColumnIndex(Database_Utils.slot_name))
                        , "", "", cur.getString(cur.getColumnIndex(Database_Utils.user_name)),
                        "", ""
                        , cur.getString(cur.getColumnIndex(Database_Utils.user_name))));

                cur.moveToNext();

                //	System.out.println(data[i]);

            }
            cur.close();
            DatabaseHelper.closedatabase();
            return ListModals;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
