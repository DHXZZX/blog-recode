package com.dh.blogrecode.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 10066610
 */
@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 6724758679661422815L;

    /**
     * user表主键
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户主页
     */
    private String homeUrl;

    /**
     * 用户显示的名称
     */
    private String screenName;

    /**
     * 用户注册时的GMT unix时间戳
     */
    private Integer created;

    /**
     * 用户最后活动时间
     */
    private Integer activated;

    /**
     * 用户上次登陆最后活跃时间
     */
    private Integer logged;

    /**
     * 用户组
     */
    private String groupName;
}
