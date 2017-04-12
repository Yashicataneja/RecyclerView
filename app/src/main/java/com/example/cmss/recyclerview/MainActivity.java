package com.example.cmss.recyclerview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import static android.content.ContentValues.TAG;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    // ArrayList for person names
    ArrayList<String> Name = new ArrayList<>(Arrays.asList("Yashica", "Ashwariya", "Farheen", "Vasudha", "Ashwini", "Swapnali"));
    ArrayList<String> Designation = new ArrayList<>(Arrays.asList("Associate Software Engineer", "Associate Software Engineer", "Associate Software Engineer", "Associate Software Engineer", "Associate Software Engineer", "Associate Software Engineer"));
    ArrayList<String> Id = new ArrayList<>(Arrays.asList("1233", "1111", "1234", "1223", ",1111", "1233"));
    ArrayList<String> ContactNumber = new ArrayList<>(Arrays.asList("9999999999", "9999999999", "9999999999 ", "9999999999", "9999999999", "9999999999"));
    ArrayList<String> CompanyName = new ArrayList<>(Arrays.asList("CMSS", "Nitor", "SEED", "Cognizant", "polaris", "Tudip"));
    ArrayList<Integer>Images = new ArrayList<>(Arrays.asList(R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        // set a LinearLayoutManager
        // with default horizontal orientation and false value for reverseLayout to show the items from start to end
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(Name ,Designation,Id,ContactNumber,CompanyName,Images,MainActivity.this);
//        Log.e(TAG, "onCreate: "+Name+" "+Designation+"" +CompanyName);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}
