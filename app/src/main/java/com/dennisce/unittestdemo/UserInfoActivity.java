package com.dennisce.unittestdemo;

import android.app.Activity;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.dennisce.unittestdemo.databinding.ActivityUserInfoBinding;
import com.dennisce.unittestdemo.entity.User;

/**
 * Created by dennis on 21/05/2017.
 * so.....
 */

public class UserInfoActivity extends Activity {
    private ActivityUserInfoBinding binding;
    private User mUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);
        initData();
    }
    private void initData(){
        Intent intent=getIntent();
        if (!intent.hasExtra("data")){
            return;
        }
        mUser=intent.getExtras().getParcelable("data");
        binding.setUser(mUser);
    }
    public void showInfo(){
        Toast.makeText(this,mUser.userName,Toast.LENGTH_SHORT).show();
    }


}
