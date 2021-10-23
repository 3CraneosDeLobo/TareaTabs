package com.example.tareatabs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tareatabs.Controlador.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1, tab2, tab3, tab4;
PagerController pagerController;
    TextView link1, link2, link3, link4;
    EditText txtUser, txtPwd;
    Button btnR, btnL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MENU



        //MENU END


        ArrayList<Users> usuarios = new ArrayList<>();
        usuarios.add(new Users("admin", "admin"));
        usuarios.add(new Users("user", "123"));




        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tab1 = findViewById(R.id.inicio);
        tab2 = findViewById(R.id.registro);
        tab3 = findViewById(R.id.contacto);
        tab4 = findViewById(R.id.canciones);

pagerController = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
viewPager.setAdapter(pagerController);
tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        if(tab.getPosition()==0){
            pagerController.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "INICIO", Toast.LENGTH_SHORT).show();
        }
        if(tab.getPosition()==1){
            pagerController.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "REGISTRO", Toast.LENGTH_SHORT).show();
txtUser = findViewById(R.id.user);
txtPwd = findViewById(R.id.pwd);


// LOGIN

btnR = findViewById(R.id.button1);
btnL = findViewById(R.id.button2);

//REGISTRARSE
btnR.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String user = txtUser.getText().toString();
        String pwd = txtPwd.getText().toString();
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        if(user.length() < 1 || pwd.length() < 1){

            alerta.setTitle("Campo Vacio")
                    .setMessage("No puede dejar ningun campo vacio")
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })
                    .create()
                    .show();


        }
        else{
            boolean userVF = false;
            for (int i = 0; i < usuarios.size(); i++) {
                if(user.equals(usuarios.get(i).getUser())){
                    userVF = true;
                }
            }
            if(userVF){
                alerta.setTitle("USUARIO EXISTENTE")
                        .setMessage("Este Usuario ya esta registrado, seleccione otro nombre de usuario")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .create()
                        .show();
            }
            else{
                usuarios.add(new Users(user, pwd));
                Intent in = new Intent(MainActivity.this, WelcomeActivity.class);
                in.putExtra("username", user);
                startActivity(in);
            }
        }


    }
});
//INICIAR SESION
btnL.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String user = txtUser.getText().toString();
        String pwd = txtPwd.getText().toString();
        boolean userVF = false;
        for (int i = 0; i < usuarios.size(); i++) {
if(user.equals(usuarios.get(i).getUser()) && pwd.equals(usuarios.get(i).getPwd()))
{
    //Do Something
    userVF = true;
}
        }
        if(userVF){
            //Do ST
            Intent in = new Intent(MainActivity.this, WelcomeActivity.class);
            in.putExtra("username", user);
            startActivity(in);

        }else{
            //Do ST
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

            alerta.setMessage("Nombre de usuario o Contraseña Incorrecta!")
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })
                    .setTitle("ERROR!")
                    .create()
                    .show();

        }

                }
            });





//LOGIN END
        }
        if(tab.getPosition()== 2){
            pagerController.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "CONTACTO", Toast.LENGTH_SHORT).show();
        } if(tab.getPosition()==3){
            pagerController.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "CANCIONES FAVORITAS", Toast.LENGTH_SHORT).show();
            link1 = findViewById(R.id.link1);
            link1.setMovementMethod(LinkMovementMethod.getInstance());
            link2 = findViewById(R.id.link2);
            link2.setMovementMethod(LinkMovementMethod.getInstance());
            link3 = findViewById(R.id.link3);
            link3.setMovementMethod(LinkMovementMethod.getInstance());
            link4 = findViewById(R.id.link4);
            link4.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});
viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int  id = item.getItemId();


        if(id == R.id.item1){

            Intent in = new Intent(MainActivity.this, OptionsActivity.class);
            in.putExtra("username", "CONFIGURACION");
            startActivity(in);
        }
       else if(id == R.id.item2){
            Intent in = new Intent(MainActivity.this, OptionsActivity.class);
            in.putExtra("username", "MUSICA");
            startActivity(in);
        }
        else if(id == R.id.item3){
            Intent in = new Intent(MainActivity.this, OptionsActivity.class);
            in.putExtra("username", "ORGANIZACION");
            startActivity(in);
        }

        return super.onOptionsItemSelected(item);


    }



}