package com.room.example.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.room.example.modelo.entidad.ComunidadEntity;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ComunidadEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static String DATABASE_NAME = "precio_database7";

    public abstract IDao dao();

    private static volatile AppDatabase INSTANCE;


    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME)
                            .addCallback(cargarDatos)
                            .build();


                }
            }
        }
        return INSTANCE;
    }



    static RoomDatabase.Callback cargarDatos = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            Log.d("Carga Datos", "inicio carga");
            super.onCreate(db);

            //AppDatabase appDatabase = AppDatabase.getDatabase()

            ContentValues contentValues = new ContentValues();
            contentValues.put("codigo", "01");
            contentValues.put("nombre", "Prueba");
            db.insert("comunidad_tabla", OnConflictStrategy.IGNORE, contentValues);
            db.execSQL("insert into comunidad_tabla (codigo,nombre) values ('03', 'otra')");

            ComunidadEntity ce = new ComunidadEntity();
            ce.setCodigo(2);
            ce.setNombre("hooola");
            //INSTANCE.comunidadDao().insert(ce);

        }

    };
}
