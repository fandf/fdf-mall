package com.fdf.api.impl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author fandongfeng
 * @date 2023/1/7 19:12
 */
@Data
@TableName("user")
public class UserEntity extends Model<UserEntity> {

    @TableId
    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer userAge;
    private String userAddress;
    private Integer userIntegral;

}
