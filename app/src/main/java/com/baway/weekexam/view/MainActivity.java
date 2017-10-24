package com.baway.weekexam.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baway.weekexam.R;
import com.baway.weekexam.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainListener {

    /**
     * 请输入账号
     */
    private EditText mEtAccount;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    /**
     * 登陆
     */
    private Button mBtLogin;
    private MainPresenter mainPresenter;
    private TextView mTv;
    /**
     * 退出登陆
     */
    private Button mBtExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        initView();
    }

    private void initView() {
        mEtAccount = (EditText) findViewById(R.id.etAccount);
        mEtPwd = (EditText) findViewById(R.id.etPwd);
        mBtLogin = (Button) findViewById(R.id.btLogin);
        mBtLogin.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
        mBtExit = (Button) findViewById(R.id.btExit);
        mBtExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btLogin:
                //登陆
                mainPresenter.login();
                break;
            case R.id.btExit:
                break;
        }
    }


    @Override
    public String getAccount() {
        return mEtAccount.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString().trim();
    }

    @Override
    public void setResult(String str) {
        mTv.setText(str);
    }
}
