package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import Model.Person;
import Model.PersonDA;

public class show_info extends AppCompatActivity {
    Person person;

    TextView firstName_view;
    TextView lastName_view;
    TextView email;
    TextView age;
    TextView phoneNumber;
    Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        person = new Person();
        setPerson();
        initViews();
        ControllerViews();

    }

    private void initViews() {

        firstName_view = findViewById(R.id.firstnameView);
        lastName_view = findViewById(R.id.lastName_view);
        email = findViewById(R.id.email_view);
        age = findViewById(R.id.ageView);
        phoneNumber = findViewById(R.id.phoneNumebr_view);
        exit = findViewById(R.id.exit);

    }

    private void ControllerViews() {
        firstName_view.setText(person.getFirstName());
        lastName_view.setText(person.getLastName());
        email.setText(person.getEmail());
//        age.setText(person.getAge());
        phoneNumber.setText(person.getPhoneNumber());
        System.out.println(person.getPhoneNumber());

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });
    }

    private void setPerson() {
        int a = getIntent().getIntExtra("place", 0);
        if (a != 0) {
            PersonDA personDA = new PersonDA(this);
            List<Person> personList = personDA.personList();
            person.setFirstName(personList.get(a).getFirstName());
            person.setLastName(personList.get(a).getLastName());
            person.setPhoneNumber(personList.get(a).getPhoneNumber());
            person.setEmail(personList.get(a).getEmail());
            person.setAge(personList.get(a).getAge());
        }
    }

}