package com.example.listservidor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.listservidor.Adaptador.AdaptadorAlumno;
import com.example.listservidor.Modelo.Alumno;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.lista);
    }

    public void Click(View view) {

        JsonArrayRequest json = new JsonArrayRequest(Request.Method.GET,
                "http://nuevo.rnrsiilge-org.mx/ListaNombre",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Type alumnolista;
                        alumnolista= new TypeToken<List<Alumno>>(){}.getType();

                        List<Alumno> alumno= new Gson().fromJson(response.toString(),alumnolista);

                        lista.setAdapter(new AdaptadorAlumno(alumno,getApplicationContext()));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        VolleySigleton2.getInstanceSigleton(getApplicationContext()).getRequestQueue().add(json);
    }
}
