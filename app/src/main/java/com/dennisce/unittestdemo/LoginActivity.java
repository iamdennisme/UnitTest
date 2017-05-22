package com.dennisce.unittestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dennisce.unittestdemo.Util.LoginUtil;
import com.dennisce.unittestdemo.entity.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_user_name)
    EditText edtUserName;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        if (TextUtils.isEmpty(edtUserName.getText().toString().trim())) {
            Toast.makeText(this, "用户名不可为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
            Toast.makeText(this, "密码不可为空", Toast.LENGTH_SHORT).show();
            return;
        }
        login();
    }

    public void login() {
        User user = LoginUtil.newInstance().login(edtUserName.getText().toString().trim(), edtPassword.getText().toString().trim());
        if (user == null) {
            Toast.makeText(this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent(this,UserInfoActivity.class).putExtra("data",user));
    }
}
