package com.example.mp_muhammadalipmutakin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class main_activity extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), MenuUtama.class);
            startActivity(intent1);
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        //set pesan yang akan ditampilkan
        builder.setMessage("Anda Yakin Ingin Keluar ?");
        //set positive tombol jika menjawab ya
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //jika kalian menekan tombol ya, maka otomatis akan keluar dari activity saat ini
                moveTaskToBack(true);

            }
        });
        //set negative tombol jika menjawab tidak
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //jika menekan tombol tidak, maka kalian akan tetap berada di activity saat ini
                Toast.makeText(getApplicationContext(), "Anda Memilih 'Cancel'",Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}