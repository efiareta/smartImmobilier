package com.example.ehamelo.smartimmobilier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ehamelo on 17/10/2014.
 */
public class BDSqlite extends SQLiteOpenHelper {

    private static final String TABLE_CONTACTS="table_contacts";

    /*user*/
    public static final String COLONNE_ID="id";
    public static final String COLONNE_NOM="nom";
    public static final String COLONNE_PRENOM="prenom";
    public static final String COLONNE_AGE="age";

    /*fiche*/

    /*creation de la base de donnée*/
    private static final String REQUETE_CREATION_BD="create table "+
                                                    TABLE_CONTACTS+"("+COLONNE_ID+" integer primary key autoincrement, " +COLONNE_NOM
                                                    +" text not null, "+ COLONNE_PRENOM +" text not null, "+ COLONNE_AGE+" integer);";

    public BDSqlite(Context context, String nom, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context,nom,cursorFactory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQUETE_CREATION_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CONTACTS + ";");
        onCreate(db);
    }
}
