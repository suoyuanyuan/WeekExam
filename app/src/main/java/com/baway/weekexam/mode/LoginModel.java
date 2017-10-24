package com.baway.weekexam.mode;

import android.content.Context;

import com.baway.weekexam.mode.bean.BaseBean;
import com.baway.weekexam.mode.bean.LoginBean;
import com.baway.weekexam.net.Api;
import com.baway.weekexam.net.HttpUtil;
import com.baway.weekexam.net.OnNetListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/10/24.
 */

public class LoginModel {
    private Context context;

    public LoginModel(Context context) {
        this.context = context;
    }

    public void login(String account, String pwd, final LoginListener loginListener) {
        //在model层里，做真正的登陆请求
        Map<String, String> params = new HashMap<>();
        params.put("username", account);
        params.put("password", pwd);
        params.put("client", "android");
        HttpUtil.getInstance(context).doPost(Api.LOGIN, params, com.baway.weekexam.mode.bean.LoginBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) throws IOException {
                LoginBean loginBean = (LoginBean) baseBean;
                loginListener.onSuccess(loginBean);
            }

            @Override
            public void onError(IOException e) {
                loginListener.onError(e);
            }
        });
    }
}
