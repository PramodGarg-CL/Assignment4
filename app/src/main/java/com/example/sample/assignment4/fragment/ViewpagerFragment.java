package com.example.sample.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sample.assignment4.AppConstants;
import com.example.sample.assignment4.R;

/**
 * Created by darknight on 28/4/17.
 */

public class ViewpagerFragment extends BaseFragment implements View.OnClickListener {
    private TextView mTextViewToolbarTitle;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        init(view);
        return view;
    }

    /**
     * intializes the views and variables
     *
     * @param view : view returned
     */
    private void init(final View view) {
        mTextViewToolbarTitle = (TextView) view.findViewById(R.id.toolbar_tv_title);
        mViewPager = (ViewPager) view.findViewById(R.id.home_viewpager);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                switch (position) {
                    case 0:
                        return DiscoverFragment.getInstance(AppConstants.MODE_ADAPTER_DISCOVER);
                    case 1:
                        return new MapFragment();
                    case 2:
                        return DiscoverFragment.getInstance(AppConstants.MODE_ADAPTER_MY_POSTS);
                    case 3:
                        return new RequestsFragment();
                    case 4:
                        return new NetworkFragment();
                    default:
                        return DiscoverFragment.getInstance(AppConstants.MODE_ADAPTER_DISCOVER);
                }
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        TextView textViewDiscover = (TextView) view.findViewById(R.id.btm_nav_discover);
        TextView textViewMap = (TextView) view.findViewById(R.id.btm_nav_map);
        TextView textViewPosts = (TextView) view.findViewById(R.id.btm_nav_posts);
        TextView textViewReq = (TextView) view.findViewById(R.id.btm_nav_req);
        TextView textViewNets = (TextView) view.findViewById(R.id.btm_nav_network);
        textViewDiscover.setOnClickListener(this);
        textViewMap.setOnClickListener(this);
        textViewPosts.setOnClickListener(this);
        textViewReq.setOnClickListener(this);
        textViewNets.setOnClickListener(this);

    }

    /**
     * change the title of the toolbar
     *
     * @param title String title for the title
     */
    private void setToolbarStitle(final String title) {
        mTextViewToolbarTitle.setText(title);
    }

    @Override
    public void onClick(final View v) {
        int position;
        switch (v.getId()) {

            case R.id.btm_nav_discover:
                Toast.makeText(getActivity(), "hhe", Toast.LENGTH_SHORT).show();
                position = 0;
                break;
            case R.id.btm_nav_map:
                position = 1;
                break;
            case R.id.btm_nav_posts:
                position = 2;
                break;
            case R.id.btm_nav_req:
                position = 3;
                break;
            case R.id.btm_nav_network:
                position = 4;
                break;
            default:
                position = 0;


        }
        changeFragment(position);
    }

    /**
     * change the fragment according to item selected at bottom navigation view
     *
     * @param position : postion selected at bottom navigation view
     */

    private void changeFragment(final int position) {
        mViewPager.setCurrentItem(position);
    }
}
