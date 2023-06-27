package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_commerce.util.ToastUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLogin;

    private EditText mEtUser;

    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBtnLogin = findViewById(R.id.btn_login);

        mEtUser = findViewById(R.id.et_1);

        mEtPassword = findViewById(R.id.et_2);

        mBtnLogin.setOnClickListener(this);

    }

    public void onClick(View v){
        //需要获取用户的用户名密码
        String username = mEtUser.getText().toString();
        String password = mEtPassword.getText().toString();
        //弹出内容设置
        String ok = "登录成功";
        String fail ="验证码有误，请重新登录";
        Intent intent = null;

        //账号验证码
        if(username.equals("1")&&password.equals("1")){

                //封装好的类
                ToastUtil.showMsg(LoginActivity.this, ok);

                //若正确进行跳转
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        else {
        ToastUtil.showMsg(LoginActivity.this, fail);}
        }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

