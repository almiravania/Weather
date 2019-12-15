package com.example.almiraapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMove1;
    private Button btnMove2;
    private Button btnMove3;
    private Button btnMove4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove1 = findViewById(R.id.btn_move_course1);
        btnMove1.setOnClickListener(this);
        btnMove2 = findViewById(R.id.btn_move_course2);
        btnMove2.setOnClickListener(this);
        btnMove3 = findViewById(R.id.btn_move_course3);
        btnMove3.setOnClickListener(this);
        btnMove4 = findViewById(R.id.btn_move_course4);
        btnMove4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_course1:
                startActivity(new Intent(this, cuacaActivity.class));
                break;
            case R.id.btn_move_course2:
                startActivity(new Intent(this, justJava.class));
                break;
            case R.id.btn_move_course3:
                startActivity(new Intent(this, listViewActivity.class));
                break;
            case R.id.btn_move_course4:
                startActivity(new Intent(this, apiActivity.class));
                break;
        }
    }
}
