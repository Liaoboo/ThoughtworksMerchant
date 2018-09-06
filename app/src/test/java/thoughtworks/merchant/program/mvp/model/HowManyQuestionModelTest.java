package thoughtworks.merchant.program.mvp.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

import thoughtworks.merchant.program.mvp.impl.Callback;
import thoughtworks.merchant.program.mvp.impl.MvpView;
import thoughtworks.merchant.program.mvp.presenter.MvpPresenter;

/**
 * Created by Liao on 2018/4/27 0027.
 */
public class HowManyQuestionModelTest implements Callback {
    HowManyQuestionModel mHowManyQuestionModel;

    @Before
    public void setUp() throws Exception {
        mHowManyQuestionModel = new HowManyQuestionModel();

        BaseModel.mConstantRoman.put("glob", "V");
        BaseModel.mConstantRoman.put("prok", "'X'");
        BaseModel.mComputedLiterals.put("Iron", "12");
    }

    @Test
    public void execute() throws Exception {
        String params = "how many Credits is glob prok Gold ?";
        String params2 = "how many Credits is glob prok Iron ?";

        mHowManyQuestionModel.params(params).execute(this);
        mHowManyQuestionModel.params(params2).execute(this);
    }

    @Override
    public void onSuccess(Object data) {
        Assert.assertNotNull(data);
    }

    @Override
    public void onFailure(String msg) {
        Assert.assertNotNull(msg);
    }

    @Override
    public void onError(String msg) {
        Assert.assertNotNull(msg);
    }

    @Override
    public void onComplete() {

    }

    @Test
    public void handleData() throws Exception {
        Method testNoParamMethod = HowManyQuestionModel.class.getDeclaredMethod("handlerData", String[].class, String.class);
        testNoParamMethod.setAccessible(true);
        String[] temp = new String[]{"glob", "prok","Iron"};
        //调用
        testNoParamMethod.invoke(mHowManyQuestionModel, temp, "how many Credits ");
    }

    @Test
    public void getRomanValue() throws Exception {
        Method testNoParamMethod = HowManyQuestionModel.class.getDeclaredMethod("getRomanValue", String.class);
        testNoParamMethod.setAccessible(true);
        //调用
        Object result = testNoParamMethod.invoke(mHowManyQuestionModel, "glob");
        Assert.assertNotNull(result);
        Assert.assertEquals(result, "V");
    }

    @Test
    public void getLiteralsValue() throws Exception {
        Method testNoParamMethod = HowManyQuestionModel.class.getDeclaredMethod("getLiteralsValue", String.class);
        testNoParamMethod.setAccessible(true);
        //调用
        Object result = testNoParamMethod.invoke(mHowManyQuestionModel, "Iron");
        Assert.assertNotNull(result);
        Assert.assertEquals(result, 12f);
    }
}