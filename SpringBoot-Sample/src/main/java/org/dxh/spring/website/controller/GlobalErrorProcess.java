package org.dxh.spring.website.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class GlobalErrorProcess extends AbstractErrorController {

	public GlobalErrorProcess() {
		super(new DefaultErrorAttributes());
	}

	@RequestMapping("error")
	public String getErrorPath(HttpServletRequest request
									,HttpServletResponse response){
		Map<String, Object> errorMap = Collections.unmodifiableMap(getErrorAttributes(request,false));
		
		StringBuffer errSb = new StringBuffer();
		errSb.append("エラー発生時間:【").append(errorMap.get("timestamp")).append("】");
		errSb.append(" HttpStatus:").append(errorMap.get("status"));
		errSb.append(" RequestPath:").append(errorMap.get("path"));
		errSb.append(" error:").append(errorMap.get("error")).append(" ").append(errorMap.get("message"));
		
		log.error(errSb.toString());
		
		return "redirect:/";
	}
	
	@Override
	public String getErrorPath() {
		return null;
	}

}
