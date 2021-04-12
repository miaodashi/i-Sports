package com.example.isports.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.isports.R;
import com.example.isports.api.Api;
import com.example.isports.api.ApiConfig;
import com.example.isports.api.TtitCallback;
import com.example.isports.util.StringUtils;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity {
    private static final String TAG = "zeta";
    private EditText etAccount;
    private EditText etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_pwd);
        btnRegister = findViewById(R.id.register_btn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPassword.getText().toString().trim();
                register(account,pwd);
            }
        });

    }
    private void register(String account,String pwd) {
        if(StringUtils.isEmpty(account)){
            showToast("请输入学号");
            return;
        }
        if(StringUtils.isEmpty(pwd)){
            showToast("请输入密码");
            return;
        }
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("studynumber", account);
        params.put("password", pwd);
        Api.config(ApiConfig.REGISTER,params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(String res) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(res);
                    }
                });
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure: ",e.toString() );

            }
        });

    }
}