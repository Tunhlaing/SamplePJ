package com.example.samplepj;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences pref;
    RecyclerView rvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        pref = getSharedPreferences("My_Pref", MODE_PRIVATE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvStatus.setLayoutManager(layoutManager);
        StatusAdapter statusAdapter = new StatusAdapter();
        rvStatus.setAdapter(statusAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_logout) {
            new AlertDialog.Builder(this).setMessage("are you sure to logout?") .setCancelable(false) . setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.clear();
                    editor.apply();
                    Intent go = new Intent (HomeActivity.this,RegisterActivity.class);
                    startActivity(go);
                    finish();

                }
            }).setNegativeButton("No",null).show();


        }
        return super.onOptionsItemSelected(item);
    }
    public void initView(){
        rvStatus = findViewById(R.id.rvStatus);

    }
}