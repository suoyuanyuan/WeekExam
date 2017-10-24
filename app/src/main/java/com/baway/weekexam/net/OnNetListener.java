package com.baway.weekexam.net;


import com.baway.weekexam.mode.bean.BaseBean;

import java.io.IOException;

/**
 * Created by peng on 2017/9/27.
 */

public interface OnNetListener {
    public void onSuccess(BaseBean baseBean) throws IOException;

    public void onError(IOException e);
}
