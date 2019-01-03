package com.qdm.mq.data;

import lombok.Data;


/**
 * @author qiudm
 * @date 2018/12/29 15:13
 * @desc
 */
@Data
public class UserInfo {

    private String userId;

    private String name;

    private Long createTime;

    /**
     * 0-userinfo_route_key_*
     * 1-*_userinfo_route_key
     */
    private Integer type;

}
