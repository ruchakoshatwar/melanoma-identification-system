package JavaBeans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class UserReg {
	Connection con;
    CallableStatement csmt;
    ResultSet rs;
    private String name,mobile,email,city,address,wcity,jobType,wenv,workingPos,prof,gender,wcityType,state,waddr,wstate,userid,pass,dob ,sentOTP,otp;
    private List<UserReg> lstusers = new ArrayList<UserReg>();
    private double workingHrs,height,weight,waterIntake,txtsleepHrs,workout;
    
    public String getSentOTP() {
		return sentOTP;
	}
	public void setSentOTP(String sentOTP) {
		this.sentOTP = sentOTP;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	  

	 public double getWorkout() {
		return workout;
	}
	public void setWorkout(double workout) {
		this.workout = workout;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public double getWaterIntake() {
		return waterIntake;
	}
	public void setWaterIntake(double waterIntake) {
		this.waterIntake = waterIntake;
	}
	public double getTxtsleepHrs() {
		return txtsleepHrs;
	}
	public void setTxtsleepHrs(double txtsleepHrs) {
		this.txtsleepHrs = txtsleepHrs;
	}
	public List<UserReg> getLstusers() {
		return lstusers;
	}
	public void setLstusers(List<UserReg> lstusers) {
		this.lstusers = lstusers;
	}
	public String getWaddr() {
		return waddr;
	}
	public void setWaddr(String waddr) {
		this.waddr = waddr;
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWcity() {
		return wcity;
	}
	public void setWcity(String wcity) {
		this.wcity = wcity;
	}
	public String getWenv() {
		return wenv;
	}
	public void setWenv(String wenv) {
		this.wenv = wenv;
	}
	public String getWorkingPos() {
		return workingPos;
	}
	public void setWorkingPos(String workingPos) {
		this.workingPos = workingPos;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWcityType() {
		return wcityType;
	}
	public void setWcityType(String wcityType) {
		this.wcityType = wcityType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWstate() {
		return wstate;
	}
	public void setWstate(String wstate) {
		this.wstate = wstate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getWorkingHrs() {
		return workingHrs;
	}
	public void setWorkingHrs(double workingHrs) {
		this.workingHrs = workingHrs;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

public boolean useridAuth()
{
	boolean flag=false;
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call useridAuth(?)}");
         csmt.setString(1, userid);
         
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        email=rs.getString("email").trim();
        name=rs.getString("username").trim();
        flag=true;
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
    return flag;
}
public boolean updatePass()
{
    try
    {
    	String bodycond="NA";
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call updatePassword(?,?)}");
        csmt.setString(1, userid);
        csmt.setString(2, pass);
        
         int n=csmt.executeUpdate();
         
                    
        
        if(n>0)
        {
            try{con.close();}catch(Exception ex){}
            System.out.println("true");
            return true;
        }
        else
            return false;

        }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
        return false;
    }
}
	/*public void getId()
	    {
	        try
	        {
	             DBConnector obj=new  DBConnector();
	            con=obj.connect();
	            csmt=con.prepareCall("{call getMaxIdUsers()}");
	           
	             csmt.execute();
	             rs=csmt.getResultSet();
	                        
	            boolean auth=false;
	            while(rs.next())
	            { System.out.println("true");
	                auth=true;
	                
	                mxid=rs.getInt("mxid");
	                  
	            }
	        }
	           
	         
	        catch(Exception ex)
	        {
	            System.out.println("err="+ex.getMessage());
	             
	        }
	    }*/
	public UserReg()
	{
		
	}
	public UserReg(ResultSet rs)
	{
		try
		{
		name=rs.getString("userName").toString().trim();
		state=rs.getString("state").toString().trim();
		city=rs.getString("city").toString().trim();
		email=rs.getString("email").toString().trim();
		mobile=rs.getString("mobile").toString().trim();
		gender=rs.getString("gender").toString().trim();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err="+e.getMessage());
		}
	}
	public void getUsers()
	{
	    try
	    {
	         DBConnector obj=new  DBConnector();
	        con=obj.connect();
	        csmt=con.prepareCall("{call getUsers()}");
	        lstusers=new ArrayList<UserReg>();
	         csmt.execute();
	         rs=csmt.getResultSet();
	                     
	        while(rs.next())
	        { System.out.println("true");
	        lstusers.add(new UserReg(rs));
	              
	        }
	    }
	       
	     
	    catch(Exception ex)
	    {
	        System.out.println("err="+ex.getMessage());
	         
	    }
	}
	public boolean registration()
	    {
	        try
	        {

	             DBConnector obj=new  DBConnector();
	            con=obj.connect();
	            csmt=con.prepareCall("{call insertUser(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	            csmt.setString(1, userid);
	            csmt.setString(2, pass);
	            csmt.setString(3, name);
	            csmt.setString(4, mobile);
	            csmt.setString(5, email);
	         
	            csmt.setString(6, prof);
	            csmt.setString(7, state);
	            csmt.setString(8, city); 
	            csmt.setString(9, address); 
	            csmt.setString(10, gender);
	            csmt.setString(11, dob);
	            csmt.setDouble(12, weight);
	            csmt.setDouble(13, height); 
	            
	             int n=csmt.executeUpdate(); 
	             if(n>0)
		            {
		            	  
		                return true;
		            }
		            else
		                return false;

		            }
	           
	         
	        catch(Exception ex)
	        {
	            System.out.println("err="+ex.getMessage());
	            return false;
	        }
	    }

}
