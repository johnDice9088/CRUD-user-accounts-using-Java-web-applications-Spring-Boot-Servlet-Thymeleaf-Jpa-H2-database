package com.example.demo;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

//import java.io.IOException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

@Controller
public class homecontroller extends HttpServlet {
	
	
	@RequestMapping("login")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Using provided static credentials for simplicity
        if ("test@sunbasedata.com".equals(loginId) && "Test@123".equals(password)) {
            // Successful authentication
            response.sendRedirect("listall");}
        else {
            // Failed authentication
         //   response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authentication failed!");
        }}
	
	
	@RequestMapping("hi")
	public String hello() {
		System.out.println("hi");
		return "login.html";
		}


		@RequestMapping("listall")
		public String homeFun() {
			System.out.println("hi");
			return "listall.html";

		}
		
		@RequestMapping("homepage")
		public String homepage() {
			System.out.println("homepage.html");
			return "homepage.html";
		}
		
		@Autowired
		Studentrepository repo;
		@Autowired
		studentservice stud;
		
		@RequestMapping("addstudent")
		public String savestudent(Model model,student stu){
			repo.save(stu);
			model.addAttribute("liststudent",stud.getAllstudent());
			return "listall.html";
			
		}
		
		//public String editstudent(Model model) {
		//model.addAttribute("listofstudent",stud.getonemethod())
		
		
	//	public String savedstudent(student stu){
	//		repo.save(stu);
	//		return stud.getonemethod(Id);
			
	//		return "update.html";
		
		
//		public String getonemethod(Integer Id){
	//		System.out.println(stud.());
		//	System.out.println(Id);
		///	return "update.html";
		
			
	//	}
		@Autowired
		Studentrepository newrepo;
	//	@RequestMapping("geton")
		@RequestMapping("geton")
	//	public String getone(Model model,Integer id){
	//		student stu = stud.getone(id);
	//		model.addAttribute("liststudent",stu);
	//		System.out.println(stu);
	//		return "update.html";
		public String getone(Model model,student stu,Integer id ){
			stu = stud.getone(id);
			model.addAttribute("liststudent",stu);
			System.out.println(stu);
			return "update.html";
			
		}
		@RequestMapping("deleteon")
		public String deleteon(Model model,Integer id) {
			stud.deletebyid(id);
			System.out.println(stud.getAllstudent());
			model.addAttribute("liststudent",stud.getAllstudent());
			return "listall.html";
		}
		
	//	@RequestMapping("savestudent")
	//	public String dele(Model model, student stu) {
	//		    stud.deletebyid(id);
	//			repo.save(stu);
	//			model.addAttribute("liststudent",stud.getAllstudent());
	//			return "listall.html";
	//	}
		
//


}

