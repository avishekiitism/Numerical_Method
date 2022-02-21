package com.example.numericalmethod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;

// Implementing Gauss Seidel Method in Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
public class Task2 extends AppCompatActivity {


    static TextView textView;
    EditText editText,editText1;
    Button calculate;
    public static int N ; // Number of unknowns
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_task2 );
        textView = findViewById ( R.id.textView8 );
        editText=findViewById ( R.id.editText );
        editText1=findViewById ( R.id.editText1 );
        calculate=findViewById ( R.id.result );
        String matrix= editText.getText ().toString ();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N = Integer.parseInt(editText1.getText().toString());
                double mat[][]= new double[N][N+1];
                String matrix= editText.getText ().toString ();
                Scanner sc = new Scanner (matrix);
                for(int i=0;i<N;i++){
                    for(int j=0;j<N+1;j++){
                        mat[i][j] = sc.nextInt();
                    }
                }
                sc.close();
                int flag = 0;
                flag = PerformOperation(mat, N);
                if (flag == 1)
                    flag = CheckConsistency(mat, N, flag);
                textView.append ( "Final Augmented Matrix is : \n" );

                PrintMatrix(mat, N);
                textView.append ( "\n" );


                PrintResult(mat, N, flag);
            }
        });


    }
    static int PerformOperation(double a[][], int n)
    {
        int i, j, k = 0, c, flag = 0, m = 0;
        float pro = 0;

        // Performing elementary operations
        for (i = 0; i < n; i++)
        {
            if (a[i][i] == 0)
            {
                c = 1;
                while ((i + c) < n && a[i + c][i] == 0)
                    c++;
                if ((i + c) == n)
                {
                    flag = 1;
                    break;
                }
                for (j = i, k = 0; k <= n; k++)
                {
                    double temp =a[j][k];
                    a[j][k] = a[j+c][k];
                    a[j+c][k] = temp;
                }
            }

            for (j = 0; j < n; j++)
            {

                // Excluding all i == j
                if (i != j)
                {

                    // Converting Matrix to reduced row
                    // echelon form(diagonal matrix)
                    double p = a[j][i] / a[i][i];

                    for (k = 0; k <= n; k++)
                        a[j][k] = a[j][k] - (a[i][k]) * p;
                }
            }
        }
        return flag;
    }

    static int CheckConsistency(double a[][], int n, int flag)
    {
        int i, j;
        double sum;

        // flag == 2 for infinite solution
        // flag == 3 for No solution
        flag = 3;
        for (i = 0; i < n; i++)
        {
            sum = 0;
            for (j = 0; j < n; j++)
                sum = sum + a[i][j];
            if (sum == a[i][j])
                flag = 2;
        }
        return flag;
    }

    static void PrintMatrix(double a[][], int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= n; j++)
                textView.append ( a[i][j]+"  " );
            textView.append ( "\n" );

        }
    }

    static void PrintResult(double a[][], int n, int flag)
    {
        textView.append (  "Result is : \n");

        if (flag == 2)
            textView.append ( "Infinite Solutions Exists\n" );
        else if (flag == 3)
            textView.append ( "No Solution Exists\n" );
        else {
            for (int i = 0; i < n; i++)
                textView.append ( a[i][n]/a[i][i] +"\n" );

        }
    }










}