<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipProgDetail.*" %>
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
   $( "#fromDtFrom" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#fromDtTo" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#toDtFrom" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#toDtTo" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#updateDtFrom" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#updateDtTo" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#circularDtFrom" ).datepicker({dateFormat: 'dd-mm-yy'});
   $( "#circularDtTo" ).datepicker({dateFormat: 'dd-mm-yy'});
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
InternshipProgDetail internshipProgDetail = (InternshipProgDetail)request.getSession().getAttribute("internshipProgDetailSearch");
ArrayList<DropDownDTO> list = new ArrayList<DropDownDTO>();
DropDownDTO ddDto=new DropDownDTO();
Iterator<DropDownDTO> it = list.iterator();
%>
<form action="internshipProgDetailCntrl"  id="myform" name="myform" accept-charset="UTF-8" >
<table cellspacing="10px">

<tr>
<td>
id:
</td>

<td>
<input type="text" name="id" value="<%=internshipProgDetail.getId()%>" size="30">
</td>

</tr>

<tr>
<td>
code:
</td>

<td>
<input type="text" name="code" value="<%=internshipProgDetail.getCode()%>" size="30">
</td>

</tr>

<tr>
<td>
value:
</td>

<td>
<input type="text" name="value" value="<%=internshipProgDetail.getValue()%>" size="30">
</td>

</tr>

<tr>
<td>
SESSIONSYEAR:
</td>

<td>

<%list = dropDownDBService.getList("dd_sessionYear");
it = list.iterator();%>
<select name="sessionYear">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipProgDetail.getSessionYear().equals(ddDto.getCode())){
%>
<option selected value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } else { %>
<option value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } %>
<%}%>
</select>
</td>

</tr>

<tr>
<td>
PRGTITLE:
</td>

<td>
<input type="text" name="prgTitle" value="<%=internshipProgDetail.getPrgTitle()%>" size="30">
</td>

</tr>

<tr>
<td>
FORMDR(From):
</td>

<td>
<input type="text" id="fromDtFrom" name="fromDtFrom" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDtFrom()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDtFrom())%>">
</td>
</tr>
<tr>
<td>FORMDR(To):</td><td><input type="text" id="fromDtTo" name="fromDtTo" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDtTo()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDtTo())%>">

</td>

</tr>

<tr>
<td>
TODT(From):
</td>

<td>
<input type="text" id="toDtFrom" name="toDtFrom" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getToDtFrom()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getToDtFrom())%>">
</td>
</tr>
<tr>
<td>TODT(To):</td><td><input type="text" id="toDtTo" name="toDtTo" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getToDtTo()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getToDtTo())%>">

</td>

</tr>

<tr>
<td>
PRGCOORD:
</td>

<td>
<input type="text" name="prgCoord" value="<%=internshipProgDetail.getPrgCoord()%>" size="30">
</td>

</tr>

<tr>
<td>
VENUE:
</td>

<td>
<input type="text" name="venue" value="<%=internshipProgDetail.getVenue()%>" size="30">
</td>

</tr>

<tr>
<td>
TARGET:
</td>

<td>
<input type="text" name="target" value="<%=internshipProgDetail.getTarget()%>" size="30">
</td>

</tr>

<tr>
<td>
STATUS:
</td>

<td>
<input type="text" name="status" value="<%=internshipProgDetail.getStatus()%>" size="30">
</td>

</tr>

<tr>
<td>
COORDSTATE:
</td>

<td>
<input type="text" name="CoordState" value="<%=internshipProgDetail.getCoordState()%>" size="30">
</td>

</tr>

<tr>
<td>
FACILITYLIST :
</td>

<td>
<input type="text" name="facultyList" value="<%=internshipProgDetail.getFacultyList()%>" size="30">
</td>

</tr>

<tr>
<td>
NAMEEXPERT:
</td>

<td>
<input type="text" name="nameExpert" value="<%=internshipProgDetail.getNameExpert()%>" size="30">
</td>

</tr>

<tr>
<td>
MINSEAT:
</td>

<td>
<input type="text" name="minSeat" value="<%=internshipProgDetail.getMinSeat()%>" size="30">
</td>

