package com.africa.cloud.basefirebase.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmHelper {

    Tarifs tarifs = new Tarifs();
    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    //reccperation de la liste
    public List<Tarifs> reccuperation() {
        Realm realm;
        //configuration du realm dans ma nouvelle activity
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(config);

        List<Tarifs> tarifsList = new ArrayList<>();
        RealmResults<Tarifs> mTarifs = realm.where(Tarifs.class).findAll();
        for (Tarifs x : tarifsList) {
            tarifsList.add(x);

            System.out.println(tarifsList);/*
            x.getmEmail();
            x.getmNumeroTelephone();
            x.getmDateNaissance();*/

        }

        return  mTarifs;
    }


    //Lecture

    public ArrayList<String> retrieve()
    {
        ArrayList<String> tarifs = new ArrayList<>();
        RealmResults<Tarifs> tarifsRealmResults = realm.where(Tarifs.class).findAll();

        for (Tarifs p : tarifsRealmResults) {

            tarifs.add(p.getmObjet());
            tarifs.add(String.valueOf(p.getmPrixRepassage()));
            tarifs.add(String.valueOf(p.getmPrixNettoyage()));
            tarifs.add(String.valueOf(p.getmPrixTeinture()));
            /*
            x.getmEmail();
            x.getmNumeroTelephone();
            x.getmDateNaissance();*/

        }
        return  tarifs;
    }




}