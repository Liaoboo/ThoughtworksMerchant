package thoughtworks.merchant.program.mvp.model;

import thoughtworks.merchant.program.mvp.impl.Callback;
import thoughtworks.merchant.program.log.ErrorMessage;

/**
 * 提取每行输入内容的罗马数字,例句： prok is V
 * <p>
 * Created by Liao on 2018/4/27 0027.
 */

public class MatchesRomanNumModel extends BaseModel {


    @Override
    public void execute(Callback callback) {
        try {
            String[] splited = mParams.trim().split("\\s+"); //根据空格拆分
            mConstantRoman.put(splited[0], splited[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            callback.onError(ErrorMessage.getMessage(ErrorMessage.INVALID_ROMAN));
        }
    }


}