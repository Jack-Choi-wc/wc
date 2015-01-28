package com.wc.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.wc.test.bo.UserBo;
import com.wc.test.model.JsonObj;
import com.wc.test.model.User;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private MappingJacksonJsonView jsonView;
	
	@Autowired
	private UserBo userBo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
				
		return "home";
	}
	
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model) {
				
		return "jqgridList";
	}
	
	
	@RequestMapping(value = "/jsonList", method = RequestMethod.GET)
	public @ResponseBody JsonObj jsonList(Model model,
		    @RequestParam(value = "page", required=false) String page,
		    @RequestParam(value = "rows", required=false) String rows,
		    @RequestParam(value = "sidx", required=false) String sidx,
		    @RequestParam(value = "sord", required=false) String sord
			) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<User> userList = userBo.selectUser(paramMap);
		
		//LOGGER.info("userList"+userList.toArray().toString());
		
		JsonObj rtnJson = new JsonObj();
		
		rtnJson.setRows(userList);
		rtnJson.setPage(1);
		rtnJson.setRecords(2);
		rtnJson.setTotal(2);
		
		model.addAttribute(rtnJson);
		
		
		
		
   	    return rtnJson;
		//return jsonView;
	}
	
	
}
