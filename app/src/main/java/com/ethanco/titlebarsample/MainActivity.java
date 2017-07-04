package com.ethanco.titlebarsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ethanco.titlebar.TitleBar;

public class MainActivity extends AppCompatActivity {
    private TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "left click!", Toast.LENGTH_SHORT).show();
            }
        });

        titleBar.setOnRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "right click!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
