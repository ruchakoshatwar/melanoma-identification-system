/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;
 
import java.io.File;
import java.io.IOException;
  
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

 
  
 
/**
 *
 * @author megha
 */
public class JavaFuns {
        Connection con;
     PreparedStatement pst;
     CallableStatement cst;
     ResultSet rs;
   
    public int FetchMax(String fldnm,String tblnm)
    {
       int maxid=1000;
    try
    {
       DBConnector obj=new DBConnector();
        con=obj.connect() ;
        String qr="select max("+fldnm+") as mxid from "+tblnm;
        pst=con.prepareStatement(qr);
        rs=pst.executeQuery();
        while(rs.next())
        maxid=rs.getInt("mxid");
        if(maxid==0)
            maxid=1000;
    }
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
    maxid=1000;
    }
    return (maxid+1);
    }
    

    
    public Vector getValue(String qr,int nocol)
    {    
        Vector v=new Vector();
        Connection con=null;
        Statement st;
        ResultSet rs;
        v.clear();
         try{ 
        	 DBConnector obj=new DBConnector();
             con=obj.connect();
           st=con.createStatement();
           System.out.println("query="+qr);
           rs=st.executeQuery(qr);
          
           while(rs.next())
           {
               for(int i=1;i<=nocol;i++)
               {
               v.addElement(rs.getString(i));
               System.out.println(rs.getString(i));
               }              
           }
         }
         catch(Exception e)
        {
            System.out.println("Error in processing due to "+e.getMessage());
        }   
          finally
         {
             try{
             con.close();}catch(Exception ex){}
         }
        return(v);        
    }
    public ResultSet getResultSet(String qr)
    {    
        Vector v=new Vector();
     
        Connection con=null;
        Statement st;
        ResultSet rs=null;
        v.clear();
         try{ 
        	 DBConnector obj=new DBConnector();
             con=obj.connect();
           st=con.createStatement();
           System.out.println("query="+qr);
           rs=st.executeQuery(qr); 
         }
         catch(Exception e)
        {
            System.out.println("Error in processing due to "+e.getMessage());
        }   
          finally
         {
            // try{
            // con.close();}catch(Exception ex){}
         }
        return(rs);        
    }
     
    public boolean execute(String qr)
    {
         Boolean sts=false;
         try
        {
        	 DBConnector obj=new DBConnector();
            con=obj.connect() ;
            Statement st=con.createStatement();
            st.executeUpdate(qr);
            sts=true;
        }
        catch(Exception ex)
        {
        sts=false;
        }
         finally
         {
             try{
             con.close();}catch(Exception ex){}
         }
        return sts;  
        
    }
        public void recordLogin(String userid,String logtyp,String machineId,String diskid)    
{
     String logdt;
     int logmon;
     int logyr;
     Connection con;
    PreparedStatement pst;
    try
    {
    	DBConnector obj=new DBConnector();
     con=obj.connect() ;
    String qr="insert into loginlog values(?,?,?,?,?,?,?,?,?,?);";
    Calendar cal=Calendar.getInstance();
    logdt=String.valueOf(cal.getTime());
    logmon=cal.get(Calendar.MONTH)+1;
    logyr=cal.get(Calendar.YEAR);
    pst=con.prepareStatement(qr);
    int maxid=FetchMax( "logid","loginlog");
    pst.setInt(1, maxid);
    pst.setString(2,logdt);
    pst.setInt(3,logmon);
    pst.setInt(4,logyr);
    pst.setString(5,userid);
    pst.setString(6,logtyp);
    pst.setInt(7,cal.get(Calendar.HOUR));
    pst.setInt(8,cal.get(Calendar.MINUTE));
    pst.setString(9,machineId);
    pst.setString(10,diskid);
    pst.executeUpdate();
    con.close();
}
catch(Exception e)
{
    System.out.println("Error:"+e.getMessage());
}

}
         
 
      

}
