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
//    Double lat[];
//    Double longi[];
    String vicinity[];
    double lat[], longi[];
    public LocationAdapter( String country[],double lat[], double longi[]){
        this.country = country;
        this.lat = lat;
        this.longi = longi;
//        this.vicinity = vicinity;

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

        holder.tx_lat.setText(Double.valueOf(lat[position]).toString());
        holder.tx_longi.setText(Double.valueOf(longi[position]).toString());
//        holder.tx_vicinity.setText(vicinity[position]);
    }

    @Override
    public int getItemCount() {
        return country.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView tx_country, tx_lat,tx_longi,tx_vicinity;


        public MainViewHolder(View view){
            super(view);
            tx_country = (TextView)view.findViewById(R.id.country);
            tx_lat = (TextView)view.findViewById(R.id.lat);
            tx_longi = (TextView)view.findViewById(R.id.longi);
            tx_vicinity = (TextView)view.findViewById(R.id.vicinity);
        }
    }

}
