package thoughtworks.merchant.program.mvp.model;

import java.util.HashMap;

import thoughtworks.merchant.program.mvp.impl.Callback;

/**
 * Model基类，提供基础方法
 *
 * Created by Liao on 2018/4/27 0027.
 */

public abstract class BaseModel<T> {

    /**
     * 记录每个标记表示的罗马数字
     */
    public static HashMap<String, String> mConstantRoman = new HashMap<>();

    /**
     * 记录计算各种金币的面值
     */
    public static HashMap<String, String> mComputedLiterals = new HashMap<>();

    //数据参数
    protected String mParams;

    /**
     * 设置数据请求参数
     *
     * @param args 参数数组
     */
    public BaseModel params(String args) {
        mParams = args;
        return this;
    }

    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    public abstract void execute(Callback<T> callback);

}
