   
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<%  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);%>
<div class="container">
<div class="row">

<div class="col-md-6">
<img src="images/Registration.png" width="100%"/>
</div>
<div class="col-md-6">
<div ><center><h2>Register Disease Tests </h2></center><br/>
 <form id="frm" action="RegFeatures1" method="post"  >
									 
									  <table class="tblform">
									     
									  
                <tr>
									 <td>Disease</td>
									 <td> 
									 <select required name="diseaseName" class="form-control" onchange="makeGetRequest(this.value)">
									 <option value=""><--select--></option>
									 <option value="Benign">Benign</option>
									 <option value="Malignant">Malignant</option>			 															  
									 </select>
									 </td>
									 </tr>
									  
               <tr><td>Pathology Test Name</td>
                <td><input type="text"  class="form-control"  name="featureName" required></td></tr>
                 <tr>
									     <tr>
		 <td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/>
		  </td></tr>
		  </table>
		  </form>
</div>
</div>

</div>

</div>
</body>
</html>