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
<!--  Begin: Data Table -->
<link rel="shortcut icon" type="image/png" href="/media/images/favicon.png">
<link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="http://www.datatables.net/rss.xml">
<link rel="stylesheet" type="text/css" href="/media/css/site-examples.css?_=11229a4cc52ab488c3d6ed72e1ec231e1">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/2.2.3/css/buttons.dataTables.min.css">
<style type="text/css" class="init">
</style>
<script type="text/javascript" src="/media/js/site.js?_=d279d6aa7c08459eca950dd4a9ff4b23"></script>
<script src="https://media.ethicalads.io/media/client/ethicalads.min.js"></script>
<script type="text/javascript" src="/media/js/dynamic.php?comments-page=extensions%2Fbuttons%2Fexamples%2Finitialisation%2Fexport.html" async></script>
<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.2.3/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.2.3/js/buttons.html5.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.2.3/js/buttons.print.min.js"></script>
<script type="text/javascript" class="init">
$(document).ready(function() {
$('#example').DataTable( {
    dom: 'Bfrtip',
    "bPaginate": false,
    buttons: [
        'copy', 'csv', 'excel', 'pdf', 'print'
    ]
} );
} );
</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
 <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
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
<div align="center">
    
    <!-- begin: side navigation -->
    <!-- end: side navigation -->
    <!--  begin: main content -->
    <div class="flex-item" align="center">
    
    <h1>Download/Print</h1>
    <!--  Begin: Dynamic Codes -->
<br/>
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
 </tr>
 </thead>
 <% String opr= (String)request.getAttribute("opr"); %>
<%if(null==opr||!opr.equals("showNone")) { %>
<% ArrayList<InternshipProgDetail> internshipProgDetailList = (ArrayList<InternshipProgDetail>)request.getAttribute("internshipProgDetailList"); %>
    <% Iterator<InternshipProgDetail> it2= internshipProgDetailList.iterator(); %>
 <tbody>
<% int count=1; %>
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
