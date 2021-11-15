package com.jhandewalan.scanner.Support;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.jhandewalan.scanner.app.AppController;


public class SavedData {
    private static final String USER_ID = "USER_ID";

    private static final String USER_NAME = "USER_NAME";
    private static final String USER_Email = "USER_Email";
    private static final String USER_Role = "USER_Role";
    private static final String FULL_NAME = "FULL_NAME";
    private static final String ADDRESS = "ADDRESS";
    private static final String isLogin = "isLogin";
    private static final String isNewOpen = "isNewOpen";
    private static final String PROFILE_PIC = "PROFILE_PIC";
    private static final String MOBILE1 = "MOBILE1";
    private static final String MOBILE2 = "MOBILE2";
    private static final String Gender = "Gender";
    private static final String Branch_code = "Branch_code";

    private static final String last_lat = "last_lat";
    private static final String last_long = "last_long";

    private static final String version_code = "version_code";
    private static final String IsIntroComplete = "IsIntroComplete";
    private static final String ApmCode = "ApmCode";
    private static final String permisionSet = "permisionSet";

    private static final String add_lat = "add_lat";
    private static final String add_long = "add_long";

    private static final String TEMPEnquery = "TEMPEnquery";
    private static final String TEMPEnqueryData = "TEMPEnqueryData";
    private static final String DateSlotSurvey = "DateSlotSurvey";
    private static final String MovementCatagory = "MovementCatagory";
    private static final String MovementItemCount = "MovementItemCount";
    private static final String SurveyType = "SurveyType";

    private static final String TempSurvey_date = "TempSurvey_date";
    private static final String TempSurvey_day = "TempSurvey_day";
    private static final String TempSurvey_time = "TempSurvey_time";
    private static final String TempSurvey_timeID = "TempSurvey_timeID";
    private static final String TempSlotType = "TempSlotType";
    private static final String MovementType = "MovementType";

    static SharedPreferences prefs;

    private static final String Locality = "Locality";
    private static final String CountryName = "CountryName";
    private static final String PostalCode = "PostalCode";
    private static final String AdminArea = "AdminArea";
    private static final String SubLocality = "SubLocality";
    private static final String SubAdminArea = "SubAdminArea";

    private static final String carModelResponse = "carModelResponse";
    private static final String carRateResponse = "carRateResponse";

    private static final String CityData = "CityData";

