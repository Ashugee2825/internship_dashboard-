<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipRegd.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  border-collapse: collapse;
  width: 30%;
}
tr, th, td {
  text-align: left;
  height:35px;
  font-size:15px;
}
</style>
<style>
.form-submit-button {
background: #0066A2;
color: white;
border-style: outset;
border-color: #0066A2;
height: 30px;
width: 70px;
font: bold17px arial,sans-serif;
text-shadow: none;
}
</style>
<!-- Begin: Button Link -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- End: Button Link -->
  
<!--  Begin: DatePicker -->
<link rel = "stylesheet"
href = "//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type = "text/javascript"
src = "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js">
</script>
<script>
   $(function() {
   $( "#updateDtFrom" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#updateDtTo" ).datepicker({dateFormat: 'dd-mm-yy'});
   });
</script>
<!--  End: DatePicker -->
<!--  Begin: Data Table -->
<link rel="stylesheet" type="text/css" href="jquery.dataTables.css">
<!-- <script type="text/javascript" language="javascript" src="jquery-3.5.1.js"></script> -->
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
<script type="text/javascript">
function popup(){
	var url=window. location. href;
	url=url.replace("opr=search", "opr=downloadPrint");
	window.open(url, 'popUpWindow', 'height = 300, width = 500, left = 100, top = 100, scrollbars = yes, resizable = yes, menubar = no, toolbar = yes, location = no, directories = no, status = yes')
	}
</script>
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
    
    <h1>Search Content</h1>
  <% 	
    int pageNo = (null==request.getParameter("pageNo")?0:Integer.parseInt(request.getParameter("pageNo")));	
    int limit = (null==request.getParameter("limit")?0:Integer.parseInt(request.getParameter("limit")));	
	int totalPages= (null==request.getAttribute("totalPages")?0:(Integer)request.getAttribute("totalPages"));	
	%>	
  
  <!-- begin:search form -->
  
    <!--  Begin: Dynamic Codes -->

<%
DropDownDBService dropDownDBService =new DropDownDBService();
InternshipRegd internshipRegd = (InternshipRegd)request.getSession().getAttribute("internshipRegdSearch");
ArrayList<DropDownDTO> list = new ArrayList<DropDownDTO>();
DropDownDTO ddDto=new DropDownDTO();
Iterator<DropDownDTO> it = list.iterator();
%>
<form action="internshipRegdCntrl"  id="myform" name="myform" accept-charset="UTF-8" >
<table cellspacing="10px">

<tr>
<td>
ID:
</td>

<td>
<input type="text" name="id" value="<%=internshipRegd.getId()%>" size="30">
</td>

</tr>

</table>

<input type="hidden" name="page" value="searchInternshipRegd">
<input type="hidden" name="pageNo" value="<%=pageNo%>">
<input type="hidden" name="limit" value="<%=limit%>">
</form>

<button type="submit" form="myform"  name="opr" value= "search" class="form-submit-button">Search</button>
<%if(pageNo==0){ %>
<a href="internshipRegdCntrl?page=searchInternshipRegd&opr=showNone&pageNo=0&limit=0"><button type="button" class="form-submit-button">Reset</button></a>
<%} else {%>
<a href="internshipRegdCntrl?page=searchInternshipRegd&opr=showNone&pageNo=1&limit=<%=limit%>"><button type="button" class="form-submit-button">Reset</button></a>
<% } %>
<% dropDownDBService.closeConnection(); %>

<%if(pageNo!=0){ %>
<div align="left">
<font color="blue" size="3">
<%if(pageNo==1){%>|&lt;&nbsp;&nbsp;&nbsp;&lt;&lt;<%} else { %><a href="internshipRegdCntrl?page=searchInternshipRegd&opr=searchFirst&pageNo=<%=1%>&limit=<%=limit%>">|&lt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=searchInternshipRegd&opr=searchPrev&pageNo=<%=pageNo-1%>&limit=<%=limit%>">&lt;&lt;</a><%}%>
&nbsp;&nbsp;&nbsp;Page: <%=pageNo%>/<%=totalPages%>
<%if(pageNo==totalPages){%>&nbsp;&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;&nbsp;&gt;|<%} else { %>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=searchInternshipRegd&opr=searchNext&pageNo=<%=pageNo+1%>&limit=<%=limit%>">&gt;&gt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=searchInternshipRegd&opr=searchLast&pageNo=<%=totalPages%>&limit=<%=limit%>">&gt;|</a><%}%>
</font>
</div>
<%} %><br/>
<div align="right">
<button onclick="popup()">Download/Print</button><br/><br/>
</div>

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
 <% String opr= (String)request.getAttribute("opr"); %>
<%if(null==opr||!opr.equals("showNone")) { %>
<% ArrayList<InternshipRegd> internshipRegdList = (ArrayList<InternshipRegd>)request.getAttribute("internshipRegdList"); %>
    <% Iterator<InternshipRegd> it2= internshipRegdList.iterator(); %>
 <tbody>
<% int count=(pageNo-1)*limit+1; %>
<% while(it2.hasNext()){
	InternshipRegd internshipRegd2 = (InternshipRegd)it2.next();
	%>
<tr>
<td><%=count++%></td>
<td><%=internshipRegd2.getId()%></td>
<td><%=internshipRegd2.getSessionYear()%></td>
<td><%=internshipRegd2.getPrgId()%></td>
<td><%=internshipRegd2.getRegId()%></td>
<td><%=internshipRegd2.getStudentName()%></td>
<td><%=internshipRegd2.getEmail()%></td>
<td><%=internshipRegd2.getMobileNo()%></td>
<td><%=internshipRegd2.getFatherName()%></td>
<td><%=internshipRegd2.getInstituteName()%></td>
<td><%=internshipRegd2.getInstituteWeb()%></td>
<td><%=internshipRegd2.getCourseValue()%></td>
<td><%=internshipRegd2.getCourseYearValue()%></td>
<td><%=internshipRegd2.getCourseBranch()%></td>
<td><%=internshipRegd2.getLocalAddress()%></td>
<td><%=internshipRegd2.getPermAddress()%></td>
<td><%=internshipRegd2.getCity()%></td>
<td><%=internshipRegd2.getDistt()%></td>
<td><%=internshipRegd2.getStateValue()%></td>
<td><%=internshipRegd2.getPin()%></td>
<td><%=internshipRegd2.getGenderValue()%></td>
<td><%=internshipRegd2.getCategory()%></td>
<td><%=internshipRegd2.getLodging()%></td>
<td><%=internshipRegd2.getUpdatedBy()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipRegd2.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipRegd2.getUpdateDt())%></td>
<td><%=internshipRegd2.getUpdateTime()%></td>
<td><%=internshipRegd2.getRemark()%></td>
<td><%=internshipRegd2.getBatch()%></td>
<td><a href="internshipRegdCntrl?page=searchInternshipRegd&opr=view&id=<%=internshipRegd2.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-primary">View</button></a></td>
<td><a href="internshipRegdCntrl?page=searchInternshipRegd&opr=edit&id=<%=internshipRegd2.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-success">Edit</button></a></td>
<td><a href="internshipRegdCntrl?page=searchInternshipRegd&opr=delete&id=<%=internshipRegd2.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-danger">Delete</button></a></td>
</tr>
	<%} %>
</tbody>
	</table>
	<%}%>	
	</div>
    <!--  end: main content -->
</div>
<!--  end: container -->
</div>
</body>
</html>
