package thoughtworks.merchant.program.mvp.model;

import thoughtworks.merchant.program.mvp.impl.Callback;
import thoughtworks.merchant.program.log.ErrorMessage;
import thoughtworks.merchant.program.utils.RomanNumberUtils;

/**
 * 提取每行输入内容的Credits ,比如glob prok Gold is 57800 Credits
 *
 * Created by Liao on 2018/4/27 0027.
 */

public class MatchesCreditsModel extends BaseModel {

    @Override
    public void execute(Callback callback) {
        try {
            //移除字符串中多余的数据，只保留
            String formatted = mParams.replaceAll("(is\\s+)|([c|C]redits\\s*)", "").trim();
            //拆分剩余的部分，如 glob prok Gold  57800
            String[] keys = formatted.split("\\s+");

            String toBeComputed = keys[keys.length - 2];//倒数第二个是要计算的 Gold
            float value = Float.parseFloat(keys[keys.length - 1]);//最后一个是值本身 57800

            String roman = "";
            for (int i = 0; i < keys.length - 2; i++) {
                roman += mConstantRoman.get(keys[i]);
            }
            int romanNumber = RomanNumberUtils.getRomanNum(roman);
            float credit = (float) (value / romanNumber);

            mComputedLiterals.put(toBeComputed, credit + "");
//            callback.onComplete();
        } catch (Exception e) {
            e.printStackTrace();
            callback.onError(ErrorMessage.getMessage(ErrorMessage.INVALID));
        }
    }

}