package com.wc.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
    @Autowired
    private SqlSession sqlSession;

	@Resource
	private MappingJacksonJsonView jsonView;
    
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
        HashMap<String, String> input = new HashMap<String, String>();
       input.put("name", "shin");
       List<HashMap<String, String>> outputs = sqlSession.selectList("userControlMapper.selectSample", input); 
       System.out.print(outputs.toString());
				
		return "home";
	}
	
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model) {
		
		return "jqgridList";
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public View testJqGrid(Model model) {
		
		
		//model.addAttribute("serverTime", formattedDate );
		
		
       		
		return jsonView;
	}
	
	
	
	
	
	
}
