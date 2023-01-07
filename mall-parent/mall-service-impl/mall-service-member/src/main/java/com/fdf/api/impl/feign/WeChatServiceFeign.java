package com.fdf.api.impl.feign;

import com.fdf.api.weixin.WeChatService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fandongfeng
 * @date 2023/1/7 15:08
 */
@FeignClient("mall-weixin")
public interface WeChatServiceFeign extends WeChatService {

}
