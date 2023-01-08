package com.fdf.api.impl.wx.mp.handler;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fdf.api.impl.weixin.mapper.KeywordsMapper;
import com.fdf.api.impl.weixin.model.entity.WechatKeywords;
import com.fdf.api.impl.wx.mp.builder.TextBuilder;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Resource
    KeywordsMapper keywordsMapper;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        String msg = wxMessage.getContent();
        LambdaQueryWrapper<WechatKeywords> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WechatKeywords::getKeywordName, msg);
        wrapper.last("limit 1");
        WechatKeywords wechatKeywords = keywordsMapper.selectOne(wrapper);
        String resultContent = null;
        //表中查询出直接返回，为查询到调用http接口
        if (wechatKeywords != null) {
            resultContent = wechatKeywords.getKeywordValue();
        } else {
            resultContent = HttpUtil.get("http://i.itpk.cn/api.php?question=" + msg);
        }

        return new TextBuilder().build(resultContent, wxMessage, weixinService);

    }

}
