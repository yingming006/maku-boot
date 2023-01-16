package net.maku.framework.common.constant;

/**
 * 常量
 *
 * @author 阿沐 babamu@126.com
 */
public interface Constant {
    /**
     * 根节点标识
     */
    Long ROOT = 0L;
    /**
     * 当前页码
     */
    String PAGE = "page";
    /**
     * 数据权限
     */
    String DATA_SCOPE = "dataScope";
    /**
     * 超级管理员
     */
    Integer SUPER_ADMIN = 1;
    /**
     * 禁用
     */
    Integer DISABLE = 0;
    /**
     * 启用
     */
    Integer ENABLE = 1;
    /**
     * 失败
     */
    Integer FAIL = 0;
    /**
     * 成功
     */
    Integer SUCCESS = 1;
    /**
     * OK
     */
    String OK = "OK";

    String SHEET_DEFAULT = "sheet1";

    /**
     * 学号
     */
    String STUDENT_NO = "student_no";

    /**
     * 课程字典前缀
     */
    String COURSE_DICT_PREFIX = "course_dict_";
}
