package com.example.huaian.mvpdemo01.base;

import android.content.Context;

/**
 * Created by HuaiAn
 * on 2018/11/20 17:10
 */
public interface BaseView {

    /**
     * 显示正在加载
     */
    void showLoading();

    /**
     * 关闭正在加载View
     */
    void hideLoding();

    /**
     * 显示提示
     * @param msg 提示内容
     */
    void showToast(String msg);

    /**
     * 显示请求错误提示
     */
    void showError();

    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
}
