package com.room.example;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import com.room.example.modelo.AppDatabase;
import com.room.example.modelo.DatabaseRepository;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.room.example", appContext.getPackageName());
    }

    @Test
    public void conexion() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseRepository databaseRepository = new DatabaseRepository(appContext);
        List comunidadLista = databaseRepository.getListaComunidad();
        Log.d("Test", "Tamaño lista comunidad: " + comunidadLista.size());
    }
}