</tr>

<tr>
<td>
MAXSEAT:
</td>

<td>
<input type="text" name="maxSeat" value="<%=internshipProgDetail.getMaxSeat()%>" size="30">
</td>

</tr>

<tr>
<td>
UPDATEBY:
</td>

<td>
<input type="text" name="updateBy" value="<%=internshipProgDetail.getUpdateBy()%>" size="30">
</td>

</tr>

<tr>
<td>
UPDATEDT(From):
</td>

<td>
<input type="text" id="updateDtFrom" name="updateDtFrom" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDtFrom()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDtFrom())%>">
</td>
</tr>
<tr>
<td>UPDATEDT(To):</td><td><input type="text" id="updateDtTo" name="updateDtTo" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDtTo()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDtTo())%>">

</td>

</tr>

<tr>
<td>
TRAININGMODE:
</td>

<td>
<input type="text" name="trainingMode" value="<%=internshipProgDetail.getTrainingMode()%>" size="30">
</td>

</tr>

<tr>
<td>
CERTITEMPL:
</td>

<td>
<input type="text" name="certiTempl" value="<%=internshipProgDetail.getCertiTempl()%>" size="30">
</td>

</tr>

<tr>
<td>
CIRCULARNO:
</td>

<td>
<input type="text" name="circularNo" value="<%=internshipProgDetail.getCircularNo()%>" size="30">
</td>

</tr>

<tr>
<td>
CIRCULARDT(From):
</td>

<td>
<input type="text" id="circularDtFrom" name="circularDtFrom" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDtFrom()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDtFrom())%>">
</td>
</tr>
<tr>
<td>CIRCULARDT(To):</td><td><input type="text" id="circularDtTo" name="circularDtTo" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDtTo()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDtTo())%>">

</td>

</tr>

<tr>
<td>
TRAININGTYPE:
</td>

<td>
<input type="text" name="trainingType" value="<%=internshipProgDetail.getTrainingType()%>" size="30">
</td>

</tr>

<tr>
<td>
TRAININGDURATION:
</td>

<td>
<input type="text" name="trainingDuration" value="<%=internshipProgDetail.getTrainingDuration()%>" size="30">
</td>

</tr>

<tr>
<td>
MINQUALIFICATION:
</td>

<td>
<input type="text" name="minQualification" value="<%=internshipProgDetail.getMinQualification()%>" size="30">
</td>

</tr>

<tr>
<td>
TRAININGNAME :
</td>

<td>
<input type="text" name="trainingName" value="<%=internshipProgDetail.getTrainingName()%>" size="30">
</td>

</tr>

<tr>
<td>
DEPTCOORDINATING:
</td>

<td>
<input type="text" name="deptCoordinating" value="<%=internshipProgDetail.getDeptCoordinating()%>" size="30">
</td>

</tr>

</table>

<input type="hidden" name="page" value="searchInternshipProgDetail">
<input type="hidden" name="pageNo" value="<%=pageNo%>">
<input type="hidden" name="limit" value="<%=limit%>">
</form>

<button type="submit" form="myform"  name="opr" value= "search" class="form-submit-button">Search</button>
<%if(pageNo==0){ %>
<a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=showNone&pageNo=0&limit=0"><button type="button" class="form-submit-button">Reset</button></a>
<%} else {%>
<a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=showNone&pageNo=1&limit=<%=limit%>"><button type="button" class="form-submit-button">Reset</button></a>
<% } %>
<% dropDownDBService.closeConnection(); %>

