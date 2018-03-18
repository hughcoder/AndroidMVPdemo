package com.tuya.androidmvpdemo;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tuya.androidmvpdemo.Presenter.UserLoginPresenter;
import com.tuya.androidmvpdemo.bean.User;
import com.tuya.androidmvpdemo.view.IUserLoginView;

/**
 * Created by home on 2018/3/18.
 */

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText etUsername,etPassword;
    private Button mBtnLogin,mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter=new UserLoginPresenter(this);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_user_login);
        initViews();
    }
    private void initViews()
    {
        etUsername=findViewById(R.id.user_name);
        etPassword=findViewById(R.id.user_password);
        mBtnLogin=findViewById(R.id.login);
        mBtnClear=findViewById(R.id.clear);
        mPbLoading=findViewById(R.id.progressbar);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          mUserLoginPresenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          mUserLoginPresenter.clear();
            }
        });

    }
    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
          etUsername.setText("");
    }

    @Override
    public void clearPassword() {
          etPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
       mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,user.getUsename()+"login success,to MainActivity",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFailedError() {
      Toast.makeText(this,"login failed",Toast.LENGTH_LONG).show();
    }
}
