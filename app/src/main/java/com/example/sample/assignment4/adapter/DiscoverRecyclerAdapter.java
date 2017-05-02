package com.example.sample.assignment4.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sample.assignment4.AppConstants;
import com.example.sample.assignment4.R;
import com.example.sample.assignment4.model.Discover;

import java.util.List;

/**
 * Created by darknight on 30/4/17.
 */

public class DiscoverRecyclerAdapter extends RecyclerView.Adapter<DiscoverRecyclerAdapter.DiscoverRecyclerVH> {

    private boolean isGridView = false;
    private List<Discover> mDiscoverList;
    private int mode;


    /**
     * set the list of data
     *
     * @param mode         : whether discover or myposts
     * @param discoverList : list of @{@link Discover}
     */

    public DiscoverRecyclerAdapter(final List<Discover> discoverList, final int mode) {
        mDiscoverList = discoverList;
        this.mode = mode;
    }

    /**
     * Setter isGridView
     *
     * @param gridView : isGridView
     */
    public void setGridView(final boolean gridView) {
        isGridView = gridView;
    }

    @Override
    public DiscoverRecyclerVH onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycler_discover_grid, parent, false);
        } else if (viewType == 1 || viewType == 2) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycler_discover, parent, false);
        } else {
            return null;
        }
       /* if (mode == AppConstants.MODE_ADAPTER_DISCOVER && isGridView) {

            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycler_discover_grid, parent, false);

        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycler_discover, parent, false);
        }
*/
        return new DiscoverRecyclerVH(view);
    }

    @Override
    public void onBindViewHolder(final DiscoverRecyclerVH holder, final int position) {
        Discover current = mDiscoverList.get(position);

      /*  if (mode == AppConstants.MODE_ADAPTER_DISCOVER && isGridView) {

        }


        holder.textViewReview.setText(current.getmReviews());
        holder.textViewText.setText(current.getmText());
        holder.textViewDuration.setText(current.getmDuration());
        holder.textViewExplore.setText("Explore " + current.getmCityName());
        if (mode == AppConstants.MODE_ADAPTER_DISCOVER) {
            holder.textViewCityName.setText(current.getmCityName());
            holder.textViewName.setText(current.getmName());

            holder.ratingBar.setRating(current.getmRating());

            holder.imageButtonDel.setVisibility(View.INVISIBLE);
            holder.imageButtonEdit.setVisibility(View.INVISIBLE);
            holder.ratingBar.setVisibility(View.VISIBLE);
            holder.textViewCityName.setVisibility(View.VISIBLE);
            holder.textViewName.setVisibility(View.VISIBLE);
            holder.imageButtonAdd.setVisibility(View.VISIBLE);
            holder.textViewSendRequest.setVisibility(View.VISIBLE);
        } else if (mode == AppConstants.MODE_ADAPTER_MY_POSTS) {

            holder.imageButtonDel.setVisibility(View.VISIBLE);
            holder.imageButtonEdit.setVisibility(View.VISIBLE);
            holder.ratingBar.setVisibility(View.INVISIBLE);
            holder.textViewCityName.setVisibility(View.INVISIBLE);
            holder.textViewName.setVisibility(View.INVISIBLE);
            holder.imageButtonAdd.setVisibility(View.INVISIBLE);
            holder.textViewSendRequest.setVisibility(View.INVISIBLE);
        }
*/

    }

    @Override
    public int getItemCount() {
        return mDiscoverList.size();
    }

    @Override
    public int getItemViewType(final int position) {
        if (mode == AppConstants.MODE_ADAPTER_DISCOVER && isGridView) {
            return 0;
        } else if (mode == AppConstants.MODE_ADAPTER_DISCOVER && !isGridView) {
            return 1;
        } else if (mode == AppConstants.MODE_ADAPTER_MY_POSTS) {
            return 2;
        } else {
            return -1;
        }
    }

    /**
     * Viewholder class for adapter
     */
    class DiscoverRecyclerVH extends RecyclerView.ViewHolder {
        private TextView textViewCityName, textViewName, textViewReview, textViewText, textViewExplore,
                textViewDuration, textViewSendRequest;
        private RatingBar ratingBar;
        private ImageButton imageButtonDel, imageButtonEdit, imageButtonAdd;

        /**
         * Deafaut constructor for viewholder
         *
         * @param itemView : current view
         */
        public DiscoverRecyclerVH(final View itemView) {
            super(itemView);
           /* textViewCityName = (TextView) itemView.findViewById(R.id.item_discover_tv_city);
            textViewDuration = (TextView) itemView.findViewById(R.id.item_discover_tv_duration);
            textViewExplore = (TextView) itemView.findViewById(R.id.item_discover_tv_expl);
            textViewReview = (TextView) itemView.findViewById(R.id.item_discover_tv_review);
            textViewText = (TextView) itemView.findViewById(R.id.item_discover_tv_text);
            textViewName = (TextView) itemView.findViewById(R.id.item_discover_tv_name);
            textViewSendRequest = (TextView) itemView.findViewById(R.id.item_discover_tv_send_req);
            ratingBar = (RatingBar) itemView.findViewById(R.id.item_discover_rating);
            imageButtonDel = (ImageButton) itemView.findViewById(R.id.item_discover_ib_del);
            imageButtonEdit = (ImageButton) itemView.findViewById(R.id.item_discover_ib_edit);
            imageButtonAdd = (ImageButton) itemView.findViewById(R.id.item_discover_ib_add);*/
        }
    }
}
