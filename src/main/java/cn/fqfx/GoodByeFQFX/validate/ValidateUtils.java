package cn.fqfx.GoodByeFQFX.validate;

public class ValidateUtils {

    /**
     * 验证字符串存在空格
     *
     * @param str 字符串
     * @return
     */
    protected static Boolean ExistSpace(String str) {
        return str.contains(" ");
    }

    /**
     * 验证字符串长度区间
     *
     * @param str 字符串
     * @param min 最小值（包括）
     * @param max 最大值（包括）
     * @return
     */
    protected static Boolean LengthBetween(String str, int min, int max) {
        int len = str.length();
        return len >= min && len <= max;
    }

    /**
     * 验证纯数字
     *
     * @param str 字符串
     * @return
     */
    protected static Boolean AllNumber(String str) {
        return str.matches("^\\d+$");
    }

    /**
     * 验证存在汉字
     *
     * @param str 字符串
     * @return
     */
    protected static Boolean ExistChinese(String str) {
        return str.matches("^.*[\u4E00-\u9FA5].*$");
    }

    /**
     * 验证纯中文汉字
     *
     * @param str 字符串
     * @return
     */
    protected static Boolean AllChinese(String str) {
        return str.matches("^[\u4E00-\u9FA5]+$");
    }

    /**
     * 验证空字符串
     *
     * @param str 字符串
     * @return
     */
    protected static boolean EmptyString(String str) {
        return str.equals("") || str.isEmpty();
    }

    /**
     * 验证整数大小范围
     *
     * @param num 整数
     * @param min 最小值（包括）
     * @param max 最大值（包括）
     * @return
     */
    protected static boolean IntegerRange(Integer num, int min, int max) {
        return num >= min && num < max;
    }

    /**
     * 验证手机号格式
     *
     * @param phone 字符串
     * @return
     */
    protected static boolean PhoneNumber(String phone) {
        return phone.matches("^1(3|4|5|7|8)\\d{9}$");
    }
}
