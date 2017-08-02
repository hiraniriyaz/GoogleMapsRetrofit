package com.example.riyaz.googlemapsretrofit;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;



/**
 * Created by Riyaz on 8/1/2017.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MainViewHolder> {

    String country[];
    public LocationAdapter( String country[]){
        this.country = country;

    }
    @Override
    public LocationAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        MainViewHolder mainViewHolder= new MainViewHolder(view);

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(LocationAdapter.MainViewHolder holder, int position) {
        holder.tx_country.setText(country[position]);
    }

    @Override
    public int getItemCount() {
        return country.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView tx_country;

        public MainViewHolder(View view){
            super(view);
            tx_country = (TextView)view.findViewById(R.id.country);
        }
    }

}
