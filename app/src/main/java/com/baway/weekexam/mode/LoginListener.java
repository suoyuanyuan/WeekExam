package com.baway.weekexam.mode;

import com.baway.weekexam.mode.bean.LoginBean;

import java.io.IOException;

/**
 * Created by peng on 2017/10/24.
 */

public interface LoginListener {
    public void onSuccess(LoginBean loginBean);

    public void onError(IOException e);
}
