<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipRegd.*" %>
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
InternshipRegd internshipRegd = (InternshipRegd)request.getAttribute("internshipRegd");
String homeURL=(String)request.getSession().getAttribute("homeURL");
String pageNo=(null==(String)request.getParameter("pageNo")?"":(String)request.getParameter("pageNo"));
String limit=(null==request.getParameter("limit")?"":(String)request.getParameter("limit"));
ArrayList<DropDownDTO> list = new ArrayList<DropDownDTO>();
DropDownDTO ddDto=new DropDownDTO();
Iterator<DropDownDTO> it = list.iterator();
%>
<form action="internshipRegdCntrl" id="myform" name="myform" accept-charset="UTF-8" >

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

<td>ID:  <%=internshipRegd.getId()%></td>
</tr>

<tr>

<td>
SESSIONYEAR<font color="red">*</font>:<br/>

<input required type="text" name="sessionYear" value="<%=internshipRegd.getSessionYear()%>" size="30">
</td>

<td>
PRGID<font color="red">*</font>:<br/>
<input required type="text" name="prgId" value="<%=internshipRegd.getPrgId()%>" size="30">
</td>

</tr>

<tr>

<td>
REGID<font color="red">*</font>:<br/>

<input required type="text" name="regId" value="<%=internshipRegd.getRegId()%>" size="30">
</td>

<td>
STUDENTNAME<font color="red">*</font>:<br/>
<input required type="text" name="studentName" value="<%=internshipRegd.getStudentName()%>" size="30">
</td>

</tr>

<tr>

<td>
EMAIL<font color="red">*</font>:<br/>

<input required type="text" name="email" value="<%=internshipRegd.getEmail()%>" size="30">
</td>

<td>
MOBILENO<font color="red">*</font>:<br/>
<input required type="text" name="mobileNo" value="<%=internshipRegd.getMobileNo()%>" size="30">
</td>

</tr>

<tr>

<td>
FATHERNAME<font color="red">*</font>:<br/>

<input required type="text" name="fatherName" value="<%=internshipRegd.getFatherName()%>" size="30">
</td>

<td>
INSTITUTENAME<font color="red">*</font>:<br/>
<input required type="text" name="instituteName" value="<%=internshipRegd.getInstituteName()%>" size="30">
</td>

</tr>

<tr>

<td>
INSTITUTEWEB<font color="red">*</font>:<br/>

<input required type="text" name="instituteWeb" value="<%=internshipRegd.getInstituteWeb()%>" size="30">
</td>

<td>
COURSE<font color="red">*</font>:<br/>
<%list = dropDownDBService.getList("dd_course");
it = list.iterator();%>
<select required name="course">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getCourse().equals(ddDto.getCode())){
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
COURSEYEAR<font color="red">*</font>:<br/>

<%list = dropDownDBService.getList("dd_courseYear");
it = list.iterator();%>
<select required name="courseYear">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getCourseYear().equals(ddDto.getCode())){
%>
<option selected value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } else { %>
<option value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } %>
<%}%>
</select>
</td>

<td>
COURSEBRANCH<font color="red">*</font>:<br/>
<input required type="text" name="courseBranch" value="<%=internshipRegd.getCourseBranch()%>" size="30">
</td>

</tr>

<tr>

<td>
LOCALADDRESS<font color="red">*</font>:<br/>

<input required type="text" name="localAddress" value="<%=internshipRegd.getLocalAddress()%>" size="30">
</td>

<td>
PERMADDRESS<font color="red">*</font>:<br/>
<input required type="text" name="permAddress" value="<%=internshipRegd.getPermAddress()%>" size="30">
</td>

</tr>

<tr>

<td>
CITY<font color="red">*</font>:<br/>

<input required type="text" name="city" value="<%=internshipRegd.getCity()%>" size="30">
</td>

<td>
DISTT<font color="red">*</font>:<br/>
<input required type="text" name="distt" value="<%=internshipRegd.getDistt()%>" size="30">
</td>

</tr>

<tr>

<td>
STATE<font color="red">*</font>:<br/>

<%list = dropDownDBService.getList("dd_state");
it = list.iterator();%>
<select required name="state">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getState().equals(ddDto.getCode())){
%>
<option selected value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } else { %>
<option value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } %>
<%}%>
</select>
</td>

<td>
PIN<font color="red">*</font>:<br/>
<input required type="text" name="pin" value="<%=internshipRegd.getPin()%>" size="30">
</td>

</tr>

<tr>

<td>
GENDER<font color="red">*</font>:<br/>

<%list = dropDownDBService.getList("dd_gender");
it = list.iterator();%>
<select required name="gender">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getGender().equals(ddDto.getCode())){
%>
<option selected value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } else { %>
<option value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } %>
<%}%>
</select>
</td>

<td>
CATEGORY<font color="red">*</font>:<br/>
<input required type="text" name="category" value="<%=internshipRegd.getCategory()%>" size="30">
</td>

</tr>

<tr>

<td>
LODGING<font color="red">*</font>:<br/>

<input required type="text" name="lodging" value="<%=internshipRegd.getLodging()%>" size="30">
</td>

