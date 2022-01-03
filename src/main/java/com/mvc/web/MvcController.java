package com.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.services.AddService;

import jdk.nashorn.internal.ir.debug.JSONWriter;


@ResponseBody
@ResponseStatus(HttpStatus.OK)
@Controller
public class MvcController {
	@RequestMapping(value = "/api/add",params = {"a","b"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String addQuery(@RequestParam("a") float a, @RequestParam("b") float b) {
		AddService addService = new AddService();
		float sum = addService.add(a, b);
		return "{\"result\":\"" + Float.toString(sum) + "\"}";
	}
	@RequestMapping(value = "/web/add",params = {"a","b"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ModelAndView addWebQuery(@RequestParam("a") float a, @RequestParam("b") float b) {
		AddService addService = new AddService();
		float sum = addService.add(a, b);
		ModelAndView mv =new ModelAndView("/index.jsp");
		mv.addObject("result",Float.toString(sum));
		return mv;
	}

	@RequestMapping(value = "/api/add", headers = {"a","b"}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String addHeader(@RequestHeader("a") float a, @RequestHeader("b") float b) {
		AddService addService = new AddService();
		float sum = addService.add(a, b);
		return "{\"result\":\"" + Float.toString(sum) + "\"}";
	}
}
