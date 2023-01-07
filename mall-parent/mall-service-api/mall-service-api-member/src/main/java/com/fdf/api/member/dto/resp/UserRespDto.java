package com.fdf.api.member.dto.resp;

import lombok.Data;

/**
 * @author fandongfeng
 * @date 2023/1/7 20:19
 */
@Data
public class UserRespDto {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userAddress;
    private Integer userIntegral;
}
