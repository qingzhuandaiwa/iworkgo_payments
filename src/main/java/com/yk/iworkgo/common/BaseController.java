package com.yk.iworkgo.common;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yk.iworkgo.payment.entity.Staff;
import com.yk.iworkgo.payment.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Slf4j
public class BaseController {

    @Resource
    StaffService staffService;

    protected Staff getStaffInfo(String phone) {
//        EmptyWrapper<Staff> entity = new EmptyWrapper();
        Wrapper<Staff> ew = new QueryWrapper();
//        ew.eq("phone", phone);
        ((QueryWrapper<Staff>) ew).eq("phone",phone);

        Staff staff = staffService.getOne(ew);
        return staff;
    }

}
