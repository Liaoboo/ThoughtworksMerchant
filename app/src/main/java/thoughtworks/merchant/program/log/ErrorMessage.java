package thoughtworks.merchant.program.log;

import thoughtworks.merchant.program.R;
import thoughtworks.merchant.program.app.MyApp;

/**
 * 错误信息提示
 * Created by Liao on 2018/4/22.
 */

public class ErrorMessage {

    public static final int NO_INPUT = 100;//没有输入
    public static final int INVALID = 101;//无效的输入，不符合规则
    public static final int INVALID_ROMAN = 102;//罗马数字输入错误
    public static final int NO_IDEA = 103;//I have no idea what you are talking about

    public ErrorMessage() {

    }

    public static String getMessage(int error) {
        String message = null;

        switch (error) {
            case NO_INPUT:
                message = getString(R.string.error_no_input);
                break;
            case INVALID:
                message = getString(R.string.error_invalid);
                break;

            case INVALID_ROMAN:
                message = getString(R.string.error_invalid_roman);
                break;

            case NO_IDEA:
                message = getString(R.string.error_no_idea);
                break;

            default:
                break;
        }
        return message;
    }

    private static String getString(int id) {
        try {
            return MyApp.AppContent.getResources().getString(id);
        }catch (NoClassDefFoundError error){
            return "";
        }catch (Exception e) {
            return "";
        }

    }

}
