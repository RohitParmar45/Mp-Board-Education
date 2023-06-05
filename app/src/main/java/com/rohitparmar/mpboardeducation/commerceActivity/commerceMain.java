package com.rohitparmar.mpboardeducation.commerceActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.aboutUsActivity;
import com.rohitparmar.mpboardeducation.commerceActivity.ImportantQuesCom.ImpQComActivity;
import com.rohitparmar.mpboardeducation.scienceClass.BluePrintSci.BluePrintsActivity;
import com.rohitparmar.mpboardeducation.scienceClass.Leader.LeaderActivity;
import com.rohitparmar.mpboardeducation.scienceClass.scienceMain;

import java.util.Objects;

public class commerceMain extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationViewCommerce;
    private NavController navController;
    private DrawerLayout drawerLayoutCommerce;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationViewCom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce_main);
        bottomNavigationViewCommerce  = findViewById(R.id.bottomNavigationViewCommerce);
        navController = Navigation.findNavController(this,R.id.frame_layout_commerce);
        drawerLayoutCommerce = findViewById(R.id.drawerLayoutCommerce);
        navigationViewCom = findViewById(R.id.navigation_view_commerce);

        toggle = new ActionBarDrawerToggle(this, drawerLayoutCommerce,R.string.start, R.string.close);
        drawerLayoutCommerce.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        NavigationUI.setupWithNavController(bottomNavigationViewCommerce, navController);


        navigationViewCom.setNavigationItemSelectedListener(this);

        navController = Navigation.findNavController(this, R.id.frame_layout_commerce);
        NavigationUI.setupWithNavController(bottomNavigationViewCommerce,navController);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developercom:

                Intent intentd = new Intent(commerceMain.this, aboutUsActivity.class);
                startActivity(intentd);

                break;

            case R.id.navigation_sharecom:

                Intent shareIntent1 = new Intent(Intent.ACTION_SEND);
                shareIntent1.setType("text/plain");
                shareIntent1.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage1 = "\n" + "MP Board Education" + "\n\n";
                shareMessage1 = shareMessage1 + "https://play.google.com/store/apps/details?id="  + BuildConfig.APPLICATION_ID + "\n\n" + "download this ";
                shareIntent1.putExtra(Intent.EXTRA_TEXT, shareMessage1);
                startActivity(Intent.createChooser(shareIntent1, "choose one"));

                break;

            case R.id.navigation_ratecom:
                gotoUrl("https://play.google.com/store/apps/details?id="  + BuildConfig.APPLICATION_ID);
                break;

            case R.id.navigation_youtubercom:
                gotoUrl("https://www.youtube.com/channel/UCQ39II8g44RdCp9ZjcRHVOg/videos" + BuildConfig.APPLICATION_ID);
                break;

            case R.id.navigation_LeaderBoardcom:
                Intent intentx = new Intent(commerceMain.this, LeaderActivity.class);
                startActivity(intentx);
                break;

            case R.id.navigation_blueprintcom:
                Intent intentb = new Intent(commerceMain.this, BluePrintsActivity.class);
                startActivity(intentb);
                break;

            case R.id.navigation_impQcom:
                Intent intente = new Intent(commerceMain.this, ImpQComActivity.class);
                startActivity(intente);
                break;

        }



        return true;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}