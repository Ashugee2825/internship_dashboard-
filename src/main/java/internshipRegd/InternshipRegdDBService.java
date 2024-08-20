package internshipRegd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
public class InternshipRegdDBService {
	Connection con;
	
	
	public InternshipRegdDBService()
	{
		DBConnectionDTO conDTO = new DBConnectionDTO();
		con=conDTO.getConnection();
	}
	
	public void closeConnection()
	{
		try {
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
public int getTotalPages(int limit)
	{
		String query="select count(*) from internship_regd";
	    int totalRecords=0;
	    int totalPages=0;
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	totalRecords= rs.getInt(1);
	    }
	    stmt.close();
	    rs.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		totalPages=totalRecords/limit;
		if(totalRecords%limit!=0)
		{
			totalPages+=1;
		}
		return totalPages;
	}
	
	//pagination
	public int getTotalPages(InternshipRegd internshipRegd,int limit)
	{
		String query=getDynamicQuery2(internshipRegd);
		int totalRecords=0;
	    int totalPages=0;
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	totalRecords= rs.getInt(1);
	    }
	    stmt.close();
	    rs.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		totalPages=totalRecords/limit;
		if(totalRecords%limit!=0)
		{
			totalPages+=1;
		}
		return totalPages;
	}
	
	
	public int getInternshipRegdId(InternshipRegd internshipRegd)
	{
		int id=0;
		String query="select id from internship_regd";
String whereClause = " where "+ "sessionYear=? and prgId=? and regId=? and studentName=? and email=? and mobileNo=? and fatherName=? and instituteName=? and instituteWeb=? and course=? and courseYear=? and courseBranch=? and localAddress=? and permAddress=? and city=? and distt=? and state=? and pin=? and gender=? and category=? and lodging=? and updatedBy=? and updateDt=? and updateTime=? and remark=? and batch=?";
	    query+=whereClause;
		System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipRegd.getSessionYear());
pstmt.setString(2, internshipRegd.getPrgId());
pstmt.setInt(3, internshipRegd.getRegId());
pstmt.setString(4, internshipRegd.getStudentName());
pstmt.setString(5, internshipRegd.getEmail());
pstmt.setString(6, internshipRegd.getMobileNo());
pstmt.setString(7, internshipRegd.getFatherName());
pstmt.setString(8, internshipRegd.getInstituteName());
pstmt.setString(9, internshipRegd.getInstituteWeb());
pstmt.setString(10, internshipRegd.getCourse());
pstmt.setString(11, internshipRegd.getCourseYear());
pstmt.setString(12, internshipRegd.getCourseBranch());
pstmt.setString(13, internshipRegd.getLocalAddress());
pstmt.setString(14, internshipRegd.getPermAddress());
pstmt.setString(15, internshipRegd.getCity());
pstmt.setString(16, internshipRegd.getDistt());
pstmt.setString(17, internshipRegd.getState());
pstmt.setString(18, internshipRegd.getPin());
pstmt.setString(19, internshipRegd.getGender());
pstmt.setString(20, internshipRegd.getCategory());
pstmt.setString(21, internshipRegd.getLodging());
pstmt.setString(22, internshipRegd.getUpdatedBy());
pstmt.setDate(23, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipRegd.getUpdateDt())));
pstmt.setString(24, internshipRegd.getUpdateTime());
pstmt.setString(25, internshipRegd.getRemark());
pstmt.setString(26, internshipRegd.getBatch());
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	       	id = rs.getInt("id");
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return id;
	}
	public void createInternshipRegd(InternshipRegd internshipRegd)
	{
		
String query="INSERT INTO internship_regd(sessionYear,prgId,regId,studentName,email,mobileNo,fatherName,instituteName,instituteWeb,course,courseYear,courseBranch,localAddress,permAddress,city,distt,state,pin,gender,category,lodging,updatedBy,updateDt,updateTime,remark,batch) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
    System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipRegd.getSessionYear());
