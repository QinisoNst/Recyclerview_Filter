package com.dummyworks.reyclerview_sorting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents App";
    Menu menu;
    MyApplication myApplication = (MyApplication) this.getApplication();

    List<President> presidentList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Button btn_addEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presidentList = myApplication.getPresidentList();

        btn_addEdit = findViewById(R.id.btn_add);



        Log.d(TAG, "onCreate: "+ presidentList.toString());
        Toast.makeText(this, "Presidents count = "+ presidentList.size(),Toast.LENGTH_SHORT).show();
        btn_addEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.lv_presidentList);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new recyclerViewAdapter(presidentList,this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.menu_aToz){

                Collections.sort(presidentList, President.PresidentNameAZComparator);
                Toast.makeText(this, "Sort A to Z",Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();

            } else if(item.getItemId() == R.id.menu_zToa){

                Collections.sort(presidentList, President.PresidentNameZAComparator);
                Toast.makeText(this, "Sort Z to A",Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();

            }else if(item.getItemId() == R.id.menu_dateAscending){

                Collections.sort(presidentList, President.PresidentDateAscendingComparator);
                Toast.makeText(this, "Sort date ascending",Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();

            }else if(item.getItemId() == R.id.menu_dateDescending){

                Collections.sort(presidentList, President.PresidentDateDescendingComparator);
                Toast.makeText(this, "Sort date descending",Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();

            }
        return super.onOptionsItemSelected(item);
    }

}