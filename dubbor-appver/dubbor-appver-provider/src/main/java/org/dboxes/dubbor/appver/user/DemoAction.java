package org.dboxes.dubbor.appver.user;

import org.dboxes.dubbor.common.ServiceResult;
import org.dboxes.dubbor.user.api.DemoService;
import org.dboxes.dubbor.user.api.UserService;
import org.dboxes.dubbor.user.dto.UserDTO;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DemoAction {
    
    private DemoService demoService;
    private UserService userService;

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void start() throws Exception {
        for (int i = 0; i < 10; i ++) {
            try {
                ServiceResult<UserDTO> user = userService.findOne(1L);

            	String hello = demoService.sayHello("world " + user.getResult().getLoginName() + i);
                System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
        }
	}

}