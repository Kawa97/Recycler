package com.example.corsista.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter=new RecyclerAdapter(new String[]{"AAAA","BBBB","dcsb","tstjdgh","fdsb","fsdh","dcsb","tstjdgh","fdsb","fsdh","dcsb","tstjdgh","fdsb","fsdh","dcsb","tstjdgh"});
        recyclerView.setAdapter(recyclerAdapter);
        Singleton.getInstance().setActiveManager("linearLayout");
        gridLayoutManager= new GridLayoutManager(this,4);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int scrollPosition= 0;
        switch (item.getItemId()) {
            case R.id.swap: {
                if (Singleton.getInstance().getActiveManager() != null) {
                    scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                            .findFirstCompletelyVisibleItemPosition();
                }
                if(Singleton.getInstance().getActiveManager().equals("linearLayout")){
                recyclerView.setLayoutManager(gridLayoutManager);
                Singleton.getInstance().setActiveManager("gridLayout");
                } else{
                    recyclerView.setLayoutManager(linearLayoutManager);
                    Singleton.getInstance().setActiveManager("linearLayout");
                }

                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.scrollToPosition(scrollPosition);}
                return true;

            default: {
                return super.onOptionsItemSelected(item);
                    }
            }

        }
    }

