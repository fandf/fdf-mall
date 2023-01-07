package com.fdf.api.member;

import com.fdf.api.base.BaseResponse;
import com.fdf.api.member.dto.req.UserReqDto;
import com.fdf.api.member.dto.resp.UserRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author fandongfeng
 * @date 2023/1/7 17:25
 */
public interface MemberService {

    /**
     * 会员调用微信服务接口
     *
     * @param a
     * @return
     */
    @GetMapping("memberToWeiXin")
    String memberToWeiXin(Integer a);

    @PostMapping("updateUserDto")
    BaseResponse<UserRespDto> updateUserDto(@Valid @RequestBody UserReqDto userReqDto);

}
