/**
 *
 */
package thoughtworks.merchant.program.merchant;

/**
 * 匹配输入类容每行文本信息的类型
 * Created by Liao on 2018/4/21.
 */
public class MerchantLineType {

    public final String patternRoman = "^([A-Za-z\\s]+) is ([I|V|X|L|C|D|M])$";
    public final String patternCredits = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";
    public final String patternHowMuch = "^how much is (([A-Za-z\\s])+)\\?$";
    public final String patternHowMany = "^how many [c|C]redits is (([A-Za-z\\s])+)\\?$";
    private LineFilter[] linefilter;

    public class LineFilter {
        private Type type;
        private String pattern;

        public LineFilter(Type type, String pattern) {
            this.type = type;
            this.pattern = pattern;
        }

        public String getPattern() {
            return this.pattern;

        }

        public Type getType() {
            return this.type;
        }
    }


    /**
     * 初始化要匹配的类型
     */
    public MerchantLineType() {
        this.linefilter = new LineFilter[4];
        this.linefilter[0] = new LineFilter(Type.ROMAN_NUM, patternRoman);
        this.linefilter[1] = new LineFilter(Type.CREDITS, patternCredits);
        this.linefilter[2] = new LineFilter(Type.QUESTION_HOW_MUCH, patternHowMuch);
        this.linefilter[3] = new LineFilter(Type.QUESTION_HOW_MANY, patternHowMany);

    }


    /**
     * 返回文本表示的类型
     */
    public Type getLineType(String line) {
        Type result = Type.OTHER;
        if (line == null || line.length() == 0) {
            return result;
        }

        line = line.trim();

        for (int i = 0; i < linefilter.length; i++) {
            if (line.matches(linefilter[i].getPattern())) { //检查匹配
                result = linefilter[i].getType();
                break;
            }

        }

        return result;

    }

    /**
     * 列举可能存在的类型情况
     */
    public enum Type {

        /**
         * 配置罗马数字  glob is V
         */
        ROMAN_NUM("thoughtworks.merchant.program.mvp.model.MatchesRomanNumModel"),

        /**
         * 表示该行是CREDITS类型. 比如 : glob glob Silver is 34 Credits
         */
        CREDITS("thoughtworks.merchant.program.mvp.model.MatchesCreditsModel"),

        /**
         * 该类型是询问how much ，比如 : how much is pish tegj glob glob ?
         */
        QUESTION_HOW_MUCH("thoughtworks.merchant.program.mvp.model.HowMuchQuestionModel"),

        /**
         * 该类型是询问how many ，比如: how many Credits is glob prok Iron ?
         */
        QUESTION_HOW_MANY("thoughtworks.merchant.program.mvp.model.HowManyQuestionModel"),

        /**
         * 其他
         */
        OTHER("");

        private String type;

        Type(String type) {
            this.type = type;
        }

        public String toString() {
            return type;
        }
    }
}
