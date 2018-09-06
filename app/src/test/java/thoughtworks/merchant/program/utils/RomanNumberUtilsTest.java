package thoughtworks.merchant.program.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import thoughtworks.merchant.program.merchant.MerchantLineType;
import thoughtworks.merchant.program.mvp.presenter.MvpPresenter;

import static org.junit.Assert.*;

/**
 * Created by Liao on 2018/4/27 0027.
 */
public class RomanNumberUtilsTest {
    RomanNumberUtils mRomanNumberUtils;

    @Before
    public void setUp() throws Exception {
        mRomanNumberUtils = new RomanNumberUtils();
    }


    @Test
    public void getRomanNum() throws Exception {
        String str = "IV";
        int s = mRomanNumberUtils.getRomanNum(str);
        Assert.assertEquals(s, 4);
    }

    @Test
    public void getRomanNum1() throws Exception {
        char str = 'V';
        int s = mRomanNumberUtils.getRomanNum(str);
        Assert.assertEquals(s, 5);
    }

}