package thoughtworks.merchant.program.mvp.model;

import thoughtworks.merchant.program.mvp.impl.Callback;
import thoughtworks.merchant.program.log.ErrorMessage;
import thoughtworks.merchant.program.utils.RomanNumberUtils;

/**
 * 处理HowMuch;如：how much is pish tegj glob glob ?
 * <p>
 * Created by Liao on 2018/4/27 0027.
 */

public class HowMuchQuestionModel extends BaseModel {
    Callback mCallback;

    @Override
    public void execute(Callback callback) {
        mCallback = callback;
        try {
            //            String formatted = line.replace("how much is","").trim();
            String formatted = mParams.split("\\sis\\s")[1].trim(); //获取is后面的关键字
            //去掉问号及空格
            formatted = formatted.replace("?", "").trim();
            //通过空格拆分出单词
            String keys[] = formatted.split("\\s+");

            StringBuffer completeResult = new StringBuffer();

            String romanResult = getRomanResult(keys);
            if (romanResult != null && romanResult.length() > 0) {
                romanResult = RomanNumberUtils.getRomanNum(romanResult) + "";
                completeResult.append(formatted).append(" is ").append(romanResult);
            }
            callback.onSuccess(completeResult.toString());
            //            callback.onComplete();
        } catch (Exception e) {
            e.printStackTrace();
            callback.onError(ErrorMessage.getMessage(ErrorMessage.INVALID));

        }

    }

    /**
     * 获取对应的罗马数字
     *
     * @param keys
     * @return
     */
    private String getRomanResult(String[] keys) {
        StringBuilder romanResult = new StringBuilder();
        for (String key : keys) {
            String romanValue = mConstantRoman.get(key);//获取单词对应的罗马数字
            if (romanValue == null) {//如果输入的的内容没有匹配到
                mCallback.onFailure(ErrorMessage.getMessage(ErrorMessage.NO_IDEA));
                break;
            }
            romanResult.append(romanValue);
        }
        return romanResult.toString();

    }


}
