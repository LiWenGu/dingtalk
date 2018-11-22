package com.zed.dingtalk.service.resttemplate;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @Author liwenguang
 * @Date 2018/11/22 11:51 PM
 * @Description 注意使用了 fastjson 解析，如果使用 springcloud 需要手动设置 MessageConverter
 */
@Configuration
public class RestTemplateAutoConfig {

    private RestTemplateInterceptor restTemplateInterceptor = new RestTemplateInterceptor();

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
        restTemplate.setInterceptors(Collections.singletonList(restTemplateInterceptor));
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());
        restTemplate.getMessageConverters().removeIf(item -> item instanceof MappingJackson2HttpMessageConverter);
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(15000);//单位为ms
        factory.setConnectTimeout(15000);//单位为ms
        return factory;
    }
}
