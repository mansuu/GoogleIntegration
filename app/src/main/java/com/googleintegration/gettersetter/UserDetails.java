package com.googleintegration.gettersetter;

/**
 * Created by himansh on 24/12/16.
 */

public class UserDetails {
    private static UserDetails userDetails;
    private UserDetails(){

    }
    public static UserDetails getUserDetailsObject(){
        if(userDetails==null){
            userDetails=new UserDetails();
        }
        return userDetails;
    }
    private String imageUrl,userName,useremailId;
    private String userId,token;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseremailId() {
        return useremailId;
    }

    public void setUseremailId(String useremailId) {
        this.useremailId = useremailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
