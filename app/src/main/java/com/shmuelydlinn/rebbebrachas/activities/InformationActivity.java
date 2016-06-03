package com.shmuelydlinn.rebbebrachas.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.shmuelydlinn.rebbebrachas.R;

/**
 * Created by shmueldlinn on 5/30/16.
 * This Activity Handles the Information Frame
 */

public class InformationActivity extends AppCompatActivity {
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

        setContentView(R.layout.information_activity);

        // Create DocumentView and set plain text
        // Important: Use DocumentLayout.class
//        DocumentView documentView = new DocumentView(this, DocumentView.PLAIN_TEXT);  // Support plain text
//        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
//        documentView.setText("just testing", true); // Set to `true` to enable justification
//
        // Handles the Justify text style
        WebView webview = new WebView(this);
        webview.setVerticalScrollBarEnabled(false);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.inset_web_view);
        if (linearLayout != null) {
            linearLayout.addView(webview);
        }
        //webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        //webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webview.loadData(getString(R.string.information_text), "text/html; charset=utf-8", "utf-8");

//        TextView text = (TextView) findViewById(R.id.information_text);
//        if (text != null) {
//            text.setMovementMethod(LinkMovementMethod.getInstance());
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // undoes animation
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right);
    }
}
