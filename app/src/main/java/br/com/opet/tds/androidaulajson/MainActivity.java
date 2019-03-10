package br.com.opet.tds.androidaulajson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView textJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textJSON = findViewById(R.id.textJSON);
    }

    public void downloadJSON(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://my-json-server.typicode.com/devdcardoso/JSONCarrosApp/carro";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textJSON.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textJSON.setText("Falha ao obter JSON");
                    }
                });

        queue.add(stringRequest);
    }

    public void downloadGSON(View view) {
        GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://my-json-server.typicode.com/devdcardoso/JSONCarrosApp/carro";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Carro carro = gson.fromJson(response,Carro.class);
                        textJSON.setText(carro.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textJSON.setText("Falha ao obter JSON");
                    }
                });

        queue.add(stringRequest);
    }
}
