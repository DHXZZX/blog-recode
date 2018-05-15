package com.dh.blogrecode.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WebConst {
    public static Map<String, String> initConfig = new HashMap<>();

    public static String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "S_L_ID";

    /**
     * ase加盐
     */
    public static String ASE_SALT = "0123456789abcdef";

    /**
     * 最大文章条数
     */
    public static final int MAX_POSTS = 9999;

    /**
     * 最大页码
     */
    public static final int MAX_PAGE = 100;

    /**
     * 文章最大可输入文字数
     */
    public static final int MAX_TEXT_COUNT = 200000;

    /**
     * 文章标题最大可输入文字数
     */
    public static final int MAX_TITLE_COUNT = 200;

    /**
     * 点击次数超过多少更新到数据库
     */
    public static final int HIN_EXCEED = 10;

    /**
     * 上传文件最大大小
     */
    public static Integer MAX_FILE_SIZE = 1024 * 1024;

    /**
     * 成功返回
     */
    public static String SUCCESS_RESULT = "SUCCESS";
    /**
     * 同一篇文章再多长时间内无论点击多少次都只算一次阅读
     */
    public static Integer HITS_LIMIT_TIME = 7200;
}
