package com.dh.blogrecode.utils;

import com.dh.blogrecode.constant.WebConst;
import com.github.pagehelper.PageInfo;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Commons {

    public static String THEME = "themes/default";

    /**
     * 判断分页中是否有数据
     *
     * @param pageInfo
     * @return
     */
    public static boolean is_empty(PageInfo pageInfo) {
        return pageInfo == null || pageInfo.getList() == null || pageInfo.getList().size() == 0;
    }

    /**
     * 网站链接
     *
     * @return
     */
    public static String site_url() {
        return site_url("");
    }

    /**
     * 返回网站链接下的全址
     *
     * @param sub
     * @return
     */
    public static String site_url(String sub) {
        return site_option("site_url" + sub);
    }

    /**
     * 网站配置项
     *
     * @param key
     * @return
     */
    private static String site_option(String key) {
        return site_option(key, "");
    }

    /**
     * 网站配置项
     *
     * @param key
     * @param defaultValue
     * @return
     */
    private static String site_option(String key, String defaultValue) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (StringUtils.isNotBlank(str)) {
            return str;
        } else {
            return defaultValue;
        }
    }

    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }
}
