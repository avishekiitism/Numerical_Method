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
public class Task1 extends AppCompatActivity {


    static TextView textView;
    EditText editText,editText1;
    Button calculate;
    public static int N ; // Number of unknowns
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_task1 );
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

                gaussianElimination(mat);
            }
        });

    }

    // Java program to demonstrate working of Gaussian Elimination
// method





        // function to get matrix content
        static void gaussianElimination(double mat[][])
        {

            /* reduction into r.e.f. */
            int singular_flag = forwardElim(mat);

            /* if matrix is singular */
            if (singular_flag != -1)
            {
                textView.append ("Singular Matrix.\n"  );
//                System.out.println("Singular Matrix.");

	/* if the RHS of equation corresponding to
			zero row is 0, * system has infinitely
			many solutions, else inconsistent*/
                if (mat[singular_flag][N] != 0)
                    textView.append ("Inconsistent System.\n"  );
//                    System.out.print("Inconsistent System.");
                else
                    textView.append ("May have infinitely many solutions.\n"  );
//                    System.out.print(
//                            "May have infinitely many solutions.");

                return;
            }

	/* get solution to system and print it using
		backward substitution */
            backSub(mat);
        }

        // function for elementary operation of swapping two
// rows
        static void swap_row(double mat[][], int i, int j)
        {
            // printf("Swapped rows %d and %d\n", i, j);

            for (int k = 0; k <= N; k++)
            {
                double temp = mat[i][k];
                mat[i][k] = mat[j][k];
                mat[j][k] = temp;
            }
        }

        // function to print matrix content at any stage
        static void print(double mat[][])
        {
            for (int i = 0; i < N; i++, System.out.println())
                for (int j = 0; j <= N; j++){
                    textView.append ( mat[i][j]+" " );
                }

        }

        // function to reduce matrix to r.e.f.
        static int forwardElim(double mat[][])
        {
            for (int k = 0; k < N; k++)
            {

                // Initialize maximum value and index for pivot
                int i_max = k;
                int v_max = (int)mat[i_max][k];

                /* find greater amplitude for pivot if any */
                for (int i = k + 1; i < N; i++)
                    if (Math.abs(mat[i][k]) > v_max)
                    {
                        v_max = (int)mat[i][k];
                        i_max = i;
                    }

                /* if a prinicipal diagonal element is zero,
                 * it denotes that matrix is singular, and
                 * will lead to a division-by-zero later. */
                if (mat[k][i_max] == 0)
                    return k; // Matrix is singular

                /* Swap the greatest value row with current row
                 */
                if (i_max != k)
                    swap_row(mat, k, i_max);

                for (int i = k + 1; i < N; i++)
                {

                    /* factor f to set current row kth element
                     * to 0, and subsequently remaining kth
                     * column to 0 */
                    double f = mat[i][k] / mat[k][k];

		/* subtract fth multiple of corresponding
				kth row element*/
                    for (int j = k + 1; j <= N; j++)
                        mat[i][j] -= mat[k][j] * f;

                    /* filling lower triangular matrix with
                     * zeros*/
                    mat[i][k] = 0;
                }

                // print(mat);	 //for matrix state
            }

            // print(mat);		 //for matrix state
            return -1;
        }

        // function to calculate the values of the unknowns
        static void backSub(double mat[][])
        {
            double x[]= new double[N];
            for (int i = N - 1; i >= 0; i--)
            {
                x[i] = mat[i][N];
                for (int j = i + 1; j < N; j++)
                {
                    x[i] -= mat[i][j] * x[j];
                }
                x[i] = x[i] / mat[i][i];
            }

            textView.append ( "\nSolution for the system:\n" );
            for (int i = 0; i < N; i++)
            {

                textView.append ( x[i]+ "\n " );
            }
        }







}