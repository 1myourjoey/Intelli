package com.sky._sb0423.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("------------prehandle------------");
        log.info("Request URI \t{}", request.getRequestURI()); // 콘솔에 uri 정보가 나타난다
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

//    post는 return이 없음 필터랑 쓰는방법 거의 비슷함 / 끝나기 때문에 돌려줄게 없어서 리턴이 없음
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("------------posthandle------------");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
