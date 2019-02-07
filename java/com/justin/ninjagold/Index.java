package com.justin.ninjagold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	Date date=new Date();
	Random rand = new Random();
	ArrayList<String> activity = new ArrayList<String>();
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
			session.setAttribute("max", 0);
			
		}	
		
		
		
		if((int) session.getAttribute("gold")> (int) session.getAttribute("max")){
			session.setAttribute("max",session.getAttribute("gold") );
		}
		

		model.addAttribute("activity", activity);
		return "index.jsp";
	}
	
	@RequestMapping("/farm")
	public String farm(HttpSession session) {
		int n = rand.nextInt(10)+10;
		activity.add("You entered a farm and earned "+ n +" gold "+"(" +date+")");
		System.out.println(activity);
		session.setAttribute("gold", (int) session.getAttribute("gold")+n); 
		return "redirect:/";
	}
	
	@RequestMapping("/cave")
	public String cave(HttpSession session) {
		int n = rand.nextInt(5)+5;
		activity.add("You entered a cave and earned "+ n +" gold "+"(" +date+")");
		System.out.println(activity);
		session.setAttribute("gold", (int) session.getAttribute("gold")+n); 
		return "redirect:/";
	}
	
	@RequestMapping("/house")
	public String house(HttpSession session) {
		int n = rand.nextInt(3)+2;
		activity.add("You entered a house and earned "+ n +" gold "+"(" +date+")");
		System.out.println(activity);
		session.setAttribute("gold", (int) session.getAttribute("gold")+n); 
		return "redirect:/";
	}
	
	@RequestMapping("/casino")
	public String casino(HttpSession session) {
		int n = rand.nextInt(100)-50;
		if(n>0) {
			activity.add("You entered a casino and earned "+ n +" gold "+"(" +date+")");
		}
		if(n<0) {
			activity.add("You entered a casino and lost "+ n +" gold "+"(" +date+")");
		}
		System.out.println(activity);
		session.setAttribute("gold", (int) session.getAttribute("gold")+n); 
		return "redirect:/";
	}
	

}
