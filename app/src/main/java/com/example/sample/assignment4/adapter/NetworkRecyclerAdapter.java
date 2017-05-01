package com.example.sample.assignment4.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sample.assignment4.R;
import com.example.sample.assignment4.model.Network;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by darknight on 1/5/17.
 */

public class NetworkRecyclerAdapter extends RecyclerView.Adapter<NetworkRecyclerAdapter.NetworkReyclerVH> {
    private List<Network> mNetworkList;

    /**
     * Constructor
     *
     * @param data : list of data to be displayed
     */
    public NetworkRecyclerAdapter(final List<Network> data) {
        mNetworkList = data;
    }

    @Override
    public NetworkReyclerVH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_network, parent, false);
        return new NetworkRecyclerAdapter.NetworkReyclerVH(view);
    }

    @Override
    public void onBindViewHolder(final NetworkReyclerVH holder, final int position) {
        Network current = mNetworkList.get(position);
        if (current != null) {
            holder.textViewName.setText(current.getName());
            holder.textViewCity.setText(current.getCity());
            holder.ratingBar.setRating(current.getRatings());
        }

    }

    /**
     * determine no of rows in recycler view
     *
     * @return : size of mNetworkList
     */
    @Override
    public int getItemCount() {
        return mNetworkList.size();
    }

    /**
     * Viewholder class for {@link NetworkRecyclerAdapter}
     */
    class NetworkReyclerVH extends RecyclerView.ViewHolder {
        private CircleImageView imageView;
        private TextView textViewName, textViewCity, textViewConnect;
        private RatingBar ratingBar;

        /**
         * Default constructor
         *
         * @param itemView : returns the current row
         */
        public NetworkReyclerVH(final View itemView) {
            super(itemView);
            imageView = (CircleImageView) itemView.findViewById(R.id.item_network_iv);
            textViewName = (TextView) itemView.findViewById(R.id.item_network_tv_name);
            textViewCity = (TextView) itemView.findViewById(R.id.item_network_tv_city);
            textViewConnect = (TextView) itemView.findViewById(R.id.item_network_tv_connect);
            ratingBar = (RatingBar) itemView.findViewById(R.id.item_network_rating);


            textViewConnect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Toast.makeText(itemView.getContext(), "Connect", Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
