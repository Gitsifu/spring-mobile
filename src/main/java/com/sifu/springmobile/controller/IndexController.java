package com.sifu.springmobile.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author sifu
 * @version 1.0
 * @date 2017/12/28
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String greeting(Device device) {
        String deviceType = "browser";
        String platform = "browser";

        if (device.isNormal()) {
            deviceType = "browser";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }

        platform = device.getDevicePlatform().name();

        if ("UNKNOWN".equalsIgnoreCase(platform)) {
            deviceType = "browser";
        }

        System.out.println("Client Device Type:" + deviceType + ",platform:" + platform);
        return "index";
    }
}
