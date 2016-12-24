package com.googleintegration.screens;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.googleintegration.R;
import com.googleintegration.gettersetter.UserDetails;
import com.googleintegration.rawdatahandler.RawUserDataFromGoogleHandler;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

private Context context;
    //Signing Options
    private GoogleSignInOptions gso;
    private SignInButton sign_in_button;
    //google api client
    private GoogleApiClient mGoogleApiClient;
    private final int REQUEST_SIGN_IN=1000;
    private RawUserDataFromGoogleHandler dataFromGoogleHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInViaGoogle();
            }
        });
    }


    /**
     * called when GoogleApiClient connection failed
     * @param connectionResult
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    /**
     * used to sign in via google
     */
    public void signInViaGoogle(){
        //Creating an intent
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);

        //Starting intent for result
        startActivityForResult(signInIntent, REQUEST_SIGN_IN);
    }

    /**
     * initalize initial variables
     */
    private void init(){
        context=MainActivity.this;
        sign_in_button=(SignInButton)findViewById(R.id.btn_sign_invia_google) ;
        //Initializing google signin option
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        //Initializing google api client
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage((AppCompatActivity)context /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_SIGN_IN&&resultCode==RESULT_OK&&data!=null){
            dataFromGoogleHandler=new RawUserDataFromGoogleHandler();
           UserDetails userDetails= dataFromGoogleHandler.handleUserData(Auth.GoogleSignInApi.getSignInResultFromIntent(data));
            if(userDetails!=null){
                Intent userDetailsIntent=new Intent(context,UserDetailsActivity.class);
                startActivity(userDetailsIntent);
            }
        }
    }
}
