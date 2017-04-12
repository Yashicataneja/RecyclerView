package com.example.cmss.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.ContentValues.TAG;


public class DisplayDetails extends AppCompatActivity {

    TextView txtname,txtDesignation,txtCompany,txtContact,txtid;
    ImageView img;
    String strName,strDesignation,strCompany,strContact,Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        txtname=(TextView)findViewById(R.id.setname);
        txtDesignation=(TextView)findViewById(R.id.setdesignation);
        txtCompany=(TextView)findViewById(R.id.setcompany);
        txtContact=(TextView)findViewById(R.id.setcontact);
        txtid=(TextView)findViewById(R.id.CompanyId);
        img=(ImageView)findViewById(R.id.setImage);

        Intent intent=getIntent();
        strName=intent.getStringExtra("Name");
        strDesignation=intent.getStringExtra("Designation");
        strCompany=intent.getStringExtra("ContactNumber");
        strContact=intent.getStringExtra("CompanyName");
        Id=intent.getStringExtra("Id");

        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("image");

        txtname.setText(strName);
        txtDesignation.setText(strDesignation);
        txtid.setText(Id);
        txtCompany.setText(strCompany);
        txtContact.setText(strContact);
        img.setImageResource(pic);

        Log.e(TAG, "DisplayName "+txtname );
    }
}
