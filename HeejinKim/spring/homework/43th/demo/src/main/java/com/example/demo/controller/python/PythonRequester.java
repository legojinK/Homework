package com.example.demo.controller.python;

import com.example.demo.entity.python.PythonProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/python-request")
public class PythonRequester {

    @GetMapping("spring2python")
    public ModelAndView spring2Python(Model model) {
        log.info("spring2Python()");

        //파이썬이 클라이언트가 되어서 rest(?리퀘스트 ) 요청을 할수 있음
        List<HttpMessageConverter<?>> converters =
                new ArrayList<>();
        //e d이런 다양한 형태를 처리하려고 만든 컨버터 사진도 보내고 여러가지 처리 (view의 formfile 같은 거)
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        //서버번호 5000을 가짐
        String result = restTemplate.getForObject(
                "http://localhost:5000/python-request",
                String.class
        );

        log.info("result = " + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/pyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }

    @GetMapping("/spring2python-multi")
    public ModelAndView spring2PythonMulti(Model model) {
        log.info("spring2PythonMulti()");

        List<HttpMessageConverter<?>> converters = new ArrayList<>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(
                "http://localhost:5000/python-request-multi",
                String.class
        );

        log.info("result = " + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/pyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }

    @GetMapping("/spring2python-realdata")
    public ModelAndView spring2PythonRealData(Model model) {
        log.info("spring2PythonRealData()");

        RestTemplate restTemplate = new RestTemplate();

        PythonProduct pythonProduct = new PythonProduct(35000L);

        String result = restTemplate.postForObject(
                "http://localhost:5000/python-request-realdata",
                pythonProduct,
                String.class
        );



        log.info("result = " + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("python/pyResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }
}
