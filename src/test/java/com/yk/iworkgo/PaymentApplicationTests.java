package com.yk.iworkgo;

//import com.yk.iworkgo.payment.service.IBillService;
import com.yk.iworkgo.payment.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentApplicationTests {

    @Autowired
    PersonServiceImpl personService;

    @Test
    public void getPerson(){
        personService.getName("123");
        personService.getName("1234");

        String name = personService.getName("");
        System.out.println(name);
    }


}

