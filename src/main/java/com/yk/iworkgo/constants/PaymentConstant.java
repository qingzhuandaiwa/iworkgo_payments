package com.yk.iworkgo.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class PaymentConstant {

    @Value("${com.tmall.id}")
    private String tmallId;

}
