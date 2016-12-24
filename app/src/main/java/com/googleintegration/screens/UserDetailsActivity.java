package com.googleintegration.screens;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.googleintegration.R;
import com.googleintegration.gettersetter.UserDetails;
import com.squareup.picasso.Picasso;

public class UserDetailsActivity extends AppCompatActivity {
    private Context context;
    private ImageView img_profile_picture;
    private TextView txt_user_name,txt_user_email_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_user_details);
        init();
        populateViews();
    }

    /**
     *
     * initialize initial variables
     */
    private void init(){
        context=UserDetailsActivity.this;
        img_profile_picture=(ImageView)findViewById(R.id.img_google_profile_picture);
        txt_user_email_id=(TextView)findViewById(R.id.txt_email_id);
        txt_user_name=(TextView)findViewById(R.id.txt_name);
    }

    /**
     * decorate all views to show user info
     */
    private void populateViews(){
        UserDetails userDetails=UserDetails.getUserDetailsObject();
        Picasso.with(context).load(userDetails.getImageUrl()).into(img_profile_picture);
        txt_user_name.setText(userDetails.getUserName());
        txt_user_email_id.setText(userDetails.getUseremailId());
    }
}
