package una.ac.cr.proyectomemoriamoviles;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PuntuacionesBDHelper extends SQLiteOpenHelper {


    private static final int Version_BaseDatos = 1;

    // Nombre de nuestro archivo de base de datos
    private static final String Nombre_BaseDatos = "Memoria.db";

    // Sentencia SQL para la creación de una tabla
    private static final String Tabla_Puntuaciones = "CREATE TABLE puntuaciones" +
            "(_id INT PRIMARY KEY, dificultad TEXT, tiempo INT)";




    public PuntuacionesBDHelper(Context context) {
        super(context, Nombre_BaseDatos, null, Version_BaseDatos);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Tabla_Puntuaciones);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tabla_Puntuaciones);
        onCreate(db);
    }

    public void insertarPuntuacion(int id, String dific, int tiem) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("dificultad", dific);
            valores.put("tiempo", tiem);
            db.insert("puntuaciones", null, valores);
            db.close();
        }
    }



    public void modificarPuntuacion(int id, String dific, int tiem){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("_id", id);
        valores.put("dificultad", dific);
        valores.put("tiempo", tiem);
        db.update("puntuaciones", valores, "_id=" + id, null);
        db.close();
    }

    public void borrarPuntuacion(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("puntuaciones", "_id="+id, null);
        db.close();
    }

    public Puntuaciones recuperarPuntuacion(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"_id", "dificultad", "tiempo"};
        Cursor c = db.query("puntuaciones", valores_recuperar, "_id=" + id, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Puntuaciones puntuaciones = new Puntuaciones(c.getInt(0), c.getString(1), c.getInt(2));
        db.close();
        c.close();
        return puntuaciones;
    }


    public List<Puntuaciones> recuperarPuntuaciones() {
        SQLiteDatabase db = getReadableDatabase();
        List<Puntuaciones> lista_puntuaciones = new ArrayList<Puntuaciones>();
        String[] valores_recuperar = {"_id", "dificultad", "tiempo"};
        Cursor c = db.query("puntuaciones", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Puntuaciones puntuaciones = new Puntuaciones(c.getInt(0), c.getString(1), c.getInt(2));
            lista_puntuaciones.add(puntuaciones);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_puntuaciones;
    }

}
