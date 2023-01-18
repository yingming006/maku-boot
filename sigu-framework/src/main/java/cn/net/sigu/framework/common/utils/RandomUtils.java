package cn.net.sigu.framework.common.utils;

import cn.hutool.core.util.RandomUtil;

/**
 * 随机工具类
 *
 * @author yingming006
 */
public class RandomUtils {

    /**
     * 随机汉字构建(随机长度)
     * @param length 长度为length长的汉字
     * @return [length,(length+param)]区间的汉字
     */
    public static String randomChinese(int length) {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < length; i++) {
            ret.append(randomChinese());
        }

        return ret.toString();
    }

    /**
     * 随机的汉字字符
     */
    public static char randomChinese() {

        String str;
        int highPos;
        int lowPos;

        highPos = (176 + RandomUtil.randomInt(39));
        lowPos = (161 + RandomUtil.randomInt(93));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            return '无';
        }

        return str.charAt(0);
    }
}
