package com.skin.melanoma;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import JavaBeans.*; 
import JavaBeans.GetURL; 
import JavaBeans.Login;
import JavaBeans.Mail;
import JavaBeans.Pass; 
import JavaBeans.RandomString;
 @Controller
public class MelanomaController {
@RequestMapping("/home")
public String myspring()
{
	return "index.jsp";
}
@RequestMapping("/datasetInsrtPython")
public ModelAndView datasetInsrtPython(HttpServletRequest request) {
	ModelAndView mv=new ModelAndView();
 	String sts=request.getParameter("sts").toString().trim() ;
	if(sts.equals("success"))
		 mv.setViewName("Success.jsp?type=datasetInsrt");
	else
		 mv.setViewName("Failure.jsp?type=datasetInsrt");
	mv.addObject("activity","datasetInsrt");
	 return mv;
}
@RequestMapping("/frompython1")
public ModelAndView frompython1(HttpServletRequest request) {
	ModelAndView mv=new ModelAndView();
 	String sts=request.getParameter("sts").toString().trim() ;
	if(sts.equals("success"))
		 mv.setViewName("Success.jsp?type=DsTrained");
	else
		 mv.setViewName("Failure.jsp");
	mv.addObject("activity","DsTrained");
	 return mv;
}
@RequestMapping("/FromPythonPred")
public String FromPythonPred(HttpServletRequest request)
{
	return "Success.jsp?type="+request.getParameter("cate").trim()+"&img="+request.getParameter("img").trim()+"&img1="+request.getParameter("img1").trim();
}
@RequestMapping("/Registration")
public String Registration()
{
	return "Registration.jsp";
}
@RequestMapping("/LoginForm")
public String LoginForm()
{
	return "Login.jsp";
}   
@RequestMapping("/forgot")
public String forgot()
{
	return "Forgot.jsp";
}
@RequestMapping("/ChangePass")
public String ChangePass()
{
	return "ChangePass.jsp";
}
@RequestMapping("/WCities")
public String Wcities()
{
	return "WCities.jsp";
}
@RequestMapping("/ExpertReg")
public String ExpertReg()
{
	return "RegExpert.jsp";
}
@RequestMapping("/adminHome")
public String adminHome()
{
	return "admin.jsp";
}
@RequestMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate();
	return "index.jsp";
}
@RequestMapping("/RegFeatures1")
public ModelAndView RegFeatures1(PathTests f,HttpSession ses)
{ 
	ModelAndView mv = new ModelAndView();
	if(f.registration()) {
		
	}
	mv.setViewName("Success.jsp?type=Regpath");
	mv.addObject("activity", "RegFeatures");
	mv.addObject("page1","RegDiseaseTests.jsp");
	return mv;
	 
}
@RequestMapping("userHome")
public String userHome(HttpSession ses)
{
	//GenerateReadingsForDT robj=new GenerateReadingsForDT();
	// robj.insertReadings(ses.getAttribute("userid").toString().trim());
	 return "user.jsp";
	//return "getPredictedDiseases";
}
@RequestMapping("expertHome")
public String expertHome()
{
	return "expert.jsp";
}
@RequestMapping("/datasetInsrtPython1")
public ModelAndView datasetInsrtPython1(HttpServletRequest request) {
	ModelAndView mv=new ModelAndView();
 	String sts=request.getParameter("sts").toString().trim() ;
	if(sts.equals("success"))
		 mv.setViewName("Success.jsp?type=datasetInsrt1");
	else
		 mv.setViewName("Failure.jsp?type=datasetInsrt1");
	mv.addObject("activity","datasetInsrt");
	 return mv;
}
@RequestMapping("/passRecoveryOTPAuth")
public ModelAndView passRecoveryOTPAuth(UserReg user)
{
	ModelAndView mv=new ModelAndView();
	try {
		if(user.getSentOTP().equals(user.getOtp()))
		{
			String pass=RandomString.getAlphaNumericString(8);
			user.setPass(pass);
			if(user.updatePass())
			{
				
			}
			
			
		    mv.setViewName("Success.jsp?type=passEmail");
		    
		    Mail mail=new Mail();
		    String msg="Dear "+user.getName()+" \n Your password has been reset to "+pass;
		    System.out.println("pass="+pass);
		    try
		    {
		    	if(mail.sendMail(msg,user.getEmail(), "New password"))
		    	{
		    		
		    	}
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
		{
			mv.setViewName("Failure.jsp?type=passEmail");
		}
		
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
    return mv;
}
@RequestMapping("/OTPAuth")
public ModelAndView OTPAuth(UserReg user,HttpSession ses)
{
	ModelAndView mv=new ModelAndView();
	try {
		if(user.getSentOTP().equals(user.getOtp()))
		{
			 
			
		    mv.setViewName(ses.getAttribute("utype").toString().trim()+"Home");
		    
		    
		}
		else
		{
			mv.setViewName("Failure.jsp?type=Auth");
		}
		
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
    return mv;
}
@RequestMapping("/passRecovery")
public ModelAndView passRecovery(UserReg user)
{
	ModelAndView mv=new ModelAndView();
	try {
		if(user.useridAuth())
		{
			String otp=RandomString.getAlphaNumericString(4);
			
		    mv.setViewName("ForgotOTP.jsp");
		    mv.addObject("userid",user.getUserid());
		    mv.addObject("otp",otp);
		    mv.addObject("email",user.getEmail());
		   JavaBeans.Mail mail=new Mail();
		    String msg="Dear "+user.getName()+" \n Your one time password is "+otp;
		    System.out.println("otp="+otp);
		    try
		    {
		    	if(mail.sendMail(msg,user.getEmail(), "One Time Password"))
		    	{
		    		
		    	}
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
		{
			mv.setViewName("Failure.jsp?type=Auth");
		}
		
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
    return mv;
}
 
@RequestMapping("/ChangePassService")
public String ChangePassService(Pass eobj,HttpSession ses)
{
	 
	 try
	 {
		 
		 eobj.setUserid(ses.getAttribute("userid").toString().trim());
		 if(eobj.changePassword())
		 {
			 
			 
			 return "Success.jsp?type=ChangePass";
		 }
		 else
		 { 
			 return "Failure.jsp?type=ChangePass";
		 }
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 System.out.println("err="+e.getMessage());
		 return("Failure.jsp?type=Auth");
	}
	 
}
@RequestMapping("/login")
public String login(HttpServletRequest request)
{
	Login obj=new Login();
	 try
	 {
		 HttpSession ses=request.getSession(true);
		 
		 if(obj.chkAuthentication(request.getParameter("txtuserid").trim(), request.getParameter("txtpass").trim()))
		 {
			 ses.setAttribute("userid", obj.getUserid());
			 System.out.println("userid="+obj.getUserid());
			 System.out.println("userid="+obj.getuType());
			 System.out.println("userid="+obj.getUserName());
			 ses.setAttribute("utype", obj.getuType());
			 ses.setAttribute("username", obj.getUserName());
			 System.out.println("utype="+obj.getuType());
			/* if(obj.getuType().equals("user"))
			 {
				 GenerateReadingsForDT robj=new GenerateReadingsForDT();
				 robj.insertReadings(obj.getUserid().trim());
				 return "findPrediction";
			 }
			 else*/
				 return obj.getuType()+".jsp";
		 }
		 else
		 { 
			 return "Failure.jsp?type=Auth";
		 }
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 System.out.println("err="+e.getMessage());
		 return("Failure.jsp?type=Auth");
	}
	 
} 
 
}