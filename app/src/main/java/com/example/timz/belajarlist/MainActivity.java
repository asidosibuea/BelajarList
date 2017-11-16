package com.example.timz.belajarlist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data yang harus ditampilkan dibentuk objeknya
        //dimasukan ke dalam array list
        final ArrayList<Makanan> daftar_makanan = new ArrayList<>();
        // Makanan m1 = new Makanan(R.drawable.ic_thumb_up_black_48dp,"Rendang",1200);
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_up_black_48dp, "Rendang", 12000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_up_black_48dp, "Ayam Geprek Pedas", 14000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_down_black_48dp, "Mir Sedap White Curry", 6000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_up_black_48dp, "Ayam Suwir", 1000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_up_black_48dp, "Ayam Nuklir", 14000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_up_black_48dp, "Nasi Kolor", 8000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_down_black_48dp, "Mie Indomie Cabe Ijo", 6000));

        //bentuk makanan adapter
        MakananAdapter adapter = new MakananAdapter(this, daftar_makanan);
        ListView lv_makanan = (ListView) findViewById(R.id.lv_makanan);
        lv_makanan.setAdapter(adapter);

        //tambahkan onItemClickListener kepada List View
        lv_makanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Makanan m = daftar_makanan.get(i);
                String nama_makanan = m.getNama();
                Toast.makeText(getApplicationContext(), nama_makanan, Toast.LENGTH_LONG).show();
            }
        });

        public void keluar (View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("data_login", Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.clear();
        spEditor.commit();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
