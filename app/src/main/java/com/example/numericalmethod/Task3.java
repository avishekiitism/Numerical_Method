package com.example.numericalmethod;
import static com.example.numericalmethod.Task1.gaussianElimination;

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
public class Task3 extends AppCompatActivity {


    static TextView textView;
    EditText editText,editText1;
    Button calculate;
    public static int N ; // Number of unknowns
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_task3 );
        textView = findViewById ( R.id.textView8 );
        editText = findViewById ( R.id.editText );
        editText1 = findViewById ( R.id.editText1 );
        calculate = findViewById ( R.id.result );
        String matrix = editText.getText ().toString ();

        calculate.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                N = Integer.parseInt ( editText1.getText ().toString () );
                double mat[][] = new double[N][N + 1];
                String matrix = editText.getText ().toString ();
                Scanner sc = new Scanner ( matrix );
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N + 1; j++) {
                        mat[i][j] = sc.nextInt ();
                    }
                }
                sc.close ();
                double[][] lower = new double[N][N+1];
                double[][] upper = new double[N][N+1];
                luDecomposition ( mat , N ,lower,upper);
                textView.append ( "\n" );
                for(int i=0;i<N;i++){
                    lower[i][N]=mat[i][N];
                }
//                Task1.gaussianElimination(lower);
            }
        } );

    }
    static int MAX = 100;

    static void luDecomposition(double mat[][], int n, double lower[][], double upper[][])
    {


        // Decomposing matrix into Upper and Lower
        // triangular matrix
        for (int i = 0; i < n; i++)
        {
            // Upper Triangular
            for (int k = i; k < n; k++)
            {
                // Summation of L(i, j) * U(j, k)
                int sum = 0;
                for (int j = 0; j < i; j++)
                    sum += (lower[i][j] * upper[j][k]);

                // Evaluating U(i, k)
                upper[i][k] = mat[i][k] - sum;
            }

            // Lower Triangular
            for (int k = i; k < n; k++)
            {
                if (i == k)
                    lower[i][i] = 1; // Diagonal as 1
                else
                {
                    // Summation of L(k, j) * U(j, i)
                    int sum = 0;
                    for (int j = 0; j < i; j++)
                        sum += (lower[k][j] * upper[j][i]);

                    // Evaluating L(k, i)
                    lower[k][i]
                            = (mat[k][i] - sum) / upper[i][i];
                }
            }
        }

        textView.append ( "Lower Triangluar\n" );

        // Displaying the result :
        for (int i = 0; i < n; i++)
        {
            // Lower
            for (int j = 0; j < n; j++)
                textView.append ( lower[i][j]+" \n" );
            textView.append ( "\n" );
        }
        textView.append ( "Upper Triangluar\n" );

        // Displaying the result :
        for (int i = 0; i < n; i++)
        {
            // Lower
            for (int j = 0; j < n; j++)
                textView.append ( upper[i][j]+" \n" );
            textView.append ( "\n" );
        }
    }










}