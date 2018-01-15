package com.scott.greendaoexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.zto.scott.componentorder.Order;

import java.util.List;

import main.java.com.zto.scott.componentorder.Helper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button saveBtn;
    private Button queryBtn;
    private Button updateBtn;
    private Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();
    }


    private void initView(){
        saveBtn = (Button) findViewById(R.id.btn_insert);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        queryBtn = (Button) findViewById(R.id.btn_query);
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query();


            }
        });
        updateBtn = (Button) findViewById(R.id.btn_update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void insert(){
        Order order=new Order();
        order.setPrice(12.5);
        order.setName("花生");
        Helper.getInstance(this).insert(order);

    }

    private void query() {
       List<Order> list= Helper.getInstance(this).query(Order.class,"price",12.5);
        Log.d(TAG, "query: "+list);
    }

}
