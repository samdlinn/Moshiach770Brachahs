package com.shmuelydlinn.rebbebrachas.Activities;

/**
 * Main Activity to handle the first page of the app
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shmuelydlinn.rebbebrachas.Adapters.MenuAdapter;
import com.shmuelydlinn.rebbebrachas.Objects.MainMenuItem;
import com.shmuelydlinn.rebbebrachas.R;

import java.util.ArrayList;
import java.util.List;

public class MainMenuActivity extends AppCompatActivity {
    private List<MainMenuItem> menuItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu_activity);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        MenuAdapter menuAdapter = new MenuAdapter(menuItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(menuAdapter);

        prepareMenuItems();
    }

    /**
     * Creates and prepares all of the menu items
     */
    private void prepareMenuItems(){
        MainMenuItem mainMenuItem1 = new MainMenuItem(getString(R.string.menu_item1));
        MainMenuItem mainMenuItem2 = new MainMenuItem(getString(R.string.menu_item2));
        MainMenuItem mainMenuItem3 = new MainMenuItem(getString(R.string.menu_item3));
        menuItemList.add(mainMenuItem1);
        menuItemList.add(mainMenuItem2);
        menuItemList.add(mainMenuItem3);
    }
}
