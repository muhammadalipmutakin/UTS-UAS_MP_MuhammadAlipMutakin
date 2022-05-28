package com.example.mp_muhammadalipmutakin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MenuUtama extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6,button7,button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, komponen_masukan.class);
                finish();
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, komponen_keluaran.class);
                finish();
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, komponen_proses.class);
                finish();
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, komponen_tambahan.class);
                finish();
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, aboutuser.class);
                finish();
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, about.class);
                finish();
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, maps.class);
                finish();
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                moveTaskToBack(true);
                //membuat method tombol keluar dari aplikasi

            }
        });
    }
    public void onBackPressed() {
        Intent intent1 = new Intent(getApplicationContext(), main_activity.class);
        startActivity(intent1);
    }
}