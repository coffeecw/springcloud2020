package com.cwcoffee.springcloud.service;

import com.cwcoffee.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author cw
 * @Date 2020/07/14 15:05
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Integer userId, @RequestParam("count") Integer count);
}
