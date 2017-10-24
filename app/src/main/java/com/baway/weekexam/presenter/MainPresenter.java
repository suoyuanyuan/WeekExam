package com.baway.weekexam.presenter;

import android.content.Context;

import com.baway.weekexam.mode.LoginListener;
import com.baway.weekexam.mode.LoginModel;
import com.baway.weekexam.mode.bean.LoginBean;
import com.baway.weekexam.view.IMainListener;

import java.io.IOException;

/**
 * Created by peng on 2017/10/24.
 */

public class MainPresenter {
    private IMainListener iMainListener;
    private Context context;
    private final LoginModel loginModel;

    public MainPresenter(IMainListener iMainListener) {
        this.context = (Context) iMainListener;
        this.iMainListener = iMainListener;
        loginModel = new LoginModel(context);
    }

    /**
     * 登陆，根据接口观察，需要用户名和密码
     */
    public void login() {
        //获取用户名
        String account = iMainListener.getAccount();
        //获取密码
        String pwd = iMainListener.getPwd();
        loginModel.login(account, pwd, new LoginListener() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                //登陆成功
                StringBuilder sb = new StringBuilder();
                sb.append(loginBean.getDatas().getUsername());
                sb.append(" " + loginBean.getDatas().getUserid());
                sb.append(" " + loginBean.getDatas().getKey());
                iMainListener.setResult(sb.toString());
            }

            @Override
            public void onError(IOException e) {
                //登陆失败
            }
        });
    }


}
