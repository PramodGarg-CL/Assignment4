package com.example.sample.assignment4.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sample.assignment4.AppConstants;
import com.example.sample.assignment4.R;
import com.example.sample.assignment4.activity.MyProfileActivity;

/**
 * Created by darknight on 28/4/17.
 */

public class ViewpagerFragment extends BaseFragment implements View.OnClickListener {
    private TextView textViewToolbarTitle;
    private ViewPager viewPager;
    private LinearLayout layoutSearchBar;
    private LinearLayout requestHeader;
    private EditText editTextSearch;

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
        textViewToolbarTitle = (TextView) view.findViewById(R.id.toolbar_tv_title);
        viewPager = (ViewPager) view.findViewById(R.id.home_viewpager);
        editTextSearch = (EditText) view.findViewById(R.id.search_bar_et);
        layoutSearchBar = (LinearLayout) view.findViewById(R.id.home_viewpager_searchbar);
        requestHeader = (LinearLayout) view.findViewById(R.id.home_viewpager_header);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.search_bar_bt);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                getActivity().startActivity(new Intent(getActivity(), MyProfileActivity.class));
            }
        });

        viewPager.setOffscreenPageLimit(5);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        requestHeader.setVisibility(View.GONE);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                switch (position) {
                    case 0:
                        layoutSearchBar.setVisibility(View.VISIBLE);
                        requestHeader.setVisibility(View.GONE);
                        editTextSearch.setHint(getString(R.string.search_bar_hint_discover));

                        break;
                    case 1:
                        layoutSearchBar.setVisibility(View.VISIBLE);
                        requestHeader.setVisibility(View.GONE);
                        editTextSearch.setHint(getString(R.string.search_bar_hint_map));
                        break;
                    case 2:
                        layoutSearchBar.setVisibility(View.VISIBLE);
                        requestHeader.setVisibility(View.GONE);
                        editTextSearch.setHint(getString(R.string.search_bar_hint_posts));
                        break;
                    case 3:
                        layoutSearchBar.setVisibility(View.GONE);
                        requestHeader.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        layoutSearchBar.setVisibility(View.GONE);
                        requestHeader.setVisibility(View.GONE);
                        break;
                    default:
                        layoutSearchBar.setVisibility(View.GONE);
                        requestHeader.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

    }

    /**
     * change the title of the toolbar
     *
     * @param title String title for the title
     */
    private void setToolbarStitle(final String title) {
        textViewToolbarTitle.setText(title);
    }

    @Override
    public void onClick(final View v) {
        int position;
        switch (v.getId()) {

            case R.id.btm_nav_discover:
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
        viewPager.setCurrentItem(position);
    }

    /**
     * Return the reference of viewpager
     *
     * @return viewPager
     */
    public ViewPager getViewPager() {
        return viewPager;
    }
}
