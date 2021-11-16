package com.unicaldasam.marketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    TextView T1,T2,T3,T4,T5,T6;
    Button B1;
    EditText E1, E2, E3,E4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        T1=(TextView) findViewById(R.id.t1);
        T2=(TextView) findViewById(R.id.t2);
        T3=(TextView) findViewById(R.id.t3);
        T4=(TextView) findViewById(R.id.t4);
        T5=(TextView) findViewById(R.id.t5);
        T6=(TextView) findViewById(R.id.t6);
        B1=(Button) findViewById(R.id.b1);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        E3=(EditText) findViewById(R.id.e3);
        E4=(EditText) findViewById(R.id.e4);
    }

    public void guardardatos(View view) {
        String nombre,apellido,telefono,correo,contraseña;
        boolean v1,v2,v3,v4,v5;
        nombre=E1.getText().toString();
        apellido=E2.getText().toString();
        telefono=E3.getText().toString();
        v1=nombre.matches("[A-Z].*");
        v2=apellido.matches("[A-Z].*");
        v3=telefono.matches("[1-9].*");
        if (v1!=true ||v2!=true||v3!=true)
        {
            T6.setText(R.string.msj2);
            Toast toast=Toast.makeText(this,"",Toast.LENGTH_LONG);
            toast.setText(R.string.msj2);
            toast.setGravity(Gravity.AXIS_SPECIFIED,200,50);
            toast.show();
        }
    }
}