package com.starlabs.strecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerviewAdapter";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private final Context mContext;

    public RecyclerviewAdapter(Context mContext, ArrayList<String> mNames,ArrayList<String> mPrice, ArrayList<String> mImageUrls) {
        this.mNames = mNames;
        this.mPrice = mPrice;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_items, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder:called");

        RequestOptions requestOptions=new RequestOptions()
        .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.image);
        holder.names.setText(mNames.get(position));
        holder.price.setText(mPrice.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick:clicked on:"+ mNames.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView names;
        TextView price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image=itemView.findViewById(R.id.picsw);
            this.names=itemView.findViewById(R.id.namesw);
            this.price=itemView.findViewById(R.id.price);

        }
    }
}