<td>
UPDATEBY<font color="red">*</font>:<br/>
<input required type="text" name="updatedBy" value="<%=internshipRegd.getUpdatedBy()%>" size="30">
</td>

</tr>

<tr>

<td>
UPDATEDT<font color="red">*</font>:<br/>

<input type="text" id="updateDt" name="updateDt" value="<%=DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt())%>">
</td>

<td>
UPDATETIME<font color="red">*</font>:<br/>
<textarea required col="50" row="10" name="updateTime" id="updateTime"><%=internshipRegd.getUpdateTime()%></textarea>
</td>

</tr>

<tr>

<td>
REMARK<font color="red">*</font>:<br/>

<textarea required col="50" row="10" name="remark" id="remark"><%=internshipRegd.getRemark()%></textarea>
</td>

<td>
BATCH<font color="red">*</font>:<br/>
<input required type="text" name="batch" value="<%=internshipRegd.getBatch()%>" size="30">
</td>

</tr>

</table>

<input type="hidden" name="page" value= "saveShowNextInternshipRegd">
<input type="hidden" name="pageNo" value= "<%=pageNo%>">
<input type="hidden" name="limit" value= "<%=limit%>">
<input type="hidden" name="id" value= "<%=internshipRegd.getId()%>">
</form>

<form action="internshipRegdCntrl"  id="myform1" name="myform1" accept-charset="UTF-8" >
<input type="hidden" name="page" value= "saveShowNextInternshipRegd">
<input type="hidden" name="pageNo" value= "<%=pageNo%>">
<input type="hidden" name="limit" value= "<%=limit%>">
<input type="hidden" name="id" value= "<%=internshipRegd.getId()%>">
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
    <% ArrayList<InternshipRegd> internshipRegdList = (ArrayList<InternshipRegd>)request.getAttribute("internshipRegdList"); %>
    <% Iterator<InternshipRegd> it1= internshipRegdList.iterator(); %>
    
<%if(pageNum!=0){ %>   	
	<div align="left">	
	<font color="blue" size="3">	
	<%if(pageNum==1){%>|&lt;&nbsp;&nbsp;&nbsp;&lt;&lt;<%} else { %><a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=1%>&limit=<%=limit%>">|&lt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=pageNum-1%>&limit=<%=limit%>">&lt;&lt;</a><%}%>	
	&nbsp;&nbsp;&nbsp;Page: <%=pageNum%>/<%=totalPages%>	
	<%if(pageNum==totalPages){%>&nbsp;&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;&nbsp;&gt;|<%} else { %>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=pageNo+1%>&limit=<%=limit%>">&gt;&gt;</a>&nbsp;&nbsp;&nbsp;<a href="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo=<%=totalPages%>&limit=<%=limit%>">&gt;|</a><%}%>	
	</font>	
	</div>    	
	<%} %>	
    

<table class="mytable" style="width:100%">
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
<th>Edit</th>
<th>Delete</th>
 </tr>
 </thead>
 <tbody>
<% int count=(pageNum-1)*limitNum+1; %>
<% while(it1.hasNext()){
	InternshipRegd internshipRegd1 = (InternshipRegd)it1.next();
	%>
<tr>
<td><%=count++%></td>
<td><%=internshipRegd1.getId()%></td>
<td><%=internshipRegd1.getSessionYear()%></td>
<td><%=internshipRegd1.getPrgId()%></td>
<td><%=internshipRegd1.getRegId()%></td>
<td><%=internshipRegd1.getStudentName()%></td>
<td><%=internshipRegd1.getEmail()%></td>
<td><%=internshipRegd1.getMobileNo()%></td>
<td><%=internshipRegd1.getFatherName()%></td>
<td><%=internshipRegd1.getInstituteName()%></td>
<td><%=internshipRegd1.getInstituteWeb()%></td>
<td><%=internshipRegd1.getCourseValue()%></td>
<td><%=internshipRegd1.getCourseYearValue()%></td>
<td><%=internshipRegd1.getCourseBranch()%></td>
<td><%=internshipRegd1.getLocalAddress()%></td>
<td><%=internshipRegd1.getPermAddress()%></td>
<td><%=internshipRegd1.getCity()%></td>
<td><%=internshipRegd1.getDistt()%></td>
<td><%=internshipRegd1.getStateValue()%></td>
<td><%=internshipRegd1.getPin()%></td>
<td><%=internshipRegd1.getGenderValue()%></td>
<td><%=internshipRegd1.getCategory()%></td>
<td><%=internshipRegd1.getLodging()%></td>
<td><%=internshipRegd1.getUpdatedBy()%></td>
<td><%=DateService.getDTSDDMMYYYY(internshipRegd1.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt())%></td>
<td><%=internshipRegd1.getUpdateTime()%></td>
<td><%=internshipRegd1.getRemark()%></td>
<td><%=internshipRegd1.getBatch()%></td>
<td><a href="internshipRegdCntrl?page=saveShowNextInternshipRegd&opr=edit&id=<%=internshipRegd1.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn">Edit</button></a></td>
<td><a href="internshipRegdCntrl?page=saveShowNextInternshipRegd&opr=delete&id=<%=internshipRegd1.getId()%>&pageNo=<%=pageNo%>&limit=<%=limit%>"><button type="button" class="btn1">Delete</button></a></td>
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
