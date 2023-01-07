package com.fdf.api.member.dto.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author fandongfeng
 * @date 2023/1/7 20:15
 */
@Data
public class UserReqDto {

    @NotNull(message = "用户id不能为空")
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userAddress;

}
