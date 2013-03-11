<%@ page import="ece1779.manager.Manager" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!		 
	List<String[]> getStats() {
	    return Manager.getInstancesCPUUsgae(getServletContext());
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Worker Status and Management</title>
</head>
<body>

<font size = 4>
<b>Welcome Manager! </b>	
</font>

<br>
<br>
<font size = 4>
<b>Increase workers </b>
</font>
<form action="/B1/servlet/GrowPool" method="post">
	Enter the number of workers you want to increase :
	<input name="growWorkers" size=15 type="text" />
	<input type="submit" value="grow" />
	<span class="error">${error1}</span>  	                   
</form>

<br>
<font size = 4>
<b>Reduce workers </b>
</font>
<form action="/B1/servlet/ShrinkPool" method="post">
	Enter the number of workers you want to reduce :
       	<input name="reduceWorkers" size=15 type="text" /> 
       	<input type="submit" value="reduce" />
	<span class="error">${error2}</span>  	                   
</form>


<br>

<font size = 4>
<b>Worker pool auto-scaling parameter</b>
</font>

<form action="/B1/servlet/AutoScaling" method="post">
	Enter the autoscaling parameters 
	<br>
        CPU threshold for growing the worker pool                         
       	<input name="gthr" size=15 type="text" />       		
       	<br>
       	CPU threshold for shrinking the worker pool                        
       	<input name="sthr" size=15 type="text" />       		
       	<br>
       	Ratio by which to expand the worker pool                         
       	<input name="gratio" size=15 type="text" />       		
       	<br>
       	Ratio by which to shrink the worker pool                         
       	<input name="sratio" size=15 type="text" />       		
       	<br>	
	<input type="submit" value="auto-scaling" />
	<span class="error">${error3}</span>  	                   
</form>

<h1>Worker Status</h1>
	<% List<String[]> stats = getStats(); %>
	<table border = 1 align="left" width = 300>
    	<tr>
        	<th>Worker List</th>
        	<th>Status</th>
    	</tr>
	<%  for (String[] data : stats) { %>
        <tr>                        
        	<th><%= data[0] %></th>
        	<th><%= data[1] %></th>
        </tr> 
	<%  } %> 
	</table>
</body>
</html>
