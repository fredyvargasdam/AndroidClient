package com.example.flyshoes.ControlDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.flyshoes.Modelo.Usuario;

public class UsuarioDB extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "usuario.db";
    private static final int VERSION_BD = 1;
    private static final String TABLA_USUARIO = "create table usuario (id INTEGER PRIMARY KEY AUTOINCREMENT,login VARCHAR(30), password VARCHAR(30),guardar VARCHAR(2))";

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

    /**
     * Agregar un usuario a la tabla
     * @param login
     * @param password
     * @param guardar
     */

    public void agregarUsuario(String login,String password,String guardar) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("insert into usuario (login,password,guardar) values ('" + login + "','" + password + "','" + guardar +"')");
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

    /**
     * Comprobar si el usuario ha guardado sus datos
     * @return
     */

    public Usuario comprobarGuardar() {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = null;
        Usuario usuario=null;
        try {
            cursor = bd.rawQuery("select * from usuario where guardar='SI'", null);
            if (cursor != null) {
                cursor.moveToFirst();
                usuario=new Usuario();
                usuario.setLogin(cursor.getString(1));
                usuario.setPassword(cursor.getString(2));

            }
        } catch (Exception e) {
        } finally {
            cursor.close();
        }
        return usuario;
    }

    /**
     * Borrar a un usuario de la tabla
     * @param login
     * @param pass
     */
    public void borrarUsuario (String login, String pass) {
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = null;
        if (bd != null) {
            bd.execSQL("delete  from usuario where login='" + login + "' and password='" + pass + "'");
            bd.close();
        }


    }



}
