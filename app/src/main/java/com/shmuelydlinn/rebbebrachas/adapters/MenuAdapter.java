package com.shmuelydlinn.rebbebrachas.adapters;

/**
 * Created by shmueldlinn on 5/30/16.
 * Adapter for the Main Menu Recycler view
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shmuelydlinn.rebbebrachas.objects.MainMenuItem;
import com.shmuelydlinn.rebbebrachas.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private final List<MainMenuItem> mainMenuItemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView text;

        public MyViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.text);
        }
    }

    /**
     *
     * @param mainMenuItemList
     */
    public MenuAdapter(List<MainMenuItem> mainMenuItemList) {
        this.mainMenuItemList = mainMenuItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MainMenuItem menuItem = mainMenuItemList.get(position);
        holder.text.setText(menuItem.getText());
    }

    @Override
    public int getItemCount() {
        return mainMenuItemList.size();
    }
}