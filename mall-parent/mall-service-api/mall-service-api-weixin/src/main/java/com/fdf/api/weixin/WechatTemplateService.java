package com.fdf.api.weixin;

import com.fdf.api.base.BaseResponse;
import com.fdf.api.weixin.dto.req.LoginReminderReqDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author fandongfeng
 * @date 2023/1/8 14:12
 */
public interface WechatTemplateService {

    /**
     * 模板消息发送
     * @param loginReminderReqDto
     * @return
     */
    @PostMapping("sendTemplate")
    BaseResponse<String> sendTemplate(@Valid @RequestBody LoginReminderReqDto loginReminderReqDto);
}
