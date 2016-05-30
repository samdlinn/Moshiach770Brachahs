package com.shmuelydlinn.rebbebrachas.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        setContentView(R.layout.request_activity);
        Button sendButton = (Button) findViewById(R.id.send_button);
        final EditText letterText = (EditText) findViewById(R.id.letter_text);
        TextView donate = (TextView) findViewById(R.id.donation_link);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paypalIntent = new Intent(Intent.ACTION_VIEW);
                paypalIntent.setData(Uri.parse(getString(R.string.paypal_url)));
                startActivity(paypalIntent);
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"Shmueld770@hotmail.com"});
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Letter for the Rebbe");
                emailIntent.putExtra(Intent.EXTRA_TEXT   , letterText.getText());
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send email using..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(RequestActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
