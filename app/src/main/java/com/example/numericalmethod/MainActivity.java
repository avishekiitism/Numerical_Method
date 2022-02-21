package com.example.numericalmethod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView task1,task2,task3,task4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        task1=findViewById ( R.id.task1 );
        task1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (MainActivity.this , "Task1",Toast.LENGTH_LONG ).show ();
                Intent intent= new Intent ( MainActivity.this , Task1.class);
                startActivity ( intent );

            }
        } );

        task2=findViewById ( R.id.task2 );
        task2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (MainActivity.this , "Task2",Toast.LENGTH_LONG ).show ();
                Intent intent= new Intent ( MainActivity.this , Task2.class);
                startActivity ( intent );

            }
        } );

        task3=findViewById ( R.id.task3 );
        task3.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (MainActivity.this , "Task3",Toast.LENGTH_LONG ).show ();
                Intent intent= new Intent ( MainActivity.this , Task3.class);
                startActivity ( intent );

            }
        } );

        task4=findViewById ( R.id.task4 );
        task4.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (MainActivity.this , "Task4",Toast.LENGTH_LONG ).show ();
                Intent intent= new Intent ( MainActivity.this , Task4.class);
                startActivity ( intent );

            }
        } );




    }



}