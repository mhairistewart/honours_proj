package com.example.mhairistewart.honours_proj;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String language = extras.getString("language", "");

        Uri uri = Uri.parse("http://localhost:8080/get_categories.php")
                .buildUpon()
                .appendQueryParameter("language", language)
                .build();

        JsonArrayRequest request = new JsonArrayRequest(uri.toString(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // For each
                try {
                    for (int i = 0; i < response.length(); i++) {
                        response.get(i);
                    }
                } catch (JSONException ex) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

}
