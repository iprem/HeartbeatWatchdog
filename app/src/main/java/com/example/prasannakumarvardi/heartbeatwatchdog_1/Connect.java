package com.example.prasannakumarvardi.heartbeatwatchdog_1;

import android.content.Context;
import android.os.AsyncTask;

import com.example.prasannakumarvardi.myapplication.backend.userEndpoint.UserEndpoint;
import com.example.prasannakumarvardi.myapplication.backend.userEndpoint.model.User;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.repackaged.com.google.common.base.Strings;

import java.io.IOException;

/**
 * Created by iprem on 5/8/16.
 */
public class Connect extends AsyncTask<String, Void, User> {

    private User user;
    private Context context;

    private static UserEndpoint myApiService = null;

    public Connect(Context context, String name, String email, String phoneNumber, String password,
                   String emergencyContactName, String emergencyContactNumber) {
        super();
        this.context = context;
        user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setEmergencyContactName(emergencyContactName);
        user.setGetEmergencyContactNumber(emergencyContactNumber);
        //user = new User(name,email,phoneNumber,emergencyContactName,emergencyContactNumber);
    }


    @Override
    protected User doInBackground(String... params) {

        if (myApiService == null) {
            UserEndpoint.Builder builder;
            //builder = new UserEndpoint.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
              //      .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            builder = new UserEndpoint.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://iprem-guestbook.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        if(params[0].equals("get")){
            try {
                return myApiService.get(params[1]).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(params[0].equals("insert")) {
            try {
                return myApiService.insert(user).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
