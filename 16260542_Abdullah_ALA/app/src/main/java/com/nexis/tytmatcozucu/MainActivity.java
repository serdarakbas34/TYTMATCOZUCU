package com.nexis.tytmatcozucu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    private UsluSayilar usluSayilar;
    private YasProblemleri yas_problem;
    private Fonksiyonlar fonksiyonlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawer = (DrawerLayout)findViewById(R.id.main_activity_drawerLayout);
        mNav = (NavigationView)findViewById(R.id.main_activity_navigationView);
        mToolbar = (Toolbar)findViewById(R.id.main_activity_toolBar);

        usluSayilar = new UsluSayilar();
        yas_problem = new YasProblemleri();
        fonksiyonlar = new Fonksiyonlar();

        setSupportActionBar(mToolbar);
        mNav.getMenu().findItem(R.id.nav_menu_uslu_sayilar).setChecked(true);
        mNav.setItemIconTintList(null);

        mToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.nav_open, R.string.nav_close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                        case R.id.nav_menu_uslu_sayilar:
                        setFragment(usluSayilar);
                        mNav.getMenu().findItem(R.id.nav_menu_uslu_sayilar).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_menu_fonksiyonlar:
                        setFragment(fonksiyonlar);
                        mNav.getMenu().findItem(R.id.nav_menu_uslu_sayilar).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_menu_yas_problemleri:
                        setFragment(yas_problem);
                        mNav.getMenu().findItem(R.id.nav_menu_uslu_sayilar).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_activity_frameLayout, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START))
            mDrawer.closeDrawer(GravityCompat.START);
    }
}