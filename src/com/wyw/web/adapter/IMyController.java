package com.wyw.web.adapter;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IMyController {
    ModelAndView hand_test(HttpServletRequest request, HttpServletResponse response);
}
