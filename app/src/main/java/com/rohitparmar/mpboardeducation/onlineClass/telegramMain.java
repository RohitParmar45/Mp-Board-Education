package com.rohitparmar.mpboardeducation.onlineClass;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.R;

public class telegramMain extends AppCompatActivity {

    private Button btnShare , btnCopy;
    private EditText edTelegram;
    private ClipboardManager clipboard;
    private ClipData myClip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram_main);

        btnCopy = findViewById(R.id.copybtn);
        btnShare = findViewById(R.id.sharebtn);
        edTelegram = findViewById(R.id.edTelegram);


        btnCopy.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                String text = edTelegram.getText().toString();
                myClip = ClipData.newPlainText("text", text);
                clipboard.setPrimaryClip(myClip);
                Toast.makeText(getApplicationContext(), "Link  Copied",
                        Toast.LENGTH_SHORT).show();
            }
        });


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareIntent1 = new Intent(Intent.ACTION_SEND);
                shareIntent1.setType("text/plain");
                shareIntent1.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage1 = "\n" + "MP Board Education Telegram" + "\n\n";
                shareMessage1 = shareMessage1 + "https://telegram.me/mp_board_education_telegram"  + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent1.putExtra(Intent.EXTRA_TEXT, shareMessage1);
                startActivity(Intent.createChooser(shareIntent1, "choose one"));





            }
        });

    }
}