package com.fdf.api.weixin.dto.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author fandongfeng
 * @date 2023/1/8 14:15
 */
@Data
public class LoginReminderReqDto {

    @NotNull
    private String openId;
    @NotNull
    private String phone;
    @NotNull
    private Date loginTime;
    @NotNull
    private String loginIp;
    @NotNull
    private String device;

}
