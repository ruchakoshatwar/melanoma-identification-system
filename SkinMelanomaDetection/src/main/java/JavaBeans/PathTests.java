package JavaBeans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
 

public class PathTests {
private String featureName,diseaseName; 
private double val;

Connection con;
CallableStatement csmt;
ResultSet rs;

private List<PathTests> lstFeatures = new ArrayList<PathTests>();
 
public double getVal() {
	return val;
}
public void setVal(double val) {
	this.val = val;
}
public String getFeatureName() {
	return featureName;
}
public void setFeatureName(String featureName) {
	this.featureName = featureName;
}
public String getDiseaseName() {
	return diseaseName;
}
public void setDiseaseName(String diseaseName) {
	this.diseaseName = diseaseName;
}
public List<PathTests> getLstFeatures() {
	return lstFeatures;
}
public void setLstFeatures(List<PathTests> lstFeatures) {
	this.lstFeatures = lstFeatures;
}
public PathTests()
{
	
}
public PathTests(ResultSet rs)
{
	try
	{
	diseaseName=rs.getString("diseaseName").toString().trim();
	featureName=rs.getString("testName").toString().trim();
	 }
	catch (Exception e) {
		// TODO: handle exception
	}
}  
public boolean registration()
{
    try
    {
    	  
    	   DBConnector obj=new  DBConnector();
           con=obj.connect();
        csmt=con.prepareCall("{call insertTests(?,?)}");
    
        csmt.setString(1, featureName);
        csmt.setString(2, diseaseName);
         
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
    finally
    {
    	 try{con.close();}catch(Exception ex){}
    }
}
}
