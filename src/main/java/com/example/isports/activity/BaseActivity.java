package com.example.isports.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

    }
    public void showToast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }
    public void showToastSync(String msg){
        Looper.prepare();
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
        Looper.loop();
    }
    public void navigateTo(Class cls){
        Intent in = new Intent(mContext,cls);
        startActivity(in);
    }
    protected void saveStringToSp(String key,String val){
        SharedPreferences sp = getSharedPreferences("sp_ttit",MODE_PRIVATE);
        SharedPreferences.Editor editor =sp.edit();
        editor.putString(key,val);
        editor.commit();
    }
}
