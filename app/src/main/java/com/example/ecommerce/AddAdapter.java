package com.example.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.ViewHolder> {

    public AddAdapter(Activity activity ,Context context,ArrayList addDescription, ArrayList telephoneNum, ArrayList heading, ArrayList address,
                      ArrayList type, ArrayList username, ArrayList addID)
    {
        this.addDescription = addDescription;
        this.telephoneNum = telephoneNum;
        this.heading = heading;
        this.address = address;
        this.type = type;
        this.username = username;
        this.addID = addID;
        this.context = context;
        this.activity = activity;
    }

    public AddAdapter(Activity activity ,Context context,ArrayList addDescription, ArrayList telephoneNum, ArrayList heading, ArrayList address,
                      ArrayList type, String username, ArrayList addID)
    {
        this.addDescription = addDescription;
        this.telephoneNum = telephoneNum;
        this.heading = heading;
        this.address = address;
        this.type = type;
        this.username1 = username;
        this.addID = addID;
        this.context = context;
        this.activity = activity;
    }

    ArrayList addDescription, telephoneNum, heading, address,type,username,addID;
    String username1;
    Context context;
    private Activity activity;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.additem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

            holder.textView1.setText(String.valueOf(heading.get(position)));
            holder.textView2.setText(String.valueOf(type.get(position)));
            holder.textView3.setText(String.valueOf(address.get(position)));
            holder.textView4.setText(String.valueOf(telephoneNum.get(position)));
            System.out.println(String.valueOf(addID.get(position)));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,String.valueOf(heading.get(position)),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, productDisplay.class);
                    intent.putExtra("ADDID",String.valueOf(addID.get(position)));
                    intent.putExtra("HEADING",String.valueOf(heading.get(position)));
                    intent.putExtra("DESCRIPTION",String.valueOf(addDescription.get(position)));
                    intent.putExtra("TYPE",String.valueOf(type.get(position)));
                    intent.putExtra("USERNAME",String.valueOf(username.get(position)));
                    intent.putExtra("ADDRESS",String.valueOf(address.get(position)));
                    intent.putExtra("TELEPHONENUM",String.valueOf(telephoneNum.get(position)));
                    activity.startActivityForResult(intent, 1);
                }
            });
    }

    @Override
    public int getItemCount() {
        return addID.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
       // ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // imageView= itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.heading);
            textView2 = itemView.findViewById(R.id.type);
            textView3 = itemView.findViewById(R.id.address);
            textView4 = itemView.findViewById(R.id.telephonenum);
            mainLayout = itemView.findViewById(R.id.allAddsLinear);
        }
    }
}
