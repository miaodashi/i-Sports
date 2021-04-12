package com.example.isports.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.isports.MainActivity;
import com.example.isports.R;
import com.example.isports.api.Api;
import com.example.isports.api.ApiConfig;
import com.example.isports.api.TtitCallback;
import com.example.isports.entity.LoginResponse;
import com.example.isports.util.AppConfig;
import com.example.isports.util.StringUtils;
import com.google.gson.Gson;

import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {
    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.login_btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPassword.getText().toString().trim();
                login(account,pwd);
            }
        });
    }

    private void login(String account,String pwd) {
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
        Api.config(ApiConfig.LOGIN,params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(String res) {
                Log.e( "onSuccess: ", res);
                showToastSync(res);
                Gson gson = new Gson();
                LoginResponse loginResponse =gson.fromJson(res,LoginResponse.class);
                if(loginResponse.getCode() == 0) {
                    String token =loginResponse.getToken();
                    saveStringToSp("token",token);
                    showToastSync("登录成功");
                }else{
                    showToastSync("登录失败");
                }
                }


            @Override
            public void onFailure(Exception e) {


            }
        });
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//        Map m = new HashMap();
//        m.put("mobile", account);
//        m.put("password", pwd);
//        JSONObject jsonObject = new JSONObject(m);
//        String jsonStr = jsonObject.toString();
//        RequestBody requestBodyJson =
//                RequestBody.create(MediaType.parse("application/json;charset=utf-8")
//                        , jsonStr);
//        //第三步创建Rquest
//        Request request = new Request.Builder()
//                .url(AppConfig.BASE_URL + "/app/login")
//                .addHeader("contentType", "application/json;charset=UTF-8")
//                .post(requestBodyJson)
//                .build();
//        //第四步创建call回调对象
//        final Call call = client.newCall(request);
//        //第五步发起请求
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("onFailure", e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        showToast(result);
//                    }
//                });
//            }
//
//
//        });
    }
}