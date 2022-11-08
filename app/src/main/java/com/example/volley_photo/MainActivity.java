package com.example.volley_photo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq= Volley.newRequestQueue(this);
        iv1=findViewById(R.id.iv1);
        recuperarImagen();

    }
// https://scratchya.com.ar/videosandroidjava/volley/foto1.jpg
//    https://datamoviles.tk/volley/fotos/foto1.jpg

    private void recuperarImagen() {
        ImageRequest requerimiento = new ImageRequest(
                "https://datamoviles.tk/volley/fotos/f320030348.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iv1.setImageBitmap(response);
                    }
                },
                0,
                0,
                null,
                null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        rq.add(requerimiento);
    }
}