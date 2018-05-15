package com.dh.blogrecode.controller;

import com.dh.blogrecode.model.vo.UserVo;
import com.dh.blogrecode.utils.MapCache;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    public static String THEME = "theme/default";

    protected MapCache cache = MapCache.single();

    public String render(String viewName) {
        return THEME + "/" + viewName;
    }

    public BaseController title(HttpServletRequest request,String title) {
        request.setAttribute("title",title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request,String keywords) {
        request.setAttribute("keywords",keywords);
        return this;
    }

    public UserVo user(HttpServletRequest request) {
        return new UserVo();
    }
}
