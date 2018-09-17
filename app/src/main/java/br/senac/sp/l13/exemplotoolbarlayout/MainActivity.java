package br.senac.sp.l13.exemplotoolbarlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navView);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_inbox: {
                Toast.makeText(getApplicationContext(), "Menu Inbox", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_favoritos: {
                Toast.makeText(getApplicationContext(), "Menu Favoritos", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_emailEnviados: {
                Toast.makeText(getApplicationContext(), "Menu Enviados", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_lixeira: {
                Toast.makeText(getApplicationContext(), "Menu Lixeira", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_spam: {
                Toast.makeText(getApplicationContext(), "Menu Spam", Toast.LENGTH_SHORT).show();
                break;
            }

        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
