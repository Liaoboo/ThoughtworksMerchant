package thoughtworks.merchant.program.mvp.presenter;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by liao on 2018/4/28 0028.
 */
public class MvpPresenterTest {

    MvpPresenter mvpPresenter;

    @Before
    public void setUp() throws Exception {
        mvpPresenter = new MvpPresenter();
    }

    @Test
    public void getData() throws Exception {
        mvpPresenter.getData("glob glob Silver is 34 Credits");
    }

    @Test
    public void handleData() throws Exception {
        Method testNoParamMethod = mvpPresenter.getClass().getDeclaredMethod("handleData",String[].class);
        testNoParamMethod.setAccessible(true);
        String[] test = new String[]{"glob is I", "prok is V", "pish is X"};
        //调用
        testNoParamMethod.invoke(mvpPresenter, new Object[]{test});
    }

}