<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipRegd.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<!-- Begin: Button Link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- End: Button Link -->
  
<!--  Begin: Data Table -->
<link rel="stylesheet" type="text/css" href="jquery.dataTables.css">
<script type="text/javascript" language="javascript" src="jquery-3.5.1.js"></script>
<script type="text/javascript" language="javascript" src="jquery.dataTables.js"></script>
	
<script type="text/javascript" language="javascript">
	
$(document).ready(function() {
	$('#example').DataTable( {
		"paging":   false,
		"ordering": true,
		"info":     true
	} );
} );
 
 /* $(document).ready(function() {
    $('#example').DataTable();
} );
 */
</script>
	
<!--  End: Data Table -->
<style>
div#banner {
background-color: white;
height: 120px;
}
div#main {
border: solid 2px blue;
margin-left: 100px;
min-height: 300px;
background-color: yellow;
}
div#leftMenu {
background-color: green;
width: 80px;
position: relative;
top: 0px;
min-height: 300px;
}
div#topMenu {
border: 0px solid red;
background-color: orange;
font-size: 20px;
}
div#main {
border: 2px solid red;
background-color: red;
}
div#content {
border: 2px solid red;
background-color: red;
}
.mycontainer {
    background-color:white;
    display:inline-flex;
}
.fixed-left-menu {
    background-color:white;
    width: 200px;
    
}
.flex-item {
    background-color:white;
    flex-grow: 1;
}
</style>
</head>
<meta charset="ISO-8859-1">
<title>Dashboard Template</title>
</head>
<body>
<div id="outer">
<!-- begin: banner -->
<div id="banner" align="center">
<img alt="nitttr-bpl" src="banner.jpg" width="70%" height="100%" >
</div>
<!-- end: banner -->
<br/>
<!--  begin: top menu -->
<div id="topMenu" class="topMenu">
<%@include file="topMenu.jsp" %>
</div>
<!--  end: top menu -->
<!--  begin: container -->
<div class="mycontainer">
    
    <!-- begin: side navigation -->
    <%@include file="leftMenu.jsp" %>
    <!-- end: side navigation -->
    <!--  begin: main content -->
    <div class="flex-item" align="center">
    
    <h1>Main Content</h1>
  
    <% 	
    int pageNo = (null==request.getParameter("pageNo")?0:Integer.parseInt(request.getParameter("pageNo")));	
    int limit = (null==request.getParameter("limit")?0:Integer.parseInt(request.getParameter("limit")));	
	int totalPages= (null==request.getAttribute("totalPages")?0:(Integer)request.getAttribute("totalPages"));	
	%>	
    <% ArrayList<InternshipRegd> internshipRegdList = (ArrayList<InternshipRegd>)request.getAttribute("internshipRegdList"); %>
    <% Iterator<InternshipRegd> it= internshipRegdList.iterator(); %>
    
<%if(pageNo!=0){ %>   	
	<div align="left">	
	<font color="blue" size="3">	
	<%if(pageNo==1){%>|&lt;&nbsp;&nbsp;&nbsp;&lt;&lt;<%} else { %><a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=1%>&limit=<%=limit%>">|&lt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=pageNo-1%>&limit=<%=limit%>">&lt;&lt;</a><%}%>	
	&nbsp;&nbsp;&nbsp;Page: <%=pageNo%>/<%=totalPages%>	
	<%if(pageNo==totalPages){%>&nbsp;&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;&nbsp;&gt;|<%} else { %>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=pageNo+1%>&limit=<%=limit%>">&gt;&gt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=totalPages%>&limit=<%=limit%>">&gt;|</a><%}%>	
	</font>	
	</div>    	
	<%} %>	
    

<table id="example" class="display" style="width:100%">
<thead>
<tr>
<th>SN</th>
<th>ID</th>
<th>SESSIONYEAR</th>
<th>PRGID</th>
<th>REGID</th>
<th>STUDENTNAME</th>
<th>EMAIL</th>
<th>MOBILENO</th>
<th>FATHERNAME</th>
<th>INSTITUTENAME</th>
<th>INSTITUTEWEB</th>
<th>COURSE</th>
<th>COURSEYEAR</th>
<th>COURSEBRANCH</th>
<th>LOCALADDRESS</th>
<th>PERMADDRESS</th>
<th>CITY</th>
<th>DISTT</th>
<th>STATE</th>
<th>PIN</th>
<th>GENDER</th>
<th>CATEGORY</th>
<th>LODGING</th>
<th>UPDATEBY</th>
<th>UPDATEDT</th>
<th>UPDATETIME</th>
<th>REMARK</th>
<th>BATCH</th>
<th>View</th>
<th>Edit</th>
<th>Delete</th>
 </tr>
 </thead>
 <tbody>
<% int count=(pageNo-1)*limit+1; %>
<% while(it.hasNext()){
	InternshipRegd internshipRegd = (InternshipRegd)it.next();
	%>
<tr>
<td><%=count++%></td>
<td><%=internshipRegd.getId()%></td>
<td><%=internshipRegd.getSessionYear()%></td>
<td><%=internshipRegd.getPrgId()%></td>
<td><%=internshipRegd.getRegId()%></td>
<td><%=internshipRegd.getStudentName()%></td>
<td><%=internshipRegd.getEmail()%></td>
<td><%=internshipRegd.getMobileNo()%></td>
<td><%=internshipRegd.getFatherName()%></td>
<td><%=internshipRegd.getInstituteName()%></td>
<td><%=internshipRegd.getInstituteWeb()%></td>
<td><%=internshipRegd.getCourseValue()%></td>
<td><%=internshipRegd.getCourseYearValue()%></td>
<td><%=internshipRegd.getCourseBranch()%></td>
<td><%=internshipRegd.getLocalAddress()%></td>
<td><%=internshipRegd.getPermAddress()%></td>
<td><%=internshipRegd.getCity()%></td>
<td><%=internshipRegd.getDistt()%></td>
<td><%=internshipRegd.getStateValue()%></td>
<td><%=internshipRegd.getPin()%></td>
<td><%=internshipRegd.getGenderValue()%></td>
<td><%=internshipRegd.getCategory()%></td>
<td><%=internshipRegd.getLodging()%></td>
<td><%=internshipRegd.getUpdatedBy()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt())%></td>
<td><%=internshipRegd.getUpdateTime()%></td>
<td><%=internshipRegd.getRemark()%></td>
<td><%=internshipRegd.getBatch()%></td>
<td><a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=view&id=<%=internshipRegd.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-primary">View</button></a></td>
<td><a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=edit&id=<%=internshipRegd.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-success">Edit</button></a></td>
<td><a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=delete&id=<%=internshipRegd.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-danger">Delete</button></a></td>
</tr>
	<%} %>
</tbody>
	</table>    </div>
    <!--  end: main content -->
</div>
<!--  end: container -->
</div>
</body>
</html>
