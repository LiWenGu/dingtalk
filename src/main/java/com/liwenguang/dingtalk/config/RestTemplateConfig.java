package com.liwenguang.dingtalk.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;

@Configuration
public class RestTemplateConfig {

    private RestTemplateInterceptor restTemplateInterceptor = new RestTemplateInterceptor();

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
        restTemplate.setInterceptors(Collections.singletonList(restTemplateInterceptor));
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());
        Iterator<HttpMessageConverter<?>> iterator = restTemplate.getMessageConverters().iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter messageConverter = iterator.next();
            if (messageConverter instanceof MappingJackson2HttpMessageConverter) {
                iterator.remove();
            }
        }
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
