package org.residentportal.portal.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RobotsController {

    @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
    @ResponseBody
    public String getRobots(HttpServletRequest request) {
        return (Arrays.asList("techieonthenet.com", "www.techieonthenet.com").contains(request.getServerName())) ?
                "robotsAllowed" : "robotsDisallowed";
    }
}
