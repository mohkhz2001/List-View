package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Model.Person;
import Model.PersonDA;
import MyAdapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    ListView list;

    List<Person> personList ;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personList = new ArrayList<>();

        PersonDA personDA = new PersonDA(MainActivity.this);
        personList = personDA.personList();

//        personDA.openDB();
//        personDA.addNewData(new Person("mehdi" , "khajehzadeh" , "@" , 20 , 0));
//        personDA.addNewData(new Person("mohammad" , "yousefipoor" , "@" , 20 , 0));
//        personDA.addNewData(new Person("hesam" , "hatefi" , "@" , 20 , 0));
//        personDA.addNewData(new Person("arshia" , "madadi" , "@" , 20 , 0));
//        personDA.addNewData(new Person("mohammad" , "khz" , "@" , 20 , 0));
//        personDA.closeDB();

        initViews();
        ViewsController();
    }

    private void initViews(){
        list = findViewById(R.id.List);

    }

    private void ViewsController(){
        myAdapter = new MyAdapter(this , personList);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this , show_info.class);
                intent.putExtra("place", i);
                startActivity(intent);
            }
        });
    }
}