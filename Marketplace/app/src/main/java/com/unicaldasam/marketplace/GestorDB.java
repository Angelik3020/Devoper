package com.unicaldasam.marketplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class GestorDB extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "DB_MARKETPLACE";
    public final static String TABLE_USUARIOS = "USUARIOS";
    public final static String TABLE_COMPRAS = "COMPRAS";
    public final static String COL1_1 = "ID";
    public final static String COL2_1 = "NOMBRE";
    public final static String COL3_1 = "APELLIDO";
    public final static String COL4_1 = "TELEFONO";
    public final static String COL5_1 = "USUARIO";
    public final static String COL6_1 = "CONTRASEÑA";
    public final static String COL1_2 = "ID";
    public final static String COL2_2 = "USUARIO";
    public final static String COL3_2 = "ARTICULO";
    public final static String COL4_2 = "CANTIDAD";

    public GestorDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USUARIOS+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NOMBRE TEXT, APELLIDO TEXT,TELEFONO INTEGER, USUARIO TEXT, CONTRASEÑA TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_COMPRAS+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,USUARIO TEXT, ARTICULO TEXT,CANTIDAD INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPRAS);
        onCreate(db);

    }

    public boolean insertData(String nombre, String apellido, String telefono, String usuario, String contraseña)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL1_1,nombre);
        cv.put(COL2_1,apellido);
        cv.put(COL3_1,telefono);
        cv.put(COL4_1,apellido);
        cv.put(COL5_1,usuario);
        cv.put(COL6_1,contraseña);
        long result=db.insert(TABLE_USUARIOS,null,cv);

        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getData(String usuario)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM "+ TABLE_USUARIOS+"WHERE USUARIO='"+usuario+"'",null);
        return cursor;
    }
    /*
    public boolean upDateData(String id, String nombre, String apellido, String telefono)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL2,nombre);
        cv.put(COL3,apellido);
        cv.put(COL4,telefono);
        long result=db.update(TABLE_NAME,cv,"ID=?",new String[]{id});

        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void deleteData (String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,"ID=?", new String []{id});

    }*/
}