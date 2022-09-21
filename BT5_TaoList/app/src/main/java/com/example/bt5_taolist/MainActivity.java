package com.example.bt5_taolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview;
        ArrayList<MonAn> arrayList;
        AdapterMonAn adapter;

        listview = findViewById(R.id.listviewmonan);
        arrayList = new ArrayList<>();
        arrayList.add(new MonAn("Pizza", "ĐƠN GIÁ:50.000 VNĐ",R.drawable.pizza));
        arrayList.add(new MonAn("Hamburger", "ĐƠN GIÁ:30.000 VNĐ",R.drawable.hamburger));
        arrayList.add(new MonAn("HotDog", "ĐƠN GIÁ:20.000 VNĐ",R.drawable.hotdog));
        arrayList.add(new MonAn("Donut", "ĐƠN GIÁ:20.000 VNĐ",R.drawable.donut));
        arrayList.add(new MonAn("KFC", "ĐƠN GIÁ:69.000 VNĐ",R.drawable.kfc));
        arrayList.add(new MonAn("Bread", "ĐƠN GIÁ:35.000 VNĐ",R.drawable.bread));

        adapter = new AdapterMonAn(MainActivity.this,R.layout.layout_monan,arrayList);
        listview.setAdapter(adapter);

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Xác nhận");
                dialog.setMessage("Bạn có đồng ý xóa không?");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        arrayList.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });

                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent w =new Intent(MainActivity.this,Detail.class );
                startActivity(w);
            }
        });
    }
}