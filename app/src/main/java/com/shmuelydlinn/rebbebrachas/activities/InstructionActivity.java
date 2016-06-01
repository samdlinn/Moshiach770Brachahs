package com.shmuelydlinn.rebbebrachas.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.shmuelydlinn.rebbebrachas.R;

/**
 * Created by shmueldlinn on 5/30/16.
 * This Activity handlers the instruction frame
 */

public class InstructionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // used for incoming animation
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_left);

        // only changes the status bar for 5.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.statusbar_yellow));
        }
        setContentView(R.layout.instruction_activity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // undoes animation
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right);
    }
}
