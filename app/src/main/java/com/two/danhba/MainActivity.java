package com.two.danhba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact);

        initView();
    }

    private void initView() {

        findViewById(R.id.btn_add_contact).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_contact:
                Intent intent = new Intent(MainActivity.this, CreateContactActivity.class);
                startActivity(intent);
        }
    }
}
