package com.example.huaian.mvpdemo01;

/**
 * Created by HuaiAn
 * on 2018/11/20 15:46
 */
public class MvpPresenter {
    // View接口
    private MvpView mView;

    public MvpPresenter() {
        //构造方法不需要View参数
    }

    /**
     * 绑定view，一般在初始化调用此方法
     * @param mView
     */
    public void attachView(MvpView mView){
        this.mView = mView;
    }

    /**
     * 断开view 一般在onDestory中调用
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要线调用方法查询是都与View建立连接
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String params) {
        //显示正在加载进度条
        mView.showLoading();
        // 调用Model请求数据
        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()) {
                    //调用view接口显示数据
                    mView.showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()) {
                    //调用view接口提示失败信息
                    mView.showFailureMessage(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()) {
                    //调用view接口提示请求异常
                    mView.showErrorMessage();
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()) {
                    // 隐藏正在加载进度条
                    mView.hideLoading();
                }
            }
        });
    }
}