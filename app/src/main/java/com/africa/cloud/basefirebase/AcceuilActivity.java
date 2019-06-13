package com.africa.cloud.basefirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class AcceuilActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    LoginButton loginButton;
    FirebaseAuth auth;
    FirebaseUser user;
    private static final int RC_SIGN_IN = 123;
    private Intent data;
    Button btnDeconnexion;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        text = (TextView)findViewById(R.id.text_vue);





}




    public void btnOnClickFb(View v)
    {
        signOut();
    }


    public void signOut() {
        // [START auth_fui_signout]
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...

                        Intent i = new Intent(AcceuilActivity.this,SignupActivity.class);
                        startActivity(i);
                    }
                });
        // [END auth_fui_signout]
    }



}