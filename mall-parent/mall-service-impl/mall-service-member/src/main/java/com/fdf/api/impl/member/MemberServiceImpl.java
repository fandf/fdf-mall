package com.fdf.api.impl.member;

import cn.hutool.core.bean.BeanUtil;
import com.fdf.api.base.BaseResponse;
import com.fdf.api.impl.entity.UserEntity;
import com.fdf.api.impl.feign.WeChatServiceFeign;
import com.fdf.api.impl.mapper.UserMapper;
import com.fdf.api.member.MemberService;
import com.fdf.api.member.dto.req.UserReqDto;
import com.fdf.api.member.dto.resp.UserRespDto;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fandongfeng
 * @date 2023/1/7 17:29
 */
@RestController
public class MemberServiceImpl implements MemberService {

    @Resource
    WeChatServiceFeign weChatServiceFeign;
    @Resource
    UserMapper userMapper;

    @Override
    public String memberToWeiXin(Integer a) {
        return weChatServiceFeign.getWeChat(a);
    }

    @Override
    public BaseResponse<UserRespDto> updateUserDto(UserReqDto userReqDto) {
        //验证参数
        UserEntity userEntity = userMapper.selectById(userReqDto.getUserId());
        Assert.notNull(userEntity, "查询数据为空");
        BeanUtil.copyProperties(userReqDto, userEntity);
        Assert.isTrue(userEntity.updateById(), "修改失败");
        return BaseResponse.success(BeanUtil.copyProperties(userEntity, UserRespDto.class));
    }

}
