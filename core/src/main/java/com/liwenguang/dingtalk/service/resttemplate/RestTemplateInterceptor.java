package com.liwenguang.dingtalk.service.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 拦截请求响应，用于打印日志 liwenguang 2018-10-29 15:53:49
 */
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(RestTemplateInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        logger.info("=============request begin");
        logger.info("URI         : {}", request.getURI());
        logger.info("Request body: {}", new String(body, "UTF-8"));
        logger.info("=============request end");
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        logger.info("=============response begin");
        logger.info("Status code  : {}", response.getStatusCode());
        logger.info("Response body: {}", inputStringBuilder.toString());
        logger.info("=============response end");
    }
}