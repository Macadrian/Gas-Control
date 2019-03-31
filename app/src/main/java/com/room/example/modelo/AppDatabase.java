package com.room.example.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import com.room.example.R;
import com.room.example.modelo.entidad.ComunidadEntity;
import com.room.example.modelo.entidad.ProvinciaEntity;
import com.room.example.modelo.entidad.PuebloEntity;

import java.io.InputStream;
import java.util.Scanner;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ComunidadEntity.class, ProvinciaEntity.class, PuebloEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static String DATABASE_NAME = "precio_database21";

    public abstract IDao dao();

    private static volatile AppDatabase INSTANCE;
    private static Resources resources;


    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    resources = context.getResources();
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME)
                            .addCallback(callback).build();


                }
            }
        }
        return INSTANCE;
    }
    static RoomDatabase.Callback callback = new RoomDatabase.Callback()
    {
        public void onCreate (SupportSQLiteDatabase db)
        {
            new RellenarTablaComunidadAsync().execute();
            new RellenarTablaProvinciaAsync().execute();
            new RellenarTablaPuebloAsync().execute();
        }
    };
    //region Métodos Rellenar Base de datos

    private static class RellenarTablaComunidadAsync extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(final Void... params) {
            InputStream comunityStream = resources.openRawResource(R.raw.communities);
            Scanner scanner = new Scanner(comunityStream);
            String[] line;
            String string;
            ComunidadEntity comunityEntity;

            while (scanner.hasNextLine()) {
                string = scanner.nextLine();
                line = string.split("#");

                comunityEntity = new ComunidadEntity(Integer.parseInt(line[0]), line[1]);
                INSTANCE.dao().insert(comunityEntity);
            }

            scanner.close();
            return null;
        }
    }

   private static class RellenarTablaProvinciaAsync extends AsyncTask<Void, Void, Void>
   {
        @Override
        protected Void doInBackground(final Void... params) {
            InputStream provinciaStream = resources.openRawResource(R.raw.provinces);
            Scanner scanner = new Scanner(provinciaStream);
            String[] line;
            String string;
            ProvinciaEntity provinciaEntity;

            while (scanner.hasNextLine()) {
                string = scanner.nextLine();
                line = string.split("#");

                provinciaEntity = new ProvinciaEntity(Integer.parseInt(line[0]),Integer.parseInt(line[2]), line[1]);
                INSTANCE.dao().insert(provinciaEntity);
            }

            scanner.close();
            return null;
        }
    }

    private static class RellenarTablaPuebloAsync extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(final Void... params) {
            int contador =0;
            InputStream puebloStream = resources.openRawResource(R.raw.towns);
            Scanner scanner = new Scanner(puebloStream);
            String[] line;
            String string;
            PuebloEntity puebloEntity;

            while (scanner.hasNextLine()) {
                contador++;
                string = scanner.nextLine();
                line = string.split("#");

                int codigoProvincia = Integer.parseInt(line[2]);
                puebloEntity = new PuebloEntity(Integer.parseInt(line[0]),codigoProvincia, line[1]);
                INSTANCE.dao().insert(puebloEntity);
            }

            scanner.close();
            return null;
        }
    }

    //endregion}
}
