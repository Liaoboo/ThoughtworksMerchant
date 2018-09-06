package thoughtworks.merchant.program.mvp.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import thoughtworks.merchant.program.mvp.impl.Callback;
import thoughtworks.merchant.program.mvp.presenter.MvpPresenter;

/**
 * Created by Liao on 2018/4/27 0027.
 */
public class HowMuchQuestionModelTest implements Callback {
    HowMuchQuestionModel mHowMuchQuestionModel;
    String params;

    @Before
    public void setUp() throws Exception {
        params = "how much is pish tegj glob glob ?";
        mHowMuchQuestionModel = new HowMuchQuestionModel();
    }

    @Test
    public void execute() throws Exception {

        mHowMuchQuestionModel.params(params).execute(this);
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
    public void getRomanResult() throws Exception {
        Method testNoParamMethod = mHowMuchQuestionModel.getClass().getDeclaredMethod("getRomanResult", String[].class);
        testNoParamMethod.setAccessible(true);
        BaseModel.mConstantRoman.put("glob", "V");
        String[] temp = new String[]{"glob"};
        //调用
        Object result = testNoParamMethod.invoke(mHowMuchQuestionModel, temp);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, "V");
    }
}