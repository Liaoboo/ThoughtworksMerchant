package thoughtworks.merchant.program.utils;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** InputFilter限制输入工具类
 * Created by liaobo on 2018/6/12 0012.
 */

public class InputFilterUtils {
    /**
     * 限制输入特殊字符
     *
     * @return
     */
    public static InputFilter limintSpecialCharacter() {
        InputFilter filter_speChat = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
                String speChat = "[`~!@#_$%^&*()+=|{}':;',\\[\\]\\-.<>/~！@#￥%……&*（）—+|{}【】‘；：”“’。，、？]";
                Pattern pattern = Pattern.compile(speChat);
                Matcher matcher = pattern.matcher(charSequence.toString());
                if (matcher.find())
                    return "";
                else
                    return null;
            }
        };
        return filter_speChat;
    }


    /**
     * 限制输入中文
     *
     * @return
     */
    public static InputFilter limintChinese() {
        InputFilter filter_space = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                String regEx = "[\u4E00-\u9FA5]";
                Pattern p = Pattern.compile(regEx);
                Matcher matcher = p.matcher(source.toString());
                if (matcher.find())
                    return "";
                else
                    return null;
            }
        };

        return filter_space;
    }

}
