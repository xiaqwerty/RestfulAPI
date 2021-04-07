package com.restfulapi.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class TestForFun
{
    @Test
    public void getBili()
    {
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
        RestTemplate client=restTemplateBuilder.build();
        HttpHeaders headers=new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity httpEntity=new HttpEntity(headers);
        ResponseEntity<String> page=client.exchange("https://www.bilibili.com/", HttpMethod.GET,httpEntity,String.class);
        System.out.println(page.getHeaders());
        System.out.println(page.getBody());
    }
    @Test
    public void getGoogle()
    {
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
        RestTemplate client=restTemplateBuilder.build();
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(
                new Proxy(
                        Proxy.Type.HTTP,
                        new InetSocketAddress("127.0.0.1",7890)
                )
        );
        client.setRequestFactory(requestFactory);
        ResponseEntity<String> page=client.getForEntity("http://google.com",String.class);
        System.out.println(page.getBody());
    }
}
