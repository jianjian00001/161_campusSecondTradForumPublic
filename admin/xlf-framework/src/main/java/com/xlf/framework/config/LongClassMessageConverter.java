package com.xlf.framework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * 解决Long类型给前端精度丢失
 * 重新注册ObjectMapper的Long类型序列化方式，推荐使用，暂时没发现问题。
 */
@Configuration
public class LongClassMessageConverter implements InitializingBean {

    @Resource
    ObjectMapper objectMapper;

    private SimpleModule getSimpleModule() {

        SimpleModule simpleModule = new SimpleModule();

        simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);

        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);//暂时放弃对小long的转换，约定与前端交互数据时，大Long全部转换成字符串//simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        objectMapper.registerModule(simpleModule);
        return simpleModule;

    }

    @Override
    public void afterPropertiesSet() {

        SimpleModule simpleModule=getSimpleModule();

        objectMapper.registerModule(simpleModule);

    }

}
