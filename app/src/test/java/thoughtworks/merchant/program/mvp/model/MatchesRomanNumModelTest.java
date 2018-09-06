package thoughtworks.merchant.program.mvp.model;

import org.junit.Assert;
import org.junit.Test;

import thoughtworks.merchant.program.mvp.impl.Callback;

/**
 * Created by Liao on 2018/4/27 0027.
 */
public class MatchesRomanNumModelTest implements Callback {
    @Test
    public void execute() throws Exception {
        String params = "prok is V";
        new MatchesRomanNumModel().params(params).execute(this);
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
}