    public static SharedPreferences getInstance() {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(AppController.getInstance());
        }
        return prefs;
    }


    public static String getCityData() {
        return getInstance().getString(CityData, "");
    }

    public static void setCityData(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(CityData, value);
        editor.apply();
    }


    public static String getAdd_lat() {
        return getInstance().getString(add_lat, "");
    }

    public static void setAdd_lat(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(add_lat, value);
        editor.apply();
    }

    public static String getAdd_long() {
        return getInstance().getString(add_long, "");
    }

    public static void setAdd_long(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(add_long, value);
        editor.apply();
    }

    public static String getLocality() {
        return getInstance().getString(Locality, "");
    }

    public static void setLocality(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(Locality, value);
        editor.apply();
    }

    public static String getCountryName() {
        return getInstance().getString(CountryName, "");
    }

    public static void setCountryName(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(CountryName, value);
        editor.apply();
    }

    public static String getPostalCode() {
        return getInstance().getString(PostalCode, "");
    }

    public static void setPostalCode(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(PostalCode, value);
        editor.apply();
    }

    public static String getAdminArea() {
        return getInstance().getString(AdminArea, "");
    }

    public static void setAdminArea(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(AdminArea, value);
        editor.apply();
    }

    public static String getSubLocality() {
        return getInstance().getString(SubLocality, "");
    }

    public static void setSubLocality(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(SubLocality, value);
        editor.apply();
    }

    public static String getSubAdminArea() {
        return getInstance().getString(SubAdminArea, "");
    }

    public static void setSubAdminArea(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(SubAdminArea, value);
        editor.apply();
    }


    public static String getPermisionSet() {
        return getInstance().getString(permisionSet, "");
    }

    public static void setPermisionSet(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(permisionSet, value);
        editor.apply();
    }


    ////////////////////////////////


    public static String getApmCode() {
        return getInstance().getString(ApmCode, "");
    }

    public static void setApmCode(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(ApmCode, value);
        editor.apply();
    }


    public static String getBranch_code() {
        return getInstance().getString(Branch_code, "");
    }

    public static void setBranch_code(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(Branch_code, value);
        editor.apply();
    }


    public static Boolean getIsIntroComplete() {
        return getInstance().getBoolean(IsIntroComplete, false);
    }

    public static void setIsIntroComplete(boolean value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putBoolean(IsIntroComplete, value);
        editor.apply();
    }


    public static String getGender() {
        return getInstance().getString(Gender, "");
    }

    public static void setGender(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(Gender, value);
        editor.apply();
    }

    public static String getLast_lat() {
        return getInstance().getString(last_lat, "null");
    }

    public static void setLast_lat(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(last_lat, value);
        editor.apply();
    }

    public static String getLast_long() {
        return getInstance().getString(last_long, "null");
    }

    public static void setLast_long(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(last_long, value);
        editor.apply();
    }


    public static String getversion() {
        return getInstance().getString(version_code, "");
    }

    public static void setversion(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(version_code, value);
        editor.apply();
    }


    // End

    public static String getUserID() {
        return getInstance().getString(USER_ID, "");
    }

    public static void setUserID(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(USER_ID, value);
        editor.apply();
    }

    public static String getUSER_Email() {
        return getInstance().getString(USER_Email, "null");
    }

    public static void setUSER_Email(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(USER_Email, value);
        editor.apply();
    }


    public static String getUSER_Role() {
        return getInstance().getString(USER_Role, "null");
    }

    public static void setUSER_Role(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(USER_Role, value);
        editor.apply();
    }


    public static void ClearAll() {
        PreferenceManager.getDefaultSharedPreferences(AppController.getInstance()).
                edit().clear().apply();
    }


    public static String getMOBILE2() {
        return getInstance().getString(MOBILE2, "");
    }

    public static void saveMOBILE2(String sMOBILE2) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(MOBILE2, sMOBILE2);
        editor.apply();
    }


    public static String getMOBILE1() {
        return getInstance().getString(MOBILE1, "");
    }

    public static void saveMOBILE1(String sMOBILE1) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(MOBILE1, sMOBILE1);
        editor.apply();
    }


    public static String getPROFILE_PIC() {
        return getInstance().getString(PROFILE_PIC, "");
    }

    public static void savePROFILE_PIC(String sPROFILE_PIC) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(PROFILE_PIC, sPROFILE_PIC);
        editor.apply();
    }


    public static void saveisNewOpen(boolean Login) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putBoolean(isNewOpen, Login);
        editor.apply();
    }


    public static boolean getisNewOpen() {
        return getInstance().getBoolean(isNewOpen, true);
    }

    public static boolean getLogin() {
        return getInstance().getBoolean(isLogin, false);
    }

    public static void saveLogin(boolean Login) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putBoolean(isLogin, Login);
        editor.apply();
    }


    public static String getADDRESS() {
        return getInstance().getString(ADDRESS, "");
    }

    public static void saveADDRESS(String sADDRESS) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(ADDRESS, sADDRESS);
        editor.apply();
    }


    public static String getUSER_NAME() {
        return getInstance().getString(USER_NAME, "");
    }

    public static void saveUSER_NAME(String sUSER_NAME) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(USER_NAME, sUSER_NAME);
        editor.apply();
    }

    public static String getFULL_NAME() {
        return getInstance().getString(FULL_NAME, "");
    }

    public static void saveFULL_NAME(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(FULL_NAME, value);
        editor.apply();
    }

    public static String GetTempEnqueryEdit() {
        return getInstance().getString(TEMPEnquery, "");
    }

    public static void SetTempEnqueryEdit(String sFULL_NAME) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(TEMPEnquery, sFULL_NAME);
        editor.apply();
    }


    public static String GetTempEnqueryData() {
        return getInstance().getString(TEMPEnqueryData, "");
    }

    public static void SetTempEnqueryData(String sFULL_NAME) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(TEMPEnqueryData, sFULL_NAME);
        editor.apply();
    }


    public static String GetDateSlotResponse() {
        return getInstance().getString(DateSlotSurvey, "");
    }

    public static void SetDateSlotResponse(String sFULL_NAME) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(DateSlotSurvey, sFULL_NAME);
        editor.apply();
    }

    public static String GetmovementCatagory() {
        return getInstance().getString(MovementCatagory, "");
    }

    public static void SetmovementCatagory(String catagory) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(MovementCatagory, catagory);
        editor.apply();
    }

    public static String GetItemCount() {
        return getInstance().getString(MovementItemCount, "");
    }

    public static void SetItemCount(String catagory) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(MovementItemCount, catagory);
        editor.apply();
    }

    public static String GetSurvey_type() {
        return getInstance().getString(SurveyType, "");
    }

    public static void SetSurvey_type(String catagory) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(SurveyType, catagory);
        editor.apply();
    }


    public static String getTempSelected_date() {
        return getInstance().getString(TempSurvey_date, "");
    }

    public static void setTempSelected_date(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(TempSurvey_date, value);
        editor.apply();
    }


    public static String getTempSelected_day() {
        return getInstance().getString(TempSurvey_day, "");
    }

    public static void setTempSelected_day(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(TempSurvey_day, value);
        editor.apply();
    }


    public static String getTemp_survey_time() {
        return getInstance().getString(TempSurvey_time, "");
    }

    public static void setTemp_survey_time(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(TempSurvey_time, value);
        editor.apply();
    }


    public static String getTemp_survey_timeID() {
        return getInstance().getString(TempSurvey_timeID, "");
    }

    public static void setTemp_survey_timeID(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(TempSurvey_timeID, value);
        editor.apply();
    }


    public static String getTemp_survey_SlotType() {
        return getInstance().getString(TempSlotType, "");
    }

    public static void setTemp_survey_SlotType(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(TempSlotType, value);
        editor.apply();
    }


    public static String getMovementType() {
        return getInstance().getString(MovementType, "");
    }

    public static void setMovementType(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(MovementType, value);
        editor.apply();
    }

    public static String GetCarModelResponse() {
        return getInstance().getString(carModelResponse, "");
    }

    public static void SetCarModelResponse(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(carModelResponse, value);
        editor.apply();
    }


    public static String GetCarRatelResponse() {
        return getInstance().getString(carRateResponse, "");
    }

    public static void SetCarRatelResponse(String value) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(carRateResponse, value);
        editor.apply();
    }


}
