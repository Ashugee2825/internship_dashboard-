<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipProgDetail.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<!--  Begin: lines added by PNH on 06.12.2022 -->
<style>
@import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Koulen&family=Lato&family=Nunito&family=Playfair+Display:ital@1&family=Prata&family=Raleway:ital,wght@1,100&family=Roboto&family=Roboto+Condensed&family=Teko&display=swap');
.btn{
font-family: Roboto, sans-serif;
font-weight: 0;
font-size: 14px;
color: #fff;
background-color: #32CD32;
padding: 10px 30px;
border: 2px solid #32CD32;
box-shadow: rgb(0, 0, 0) 0px 0px 0px 0px;
border-radius: 50px;
align-items: center;
cursor: pointer;
}
.btn:hover{
background-color: #fff;
color: #0066cc;
border: solid 2px #0066cc;
}
.btn1{
font-family: Roboto, sans-serif;
font-weight: 0;
font-size: 14px;
color: #fff;
background-color: #DE3163;
padding: 10px 30px;
border: 2px solid #DE3163;
box-shadow: rgb(0, 0, 0) 0px 0px 0px 0px;
border-radius: 50px;
align-items: center;
cursor: pointer;
}
.btn1:hover{
background-color: #fff;
color: #0066cc;
border: solid 2px #0066cc;
}
.btn3{
font-family: Roboto, sans-serif;
font-weight: 0;
font-size: 14px;
color: #fff;
background-color: #6495ED;
padding: 10px 30px;
border: 2px solid #6495ED;
box-shadow: rgb(0, 0, 0) 0px 0px 0px 0px;
border-radius: 50px;
align-items: center;
cursor: pointer;
}
.btn3:hover{
background-color: #fff;
color: #0066cc;
border: solid 2px #0066cc;
}
</style>
<!-- 2️code HTML below -->
<!--  End: lines added by PNH on 06.12.2022 -->
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
<!-- Begin: Data Table Section -->
<style>
.mytable{
  border-collapse: collapse;
  width: 100%;
}
.mytable th, 
.mytable td {
  text-align: left;
  padding: 8px;
}
.mytable tr:nth-child(even){background-color: #f2f2f2}
.mytable th {
  background-color: #C0C0C0;
  color: black;
}
</style>
<!-- End: Data Table Section -->
<!-- Begin:Add/Update Section -->
<!--  Begin: Date Picker -->
<link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>
<script>
    $(document).ready(function () {
    	$('input[id$=dob]').datepicker({
    	    dateFormat: 'dd-mm-yy'
    	});
    });
</script>
<!-- End: Date Picker -->
<!-- End:Add/Update Section -->
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

<%
DropDownDBService dropDownDBService =new DropDownDBService();
InternshipProgDetail internshipProgDetail = (InternshipProgDetail)request.getAttribute("internshipProgDetail");
String homeURL=(String)request.getSession().getAttribute("homeURL");
String pageNo=(null==(String)request.getParameter("pageNo")?"":(String)request.getParameter("pageNo"));
String limit=(null==request.getParameter("limit")?"":(String)request.getParameter("limit"));
ArrayList<DropDownDTO> list = new ArrayList<DropDownDTO>();
DropDownDTO ddDto=new DropDownDTO();
Iterator<DropDownDTO> it = list.iterator();
%>
<form action="internshipProgDetailCntrl" id="myform" name="myform" accept-charset="UTF-8" >

<h2>Add/Update Section</h2>
<%if(null!=request.getSession().getAttribute("msg")){ %>
<%String msg = (String)request.getSession().getAttribute("msg");%>
<%if(!msg.equals("")){ %>
<br/><h3><font color="red"><%=msg%></font></h3><br/>
<%}%>
<%request.getSession().removeAttribute("msg");%>
<%}%>
<table cellspacing="10px">

<tr>

<td>ID:  <%=internshipProgDetail.getId()%></td>
</tr>

<tr>

<td>
code<font color="red">*</font>:<br/>

<input required type="text" name="code" value="<%=internshipProgDetail.getCode()%>" size="30">
</td>

<td>
value<font color="red">*</font>:<br/>
<input required type="text" name="value" value="<%=internshipProgDetail.getValue()%>" size="30">
</td>

</tr>

<tr>

<td>
SESSIONSYEAR<font color="red">*</font>:<br/>

<%list = dropDownDBService.getList("dd_sessionYear");
it = list.iterator();%>
<select required name="sessionYear">
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

<td>
PRGTITLE<font color="red">*</font>:<br/>
<input required type="text" name="prgTitle" value="<%=internshipProgDetail.getPrgTitle()%>" size="30">
</td>

</tr>

<tr>

<td>
FORMDR<font color="red">*</font>:<br/>

<input type="text" id="fromDt" name="fromDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDt())%>">
</td>

<td>
TODT<font color="red">*</font>:<br/>
<input type="text" id="toDt" name="toDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getToDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getToDt())%>">
</td>

</tr>

<tr>

<td>
PRGCOORD<font color="red">*</font>:<br/>

<input required type="text" name="prgCoord" value="<%=internshipProgDetail.getPrgCoord()%>" size="30">
</td>

<td>
VENUE<font color="red">*</font>:<br/>
<input required type="text" name="venue" value="<%=internshipProgDetail.getVenue()%>" size="30">
</td>

</tr>

<tr>

<td>
TARGET<font color="red">*</font>:<br/>

<input required type="text" name="target" value="<%=internshipProgDetail.getTarget()%>" size="30">
</td>

<td>
STATUS<font color="red">*</font>:<br/>
<input required type="text" name="status" value="<%=internshipProgDetail.getStatus()%>" size="30">
</td>

</tr>

<tr>

<td>
COORDSTATE<font color="red">*</font>:<br/>

<input required type="text" name="CoordState" value="<%=internshipProgDetail.getCoordState()%>" size="30">
</td>

<td>
FACILITYLIST <font color="red">*</font>:<br/>
<input required type="text" name="facultyList" value="<%=internshipProgDetail.getFacultyList()%>" size="30">
</td>

</tr>

<tr>

<td>
NAMEEXPERT<font color="red">*</font>:<br/>

<input required type="text" name="nameExpert" value="<%=internshipProgDetail.getNameExpert()%>" size="30">
</td>

<td>
MINSEAT<font color="red">*</font>:<br/>
<input required type="text" name="minSeat" value="<%=internshipProgDetail.getMinSeat()%>" size="30">
</td>

</tr>

<tr>

<td>
MAXSEAT<font color="red">*</font>:<br/>

<input required type="text" name="maxSeat" value="<%=internshipProgDetail.getMaxSeat()%>" size="30">
</td>

<td>
UPDATEBY<font color="red">*</font>:<br/>
<input required type="text" name="updateBy" value="<%=internshipProgDetail.getUpdateBy()%>" size="30">
</td>

</tr>

<tr>

<td>
UPDATEDT<font color="red">*</font>:<br/>

<input type="text" id="updateDt" name="updateDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDt())%>">
</td>

<td>
TRAININGMODE<font color="red">*</font>:<br/>
<input required type="text" name="trainingMode" value="<%=internshipProgDetail.getTrainingMode()%>" size="30">
</td>

</tr>

<tr>

<td>
CERTITEMPL<font color="red">*</font>:<br/>

<input required type="text" name="certiTempl" value="<%=internshipProgDetail.getCertiTempl()%>" size="30">
</td>

<td>
CIRCULARNO<font color="red">*</font>:<br/>
<input required type="text" name="circularNo" value="<%=internshipProgDetail.getCircularNo()%>" size="30">
</td>

</tr>

<tr>

<td>
CIRCULARDT:<br/>

<input type="text" id="circularDt" name="circularDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDt())%>">
</td>

<td>
TRAININGTYPE<font color="red">*</font>:<br/>
<input required type="text" name="trainingType" value="<%=internshipProgDetail.getTrainingType()%>" size="30">
</td>

</tr>

<tr>

<td>
TRAININGDURATION<font color="red">*</font>:<br/>

<input required type="text" name="trainingDuration" value="<%=internshipProgDetail.getTrainingDuration()%>" size="30">
</td>

<td>
MINQUALIFICATION<font color="red">*</font>:<br/>
<input required type="text" name="minQualification" value="<%=internshipProgDetail.getMinQualification()%>" size="30">
</td>

</tr>

<tr>

<td>
TRAININGNAME <font color="red">*</font>:<br/>

<input required type="text" name="trainingName" value="<%=internshipProgDetail.getTrainingName()%>" size="30">
</td>

<td>
DEPTCOORDINATING<font color="red">*</font>:<br/>
<input required type="text" name="deptCoordinating" value="<%=internshipProgDetail.getDeptCoordinating()%>" size="30">
</td>

</tr>

</table>

<input type="hidden" name="page" value= "saveShowNextInternshipProgDetail">
<input type="hidden" name="pageNo" value= "<%=pageNo%>">
<input type="hidden" name="limit" value= "<%=limit%>">
<input type="hidden" name="id" value= "<%=internshipProgDetail.getId()%>">
</form>

<form action="internshipProgDetailCntrl"  id="myform1" name="myform1" accept-charset="UTF-8" >
<input type="hidden" name="page" value= "saveShowNextInternshipProgDetail">
<input type="hidden" name="pageNo" value= "<%=pageNo%>">
<input type="hidden" name="limit" value= "<%=limit%>">
<input type="hidden" name="id" value= "<%=internshipProgDetail.getId()%>">
</form>    
    
<%String buttonClicked = request.getParameter("opr");%>
<%if(buttonClicked.equals("edit")) {%>
<button type="submit" form="myform"  name="opr" value= "update" class="btn3">Update</button>
<button type="submit" form="myform1"  name="opr" value= "cancel" class="btn3">Cancel</button>
<%} else { %>
<button type="submit" form="myform"  name="opr" value= "addNew" class="btn3">Add New</button>
<button type="submit" form="myform1"  name="opr" value= "reset" class="btn3">Reset</button>
<%} %>
<% dropDownDBService.closeConnection(); %>
    <!--  End: Dynamic Codes -->
    
    <!-- End: Add/Update Section -->
    <h1>Data Table</h1>
  
    <% 	
    int pageNum = (null==request.getParameter("pageNo")?0:Integer.parseInt(request.getParameter("pageNo")));	
    int limitNum = (null==request.getParameter("limit")?0:Integer.parseInt(request.getParameter("limit")));	
	int totalPages= (null==request.getAttribute("totalPages")?0:(Integer)request.getAttribute("totalPages"));	
	%>	
    <% ArrayList<InternshipProgDetail> internshipProgDetailList = (ArrayList<InternshipProgDetail>)request.getAttribute("internshipProgDetailList"); %>
    <% Iterator<InternshipProgDetail> it1= internshipProgDetailList.iterator(); %>
    
<%if(pageNum!=0){ %>   	
	<div align="left">	
	<font color="blue" size="3">	
	<%if(pageNum==1){%>|&lt;&nbsp;&nbsp;&nbsp;&lt;&lt;<%} else { %><a href="internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=showAll&pageNo=<%=1%>&limit=<%=limit%>">|&lt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=showAll&pageNo=<%=pageNum-1%>&limit=<%=limit%>">&lt;&lt;</a><%}%>	
	&nbsp;&nbsp;&nbsp;Page: <%=pageNum%>/<%=totalPages%>	
	<%if(pageNum==totalPages){%>&nbsp;&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;&nbsp;&gt;|<%} else { %>&nbsp;&nbsp;&nbsp;<a href="internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=showAll&pageNo=<%=pageNo+1%>&limit=<%=limit%>">&gt;&gt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=showAll&pageNo=<%=totalPages%>&limit=<%=limit%>">&gt;|</a><%}%>	
	</font>	
	</div>    	
	<%} %>	
    

<table class="mytable" style="width:100%">
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
<th>Edit</th>
<th>Delete</th>
 </tr>
 </thead>
 <tbody>
<% int count=(pageNum-1)*limitNum+1; %>
<% while(it1.hasNext()){
	InternshipProgDetail internshipProgDetail1 = (InternshipProgDetail)it1.next();
	%>
<tr>
<td><%=count++%></td>
<td><%=internshipProgDetail1.getId()%></td>
<td><%=internshipProgDetail1.getCode()%></td>
<td><%=internshipProgDetail1.getValue()%></td>
<td><%=internshipProgDetail1.getSessionYearValue()%></td>
<td><%=internshipProgDetail1.getPrgTitle()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail1.getFromDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDt())%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail1.getToDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getToDt())%></td>
<td><%=internshipProgDetail1.getPrgCoord()%></td>
<td><%=internshipProgDetail1.getVenue()%></td>
<td><%=internshipProgDetail1.getTarget()%></td>
<td><%=internshipProgDetail1.getStatus()%></td>
<td><%=internshipProgDetail1.getCoordState()%></td>
<td><%=internshipProgDetail1.getFacultyList()%></td>
<td><%=internshipProgDetail1.getNameExpert()%></td>
<td><%=internshipProgDetail1.getMinSeat()%></td>
<td><%=internshipProgDetail1.getMaxSeat()%></td>
<td><%=internshipProgDetail1.getUpdateBy()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail1.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDt())%></td>
<td><%=internshipProgDetail1.getTrainingMode()%></td>
<td><%=internshipProgDetail1.getCertiTempl()%></td>
<td><%=internshipProgDetail1.getCircularNo()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipProgDetail1.getCircularDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDt())%></td>
<td><%=internshipProgDetail1.getTrainingType()%></td>
<td><%=internshipProgDetail1.getTrainingDuration()%></td>
<td><%=internshipProgDetail1.getMinQualification()%></td>
<td><%=internshipProgDetail1.getTrainingName()%></td>
<td><%=internshipProgDetail1.getDeptCoordinating()%></td>
<td><a href="internshipProgDetailCntrl?page=saveShowNextInternshipProgDetail&opr=edit&id=<%=internshipProgDetail1.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn">Edit</button></a></td>
<td><a href="internshipProgDetailCntrl?page=saveShowNextInternshipProgDetail&opr=delete&id=<%=internshipProgDetail1.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn1">Delete</button></a></td>
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
