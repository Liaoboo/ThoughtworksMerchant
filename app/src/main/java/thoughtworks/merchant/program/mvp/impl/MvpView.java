package thoughtworks.merchant.program.mvp.impl;

/**
 * Created by Liao on 2018/4/27 0027.
 */

public interface MvpView extends BaseView{
    /**
     * 当数据匹配成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(Object data);
}
