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
<div ><center><h2>Register Images Dataset</h2></center><br/>
 <form id="frm" action="http://localhost:80/SkinMelanomaDetectionPython/multiPhotosHandler.py" method="post"  enctype="multipart/form-data">
									 
									  <table class="tblform">
									      
									  
                <tr>
									 <td>Category</td>
									 <td> 
									 <select required name="category" class="form-control" onchange="makeGetRequest(this.value)">
									 <option value=""><--select--></option>
										 
									 <option value="0">Melanoma</option>
									 <option value="1">Other</option>											
					  														  
									 </select>
									 </td>
									 </tr>
									  
               <tr><td>Upload Image</td>
                <td><input type="file" multiple="multiple"  class="form-control"  name="file" required></td></tr>
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