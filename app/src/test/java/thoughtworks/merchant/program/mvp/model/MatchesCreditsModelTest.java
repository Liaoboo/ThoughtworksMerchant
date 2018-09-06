package thoughtworks.merchant.program.mvp.model;

import org.junit.Assert;
import org.junit.Test;

import thoughtworks.merchant.program.mvp.impl.Callback;

/**
 * Created by Liao on 2018/4/27 0027.
 */
public class MatchesCreditsModelTest  {

    @Test
    public void execute() throws Exception {
        String params = "glob prok Gold is 57800 Credits";
        new MatchesCreditsModel().params(params).execute(new Callback() {
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
        });
    }

}