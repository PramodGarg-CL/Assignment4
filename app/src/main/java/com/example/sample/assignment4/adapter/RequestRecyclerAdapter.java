package com.example.sample.assignment4.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sample.assignment4.R;
import com.example.sample.assignment4.model.Request;

import java.util.List;

/**
 * Created by darknight on 1/5/17.
 */

public class RequestRecyclerAdapter extends RecyclerView.Adapter<RequestRecyclerAdapter.RequestReyclerVH> {
    private List<Request> mRequestList;

    /**
     * Constructor
     *
     * @param data : list of data to be displayed
     */
    public RequestRecyclerAdapter(final List<Request> data) {
        mRequestList = data;
    }

    @Override
    public RequestReyclerVH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_request, parent, false);
        return new RequestRecyclerAdapter.RequestReyclerVH(view);
    }

    @Override
    public void onBindViewHolder(final RequestReyclerVH holder, final int position) {
        Request current = mRequestList.get(position);
        if (current != null) {
            holder.textViewName.setText(current.getName());
            holder.textViewDuration.setText(current.getName());
            holder.textViewAddress.setText(current.getAddress());
            holder.textViewText.setText(current.getReview());
            holder.ratingBar.setRating(current.getRatings());
        }

    }

    /**
     * determine no of rows in recycler view
     *
     * @return : size of mRequestList
     */
    @Override
    public int getItemCount() {
        return mRequestList.size();
    }

    /**
     * Viewholder class for {@link RequestRecyclerAdapter}
     */
    class RequestReyclerVH extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewName, textViewAddress, textViewDuration, textViewText, textViewAccept,
                textViewReject, textViewShowOn;
        private RatingBar ratingBar;

        /**
         * Default constructor
         *
         * @param itemView : returns the current row
         */
        public RequestReyclerVH(final View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_request_iv);
            textViewName = (TextView) itemView.findViewById(R.id.item_request_tv_name);
            textViewAddress = (TextView) itemView.findViewById(R.id.item_request_tv_address);
            textViewDuration = (TextView) itemView.findViewById(R.id.item_request_tv_duration);
            textViewText = (TextView) itemView.findViewById(R.id.item_request_tv_review);
            textViewAccept = (TextView) itemView.findViewById(R.id.item_request_tv_accept);
            textViewReject = (TextView) itemView.findViewById(R.id.item_request_tv_reject);
            textViewShowOn = (TextView) itemView.findViewById(R.id.item_request_tv_show_on);
            ratingBar = (RatingBar) itemView.findViewById(R.id.item_request_rating);

            textViewAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Toast.makeText(itemView.getContext(), "Accept", Toast.LENGTH_SHORT).show();

                }
            });
            textViewReject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Toast.makeText(itemView.getContext(), "Reject", Toast.LENGTH_SHORT).show();

                }
            });
            textViewShowOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Toast.makeText(itemView.getContext(), "ShowOnMap", Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
