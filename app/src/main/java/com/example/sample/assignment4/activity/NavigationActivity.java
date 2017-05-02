package com.example.sample.assignment4.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sample.assignment4.R;
import com.example.sample.assignment4.fragment.DiscoverFragment;
import com.example.sample.assignment4.fragment.ViewpagerFragment;

import static com.example.sample.assignment4.AppConstants.TAG_VIEWPAGER;

/**
 * Home activity
 */

public class NavigationActivity extends AppCompatActivity {
    private ImageButton mImageViewToolbar;
    private DrawerLayout mDrawerLayout;
    private TextView mTextViewToolbarTitle;
    private ImageButton imageButtonGrid;
    private ImageButton imageButtonList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        init();
    }

    /**
     * Intializes variables and views
     */
    private void init() {
        mImageViewToolbar = (ImageButton) findViewById(R.id.toolbar_ib_home);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.home_drawer_layout);
        mTextViewToolbarTitle = (TextView) findViewById(R.id.toolbar_tv_title);
        imageButtonGrid = (ImageButton) findViewById(R.id.toolbar_ib_grid);
        imageButtonList = (ImageButton) findViewById(R.id.toolbar_ib_list);

        mImageViewToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setToolbarTitle(getString(R.string.title_discover));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout, new ViewpagerFragment(), TAG_VIEWPAGER);
        fragmentTransaction.commit();

        imageButtonGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                ViewpagerFragment fragment = (ViewpagerFragment) getSupportFragmentManager()
                        .findFragmentByTag(TAG_VIEWPAGER);
                ViewPager viewPager = fragment.getViewPager();
                Fragment page = fragment.getChildFragmentManager().findFragmentByTag("android:switcher:"
                        + R.id.home_viewpager + ":" + viewPager.getCurrentItem());

                if (viewPager.getCurrentItem() == 0 && page != null) {
                    DiscoverFragment discoverFragment = (DiscoverFragment) page;
                    discoverFragment.onRecyclerLayoutChange(true);
                }

            }
        });
        imageButtonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ViewpagerFragment fragment = (ViewpagerFragment) getSupportFragmentManager()
                        .findFragmentByTag(TAG_VIEWPAGER);
                ViewPager viewPager = fragment.getViewPager();
                Fragment page = fragment.getChildFragmentManager().findFragmentByTag("android:switcher:"
                        + R.id.home_viewpager + ":" + viewPager.getCurrentItem());

                if (viewPager.getCurrentItem() == 0 && page != null) {
                    DiscoverFragment discoverFragment = (DiscoverFragment) page;
                    discoverFragment.onRecyclerLayoutChange(false);
                }

            }
        });
    }

    /**
     * change the title of the toolbar
     *
     * @param title String title for the title
     */
    private void setToolbarTitle(final String title) {
        mTextViewToolbarTitle.setText(title);
    }

    /**
     * Interface implemented by @{@link com.example.sample.assignment4.fragment.DiscoverFragment}
     * to change the layoutmanager of recycler view
     */
    public interface OnRecyclerLayoutChange {
        /**
         * abstract method
         *
         * @param isGridViewEnabled : true for item_recycler_discover_grid, false for linear
         */
        void onRecyclerLayoutChange(boolean isGridViewEnabled);
    }

}
