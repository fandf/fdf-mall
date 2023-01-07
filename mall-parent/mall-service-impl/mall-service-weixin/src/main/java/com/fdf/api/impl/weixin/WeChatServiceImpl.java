package com.fdf.api.impl.weixin;

import com.fdf.api.weixin.WeChatService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fandongfeng
 * @date 2023/1/7 15:40
 */
@RestController
public class WeChatServiceImpl implements WeChatService {
    @Override
    public String getWeChat(Integer a) {
        return "getWeChat:a:" + a;
    }
}
