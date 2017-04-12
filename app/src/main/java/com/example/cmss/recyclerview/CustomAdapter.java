package com.example.cmss.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.example.cmss.recyclerview.R.id.name;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> Name;
    ArrayList<String> Designation;
    ArrayList<String> Id;
    ArrayList<String> ContactNumber;
    ArrayList<String> CompanyName;
    ArrayList<Integer> Images;
    Context context;


    public CustomAdapter(ArrayList<String> name, ArrayList<String> designation,ArrayList<String>id, ArrayList<String> contactNumber, ArrayList<String> companyName, ArrayList<Integer> images, Context context) {
        Name = name;
        Designation = designation;
        Id=id;
        ContactNumber = contactNumber;
        CompanyName = companyName;
        Images = images;
        this.context = context;
    }

    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder view = new MyViewHolder(v); // pass the view to View Holder
        return view;

    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(Name.get(position));
        holder.Designation.setText(Designation.get(position));
        holder.Id.setText(Id.get(position));
        holder.ContactNumber.setText(ContactNumber.get(position));
        holder.CompanyName.setText(CompanyName.get(position));
        holder.image.setImageResource(Images.get(position));

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e(TAG, "onClick: "+Name.get(position) );
                Intent intent =new Intent(context,DisplayDetails.class);
                intent.putExtra("Name",Name.get(position));
                intent.putExtra("Designation",Designation.get(position));
                intent.putExtra("Id",Id.get(position));
                intent.putExtra("ContactNumber",ContactNumber.get(position));
                intent.putExtra("CompanyName",CompanyName.get(position));
                Bundle bundle = new Bundle();
                bundle.putInt("image",Images.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name,Designation,ContactNumber,CompanyName,Id;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            Designation=(TextView)itemView.findViewById(R.id.Designation);
            Id=(TextView)itemView.findViewById(R.id.Companyid);
            CompanyName = (TextView) itemView.findViewById(R.id.CompanyName);
            ContactNumber = (TextView) itemView.findViewById(R.id.ContactNumber);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
