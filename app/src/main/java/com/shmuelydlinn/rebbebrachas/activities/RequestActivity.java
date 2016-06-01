package com.shmuelydlinn.rebbebrachas.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.shmuelydlinn.rebbebrachas.R;

/**
 * Created by shmueldlinn on 5/30/16.
 * This Activity handles the Request frame
 */

public class RequestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // used for incoming animation
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_left);

        // only changes the status bar color for 5.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.statusbar_yellow));
        }

        setContentView(R.layout.request_activity);
        Button sendButton = (Button) findViewById(R.id.send_button);
        final EditText letterText = (EditText) findViewById(R.id.letter_text);
        // create and handle Paypal donate button
        ImageButton donate = (ImageButton) findViewById(R.id.donation_button);
        if (donate != null) {
            donate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent paypalIntent = new Intent(Intent.ACTION_VIEW);
                    // send the use to a browser with paypal.me
                    paypalIntent.setData(Uri.parse(getString(R.string.paypal_url)));
                    startActivity(paypalIntent);
                }
            });
        }
        // handle sending button to make an email intent
        if (sendButton != null) {
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    // send to this email
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.rebbe_email)});
                    // chose apps that can send messages
                    emailIntent.setType("message/rfc822");
                    // Subject of the email
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.letter_for_rebbe ));
                    assert letterText != null;
                    emailIntent.putExtra(Intent.EXTRA_TEXT, letterText.getText());
                    emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

                    // test if the user does not have email installed
                    try {
                        startActivity(Intent.createChooser(emailIntent, getString(R.string.send_email_using)));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(RequestActivity.this, R.string.no_email_clients, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // undoes animation
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right);
    }
}
