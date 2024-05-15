package com.example.bodega.frontend.app.drawer_menu;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.bodega.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bodega.databinding.ActivityHomepage2Binding;

public class HomePage2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration; //Stores the configuration for the app bar and
    // navigation drawer.
    private ActivityHomepage2Binding binding; //This variable holds the binding object for the activity layout,
    // allowing easier access to UI elements.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomepage2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigatonDrawer.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.anadir_proveedor, R.id.ver_stock, R.id.ver_proovedores,  R.id.anadir_producto, R.id.ver_informes, R.id.ver_clientes,
                R.id.registrar_salidas, R.id.registrar_entradas, R.id.anadir_cliente,  R.id.consultar_salidas, R.id.consultar_entradas,
                R.id.main_page
                )

                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigaton_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    //This method inflates the menu layout associated with the navigation drawer,
    // adding menu items to the action bar.
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigaton_drawer, menu);
        return true;
    }

    @Override
    //This method handles the back button press or navigation up action.
    // It uses the NavController to navigate back within the app according to the mAppBarConfiguration.
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigaton_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}