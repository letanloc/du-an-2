package efood.loc.com.efood;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import efood.loc.com.efood.Views.Frament_Add_Caculator;
import efood.loc.com.efood.Views.Frament_reciper;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitactionBar();
        Iniview();

    }

    public void InitactionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("loc");
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    NavigationView navigationView;

    public void Iniview() {
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }
        setupNavigationDrawerContent(navigationView);
        setFragment(0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /// thuw hien click
    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Frament_Add_Caculator inboxFragment = new Frament_Add_Caculator();
                fragmentTransaction.replace(R.id.fragment, Frament_Add_Caculator.newInstance());
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Frament_reciper starredFragment = new Frament_reciper();
                fragmentTransaction.replace(R.id.fragment, starredFragment);
                fragmentTransaction.commit();
                break;
        }
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_inbox:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_starred:
                                menuItem.setChecked(true);
                                setFragment(1);
                                drawerLayout    .closeDrawer(GravityCompat.START);
                                return true;
//                            case R.id.item_navigation_drawer_sent_mail:
//                                menuItem.setChecked(true);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_drafts:
//                                menuItem.setChecked(true);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_settings:
//                                menuItem.setChecked(true);
//                                Toast.makeText(MainActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
//                                startActivity(intent);
//                                return true;
//                            case R.id.item_navigation_drawer_help_and_feedback:
//                                menuItem.setChecked(true);
//                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
                        }
                        return true;
                    }
                });
    }

}
