package com.example.mp_muhammadalipmutakin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class komponen_proses extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komponen_proses);

        listView = (ListView) findViewById(R.id.list3);
        String[] values = new String[]{"RAM", "CPU", "MotherBoard", "Storage"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), ram.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), cpu.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), motherboard.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), storage.class);
                    startActivityForResult(myIntent, 0);
                }



            }
        });

    }
    public void onBackPressed() {
        Intent intent1 = new Intent(getApplicationContext(), MenuUtama.class);
        startActivity(intent1);
    }
}