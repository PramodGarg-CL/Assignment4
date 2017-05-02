package com.example.sample.assignment4.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sample.assignment4.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darknight on 28/4/17.
 */

public class MyProfileActivity extends AppCompatActivity {

    private static final int NO_OF_VIEWS = 10;
    private static final int VIEW_NO_NICKNAME = 1;
    private static final int VIEW_NO_REF = 7;
    private static final int VIEW_NO_INTEREST = 8;
    private static final int VIEW_NO_EMAIL = 9;
    private static final String TAG = "MyProfileActivity";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        init();
    }

    /**
     * Intializes the view and variables
     */
    private void init() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Nickname");
        stringList.add("Age");
        stringList.add("Gender");
        stringList.add("City ");
        stringList.add("Country ");
        stringList.add("Profession");
        stringList.add("Reference Links");
        stringList.add("Interests");
        stringList.add("Email Address");
        LinearLayout cardView = (LinearLayout) findViewById(R.id.frag_prof_card_ll);

        LinearLayout llFName = (LinearLayout) findViewById(R.id.my_prof_inc_fname);

        TextView textViewFirst = (TextView) llFName.findViewById(R.id.my_prof_tv_title);
        textViewFirst.setText("First Name");

        LinearLayout llLName = (LinearLayout) findViewById(R.id.my_prof_inc_lname);

        TextView textViewLast = (TextView) llLName.findViewById(R.id.my_prof_tv_title);
        textViewLast.setText("Last Name");

        setTitle(stringList, cardView);

    }

    /**
     * Set title of views
     *
     * @param title     : list of title
     * @param viewGroup : viewgroup
     */
    private void setTitle(final List<String> title, final ViewGroup viewGroup) {

        for (int i = 1; i < NO_OF_VIEWS; i++) {
            View view = viewGroup.getChildAt(i);
            TextView textViewTitle = (TextView) view.findViewById(R.id.my_prof_tv_title);
            textViewTitle.setText(title.get(i - 1));

            /*
            Disable privacy textView
             */
            if (!(i == VIEW_NO_NICKNAME || i == VIEW_NO_REF || i == VIEW_NO_INTEREST || i == VIEW_NO_EMAIL)) {
                Log.d(TAG, "setTitle: ");
                TextView textView = (TextView) view.findViewById(R.id.my_prof_tv_privacy);
                textView.setVisibility(View.VISIBLE);
            }
            /*
            Enable RadioGroup
             */
            if (i == 3) {
                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.my_prof_rg);
                radioGroup.setVisibility(View.VISIBLE);
                EditText relativeLayout = (EditText) view.findViewById(R.id.my_prof_et);
                relativeLayout.setVisibility(View.GONE);
            }
        }

    }
}
