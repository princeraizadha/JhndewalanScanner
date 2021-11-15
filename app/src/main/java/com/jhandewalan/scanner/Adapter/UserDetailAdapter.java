package com.jhandewalan.scanner.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jhandewalan.scanner.Pojo.OpeningBeans;
import com.jhandewalan.scanner.R;

import java.util.ArrayList;
import java.util.List;

public class UserDetailAdapter extends RecyclerView.Adapter<UserDetailAdapter.ViewHolder> {

    Context context;
    ArrayList<OpeningBeans> productListBeanList;
    private List<OpeningBeans> GcFilteredList;
    Activity activity;


    public UserDetailAdapter(Context context, ArrayList<OpeningBeans> productListBeanList) {
        this.context = context;
        this.productListBeanList = productListBeanList;
//        Log.e("i m heree", "i m heree" + productListBeanList.size());
        GcFilteredList = productListBeanList;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cst_list_user_data, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.txt_booking_id.setText("Booking id : " + GcFilteredList.get(position).getId());
        holder.txt_user_name.setText(GcFilteredList.get(position).getFname());
        holder.txt_no_of_person.setText(GcFilteredList.get(position).getNoOfPerson());
        holder.txt_scan_by.setText(GcFilteredList.get(position).getScannedBy());
        holder.txt_scan_time.setText(GcFilteredList.get(position).getScannedAt());
        holder.txt_scan_date.setText(GcFilteredList.get(position).getUpdatedAt());
    }


    @Override
    public int getItemCount() {
        return GcFilteredList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView crd_gc;
        TextView txt_booking_id,
                txt_user_name, txt_no_of_person, txt_scan_by, txt_scan_time, txt_scan_date;


        public ViewHolder(View itemView) {
            super(itemView);

            txt_booking_id = itemView.findViewById(R.id.txt_booking_id);
            txt_user_name = itemView.findViewById(R.id.txt_user_name);
            txt_no_of_person = itemView.findViewById(R.id.txt_no_of_person);
            txt_scan_by = itemView.findViewById(R.id.txt_scan_by);
            txt_scan_time = itemView.findViewById(R.id.txt_scan_time);
            txt_scan_date = itemView.findViewById(R.id.txt_scan_date);


        }


    }

}




