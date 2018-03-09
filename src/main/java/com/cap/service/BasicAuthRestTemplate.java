package com.cap.service;

import java.util.Collections;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Rest template to set the auth information for to make the call to Adobe AEM
 * 
 * @author Venkata Kodali 
 * 
 */

public class BasicAuthRestTemplate extends RestTemplate {

    private String username;
    private String password;

    public BasicAuthRestTemplate(String username, String password) {
        super();
        this.username = username;
        this.password = password;
        addAuthentication();
    }

    private void addAuthentication() {
        if (StringUtils.isEmpty(username)) {
            throw new RuntimeException("Username is mandatory for Basic Auth");
        }

        List<ClientHttpRequestInterceptor> interceptors = Collections.singletonList(new BasicAuthInterceptor(username, password));
        setRequestFactory(new InterceptingClientHttpRequestFactory(getRequestFactory(), interceptors));
    }
}