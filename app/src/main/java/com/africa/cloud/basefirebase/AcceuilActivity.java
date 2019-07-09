package com.africa.cloud.basefirebase;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.africa.cloud.basefirebase.adapter.PageAdapter;
import com.africa.cloud.basefirebase.model.Tarifs;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class AcceuilActivity extends AppCompatActivity implements View.OnClickListener,
        InfoFragment.OnFragmentInteractionListener,
        TarifsFragment.OnFragmentInteractionListener,
        CommandeFragment.OnFragmentInteractionListener{
    CallbackManager callbackManager;
    LoginButton loginButton;
    FirebaseAuth auth;
    FirebaseUser user;
    private static final int RC_SIGN_IN = 123;
    private static final int GOOGLE_SIGN = 123;
    private static final int SIGN_OUT_TASK = 10;
    private static final int SIGN_OUT_EMAIL = 30;
    private static final int DELETE_USER_TASK = 20;
    private Intent data;
    Button btnDeconnexion, deconnexion;
    TextView text;
    private DatabaseReference mStatusTextView;
    private TextView mDetailTextView, statut;
    private static final String TAG = "GoogleActivity";
    GoogleSignInClient mGoogleSignInClient;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    Realm realm;
    private List<Tarifs> tarifsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        setTitle(null);
        Toolbar toolbar = findViewById(R.id.toolbar); //Declaration du toolbar
        toolbar.setTitle("Mon Pressing");//Donner au toobar
        setSupportActionBar(toolbar); //Afficher les element du toolbar
        TabLayout tabLayout = findViewById(R.id.tablayout); //Déclarattion du TabLayout pour contenir les fragments
        TabItem tabInfo = findViewById(R.id.tabInfo); //Declaration du premier fragment Qui concerne l'affichage des informations
        TabItem tabCommande = findViewById(R.id.tabCommande); //Deuxième fragment Pour pouvoir effectuer les commandes
        TabItem tabTarifs = findViewById(R.id.tabTarifs); //Troisième fragment pour
        ViewPager viewPager = findViewById(R.id.viewPager); //Déclaration de la vue des pages des differents fragment


        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        //Changement des fragments avec les defilement
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//Changement fragment avec les clics
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//Fin de la methode d'interception

//        findViewById(R.id.disconnectButton).setOnClickListener(this);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder()
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);


    }



    @Nullable
    protected FirebaseUser getCurrentUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    protected Boolean isCurrentUserLogged() {
        return (this.getCurrentUser() != null);
    }

  



    private void signOutUserFromFirebase() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(SIGN_OUT_TASK));
    }


    private void signOutUserLoginByEmailFromFirebase() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(SIGN_OUT_EMAIL));
       Intent i = new Intent(AcceuilActivity.this, SignupActivity.class);
        startActivity(i);

    }

    private void deleteUserFromFirebase() {
        if (this.getCurrentUser() != null) {
            AuthUI.getInstance()
                    .delete(this)
                    .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(DELETE_USER_TASK));
        }
    }

    private OnSuccessListener<Void> updateUIAfterRESTRequestsCompleted(final int origin) {
        return new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                switch (origin) {
                    case SIGN_OUT_TASK:
                        finish();
                        break;
                    case DELETE_USER_TASK:
                        finish();
                        break;
                    case SIGN_OUT_EMAIL:
                    default:
                        auth.signOut();
                        break;
                }
            }
        };

    }


    //Declaration du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    //Gestions des menu du toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.deconnexion_settings) {
            signOutUserLoginByEmailFromFirebase();
            return true;
        }

        if (id == R.id.tarifs_settings) {
          // Intent t = new Intent(AcceuilActivity.this, TarifsActivity.class);
           //startActivity(t);
            return true;
        }

        if (id == R.id.commande_settings) {
            Intent t = new Intent(AcceuilActivity.this, CommandeActivity.class);
            startActivity(t);
            return true;
        }


        if (id == R.id.action_refresh) {
            Toast.makeText(AcceuilActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }




    @Override
    public void onClick(View v) {

    }



}