<%if(pageNo!=0){ %>
<div align="left">
<font color="blue" size="3">
<%if(pageNo==1){%>|&lt;&nbsp;&nbsp;&nbsp;&lt;&lt;<%} else { %><a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=searchFirst&pageNo=<%=1%>&limit=<%=limit%>">|&lt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=searchPrev&pageNo=<%=pageNo-1%>&limit=<%=limit%>">&lt;&lt;</a><%}%>
&nbsp;&nbsp;&nbsp;Page: <%=pageNo%>/<%=totalPages%>
<%if(pageNo==totalPages){%>&nbsp;&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;&nbsp;&gt;|<%} else { %>&nbsp;&nbsp;&nbsp;<a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=searchNext&pageNo=<%=pageNo+1%>&limit=<%=limit%>">&gt;&gt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=searchLast&pageNo=<%=totalPages%>&limit=<%=limit%>">&gt;|</a><%}%>
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
<th>id</th>
<th>code</th>
<th>value</th>
<th>SESSIONSYEAR</th>
<th>PRGTITLE</th>
<th>FORMDR</th>
<th>TODT</th>
<th>PRGCOORD</th>
<th>VENUE</th>
<th>TARGET</th>
<th>STATUS</th>
<th>COORDSTATE</th>
<th>FACILITYLIST </th>
<th>NAMEEXPERT</th>
<th>MINSEAT</th>
<th>MAXSEAT</th>
<th>UPDATEBY</th>
<th>UPDATEDT</th>
<th>TRAININGMODE</th>
<th>CERTITEMPL</th>
<th>CIRCULARNO</th>
<th>CIRCULARDT</th>
<th>TRAININGTYPE</th>
<th>TRAININGDURATION</th>
<th>MINQUALIFICATION</th>
<th>TRAININGNAME </th>
<th>DEPTCOORDINATING</th>
<th>View</th>
<th>Edit</th>
<th>Delete</th>
 </tr>
 </thead>
 <% String opr= (String)request.getAttribute("opr"); %>
<%if(null==opr||!opr.equals("showNone")) { %>
<% ArrayList<InternshipProgDetail> internshipProgDetailList = (ArrayList<InternshipProgDetail>)request.getAttribute("internshipProgDetailList"); %>
    <% Iterator<InternshipProgDetail> it2= internshipProgDetailList.iterator(); %>
 <tbody>
<% int count=(pageNo-1)*limit+1; %>
<% while(it2.hasNext()){
	InternshipProgDetail internshipProgDetail2 = (InternshipProgDetail)it2.next();
	%>
<tr>
<td><%=count++%></td>
<td><%=internshipProgDetail2.getId()%></td>
<td><%=internshipProgDetail2.getCode()%></td>
<td><%=internshipProgDetail2.getValue()%></td>
<td><%=internshipProgDetail2.getSessionYearValue()%></td>
<td><%=internshipProgDetail2.getPrgTitle()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail2.getFromDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail2.getFromDt())%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail2.getToDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail2.getToDt())%></td>
<td><%=internshipProgDetail2.getPrgCoord()%></td>
<td><%=internshipProgDetail2.getVenue()%></td>
<td><%=internshipProgDetail2.getTarget()%></td>
<td><%=internshipProgDetail2.getStatus()%></td>
<td><%=internshipProgDetail2.getCoordState()%></td>
<td><%=internshipProgDetail2.getFacultyList()%></td>
<td><%=internshipProgDetail2.getNameExpert()%></td>
<td><%=internshipProgDetail2.getMinSeat()%></td>
<td><%=internshipProgDetail2.getMaxSeat()%></td>
<td><%=internshipProgDetail2.getUpdateBy()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail2.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail2.getUpdateDt())%></td>
<td><%=internshipProgDetail2.getTrainingMode()%></td>
<td><%=internshipProgDetail2.getCertiTempl()%></td>
<td><%=internshipProgDetail2.getCircularNo()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail2.getCircularDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail2.getCircularDt())%></td>
<td><%=internshipProgDetail2.getTrainingType()%></td>
<td><%=internshipProgDetail2.getTrainingDuration()%></td>
<td><%=internshipProgDetail2.getMinQualification()%></td>
<td><%=internshipProgDetail2.getTrainingName()%></td>
<td><%=internshipProgDetail2.getDeptCoordinating()%></td>
<td><a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=view&id=<%=internshipProgDetail2.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-primary">View</button></a></td>
<td><a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=edit&id=<%=internshipProgDetail2.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-success">Edit</button></a></td>
<td><a href="internshipProgDetailCntrl?page=searchInternshipProgDetail&opr=delete&id=<%=internshipProgDetail2.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn btn-danger">Delete</button></a></td>
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
