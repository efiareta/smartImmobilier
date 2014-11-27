package com.example.ehamelo.smartimmobilier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.ehamelo.smartimmobilier.entite.Fiche;

import java.util.ArrayList;

/**
 * Created by ehamelo on 18/11/2014.
 */
public class BDSqLiteManager {

    private static final int BASE_VERSION =1;
    private static final String BASE_NOM="contacts.db";

    private static final String TABLE_CONTACTS="table_contacts";
    public static final String COLONNE_ID="id";
    public static final int COLONNE_ID_ID=0;
    public static final String COLONNE_NOM="nom";
    public static final int COLONNE_ID_NOM=1;
    public static final String COLONNE_PRENOM="prenom";
    public static final int COLONNE_ID_PRENOM=2;
    public static final String COLONNE_AGE="age";
    public static final int COLONNE_ID_AGE=3;

    private SQLiteDatabase bdd;

    /*la base de donnée*/
    private BDSqlite maBaseSQLite;

    public BDSqLiteManager(Context context){
        /*instanciation de la base*/
        maBaseSQLite= new BDSqlite(context,BASE_NOM,null,BASE_VERSION);

    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insert(Fiche fiche)
    {
        ContentValues values= new ContentValues();
        //values.put(COLONNE_NOM,contact.getNom());
        //values.put(COLONNE_PRENOM,contact.getPrenom());
        //values.put(COLONNE_AGE,contact.getAge());

        return bdd.insert(TABLE_CONTACTS,null,values);
    }

    public int update(int id,Fiche fiche)
    {
        ContentValues values= new ContentValues();
        //values.put(COLONNE_NOM,contact.getNom());
        //values.put(COLONNE_PRENOM,contact.getPrenom());
        //values.put(COLONNE_AGE,contact.getAge());

        return bdd.update(TABLE_CONTACTS,values,COLONNE_ID + "=" + id,null);
    }

    public int removeWithID(int id)
    {
        return bdd.delete(TABLE_CONTACTS,COLONNE_ID + "=" + id,null);
    }

    public void dropTable(){
        bdd.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
    }


    public Fiche  getContactWithName(String nom){
        Cursor c = bdd.query(TABLE_CONTACTS, new String[] {COLONNE_ID, COLONNE_NOM, COLONNE_PRENOM, COLONNE_AGE}, COLONNE_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
        return this.cursorToContact(c);
    }

    public ArrayList<Fiche> getAll(){
        ArrayList<Fiche> contacts=new ArrayList<Fiche>();
        Cursor c = bdd.rawQuery("SELECT  * FROM " + TABLE_CONTACTS,null);

        if(c.getCount()==0)return null;

        c.moveToFirst();
        while(c.moveToNext()){
            //contacts.add(new Fiche(c.getString(COLONNE_ID_NOM),c.getString(COLONNE_ID_PRENOM),c.getInt(COLONNE_ID_AGE)));
        }
        return contacts;
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Fiche cursorToContact(Cursor c){
        if (c.getCount() == 0)return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        //Contact contact = new Contact(c.getString(COLONNE_ID_NOM),c.getString(COLONNE_ID_PRENOM),c.getInt(COLONNE_ID_AGE));
        //contact.setId(c.getInt(COLONNE_ID_ID));
        //contact.
        //On ferme le cursor
        c.close();

        //On retourne le livre
        return null;

    }


}
