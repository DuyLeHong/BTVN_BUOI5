package com.example.btvn_buoi4.folder;

import static com.example.btvn_buoi4.R.menu.menu_item_folder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.btvn_buoi4.R;

import java.util.ArrayList;
import java.util.List;

public class Activity_folder extends AppCompatActivity {
    private RecyclerView rcv_holder;
    private List<FolderModel> folderModelList;
    private int index = 1;
    FolderAdapter adapter;
    LinearLayoutManager linearLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);

        rcv_holder = findViewById(R.id.rcv_folder);
        linearLayoutManager = new LinearLayoutManager(getApplication(),RecyclerView.VERTICAL,false);
        adapter = new FolderAdapter(setListFolder());

        rcv_holder.setLayoutManager(linearLayoutManager);
        rcv_holder.setAdapter(adapter);


        setToolbar();


    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.icon_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        toolbar.inflateMenu(menu_item_folder);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_menu:
                    folderModelList.add(new FolderModel("Folder" + index));
                    adapter.notifyDataSetChanged();
                    linearLayoutManager.scrollToPosition(folderModelList.size()-1);
                    index++;
                }
                return true;

            }
        });

        getWindow().setStatusBarColor(getColor(R.color.color_status_bar));
    }

    private List<FolderModel> setListFolder() {
        folderModelList = new ArrayList<>();
        folderModelList.add(new FolderModel("Video"));
        folderModelList.add(new FolderModel("Android"));
        folderModelList.add(new FolderModel("Applock"));
        folderModelList.add(new FolderModel("Books"));
        folderModelList.add(new FolderModel("Authenticate Using Google..."));
        return folderModelList;
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_item_folder, menu);
//        return true;
//    }

}