pstmt.setString(2, internshipRegd.getPrgId());
pstmt.setInt(3, internshipRegd.getRegId());
pstmt.setString(4, internshipRegd.getStudentName());
pstmt.setString(5, internshipRegd.getEmail());
pstmt.setString(6, internshipRegd.getMobileNo());
pstmt.setString(7, internshipRegd.getFatherName());
pstmt.setString(8, internshipRegd.getInstituteName());
pstmt.setString(9, internshipRegd.getInstituteWeb());
pstmt.setString(10, internshipRegd.getCourse());
pstmt.setString(11, internshipRegd.getCourseYear());
pstmt.setString(12, internshipRegd.getCourseBranch());
pstmt.setString(13, internshipRegd.getLocalAddress());
pstmt.setString(14, internshipRegd.getPermAddress());
pstmt.setString(15, internshipRegd.getCity());
pstmt.setString(16, internshipRegd.getDistt());
pstmt.setString(17, internshipRegd.getState());
pstmt.setString(18, internshipRegd.getPin());
pstmt.setString(19, internshipRegd.getGender());
pstmt.setString(20, internshipRegd.getCategory());
pstmt.setString(21, internshipRegd.getLodging());
pstmt.setString(22, internshipRegd.getUpdatedBy());
pstmt.setDate(23, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipRegd.getUpdateDt())));
pstmt.setString(24, internshipRegd.getUpdateTime());
pstmt.setString(25, internshipRegd.getRemark());
pstmt.setString(26, internshipRegd.getBatch());
	    int x = pstmt.executeUpdate();
	    }
	    catch (Exception e) {
	  
  	System.out.println(e);
		}
		int id = getInternshipRegdId(internshipRegd);
		internshipRegd.setId(id);
	}
	public void updateInternshipRegd(InternshipRegd internshipRegd)
	{
		
String query="update internship_regd set "+"sessionYear=?,prgId=?,regId=?,studentName=?,email=?,mobileNo=?,fatherName=?,instituteName=?,instituteWeb=?,course=?,courseYear=?,courseBranch=?,localAddress=?,permAddress=?,city=?,distt=?,state=?,pin=?,gender=?,category=?,lodging=?,updatedBy=?,updateDt=?,updateTime=?,remark=?,batch=? where id=?";
	   
 System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipRegd.getSessionYear());
