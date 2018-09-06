package thoughtworks.merchant.program.mvp.impl;

import android.content.Context;

/**
 * Created by Liao on 2018/4/27 0027.
 */

public interface BaseView {
    /**
     * 显示正在加载view
     */
    void showLoading();
    /**
     * 关闭正在加载view
     */
    void hideLoading();
    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);
    /**
     * 显示请求错误提示
     */
    void showErr(String msg);
    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
}
