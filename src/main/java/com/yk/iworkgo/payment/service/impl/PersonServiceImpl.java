package com.yk.iworkgo.payment.service.impl;

import com.yk.iworkgo.utils.AccessTokenGenerator;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author yuhao.wang
 */
@Service
public class PersonServiceImpl{

    @Cacheable(cacheNames = "payment",sync = true,key = "#name")
    public String getName(String name){
        String value = "123";

        return value;
    }

    @Cacheable(value = "payment2")
    public String getName1(String name){
        String value = "1234";

        return value;
    }

    public static void main(String[] args) {
        PersonServiceImpl service = new PersonServiceImpl();
        String name =service.getName("123");
        System.out.println(name);

        name =service.getName1("123");
        System.out.println(name);


    }


}
