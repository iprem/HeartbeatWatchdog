package com.example.prasannakumarvardi.heartbeatwatchdog_1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasannakumarvardi.myapplication.backend.userEndpoint.model.User;

import java.util.concurrent.ExecutionException;

public class NewUser extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText emergencyContact;
    EditText emergencyName;
    EditText name;
    EditText userContact;
    Intent intent;

    Intent intentBack;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        name = (EditText) findViewById(R.id.Name);
        userContact = (EditText) findViewById(R.id.UserContact);
        email=(EditText)findViewById(R.id.Email);
        password=(EditText)findViewById(R.id.Password);
        emergencyName = (EditText) findViewById(R.id.EmergencyName);
        emergencyContact = (EditText) findViewById(R.id.EmergencyContact);

        intent=getIntent();
        String emailNPassword=intent.getStringExtra("Email+Password");
        String emailVal;
        String passwordVal;
        String pieces[]=emailNPassword.split(":");
        emailVal=pieces[0];
        passwordVal=pieces[1];

        CharSequence emVal=emailVal;
        CharSequence psVal=passwordVal;
        email.setText(emVal, TextView.BufferType.EDITABLE);
        password.setText(psVal, TextView.BufferType.EDITABLE);

        //intentBack=new Intent(this,LoginActivity.class);
        //startActivity(intentBack);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button = (Button) findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void registerUser(){

        String eContact, eName, emailID, pass, userName, uContact;

        eContact = emergencyContact.getText().toString();
        emailID = email.getText().toString();
        eName = emergencyName.getText().toString();
        pass = password.getText().toString();
        userName = name.getText().toString();
        uContact = userContact.getText().toString();

        Connect connect = new Connect(this,userName,emailID,uContact,pass,eName,eContact);

        AsyncTask<String, Void, User> user = connect.execute("insert");

        try {
            if(user.get() == null){
                Toast.makeText(this, "User already exists", Toast.LENGTH_LONG).show();
            }
            else Toast.makeText(this, user.get().getName(), Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
