package thoughtworks.merchant.program.mvp.presenter;

import thoughtworks.merchant.program.mvp.impl.Callback;
import thoughtworks.merchant.program.mvp.impl.MvpView;
import thoughtworks.merchant.program.mvp.model.BaseModel;
import thoughtworks.merchant.program.mvp.model.DataModel;
import thoughtworks.merchant.program.log.ErrorMessage;
import thoughtworks.merchant.program.merchant.MerchantLineType;

/**
 * MvpPresenter处理输入内容
 * <p>
 * Created by Liao on 2018/4/27 0027.
 */

public class MvpPresenter extends BasePresenter<MvpView> implements Callback {

    /**
     * 获取数据
     *
     * @param params 参数
     */
    public void getData(String params) {
        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }
        BaseModel.mComputedLiterals.clear();
        BaseModel.mConstantRoman.clear();

        //显示正在加载进度条
        getView().showLoading();


        if (params.contains("\n")) {
            String lines[] = params.split("\\n");
            handleData(lines);
        } else {
            if (params == null || params.length() == 0) {
                getView().showToast(ErrorMessage.getMessage(ErrorMessage.NO_INPUT));
            } else {
                getView().showToast(ErrorMessage.getMessage(ErrorMessage.INVALID));
            }

            getView().hideLoading();
        }


    }

    /**
     * 处理输入的数据
     *
     * @param params
     */
    private void handleData(String[] params) {

        for (int i = 0; i < params.length; i++) {
            String data = params[i];
            MerchantLineType.Type lineType = new MerchantLineType().getLineType(data);
            if (lineType != MerchantLineType.Type.OTHER) {
                DataModel.request(lineType.toString()).params(data).execute(this);
            } else {
                if (isViewAttached())
                    getView().showErr(ErrorMessage.getMessage(ErrorMessage.NO_IDEA));
            }

        }
        if (isViewAttached())
            getView().hideLoading();
    }

    @Override
    public void onSuccess(Object data) {
        getView().showData(data);
    }

    @Override
    public void onFailure(String msg) {
        //调用view接口提示失败信息
        getView().showErr(msg);
    }

    @Override
    public void onError(String msg) {
        //调用view接口提示错误信息
        getView().showToast(msg);
    }

    @Override
    public void onComplete() {
        // 隐藏正在加载进度条
        getView().hideLoading();
    }

}