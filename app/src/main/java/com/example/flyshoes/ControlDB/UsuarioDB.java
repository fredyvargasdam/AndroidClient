package com.example.flyshoes.ControlDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDB extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "usuario.db";
    private static final int VERSION_BD = 1;
    private static final String TABLA_USUARIO = "create table jugador (id INTEGER PRIMARY KEY AUTOINCREMENT,login VARCHAR(30), password VARCHAR(), contrasena VARCHAR(20),guardar VARCHAR(2)";

    public UsuarioDB(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists '" + TABLA_USUARIO + "'");
        sqLiteDatabase.execSQL(TABLA_USUARIO);

    }

    public void agregarUsuario(String login,String password,String guardar) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("insert into jugador (login,password,guardar) values ('" + login + "','" + password + "','" + guardar +"')");
            bd.close();
        }
    }


    public boolean comprobarGuardar(String login,String guardar) {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = bd.rawQuery("select * from usuario where login='" + login + "' and guardar ='"+ guardar+"'", null);
            if (cursor.getCount() != 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            cursor.close();
        }
        return false;
    }


}
