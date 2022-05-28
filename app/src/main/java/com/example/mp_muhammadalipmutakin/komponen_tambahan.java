package com.example.mp_muhammadalipmutakin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class komponen_tambahan extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komponen_tambahan);

        listView = (ListView) findViewById(R.id.list4);
        String[] values = new String[]{"Modem", "Flashdisk"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), modem.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), flashdisk.class);
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