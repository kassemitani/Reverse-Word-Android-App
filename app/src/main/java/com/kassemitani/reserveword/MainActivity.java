package com.kassemitani.reserveword;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A main screen that reserve word.
 */
public class MainActivity extends AppCompatActivity  {


    // UI references.
    private EditText mWordView;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWordView = (EditText) findViewById(R.id.word);

        Button btnSubmit = (Button) findViewById(R.id.submit_button);
        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                reverseWord();
            }
        });

        Button btnCopy = (Button) findViewById(R.id.copy_button);
        btnCopy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                copyWord();
            }
        });

        txtResult = (TextView) findViewById(R.id.txtResult);
    }


    private void reverseWord() {

        String reversed = new StringBuilder(mWordView.getText()).reverse().toString();
        txtResult.setText(reversed);

    }

    private void copyWord() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("lbl", txtResult.getText());
        clipboard.setPrimaryClip(clip);
    }


}

