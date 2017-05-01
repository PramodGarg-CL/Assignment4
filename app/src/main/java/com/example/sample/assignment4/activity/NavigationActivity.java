package com.example.sample.assignment4.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sample.assignment4.R;
import com.example.sample.assignment4.fragment.ViewpagerFragment;

/**
 * Home activity
 */

public class NavigationActivity extends AppCompatActivity {
    private ImageButton mImageViewToolbar;
    private DrawerLayout mDrawerLayout;
    private TextView mTextViewToolbarTitle;

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

        mImageViewToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setToolbarStitle(getString(R.string.title_discover));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout, new ViewpagerFragment());
        fragmentTransaction.commit();
    }

    /**
     * change the title of the toolbar
     *
     * @param title String title for the title
     */
    private void setToolbarStitle(final String title) {
        mTextViewToolbarTitle.setText(title);
    }

}
