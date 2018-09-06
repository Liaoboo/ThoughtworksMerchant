package thoughtworks.merchant.program.mvp.model;

import java.util.Stack;

import thoughtworks.merchant.program.mvp.impl.Callback;
import thoughtworks.merchant.program.log.ErrorMessage;
import thoughtworks.merchant.program.utils.RomanNumberUtils;

/**
 * 处理HowMany；如：how many Credits is glob prok Gold ?
 * <p>
 * Created by Liao on 2018/4/27 0027.
 */

public class HowManyQuestionModel extends BaseModel {
    private Callback mCallback;

    @Override
    public void execute(Callback callback) {
        mCallback = callback;
        try {
            String formatted = mParams.split("(\\sis\\s)")[1];

            formatted = formatted.replace("?", "").trim();

            String[] keys = formatted.split("\\s+");

            handlerData(keys, formatted);

        } catch (Exception e) {
            e.printStackTrace();
            callback.onError(ErrorMessage.getMessage(ErrorMessage.INVALID));
        }
    }

    /**
     * 处理数据
     *
     * @param keys
     */
    private void handlerData(String[] keys, String formatted) {
        boolean isMatches = false;
        StringBuilder roman = new StringBuilder();
        StringBuffer outputResult = new StringBuffer();
        Stack<Float> values = new Stack<>();
        for (String key : keys) {
            isMatches = false;

            String romanValue = getRomanValue(key);
            if (romanValue != null) {
                roman.append(romanValue); //拼接罗马数字
                isMatches = true;
            }

            if (!isMatches) {
                float value = getLiteralsValue(key);
                if (value != -1)
                    values.push(value); // 记录金币的值
                isMatches = true;
            }

            if (!isMatches && mCallback != null) {
                mCallback.onFailure(ErrorMessage.getMessage(ErrorMessage.NO_IDEA));
                break;
            }
        }

        if (isMatches) {
            float result = 1;
            for (int i = 0; i < values.size(); i++) {
                result *= values.get(i);
            }
            int finalResult = (int) result;
            if (roman.length() > 0) {
                finalResult = (int) (RomanNumberUtils.getRomanNum(roman.toString()) * result);
            }
            outputResult.append(formatted).append(" is ").append(finalResult).append(" Credits");
        }
        if (mCallback != null)
            mCallback.onSuccess(outputResult.toString());
    }

    /**
     * 获取罗马数字
     *
     * @param key
     * @return
     */
    private String getRomanValue(String key) {
        String romanValue = mConstantRoman.get(key);
        if (romanValue != null) {
            return romanValue; // 罗马数字
        }
        return null;
    }

    /**
     * 获取金币的值
     *
     * @param key
     * @return
     */
    private float getLiteralsValue(String key) {
        String computedValue = mComputedLiterals.get(key);
        if (computedValue != null) {
            return Float.parseFloat(computedValue); //  金币的值
        }

        return -1;
    }
}
