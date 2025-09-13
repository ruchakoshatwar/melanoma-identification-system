<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="DefaultTop.jsp"></jsp:include>
<div class="container"><br/><br/>
<%
if(request.getParameter("type").toString().trim().equals("Reg"))
{
	%><h2 class="h2">Your Registration Done Successfully....</h2>
	<br/>
	<a href="home">Home</a>
<%}
if(request.getParameter("type").toString().trim().equals("Regpath"))
{
	%><h2 class="h2">Pathology Tests Registration Done Successfully....</h2>
	<br/>
	<a href="adminHome">Home</a>
<%}
else if(request.getParameter("type").toString().trim().equals("DsTrained"))
{
	%><h2 class="h2">Dataset trained Successfully....</h2>
	<br/>
	<a href="adminHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("non_covid"))
{
	%><h2 class="h2">Input Xray image classified into Non Covid Category....</h2>
	<br/>
	
	<a href="userHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("covid"))
{
	%>
	<div class="row">
	<div class="col-md-6">
	
	
	<h2 class="h2">Input Xray image classified into Covid Category....</h2>
	<table>
	<tr>
	<td>
	<img src="http://localhost:80/CovidDetection/InputImg/<%=request.getParameter("img").toString().trim() %>" width="200px"/>
	</td>
	<td>
	<img src="http://localhost:80/CovidDetection/InputImg/<%=request.getParameter("img1").toString().trim() %>" width="200px"/>
	</td>
	 
	</tr>
	</table>
	<%
	try{
	String s="NA";
	Process p = Runtime.getRuntime().exec("python C:/xampp/htdocs/CovidDetection/predict_severity.py 1.jpeg C:/xampp/htdocs/CovidDetection/examples/ -saliency_path heatmap.jpg");
	BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	while((s=in.readLine())!=null){
		out.println(s);
	
	}
	}
	catch(Exception ex){
		out.println("err="+ex.getMessage());
	}
	%>
	
	</div>
	<div class="col-md-6">
	<h2>Output Details</h2>
	<ul class="ulstyle"><li>  geographic_extent_mean: <br/>The extent of lung involvement by ground glass opacity or consolidation for each lung (right lung and left lung separately) was scored as: 0 = no involvement; 1 = <25% involvement; 2 = 25-50% involvement; 3 = 50-75% involvement; 4 = >75% involvement. The total extent score ranged from 0 to 8 (right lung and left lung together).
  
	</li>
	<li>opacity_mean:<br/> The degree of opacity for each lung (right lung and left lung separately) was scored as: 0 = no opacity; 1 = ground glass opacity; 2 = consolidation; 3 = mix of consolidation and ground glass opacity (>50% consolidation); 4 = white-out. The total opacity score ranged from 0 to 8 (right lung and left lung together). NOTE: The total opacity score ranged from 0 to 6 for the COVID-19 Image Data Collection Dataset so scalling (like opacity/6*8) will align the two datasets.
	
	</li>
	</ul>
    
	</div>
	</div>
	<br/><br/><br/>
	<a href="userHome">Home</a><br/><br/>
<%
}
else if(request.getParameter("type").toString().trim().equals("datasetInsrt"))
{
	%><h2 class="h2">Dataset Uploaded Successfully....</h2>
	<br/>
	<a href="adminHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("datasetInsrt1"))
{
	%><h2 class="h2">Dataset Uploaded Successfully....</h2>
	<br/>
	<a href="expertHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("Exp"))
{
	%><h2 class="h2">Expert Registration Done Successfully....</h2>
	<br/>
	<a href="adminHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("CommReply"))
{
	%><h2 class="h2">Query Processed Successfully....</h2>
	<br/>
	<a href="expertHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("RegComm"))
{
	%><h2 class="h2">Query Sent Successfully....</h2>
	<br/>
	<a href="userHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("habit"))
{
	%><h2 class="h2">Eating Habit Registration Done Successfully....</h2>
	<br/>
	<a href="adminHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("RegUserDisease"))
{
	%><h2 class="h2">Disease Registered Successfully....</h2>
	<br/>
	<a href="/userHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("RegUserReading"))
{
	%><h2 class="h2">Readings Registered Successfully....</h2>
	<br/>
	<a href="/userHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("DiseaseDataSet"))
{
	%><h2 class="h2">New Disease Registered Successfully....</h2>
	<br/>
	<a href="ViewJobs.jsp">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ChangePass"))
{
	%><h2 class="h2">Password Changed Successfully....</h2>
	<br/>
	<a href="uploaddocs">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("passEmail"))
{
	%><h2 class="h2">New Password has been sent on your registered email id  Successfully....</h2>
	<br/>
	<a href="home">continue...</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("Prev"))
{
	%><h2 class="h2">Preventive Measures Registered  Successfully....</h2>
	<br/>
	<a href="adminHome">continue...</a>
<%
}
%>
</div>
</body>
</html>