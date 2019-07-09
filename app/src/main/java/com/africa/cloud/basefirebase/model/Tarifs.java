package com.africa.cloud.basefirebase.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Tarifs extends RealmObject {
    public static String[] data;

    //declaration des variables

    @PrimaryKey
    public
    int id;


    private
    String mObjet;

    private
    int mPrixRepassage;

    private
    int mPrixNettoyage;

    private
    int mPrixTeinture;


    public Tarifs() {
        this.id = id;
        this.mObjet = mObjet;
        this.mPrixRepassage = mPrixRepassage;
        this.mPrixNettoyage = mPrixNettoyage;
        this.mPrixTeinture = mPrixTeinture;
    }


    public int getId() {
        return id;
    }
    public void setId(int nextId) {
    }
    public String getmObjet() {
        return mObjet;
    }

    public void setmObjet(String mObjet) {
        this.mObjet = mObjet;
    }


    public int getmPrixRepassage() {
        return mPrixRepassage;
    }

    public void setmPrixRepassage(int mPrixRepassage) {
        this.mPrixRepassage = mPrixRepassage;
    }

    public int getmPrixNettoyage() {
        return mPrixNettoyage;
    }

    public void setmPrixNettoyage(int mPrixNettoyage) {
        this.mPrixNettoyage = mPrixNettoyage;
    }


    public int getmPrixTeinture() {
        return mPrixTeinture;
    }

    public void setmPrixTeinture(int mPrixTeinture) {
        this.mPrixTeinture = mPrixTeinture;
    }




}