pstmt.setString(2, internshipRegd.getPrgId());
pstmt.setInt(3, internshipRegd.getRegId());
pstmt.setString(4, internshipRegd.getStudentName());
pstmt.setString(5, internshipRegd.getEmail());
pstmt.setString(6, internshipRegd.getMobileNo());
pstmt.setString(7, internshipRegd.getFatherName());
pstmt.setString(8, internshipRegd.getInstituteName());
pstmt.setString(9, internshipRegd.getInstituteWeb());
pstmt.setString(10, internshipRegd.getCourse());
pstmt.setString(11, internshipRegd.getCourseYear());
pstmt.setString(12, internshipRegd.getCourseBranch());
pstmt.setString(13, internshipRegd.getLocalAddress());
pstmt.setString(14, internshipRegd.getPermAddress());
pstmt.setString(15, internshipRegd.getCity());
pstmt.setString(16, internshipRegd.getDistt());
pstmt.setString(17, internshipRegd.getState());
pstmt.setString(18, internshipRegd.getPin());
pstmt.setString(19, internshipRegd.getGender());
pstmt.setString(20, internshipRegd.getCategory());
pstmt.setString(21, internshipRegd.getLodging());
pstmt.setString(22, internshipRegd.getUpdatedBy());
pstmt.setDate(23, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipRegd.getUpdateDt())));
pstmt.setString(24, internshipRegd.getUpdateTime());
pstmt.setString(25, internshipRegd.getRemark());
pstmt.setString(26, internshipRegd.getBatch());
pstmt.setInt(27, internshipRegd.getId());
	    int x = pstmt.executeUpdate();
	    }
	    catch (Exception e) {
	    	System.out.println(e);
		}
		
	}
	public String getValue(String code,String table) {
		
		String value="";
		String query="select value from "+table+" where code='"+code+"'";
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	
	    	value=rs.getString("value");
	    }
		}
		catch (Exception e) {
			System.out.println(e);
		}
	    return value;
	}
	
	public InternshipRegd getInternshipRegd(int id)
	{
		InternshipRegd internshipRegd =new InternshipRegd();
		String query="select * from internship_regd where id="+id;
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	
	
internshipRegd.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipRegd.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipRegd.setPrgId(rs.getString("prgId")==null?"":rs.getString("prgId"));
internshipRegd.setRegId(rs.getInt("regId")==0?0:rs.getInt("regId"));
internshipRegd.setStudentName(rs.getString("studentName")==null?"":rs.getString("studentName"));
internshipRegd.setEmail(rs.getString("email")==null?"":rs.getString("email"));
internshipRegd.setMobileNo(rs.getString("mobileNo")==null?"":rs.getString("mobileNo"));
internshipRegd.setFatherName(rs.getString("fatherName")==null?"":rs.getString("fatherName"));
internshipRegd.setInstituteName(rs.getString("instituteName")==null?"":rs.getString("instituteName"));
internshipRegd.setInstituteWeb(rs.getString("instituteWeb")==null?"":rs.getString("instituteWeb"));
internshipRegd.setCourse(rs.getString("course")==null?"":rs.getString("course"));
internshipRegd.setCourseValue(rs.getString("course")==null?"":getValue(rs.getString("course"),"dd_course"));
internshipRegd.setCourseYear(rs.getString("courseYear")==null?"":rs.getString("courseYear"));
internshipRegd.setCourseYearValue(rs.getString("courseYear")==null?"":getValue(rs.getString("courseYear"),"dd_courseYear"));
internshipRegd.setCourseBranch(rs.getString("courseBranch")==null?"":rs.getString("courseBranch"));
internshipRegd.setLocalAddress(rs.getString("localAddress")==null?"":rs.getString("localAddress"));
internshipRegd.setPermAddress(rs.getString("permAddress")==null?"":rs.getString("permAddress"));
internshipRegd.setCity(rs.getString("city")==null?"":rs.getString("city"));
internshipRegd.setDistt(rs.getString("distt")==null?"":rs.getString("distt"));
internshipRegd.setState(rs.getString("state")==null?"":rs.getString("state"));
internshipRegd.setStateValue(rs.getString("state")==null?"":getValue(rs.getString("state"),"dd_state"));
internshipRegd.setPin(rs.getString("pin")==null?"":rs.getString("pin"));
internshipRegd.setGender(rs.getString("gender")==null?"":rs.getString("gender"));
internshipRegd.setGenderValue(rs.getString("gender")==null?"":getValue(rs.getString("gender"),"dd_gender"));
internshipRegd.setCategory(rs.getString("category")==null?"":rs.getString("category"));
internshipRegd.setLodging(rs.getString("lodging")==null?"":rs.getString("lodging"));
internshipRegd.setUpdatedBy(rs.getString("updatedBy")==null?"":rs.getString("updatedBy"));
internshipRegd.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipRegd.setUpdateTime(rs.getString("updateTime")==null?"":rs.getString("updateTime"));
internshipRegd.setRemark(rs.getString("remark")==null?"":rs.getString("remark"));
internshipRegd.setBatch(rs.getString("batch")==null?"":rs.getString("batch"));
	    	
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipRegd;
	}
	
	
	public ArrayList<InternshipRegd> getInternshipRegdList()
	{
		ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
		String query="select * from internship_regd";
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    while(rs.next()) {
	    	InternshipRegd internshipRegd =new InternshipRegd();
internshipRegd.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipRegd.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipRegd.setPrgId(rs.getString("prgId")==null?"":rs.getString("prgId"));
internshipRegd.setRegId(rs.getInt("regId")==0?0:rs.getInt("regId"));
internshipRegd.setStudentName(rs.getString("studentName")==null?"":rs.getString("studentName"));
internshipRegd.setEmail(rs.getString("email")==null?"":rs.getString("email"));
internshipRegd.setMobileNo(rs.getString("mobileNo")==null?"":rs.getString("mobileNo"));
internshipRegd.setFatherName(rs.getString("fatherName")==null?"":rs.getString("fatherName"));
internshipRegd.setInstituteName(rs.getString("instituteName")==null?"":rs.getString("instituteName"));
internshipRegd.setInstituteWeb(rs.getString("instituteWeb")==null?"":rs.getString("instituteWeb"));
internshipRegd.setCourse(rs.getString("course")==null?"":rs.getString("course"));
internshipRegd.setCourseValue(rs.getString("course")==null?"":getValue(rs.getString("course"),"dd_course"));
internshipRegd.setCourseYear(rs.getString("courseYear")==null?"":rs.getString("courseYear"));
internshipRegd.setCourseYearValue(rs.getString("courseYear")==null?"":getValue(rs.getString("courseYear"),"dd_courseYear"));
internshipRegd.setCourseBranch(rs.getString("courseBranch")==null?"":rs.getString("courseBranch"));
internshipRegd.setLocalAddress(rs.getString("localAddress")==null?"":rs.getString("localAddress"));
internshipRegd.setPermAddress(rs.getString("permAddress")==null?"":rs.getString("permAddress"));
internshipRegd.setCity(rs.getString("city")==null?"":rs.getString("city"));
internshipRegd.setDistt(rs.getString("distt")==null?"":rs.getString("distt"));
internshipRegd.setState(rs.getString("state")==null?"":rs.getString("state"));
internshipRegd.setStateValue(rs.getString("state")==null?"":getValue(rs.getString("state"),"dd_state"));
internshipRegd.setPin(rs.getString("pin")==null?"":rs.getString("pin"));
internshipRegd.setGender(rs.getString("gender")==null?"":rs.getString("gender"));
internshipRegd.setGenderValue(rs.getString("gender")==null?"":getValue(rs.getString("gender"),"dd_gender"));
internshipRegd.setCategory(rs.getString("category")==null?"":rs.getString("category"));
internshipRegd.setLodging(rs.getString("lodging")==null?"":rs.getString("lodging"));
internshipRegd.setUpdatedBy(rs.getString("updatedBy")==null?"":rs.getString("updatedBy"));
internshipRegd.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipRegd.setUpdateTime(rs.getString("updateTime")==null?"":rs.getString("updateTime"));
internshipRegd.setRemark(rs.getString("remark")==null?"":rs.getString("remark"));
internshipRegd.setBatch(rs.getString("batch")==null?"":rs.getString("batch"));
	    	internshipRegdList.add(internshipRegd);
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipRegdList;
	}
	
	public ArrayList<InternshipRegd> getInternshipRegdList(int pageNo,int limit)
	{
		ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
String query="select * from internship_regd limit "+limit +" offset "+limit*(pageNo-1);
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    while(rs.next()) {
	    	InternshipRegd internshipRegd =new InternshipRegd();
internshipRegd.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipRegd.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipRegd.setPrgId(rs.getString("prgId")==null?"":rs.getString("prgId"));
internshipRegd.setRegId(rs.getInt("regId")==0?0:rs.getInt("regId"));
internshipRegd.setStudentName(rs.getString("studentName")==null?"":rs.getString("studentName"));
internshipRegd.setEmail(rs.getString("email")==null?"":rs.getString("email"));
internshipRegd.setMobileNo(rs.getString("mobileNo")==null?"":rs.getString("mobileNo"));
internshipRegd.setFatherName(rs.getString("fatherName")==null?"":rs.getString("fatherName"));
internshipRegd.setInstituteName(rs.getString("instituteName")==null?"":rs.getString("instituteName"));
internshipRegd.setInstituteWeb(rs.getString("instituteWeb")==null?"":rs.getString("instituteWeb"));
internshipRegd.setCourse(rs.getString("course")==null?"":rs.getString("course"));
internshipRegd.setCourseValue(rs.getString("course")==null?"":getValue(rs.getString("course"),"dd_course"));
internshipRegd.setCourseYear(rs.getString("courseYear")==null?"":rs.getString("courseYear"));
internshipRegd.setCourseYearValue(rs.getString("courseYear")==null?"":getValue(rs.getString("courseYear"),"dd_courseYear"));
internshipRegd.setCourseBranch(rs.getString("courseBranch")==null?"":rs.getString("courseBranch"));
internshipRegd.setLocalAddress(rs.getString("localAddress")==null?"":rs.getString("localAddress"));
internshipRegd.setPermAddress(rs.getString("permAddress")==null?"":rs.getString("permAddress"));
internshipRegd.setCity(rs.getString("city")==null?"":rs.getString("city"));
internshipRegd.setDistt(rs.getString("distt")==null?"":rs.getString("distt"));
internshipRegd.setState(rs.getString("state")==null?"":rs.getString("state"));
internshipRegd.setStateValue(rs.getString("state")==null?"":getValue(rs.getString("state"),"dd_state"));
internshipRegd.setPin(rs.getString("pin")==null?"":rs.getString("pin"));
internshipRegd.setGender(rs.getString("gender")==null?"":rs.getString("gender"));
internshipRegd.setGenderValue(rs.getString("gender")==null?"":getValue(rs.getString("gender"),"dd_gender"));
internshipRegd.setCategory(rs.getString("category")==null?"":rs.getString("category"));
internshipRegd.setLodging(rs.getString("lodging")==null?"":rs.getString("lodging"));
internshipRegd.setUpdatedBy(rs.getString("updatedBy")==null?"":rs.getString("updatedBy"));
internshipRegd.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipRegd.setUpdateTime(rs.getString("updateTime")==null?"":rs.getString("updateTime"));
internshipRegd.setRemark(rs.getString("remark")==null?"":rs.getString("remark"));
internshipRegd.setBatch(rs.getString("batch")==null?"":rs.getString("batch"));
	    	internshipRegdList.add(internshipRegd);
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipRegdList;
	}
	
	public void deleteInternshipRegd(int id) {
		
			String query="delete from internship_regd where id="+id;
		    System.out.println(query);
				
			
		    try {
			Statement stmt = con.createStatement();
		    int x = stmt.executeUpdate(query);
		    }
		    catch (Exception e) {
		    	System.out.println(e);
			}
		
	}
	
public String getDynamicQuery(InternshipRegd internshipRegd)
{
String query="select * from internship_regd ";
String whereClause="";
whereClause+=(internshipRegd.getId()==0?"":" id="+internshipRegd.getId());
if(!whereClause.equals(""))
query+=" where "+whereClause;
System.out.println("Search Query= "+query);
    return query;
}
public String getDynamicQuery2(InternshipRegd internshipRegd)
{
String query="select count(*) from internship_regd ";
String whereClause="";
whereClause+=(internshipRegd.getId()==0?"":" id="+internshipRegd.getId());
if(!whereClause.equals(""))
query+=" where "+whereClause;
System.out.println("Search Query= "+query);
    return query;
}
public ArrayList<InternshipRegd> getInternshipRegdList(InternshipRegd internshipRegd)
{
ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
String query=getDynamicQuery(internshipRegd);
System.out.println("Search Query= "+query);
try {
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
while(rs.next()) {
InternshipRegd internshipRegd2 =new InternshipRegd();
internshipRegd2.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipRegd2.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipRegd2.setPrgId(rs.getString("prgId")==null?"":rs.getString("prgId"));
internshipRegd2.setRegId(rs.getInt("regId")==0?0:rs.getInt("regId"));
internshipRegd2.setStudentName(rs.getString("studentName")==null?"":rs.getString("studentName"));
internshipRegd2.setEmail(rs.getString("email")==null?"":rs.getString("email"));
internshipRegd2.setMobileNo(rs.getString("mobileNo")==null?"":rs.getString("mobileNo"));
internshipRegd2.setFatherName(rs.getString("fatherName")==null?"":rs.getString("fatherName"));
internshipRegd2.setInstituteName(rs.getString("instituteName")==null?"":rs.getString("instituteName"));
internshipRegd2.setInstituteWeb(rs.getString("instituteWeb")==null?"":rs.getString("instituteWeb"));
internshipRegd2.setCourse(rs.getString("course")==null?"":rs.getString("course"));
internshipRegd2.setCourseValue(rs.getString("course")==null?"":getValue(rs.getString("course"),"dd_course"));
internshipRegd2.setCourseYear(rs.getString("courseYear")==null?"":rs.getString("courseYear"));
internshipRegd2.setCourseYearValue(rs.getString("courseYear")==null?"":getValue(rs.getString("courseYear"),"dd_courseYear"));
internshipRegd2.setCourseBranch(rs.getString("courseBranch")==null?"":rs.getString("courseBranch"));
internshipRegd2.setLocalAddress(rs.getString("localAddress")==null?"":rs.getString("localAddress"));
internshipRegd2.setPermAddress(rs.getString("permAddress")==null?"":rs.getString("permAddress"));
internshipRegd2.setCity(rs.getString("city")==null?"":rs.getString("city"));
internshipRegd2.setDistt(rs.getString("distt")==null?"":rs.getString("distt"));
internshipRegd2.setState(rs.getString("state")==null?"":rs.getString("state"));
internshipRegd2.setStateValue(rs.getString("state")==null?"":getValue(rs.getString("state"),"dd_state"));
internshipRegd2.setPin(rs.getString("pin")==null?"":rs.getString("pin"));
internshipRegd2.setGender(rs.getString("gender")==null?"":rs.getString("gender"));
internshipRegd2.setGenderValue(rs.getString("gender")==null?"":getValue(rs.getString("gender"),"dd_gender"));
internshipRegd2.setCategory(rs.getString("category")==null?"":rs.getString("category"));
internshipRegd2.setLodging(rs.getString("lodging")==null?"":rs.getString("lodging"));
internshipRegd2.setUpdatedBy(rs.getString("updatedBy")==null?"":rs.getString("updatedBy"));
internshipRegd2.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipRegd2.setUpdateTime(rs.getString("updateTime")==null?"":rs.getString("updateTime"));
internshipRegd2.setRemark(rs.getString("remark")==null?"":rs.getString("remark"));
internshipRegd2.setBatch(rs.getString("batch")==null?"":rs.getString("batch"));
    	internshipRegdList.add(internshipRegd2);
    }
	}
    catch (Exception e) {
    	System.out.println(e);
	}
    return internshipRegdList;
}
	
public ArrayList<InternshipRegd> getInternshipRegdList(InternshipRegd internshipRegd,int pageNo,int limit)
{
ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
String query=getDynamicQuery(internshipRegd);
query+= " limit "+limit +" offset "+limit*(pageNo-1);
System.out.println("Search Query= "+query);
try {
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
while(rs.next()) {
InternshipRegd internshipRegd2 =new InternshipRegd();
internshipRegd2.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipRegd2.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipRegd2.setPrgId(rs.getString("prgId")==null?"":rs.getString("prgId"));
internshipRegd2.setRegId(rs.getInt("regId")==0?0:rs.getInt("regId"));
internshipRegd2.setStudentName(rs.getString("studentName")==null?"":rs.getString("studentName"));
internshipRegd2.setEmail(rs.getString("email")==null?"":rs.getString("email"));
internshipRegd2.setMobileNo(rs.getString("mobileNo")==null?"":rs.getString("mobileNo"));
internshipRegd2.setFatherName(rs.getString("fatherName")==null?"":rs.getString("fatherName"));
internshipRegd2.setInstituteName(rs.getString("instituteName")==null?"":rs.getString("instituteName"));
internshipRegd2.setInstituteWeb(rs.getString("instituteWeb")==null?"":rs.getString("instituteWeb"));
internshipRegd2.setCourse(rs.getString("course")==null?"":rs.getString("course"));
internshipRegd2.setCourseValue(rs.getString("course")==null?"":getValue(rs.getString("course"),"dd_course"));
internshipRegd2.setCourseYear(rs.getString("courseYear")==null?"":rs.getString("courseYear"));
internshipRegd2.setCourseYearValue(rs.getString("courseYear")==null?"":getValue(rs.getString("courseYear"),"dd_courseYear"));
internshipRegd2.setCourseBranch(rs.getString("courseBranch")==null?"":rs.getString("courseBranch"));
internshipRegd2.setLocalAddress(rs.getString("localAddress")==null?"":rs.getString("localAddress"));
internshipRegd2.setPermAddress(rs.getString("permAddress")==null?"":rs.getString("permAddress"));
internshipRegd2.setCity(rs.getString("city")==null?"":rs.getString("city"));
internshipRegd2.setDistt(rs.getString("distt")==null?"":rs.getString("distt"));
internshipRegd2.setState(rs.getString("state")==null?"":rs.getString("state"));
internshipRegd2.setStateValue(rs.getString("state")==null?"":getValue(rs.getString("state"),"dd_state"));
internshipRegd2.setPin(rs.getString("pin")==null?"":rs.getString("pin"));
internshipRegd2.setGender(rs.getString("gender")==null?"":rs.getString("gender"));
internshipRegd2.setGenderValue(rs.getString("gender")==null?"":getValue(rs.getString("gender"),"dd_gender"));
internshipRegd2.setCategory(rs.getString("category")==null?"":rs.getString("category"));
internshipRegd2.setLodging(rs.getString("lodging")==null?"":rs.getString("lodging"));
internshipRegd2.setUpdatedBy(rs.getString("updatedBy")==null?"":rs.getString("updatedBy"));
internshipRegd2.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipRegd2.setUpdateTime(rs.getString("updateTime")==null?"":rs.getString("updateTime"));
internshipRegd2.setRemark(rs.getString("remark")==null?"":rs.getString("remark"));
internshipRegd2.setBatch(rs.getString("batch")==null?"":rs.getString("batch"));
    	internshipRegdList.add(internshipRegd2);
    }
	}
    catch (Exception e) {
    	System.out.println(e);
	}
    return internshipRegdList;
}
	
	
	public static void main(String[] args) {
		
		InternshipRegdDBService internshipRegdDBService =new InternshipRegdDBService();
		
		
		
		 //Test-1 : Create InternshipRegd
		  
		  InternshipRegd internshipRegd = new InternshipRegd(); internshipRegd.setDefaultValues();
		  internshipRegdDBService.createInternshipRegd(internshipRegd);
		  
		 ArrayList<InternshipRegd> internshipRegdList = internshipRegdDBService.getInternshipRegdList();
		InternshipRegdService internshipRegdService =new InternshipRegdService();
		internshipRegdService.displayList(internshipRegdList);
		
	}
}
