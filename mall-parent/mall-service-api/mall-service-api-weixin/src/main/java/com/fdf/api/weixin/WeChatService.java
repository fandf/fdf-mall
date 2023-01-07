package com.fdf.api.weixin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fandongfeng
 * @date 2023/1/7 15:08
 */
public interface WeChatService {

    /**
     * 获取微信
     *
     * @param a
     * @return
     */
    @GetMapping("/getWeChat")
    String getWeChat(@RequestParam("a") Integer a);
}
