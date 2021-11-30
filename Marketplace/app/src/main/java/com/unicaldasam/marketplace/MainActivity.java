package com.unicaldasam.marketplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView T1;
    EditText E1,E2;
    CheckBox CHECK;
    GestorDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T1=(TextView)findViewById(R.id.t10);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.apertura,R.string.cierre);
        toggle.syncState();
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        E1=(EditText) findViewById(R.id.e1login);
        E2=(EditText) findViewById(R.id.e2login);
        CHECK = (CheckBox)findViewById(R.id.checklogin);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.op1Nav:
                T1.setText("Hola mundo");
                Intent registro = new Intent(this,Registro.class);
                startActivity(registro);
            break;

            case R.id.op2Nav:
                T1.setText("segunda opcion");
                break;
        }
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void metodoIngresar(View view) {
        Cursor res;
        String contraseña;
        res=DB.getDataUsuario(E1.getText().toString());
        if(res.moveToFirst())
        {
            contraseña=""+res.getString(5);
            if (contraseña.equals(E2.getText().toString()))
            {
                if(CHECK.isChecked())
                {
                    DB.insertSesion(E1.getText().toString(),"1");
                }
                else
                {
                    DB.insertSesion(E1.getText().toString(),"0");
                }
                //Lanzar la activivy de compras
            }
        }


    }
}