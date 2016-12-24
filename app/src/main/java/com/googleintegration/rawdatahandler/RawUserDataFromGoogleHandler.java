package com.googleintegration.rawdatahandler;

import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.googleintegration.gettersetter.UserDetails;

import java.util.ArrayList;

/**
 * Created by himansh on 24/12/16.
 */

/**
 * class which parse data retured by google
 */
public class RawUserDataFromGoogleHandler {

    /**
     * parse raw data and return UserDetails object
     * @param result
     * @return
     */
    public UserDetails handleUserData(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            UserDetails userDetails=UserDetails.getUserDetailsObject();
            userDetails.setImageUrl(account.getPhotoUrl().toString());
            userDetails.setUseremailId(account.getEmail());
            userDetails.setUserName(account.getDisplayName());
            userDetails.setToken(account.getIdToken());
            userDetails.setUserId(account.getId());
            return userDetails;
        }


        return null;
    }
}
