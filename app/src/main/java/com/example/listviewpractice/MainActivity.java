package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText en;
    EditText em;
    EditText ep;
    Button b;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        en=findViewById(R.id.etname);
        em=findViewById(R.id.etmail);
        ep=findViewById(R.id.etpin);
        b=findViewById(R.id.btn);
        l=findViewById(R.id.lv);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Submitted",Toast.LENGTH_SHORT).show();
                ArrayList<String> arrayList=new ArrayList<>();

                arrayList.add("Name : "+en.getText().toString());
                arrayList.add("Email : "+em.getText().toString());
                arrayList.add("Pin : "+ep.getText().toString());
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                l.setAdapter(arrayAdapter);
                l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this,arrayList.get(position)+" clicked",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}