package com.google.android.gms.location.sample.locationupdates;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LocationHistoryViewAdapter extends RecyclerView.Adapter<LocationHistoryViewAdapter.MyViewHolder> {
    private ArrayList<LocationEntry> mDataset;
    private static final String TAG = LocationHistoryViewAdapter.class.getSimpleName();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout mLinearLayout;
        public TextView mLocationTime;
        public TextView mLocationLon;
        public TextView mLocationLat;
        public MyViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            mLinearLayout = linearLayout;
            mLocationTime = (TextView)linearLayout.getChildAt(0);
            mLocationLon = (TextView)linearLayout.getChildAt(1);
            mLocationLat = (TextView)linearLayout.getChildAt(2);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public LocationHistoryViewAdapter(ArrayList<LocationEntry> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public LocationHistoryViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        // create a new view
        Log.d(TAG, "onCreateViewHolder -> called");
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_history_textview, parent, false);
        MyViewHolder vh = new MyViewHolder(linearLayout);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.d(TAG, "onBindViewHolder -> called with position " + position + " holder is " + holder);
        holder.mLocationTime.setText(mDataset.get(position).getTime());
        holder.mLocationLat.setText(Double.toString(mDataset.get(position).getLocation().getLatitude()));
        holder.mLocationLon.setText(Double.toString(mDataset.get(position).getLocation().getLongitude()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        Log.d(TAG, "mDataset size is " + mDataset.size());
        return mDataset.size();
    }
}
