package thoughtworks.merchant.program.mvp.impl;

/** 回调接口
 * Created by Liao on 2018/4/27 0027.
 */

public interface Callback<T> {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void onSuccess(T data);
    /**
     *  匹配失败，不能识别
     */
    void onFailure(String msg);
    /**
     * 异常错误
     */
    void onError(String msg);
    /**
     * 加载完成，可以作为隐藏“正在加载”的等待控件，暂时作为扩展功能未使用
     */
    void onComplete();
}