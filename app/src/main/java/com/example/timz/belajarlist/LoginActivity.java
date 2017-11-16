package com.example.timz.belajarlist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.SharedLibraryInfo;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor spEditor;

    // UI references.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("data_login", Context.MODE_PRIVATE);
        spEditor = sharedPreferences.edit();

        //ambil setting yang sudah ada jika tersimpan
        String uname = sharedPreferences.getString("uname","");
        String pass = sharedPreferences.getString("pass","");

        if (validasiLogin(uname,pass)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void masuk(View view) {
        EditText et_username = (EditText) findViewById(R.id.et_username);
        EditText et_password = (EditText) findViewById(R.id.et_password);

        String uname = et_username.getText().toString();
        String pass = et_password.getText().toString();
        if (validasiLogin(uname, pass)) {
            //simpan setting username dan password
            spEditor.putString("uname",uname);
            spEditor.putString("pass",pass);
            spEditor.commit();
            //Lakukan pindah activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            //Munculkan tulisan username dan password tidak cocok
            Toast.makeText(this, "Username & Password Salah", Toast.LENGTH_SHORT).show();
        }
    }


    public boolean validasiLogin(String uname, String pass) {
        if(uname.equals("admin") && pass.equals("123456")) {
            return true;
        }
        return false;
    }
}


