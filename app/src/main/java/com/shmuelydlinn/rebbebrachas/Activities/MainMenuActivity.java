package com.shmuelydlinn.rebbebrachas.Activities;

/**
 * Main Activity to handle the first page of the app
 */

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.shmuelydlinn.rebbebrachas.Adapters.MenuAdapter;
import com.shmuelydlinn.rebbebrachas.Listeners.MainMenuRecyclerItemClickListener;
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.statusbar_yellow));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        MenuAdapter menuAdapter = new MenuAdapter(menuItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(menuAdapter);

        recyclerView.addOnItemTouchListener(
                new MainMenuRecyclerItemClickListener(getApplicationContext(), new MainMenuRecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent;
                        switch (position){
                            case 0:
                                intent = new Intent(MainMenuActivity.this, InstructionActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(MainMenuActivity.this, InformationActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(MainMenuActivity.this, RequestActivity.class);
                                startActivity(intent);
                                break;
                            default:
                                Log.d("MainMenuActivity", "Error on Click at position " + position);
                        }
                    }
                })
        );
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
