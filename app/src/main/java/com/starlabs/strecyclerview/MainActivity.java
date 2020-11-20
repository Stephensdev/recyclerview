package com.starlabs.strecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private static final int NUM_COLUMNS=2;

    private ArrayList<String> mImageUrls= new ArrayList<>();
    private ArrayList<String> mNames= new ArrayList<>();
    private ArrayList<String> mPrice= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


    mImageUrls.add("https://i.redd.it/tkvzx2h2or841.jpg");
        mNames.add("Felt bouquet");
        mPrice.add("$32.00 USD");

        mImageUrls.add("https://i.etsystatic.com/6017053/r/il/c39f02/488204234/il_794xN.488204234_3l0r.jpg");
        mNames.add("DIY putz village");
        mPrice.add("$32.00 USD");

        mImageUrls.add("https://i.etsystatic.com/20205967/r/il/cfd9ac/2127712078/il_794xN.2127712078_974m.jpg");
        mNames.add("Dining stool");
        mPrice.add("$32.00 USD");

        mImageUrls.add("https://i.etsystatic.com/7240086/r/il/744633/2649460118/il_794xN.2649460118_6l77.jpg");
        mNames.add("Ring");
        mPrice.add("$32.00 USD");


        mImageUrls.add("https://i.etsystatic.com/12482673/r/il/fe8e3c/1508752837/il_794xN.1508752837_b397.jpg");
        mNames.add("Emergency Gin..");
        mPrice.add("$32.00 USD");

        mImageUrls.add("https://i.etsystatic.com/9674287/r/il/80d1b9/1106002066/il_794xN.1106002066_af3d.jpg");
        mNames.add("Docking station");
        mPrice.add("$32.00 USD");


        mImageUrls.add("https://i.etsystatic.com/13285848/r/il/04e625/1574085717/il_794xN.1574085717_scw6.jpg");
        mNames.add("Wood Stand Holder");
        mPrice.add("$32.00 USD");

        mImageUrls.add("https://i.etsystatic.com/8842438/r/il/63b7d4/2242590529/il_794xN.2242590529_g7td.jpg");
        mNames.add("Working Class Hero..");
        mPrice.add("$32.00 USD");

        mImageUrls.add("https://i.etsystatic.com/22494995/r/il/c324a7/2374256858/il_1588xN.2374256858_5q44.jpg");
        mNames.add("Rhodochrosite Bra..");
        mPrice.add("$32.00 USD");
        initRecyclerView();

}
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initializing staggered recyclerview.");

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        RecyclerviewAdapter recyclerviewAdapter =
                new RecyclerviewAdapter(this, mNames, mPrice, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);
    }
}