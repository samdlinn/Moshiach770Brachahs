package com.shmuelydlinn.rebbebrachas.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.shmuelydlinn.rebbebrachas.R;

/**
 * Created by shmueldlinn on 5/30/16.
 * This Activity Handles the Information Frame
 */

public class InformationActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);

        TextView text = (TextView) findViewById(R.id.information_text);
        if (text != null) {
//            text.setText(Html.fromHtml(getString(R.string.instructions_text)))/;
            text.setMovementMethod(LinkMovementMethod.getInstance());
//            Linkify.addLinks(text, Linkify.ALL);
        }
    }
}
