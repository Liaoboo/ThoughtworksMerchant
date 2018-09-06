package thoughtworks.merchant.program.merchant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import thoughtworks.merchant.program.mvp.presenter.MvpPresenter;

import static org.junit.Assert.*;

/**
 * Created by liaobo on 2018/6/13 0013.
 */
public class MerchantLineTypeTest {
    MerchantLineType mMerchantLineType;

    @Before
    public void setUp() throws Exception {
        mMerchantLineType = new MerchantLineType();
    }

    @Test
    public void getLineType() throws Exception {
        String temp = "glob is V";
        Object type = mMerchantLineType.getLineType(temp);
        Assert.assertNotNull(type);
        Assert.assertEquals(type, MerchantLineType.Type.ROMAN_NUM);
    }

}