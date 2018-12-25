package com.yk.iworkgo.payment.service.impl;

import com.yk.iworkgo.utils.AccessTokenGenerator;
import com.yk.iworkgo.utils.EhCacheUtil;
import net.sf.ehcache.Cache;
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


    public static void main(String[] args) throws InterruptedException {
//        PersonServiceImpl service = new PersonServiceImpl();
//        String name =service.getName("123");
//        System.out.println(name);

        EhCacheUtil.getInstance().put("payment","guojing",123);

        Object a = EhCacheUtil.getInstance().get("payment","guojing");
        System.out.println(a);

        Thread.sleep(1000);
        a = EhCacheUtil.getInstance().get("payment","guojing");
        System.out.println(a);


        a = EhCacheUtil.getInstance().get("payment","guojing");
        System.out.println(a);



    }


}
