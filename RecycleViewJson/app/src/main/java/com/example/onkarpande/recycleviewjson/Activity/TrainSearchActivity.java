package com.example.onkarpande.recycleviewjson.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onkarpande.recycleviewjson.Entity.TrainSearchListItem;
import com.example.onkarpande.recycleviewjson.Adapter.TrainSearchListAdapter;
import com.example.onkarpande.recycleviewjson.R;

import java.util.ArrayList;
import java.util.List;

public class TrainSearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<TrainSearchListItem> trainSearchListItems;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_search);

        mDrawerLayout =findViewById(R.id.drawer);
        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView =findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        //navigation view onclicks

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        trainSearchListItems =new ArrayList<>();

        //List of Trains

        trainSearchListItems.add(new TrainSearchListItem("11019","CSTM BBS"));
        trainSearchListItems.add(new TrainSearchListItem("11093","CSTM BBS"));
        trainSearchListItems.add(new TrainSearchListItem("12105","CSTM GONDIA"));
        trainSearchListItems.add(new TrainSearchListItem("12137","CSTM FZR"));
        trainSearchListItems.add(new TrainSearchListItem("11057","CSTM ASR"));
        trainSearchListItems.add(new TrainSearchListItem("12123","CSTM PUNE"));
        trainSearchListItems.add(new TrainSearchListItem("51027","CSTM PVR"));
        trainSearchListItems.add(new TrainSearchListItem("51029","CSTM BJP"));
        trainSearchListItems.add(new TrainSearchListItem("51033","CSTM SNSI"));
        trainSearchListItems.add(new TrainSearchListItem("11027","CSTM MAS"));
        trainSearchListItems.add(new TrainSearchListItem("11041","CSTM MAS"));
        trainSearchListItems.add(new TrainSearchListItem("22105","CSTM PUNE"));
        trainSearchListItems.add(new TrainSearchListItem("22107","CSTM LUR"));
        trainSearchListItems.add(new TrainSearchListItem("22147","CSTM SNSI"));
        trainSearchListItems.add(new TrainSearchListItem("11007","CSTM PUNE"));


        adapter=new TrainSearchListAdapter(trainSearchListItems,this);
        recyclerView.setAdapter(adapter);

        EditText searchText=findViewById(R.id.search_field);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                 filter(editable.toString());
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public void filter(String text)
    {
        List<TrainSearchListItem> filterList=new ArrayList<>();
        for(TrainSearchListItem item: trainSearchListItems)
        {
            if((item.gettNo().toLowerCase().contains(text.toLowerCase())) || (item.gettName().toLowerCase().contains(text.toLowerCase())) )
            {
                filterList.add(item);
            }
        }
        adapter=new TrainSearchListAdapter(filterList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        if(id==R.id.total_inspection)
        {
            //Toast.makeText(this,"Home selected",Toast.LENGTH_SHORT).show();
            String url = "http://www.facebook.com";
            Intent i =new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        if(id==R.id.help)
        {
            //Toast.makeText(this,"Settings selected",Toast.LENGTH_SHORT).show();
            String url = "https://github.com";
            Intent i =new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        if(id==R.id.logout)
        {
            String url = "http://www.facebook.com";
            Intent i =new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        return true;
    }

}
