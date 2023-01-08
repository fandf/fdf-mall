package com.fdf.api.impl.weixin;

import cn.hutool.core.date.DateUtil;
import com.fdf.api.base.BaseResponse;
import com.fdf.api.impl.wx.mp.config.WxMpConfiguration;
import com.fdf.api.impl.wx.mp.config.WxMpProperties;
import com.fdf.api.weixin.WechatTemplateService;
import com.fdf.api.weixin.dto.req.LoginReminderReqDto;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fandongfeng
 * @date 2023/1/8 14:17
 */
@RestController
public class WechatTemplateServiceImpl implements WechatTemplateService {

    @Value("${fdf.weixin.login.templateId}")
    private String loginTemplateId;

    @Resource
    WxMpProperties wxMpProperties;
    @Resource
    WxMpTemplateMsgService wxMpTemplateMsgService;

    @Override
    public BaseResponse<String> sendTemplate(LoginReminderReqDto loginReminderReqDto) {

        String device = loginReminderReqDto.getDevice();
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId(loginTemplateId);
        wxMpTemplateMessage.setToUser(loginReminderReqDto.getOpenId());
//        亲爱的用户:{{first.DATA}}
//        登录时间:{{keyword1.DATA}}
//        登录IP:{{keyword2.DATA}}
//        登录设备:{{keyword3.DATA}}
//        如果不是您本人登录，可以联系管理员锁定账号。

        List<WxMpTemplateData> data = new ArrayList<>();
        data.add(new WxMpTemplateData("first", loginReminderReqDto.getPhone()));
        data.add(new WxMpTemplateData("keyword1", DateUtil.formatDateTime(loginReminderReqDto.getLoginTime())));
        data.add(new WxMpTemplateData("keyword2", loginReminderReqDto.getLoginIp()));
        data.add(new WxMpTemplateData("keyword3", device));
        wxMpTemplateMessage.setData(data);

        try {
            wxMpTemplateMsgService.sendTemplateMsg(wxMpTemplateMessage);
            return BaseResponse.success();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return BaseResponse.fail("发送失败");
    }
}
