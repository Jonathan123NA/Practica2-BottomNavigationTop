package com.example.practica1tercerparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    InicioFragment inicioFragment = new InicioFragment();
    WatchFragment watchFragment = new WatchFragment();
    MarketplaceFragment marketplaceFragment = new MarketplaceFragment();
    PerfilFragment perfilFragment = new PerfilFragment();
    NotificacionFragment notificacionFragment = new NotificacionFragment();
    MenuFragment menuFragment = new MenuFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(firstFragment);

        BottomNavigationView navigationTop = findViewById(R.id.bottom_navigation_top);
        navigationTop.setOnNavigationItemSelectedListener(mTopOnNavigationItemSelectedListener);
        loadFragment(inicioFragment);

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firtstFragment:
                    loadFragment(firstFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(secondFragment);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(thirdFragment);
                    return true;
            }
            return false;
        }
    };

    private final BottomNavigationView.OnNavigationItemSelectedListener mTopOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.inicioFragment:
                    loadFragment(inicioFragment);
                    return true;
                case R.id.watchFragment:
                    loadFragment(watchFragment);
                    return true;
                case R.id.marketplaceFragment:
                    loadFragment(marketplaceFragment);
                    return true;
                /*case R.id.perfilFragment:
                    loadFragment(perfilFragment);
                    return true;*/
                case R.id.notificacionFragment:
                    loadFragment(notificacionFragment);
                    return true;
                case R.id.menuFragment:
                    loadFragment(menuFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();
    }
}