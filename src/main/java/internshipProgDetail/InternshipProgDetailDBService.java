package internshipProgDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
public class InternshipProgDetailDBService {
	Connection con;
	
	
	public InternshipProgDetailDBService()
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
		String query="select count(*) from Internship_prog_detail";
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
	public int getTotalPages(InternshipProgDetail internshipProgDetail,int limit)
	{
		String query=getDynamicQuery2(internshipProgDetail);
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
	
	
	public int getInternshipProgDetailId(InternshipProgDetail internshipProgDetail)
	{
		int id=0;
		String query="select id from Internship_prog_detail";
String whereClause = " where "+ "code=? and value=? and sessionYear=? and prgTitle=? and fromDt=? and toDt=? and prgCoord=? and venue=? and target=? and status=? and CoordState=? and facultyList=? and nameExpert=? and minSeat=? and maxSeat=? and updateBy=? and updateDt=? and trainingMode=? and certiTempl=? and circularNo=? and circularDt=? and trainingType=? and trainingDuration=? and minQualification=? and trainingName=? and deptCoordinating=?";
	    query+=whereClause;
		System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipProgDetail.getCode());
pstmt.setString(2, internshipProgDetail.getValue());
pstmt.setString(3, internshipProgDetail.getSessionYear());
pstmt.setString(4, internshipProgDetail.getPrgTitle());
pstmt.setDate(5, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDt())));
pstmt.setDate(6, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDt())));
pstmt.setInt(7, internshipProgDetail.getPrgCoord());
pstmt.setString(8, internshipProgDetail.getVenue());
pstmt.setString(9, internshipProgDetail.getTarget());
pstmt.setString(10, internshipProgDetail.getStatus());
pstmt.setString(11, internshipProgDetail.getCoordState());
pstmt.setInt(12, internshipProgDetail.getFacultyList());
pstmt.setString(13, internshipProgDetail.getNameExpert());
pstmt.setInt(14, internshipProgDetail.getMinSeat());
pstmt.setInt(15, internshipProgDetail.getMaxSeat());
pstmt.setString(16, internshipProgDetail.getUpdateBy());
pstmt.setDate(17, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDt())));
pstmt.setString(18, internshipProgDetail.getTrainingMode());
pstmt.setString(19, internshipProgDetail.getCertiTempl());
pstmt.setString(20, internshipProgDetail.getCircularNo());
pstmt.setDate(21, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDt())));
pstmt.setString(22, internshipProgDetail.getTrainingType());
pstmt.setString(23, internshipProgDetail.getTrainingDuration());
pstmt.setString(24, internshipProgDetail.getMinQualification());
pstmt.setString(25, internshipProgDetail.getTrainingName());
pstmt.setString(26, internshipProgDetail.getDeptCoordinating());
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
	public void createInternshipProgDetail(InternshipProgDetail internshipProgDetail)
	{
		
String query="INSERT INTO Internship_prog_detail(code,value,sessionYear,prgTitle,fromDt,toDt,prgCoord,venue,target,status,CoordState,facultyList,nameExpert,minSeat,maxSeat,updateBy,updateDt,trainingMode,certiTempl,circularNo,circularDt,trainingType,trainingDuration,minQualification,trainingName,deptCoordinating) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
    System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipProgDetail.getCode());
pstmt.setString(2, internshipProgDetail.getValue());
pstmt.setString(3, internshipProgDetail.getSessionYear());
pstmt.setString(4, internshipProgDetail.getPrgTitle());
pstmt.setDate(5, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDt())));
pstmt.setDate(6, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDt())));
pstmt.setInt(7, internshipProgDetail.getPrgCoord());
pstmt.setString(8, internshipProgDetail.getVenue());
pstmt.setString(9, internshipProgDetail.getTarget());
pstmt.setString(10, internshipProgDetail.getStatus());
pstmt.setString(11, internshipProgDetail.getCoordState());
pstmt.setInt(12, internshipProgDetail.getFacultyList());
pstmt.setString(13, internshipProgDetail.getNameExpert());
pstmt.setInt(14, internshipProgDetail.getMinSeat());
pstmt.setInt(15, internshipProgDetail.getMaxSeat());
pstmt.setString(16, internshipProgDetail.getUpdateBy());
pstmt.setDate(17, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDt())));
pstmt.setString(18, internshipProgDetail.getTrainingMode());
pstmt.setString(19, internshipProgDetail.getCertiTempl());
pstmt.setString(20, internshipProgDetail.getCircularNo());
pstmt.setDate(21, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDt())));
pstmt.setString(22, internshipProgDetail.getTrainingType());
pstmt.setString(23, internshipProgDetail.getTrainingDuration());
pstmt.setString(24, internshipProgDetail.getMinQualification());
pstmt.setString(25, internshipProgDetail.getTrainingName());
pstmt.setString(26, internshipProgDetail.getDeptCoordinating());
	    int x = pstmt.executeUpdate();
	    }
	    catch (Exception e) {
	  
  	System.out.println(e);
		}
		int id = getInternshipProgDetailId(internshipProgDetail);
		internshipProgDetail.setId(id);
	}
	public void updateInternshipProgDetail(InternshipProgDetail internshipProgDetail)
	{
		
String query="update Internship_prog_detail set "+"code=?,value=?,sessionYear=?,prgTitle=?,fromDt=?,toDt=?,prgCoord=?,venue=?,target=?,status=?,CoordState=?,facultyList=?,nameExpert=?,minSeat=?,maxSeat=?,updateBy=?,updateDt=?,trainingMode=?,certiTempl=?,circularNo=?,circularDt=?,trainingType=?,trainingDuration=?,minQualification=?,trainingName=?,deptCoordinating=? where id=?";
	   
 System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipProgDetail.getCode());
pstmt.setString(2, internshipProgDetail.getValue());
pstmt.setString(3, internshipProgDetail.getSessionYear());
pstmt.setString(4, internshipProgDetail.getPrgTitle());
pstmt.setDate(5, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDt())));
pstmt.setDate(6, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDt())));
pstmt.setInt(7, internshipProgDetail.getPrgCoord());
pstmt.setString(8, internshipProgDetail.getVenue());
pstmt.setString(9, internshipProgDetail.getTarget());
pstmt.setString(10, internshipProgDetail.getStatus());
pstmt.setString(11, internshipProgDetail.getCoordState());
pstmt.setInt(12, internshipProgDetail.getFacultyList());
pstmt.setString(13, internshipProgDetail.getNameExpert());
pstmt.setInt(14, internshipProgDetail.getMinSeat());
pstmt.setInt(15, internshipProgDetail.getMaxSeat());
pstmt.setString(16, internshipProgDetail.getUpdateBy());
pstmt.setDate(17, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDt())));
pstmt.setString(18, internshipProgDetail.getTrainingMode());
pstmt.setString(19, internshipProgDetail.getCertiTempl());
pstmt.setString(20, internshipProgDetail.getCircularNo());
pstmt.setDate(21, java.sql.Date.valueOf(DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDt())));
pstmt.setString(22, internshipProgDetail.getTrainingType());
pstmt.setString(23, internshipProgDetail.getTrainingDuration());
pstmt.setString(24, internshipProgDetail.getMinQualification());
pstmt.setString(25, internshipProgDetail.getTrainingName());
pstmt.setString(26, internshipProgDetail.getDeptCoordinating());
pstmt.setInt(27, internshipProgDetail.getId());
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
	
	public InternshipProgDetail getInternshipProgDetail(int id)
	{
		InternshipProgDetail internshipProgDetail =new InternshipProgDetail();
		String query="select * from Internship_prog_detail where id="+id;
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	
	
internshipProgDetail.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipProgDetail.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipProgDetail.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipProgDetail.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipProgDetail.setSessionYearValue(rs.getString("sessionYear")==null?"":getValue(rs.getString("sessionYear"),"dd_sessionYear"));
internshipProgDetail.setPrgTitle(rs.getString("prgTitle")==null?"":rs.getString("prgTitle"));
internshipProgDetail.setFromDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("fromDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("fromDt")));
internshipProgDetail.setToDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("toDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("toDt")));
internshipProgDetail.setPrgCoord(rs.getInt("prgCoord")==0?0:rs.getInt("prgCoord"));
internshipProgDetail.setVenue(rs.getString("venue")==null?"":rs.getString("venue"));
internshipProgDetail.setTarget(rs.getString("target")==null?"":rs.getString("target"));
internshipProgDetail.setStatus(rs.getString("status")==null?"":rs.getString("status"));
internshipProgDetail.setCoordState(rs.getString("CoordState")==null?"":rs.getString("CoordState"));
internshipProgDetail.setFacultyList(rs.getInt("facultyList")==0?0:rs.getInt("facultyList"));
internshipProgDetail.setNameExpert(rs.getString("nameExpert")==null?"":rs.getString("nameExpert"));
internshipProgDetail.setMinSeat(rs.getInt("minSeat")==0?0:rs.getInt("minSeat"));
internshipProgDetail.setMaxSeat(rs.getInt("maxSeat")==0?0:rs.getInt("maxSeat"));
internshipProgDetail.setUpdateBy(rs.getString("updateBy")==null?"":rs.getString("updateBy"));
internshipProgDetail.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipProgDetail.setTrainingMode(rs.getString("trainingMode")==null?"":rs.getString("trainingMode"));
internshipProgDetail.setCertiTempl(rs.getString("certiTempl")==null?"":rs.getString("certiTempl"));
internshipProgDetail.setCircularNo(rs.getString("circularNo")==null?"":rs.getString("circularNo"));
internshipProgDetail.setCircularDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("circularDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("circularDt")));
internshipProgDetail.setTrainingType(rs.getString("trainingType")==null?"":rs.getString("trainingType"));
internshipProgDetail.setTrainingDuration(rs.getString("trainingDuration")==null?"":rs.getString("trainingDuration"));
internshipProgDetail.setMinQualification(rs.getString("minQualification")==null?"":rs.getString("minQualification"));
internshipProgDetail.setTrainingName(rs.getString("trainingName")==null?"":rs.getString("trainingName"));
internshipProgDetail.setDeptCoordinating(rs.getString("deptCoordinating")==null?"":rs.getString("deptCoordinating"));
	    	
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipProgDetail;
	}
	
	
	public ArrayList<InternshipProgDetail> getInternshipProgDetailList()
	{
		ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
		String query="select * from Internship_prog_detail";
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    while(rs.next()) {
	    	InternshipProgDetail internshipProgDetail =new InternshipProgDetail();
internshipProgDetail.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipProgDetail.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipProgDetail.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipProgDetail.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipProgDetail.setSessionYearValue(rs.getString("sessionYear")==null?"":getValue(rs.getString("sessionYear"),"dd_sessionYear"));
internshipProgDetail.setPrgTitle(rs.getString("prgTitle")==null?"":rs.getString("prgTitle"));
internshipProgDetail.setFromDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("fromDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("fromDt")));
internshipProgDetail.setToDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("toDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("toDt")));
internshipProgDetail.setPrgCoord(rs.getInt("prgCoord")==0?0:rs.getInt("prgCoord"));
internshipProgDetail.setVenue(rs.getString("venue")==null?"":rs.getString("venue"));
internshipProgDetail.setTarget(rs.getString("target")==null?"":rs.getString("target"));
internshipProgDetail.setStatus(rs.getString("status")==null?"":rs.getString("status"));
internshipProgDetail.setCoordState(rs.getString("CoordState")==null?"":rs.getString("CoordState"));
internshipProgDetail.setFacultyList(rs.getInt("facultyList")==0?0:rs.getInt("facultyList"));
internshipProgDetail.setNameExpert(rs.getString("nameExpert")==null?"":rs.getString("nameExpert"));
internshipProgDetail.setMinSeat(rs.getInt("minSeat")==0?0:rs.getInt("minSeat"));
internshipProgDetail.setMaxSeat(rs.getInt("maxSeat")==0?0:rs.getInt("maxSeat"));
internshipProgDetail.setUpdateBy(rs.getString("updateBy")==null?"":rs.getString("updateBy"));
internshipProgDetail.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipProgDetail.setTrainingMode(rs.getString("trainingMode")==null?"":rs.getString("trainingMode"));
internshipProgDetail.setCertiTempl(rs.getString("certiTempl")==null?"":rs.getString("certiTempl"));
internshipProgDetail.setCircularNo(rs.getString("circularNo")==null?"":rs.getString("circularNo"));
internshipProgDetail.setCircularDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("circularDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("circularDt")));
internshipProgDetail.setTrainingType(rs.getString("trainingType")==null?"":rs.getString("trainingType"));
internshipProgDetail.setTrainingDuration(rs.getString("trainingDuration")==null?"":rs.getString("trainingDuration"));
internshipProgDetail.setMinQualification(rs.getString("minQualification")==null?"":rs.getString("minQualification"));
internshipProgDetail.setTrainingName(rs.getString("trainingName")==null?"":rs.getString("trainingName"));
internshipProgDetail.setDeptCoordinating(rs.getString("deptCoordinating")==null?"":rs.getString("deptCoordinating"));
	    	internshipProgDetailList.add(internshipProgDetail);
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipProgDetailList;
	}
	
	public ArrayList<InternshipProgDetail> getInternshipProgDetailList(int pageNo,int limit)
	{
		ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
String query="select * from Internship_prog_detail limit "+limit +" offset "+limit*(pageNo-1);
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    while(rs.next()) {
	    	InternshipProgDetail internshipProgDetail =new InternshipProgDetail();
internshipProgDetail.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipProgDetail.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipProgDetail.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipProgDetail.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipProgDetail.setSessionYearValue(rs.getString("sessionYear")==null?"":getValue(rs.getString("sessionYear"),"dd_sessionYear"));
internshipProgDetail.setPrgTitle(rs.getString("prgTitle")==null?"":rs.getString("prgTitle"));
internshipProgDetail.setFromDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("fromDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("fromDt")));
internshipProgDetail.setToDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("toDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("toDt")));
internshipProgDetail.setPrgCoord(rs.getInt("prgCoord")==0?0:rs.getInt("prgCoord"));
internshipProgDetail.setVenue(rs.getString("venue")==null?"":rs.getString("venue"));
internshipProgDetail.setTarget(rs.getString("target")==null?"":rs.getString("target"));
internshipProgDetail.setStatus(rs.getString("status")==null?"":rs.getString("status"));
internshipProgDetail.setCoordState(rs.getString("CoordState")==null?"":rs.getString("CoordState"));
internshipProgDetail.setFacultyList(rs.getInt("facultyList")==0?0:rs.getInt("facultyList"));
internshipProgDetail.setNameExpert(rs.getString("nameExpert")==null?"":rs.getString("nameExpert"));
internshipProgDetail.setMinSeat(rs.getInt("minSeat")==0?0:rs.getInt("minSeat"));
internshipProgDetail.setMaxSeat(rs.getInt("maxSeat")==0?0:rs.getInt("maxSeat"));
internshipProgDetail.setUpdateBy(rs.getString("updateBy")==null?"":rs.getString("updateBy"));
internshipProgDetail.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipProgDetail.setTrainingMode(rs.getString("trainingMode")==null?"":rs.getString("trainingMode"));
internshipProgDetail.setCertiTempl(rs.getString("certiTempl")==null?"":rs.getString("certiTempl"));
internshipProgDetail.setCircularNo(rs.getString("circularNo")==null?"":rs.getString("circularNo"));
internshipProgDetail.setCircularDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("circularDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("circularDt")));
internshipProgDetail.setTrainingType(rs.getString("trainingType")==null?"":rs.getString("trainingType"));
internshipProgDetail.setTrainingDuration(rs.getString("trainingDuration")==null?"":rs.getString("trainingDuration"));
internshipProgDetail.setMinQualification(rs.getString("minQualification")==null?"":rs.getString("minQualification"));
internshipProgDetail.setTrainingName(rs.getString("trainingName")==null?"":rs.getString("trainingName"));
internshipProgDetail.setDeptCoordinating(rs.getString("deptCoordinating")==null?"":rs.getString("deptCoordinating"));
	    	internshipProgDetailList.add(internshipProgDetail);
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipProgDetailList;
	}
	
	public void deleteInternshipProgDetail(int id) {
		
			String query="delete from Internship_prog_detail where id="+id;
		    System.out.println(query);
				
			
		    try {
			Statement stmt = con.createStatement();
		    int x = stmt.executeUpdate(query);
		    }
		    catch (Exception e) {
		    	System.out.println(e);
			}
		
	}
	
public String getDynamicQuery(InternshipProgDetail internshipProgDetail)
{
String query="select * from Internship_prog_detail ";
String whereClause="";
whereClause+=(internshipProgDetail.getId()==0?"":" id="+internshipProgDetail.getId());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCode()||internshipProgDetail.getCode().equals(""))?"":" code='"+internshipProgDetail.getCode()+"'";
else
whereClause+=(null==internshipProgDetail.getCode()||internshipProgDetail.getCode().equals(""))?"":" and code='"+internshipProgDetail.getCode()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getValue()||internshipProgDetail.getValue().equals(""))?"":" value='"+internshipProgDetail.getValue()+"'";
else
whereClause+=(null==internshipProgDetail.getValue()||internshipProgDetail.getValue().equals(""))?"":" and value='"+internshipProgDetail.getValue()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getSessionYear()||internshipProgDetail.getSessionYear().equals(""))?"":" sessionYear='"+internshipProgDetail.getSessionYear()+"'";
else
whereClause+=(null==internshipProgDetail.getSessionYear()||internshipProgDetail.getSessionYear().equals(""))?"":" and sessionYear='"+internshipProgDetail.getSessionYear()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getPrgTitle()||internshipProgDetail.getPrgTitle().equals(""))?"":" prgTitle='"+internshipProgDetail.getPrgTitle()+"'";
else
whereClause+=(null==internshipProgDetail.getPrgTitle()||internshipProgDetail.getPrgTitle().equals(""))?"":" and prgTitle='"+internshipProgDetail.getPrgTitle()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getFromDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom()).equals("1111-11-11"))?"":" (fromDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getFromDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom()).equals("1111-11-11"))?"":" and (fromDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getToDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom()).equals("1111-11-11"))?"":" (toDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getToDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom()).equals("1111-11-11"))?"":" and (toDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getPrgCoord()==0?"":" prgCoord="+internshipProgDetail.getPrgCoord());
else
whereClause+=(internshipProgDetail.getPrgCoord()==0?"":" and prgCoord="+internshipProgDetail.getPrgCoord());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getVenue()||internshipProgDetail.getVenue().equals(""))?"":" venue='"+internshipProgDetail.getVenue()+"'";
else
whereClause+=(null==internshipProgDetail.getVenue()||internshipProgDetail.getVenue().equals(""))?"":" and venue='"+internshipProgDetail.getVenue()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTarget()||internshipProgDetail.getTarget().equals(""))?"":" target='"+internshipProgDetail.getTarget()+"'";
else
whereClause+=(null==internshipProgDetail.getTarget()||internshipProgDetail.getTarget().equals(""))?"":" and target='"+internshipProgDetail.getTarget()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getStatus()||internshipProgDetail.getStatus().equals(""))?"":" status='"+internshipProgDetail.getStatus()+"'";
else
whereClause+=(null==internshipProgDetail.getStatus()||internshipProgDetail.getStatus().equals(""))?"":" and status='"+internshipProgDetail.getStatus()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCoordState()||internshipProgDetail.getCoordState().equals(""))?"":" CoordState='"+internshipProgDetail.getCoordState()+"'";
else
whereClause+=(null==internshipProgDetail.getCoordState()||internshipProgDetail.getCoordState().equals(""))?"":" and CoordState='"+internshipProgDetail.getCoordState()+"'";
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getFacultyList()==0?"":" facultyList="+internshipProgDetail.getFacultyList());
else
whereClause+=(internshipProgDetail.getFacultyList()==0?"":" and facultyList="+internshipProgDetail.getFacultyList());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getNameExpert()||internshipProgDetail.getNameExpert().equals(""))?"":" nameExpert='"+internshipProgDetail.getNameExpert()+"'";
else
whereClause+=(null==internshipProgDetail.getNameExpert()||internshipProgDetail.getNameExpert().equals(""))?"":" and nameExpert='"+internshipProgDetail.getNameExpert()+"'";
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getMinSeat()==0?"":" minSeat="+internshipProgDetail.getMinSeat());
else
whereClause+=(internshipProgDetail.getMinSeat()==0?"":" and minSeat="+internshipProgDetail.getMinSeat());
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getMaxSeat()==0?"":" maxSeat="+internshipProgDetail.getMaxSeat());
else
whereClause+=(internshipProgDetail.getMaxSeat()==0?"":" and maxSeat="+internshipProgDetail.getMaxSeat());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getUpdateBy()||internshipProgDetail.getUpdateBy().equals(""))?"":" updateBy='"+internshipProgDetail.getUpdateBy()+"'";
else
whereClause+=(null==internshipProgDetail.getUpdateBy()||internshipProgDetail.getUpdateBy().equals(""))?"":" and updateBy='"+internshipProgDetail.getUpdateBy()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getUpdateDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom()).equals("1111-11-11"))?"":" (updateDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getUpdateDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom()).equals("1111-11-11"))?"":" and (updateDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingMode()||internshipProgDetail.getTrainingMode().equals(""))?"":" trainingMode='"+internshipProgDetail.getTrainingMode()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingMode()||internshipProgDetail.getTrainingMode().equals(""))?"":" and trainingMode='"+internshipProgDetail.getTrainingMode()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCertiTempl()||internshipProgDetail.getCertiTempl().equals(""))?"":" certiTempl='"+internshipProgDetail.getCertiTempl()+"'";
else
whereClause+=(null==internshipProgDetail.getCertiTempl()||internshipProgDetail.getCertiTempl().equals(""))?"":" and certiTempl='"+internshipProgDetail.getCertiTempl()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCircularNo()||internshipProgDetail.getCircularNo().equals(""))?"":" circularNo='"+internshipProgDetail.getCircularNo()+"'";
else
whereClause+=(null==internshipProgDetail.getCircularNo()||internshipProgDetail.getCircularNo().equals(""))?"":" and circularNo='"+internshipProgDetail.getCircularNo()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCircularDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom()).equals("1111-11-11"))?"":" (circularDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getCircularDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom()).equals("1111-11-11"))?"":" and (circularDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingType()||internshipProgDetail.getTrainingType().equals(""))?"":" trainingType='"+internshipProgDetail.getTrainingType()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingType()||internshipProgDetail.getTrainingType().equals(""))?"":" and trainingType='"+internshipProgDetail.getTrainingType()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingDuration()||internshipProgDetail.getTrainingDuration().equals(""))?"":" trainingDuration='"+internshipProgDetail.getTrainingDuration()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingDuration()||internshipProgDetail.getTrainingDuration().equals(""))?"":" and trainingDuration='"+internshipProgDetail.getTrainingDuration()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getMinQualification()||internshipProgDetail.getMinQualification().equals(""))?"":" minQualification='"+internshipProgDetail.getMinQualification()+"'";
else
whereClause+=(null==internshipProgDetail.getMinQualification()||internshipProgDetail.getMinQualification().equals(""))?"":" and minQualification='"+internshipProgDetail.getMinQualification()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingName()||internshipProgDetail.getTrainingName().equals(""))?"":" trainingName='"+internshipProgDetail.getTrainingName()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingName()||internshipProgDetail.getTrainingName().equals(""))?"":" and trainingName='"+internshipProgDetail.getTrainingName()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getDeptCoordinating()||internshipProgDetail.getDeptCoordinating().equals(""))?"":" deptCoordinating='"+internshipProgDetail.getDeptCoordinating()+"'";
else
whereClause+=(null==internshipProgDetail.getDeptCoordinating()||internshipProgDetail.getDeptCoordinating().equals(""))?"":" and deptCoordinating='"+internshipProgDetail.getDeptCoordinating()+"'";
if(!whereClause.equals(""))
query+=" where "+whereClause;
System.out.println("Search Query= "+query);
    return query;
}
public String getDynamicQuery2(InternshipProgDetail internshipProgDetail)
{
String query="select count(*) from Internship_prog_detail ";
String whereClause="";
whereClause+=(internshipProgDetail.getId()==0?"":" id="+internshipProgDetail.getId());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCode()||internshipProgDetail.getCode().equals(""))?"":" code='"+internshipProgDetail.getCode()+"'";
else
whereClause+=(null==internshipProgDetail.getCode()||internshipProgDetail.getCode().equals(""))?"":" and code='"+internshipProgDetail.getCode()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getValue()||internshipProgDetail.getValue().equals(""))?"":" value='"+internshipProgDetail.getValue()+"'";
else
whereClause+=(null==internshipProgDetail.getValue()||internshipProgDetail.getValue().equals(""))?"":" and value='"+internshipProgDetail.getValue()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getSessionYear()||internshipProgDetail.getSessionYear().equals(""))?"":" sessionYear='"+internshipProgDetail.getSessionYear()+"'";
else
whereClause+=(null==internshipProgDetail.getSessionYear()||internshipProgDetail.getSessionYear().equals(""))?"":" and sessionYear='"+internshipProgDetail.getSessionYear()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getPrgTitle()||internshipProgDetail.getPrgTitle().equals(""))?"":" prgTitle='"+internshipProgDetail.getPrgTitle()+"'";
else
whereClause+=(null==internshipProgDetail.getPrgTitle()||internshipProgDetail.getPrgTitle().equals(""))?"":" and prgTitle='"+internshipProgDetail.getPrgTitle()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getFromDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom()).equals("1111-11-11"))?"":" (fromDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getFromDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom()).equals("1111-11-11"))?"":" and (fromDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getFromDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getToDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom()).equals("1111-11-11"))?"":" (toDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getToDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom()).equals("1111-11-11"))?"":" and (toDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getToDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getPrgCoord()==0?"":" prgCoord="+internshipProgDetail.getPrgCoord());
else
whereClause+=(internshipProgDetail.getPrgCoord()==0?"":" and prgCoord="+internshipProgDetail.getPrgCoord());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getVenue()||internshipProgDetail.getVenue().equals(""))?"":" venue='"+internshipProgDetail.getVenue()+"'";
else
whereClause+=(null==internshipProgDetail.getVenue()||internshipProgDetail.getVenue().equals(""))?"":" and venue='"+internshipProgDetail.getVenue()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTarget()||internshipProgDetail.getTarget().equals(""))?"":" target='"+internshipProgDetail.getTarget()+"'";
else
whereClause+=(null==internshipProgDetail.getTarget()||internshipProgDetail.getTarget().equals(""))?"":" and target='"+internshipProgDetail.getTarget()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getStatus()||internshipProgDetail.getStatus().equals(""))?"":" status='"+internshipProgDetail.getStatus()+"'";
else
whereClause+=(null==internshipProgDetail.getStatus()||internshipProgDetail.getStatus().equals(""))?"":" and status='"+internshipProgDetail.getStatus()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCoordState()||internshipProgDetail.getCoordState().equals(""))?"":" CoordState='"+internshipProgDetail.getCoordState()+"'";
else
whereClause+=(null==internshipProgDetail.getCoordState()||internshipProgDetail.getCoordState().equals(""))?"":" and CoordState='"+internshipProgDetail.getCoordState()+"'";
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getFacultyList()==0?"":" facultyList="+internshipProgDetail.getFacultyList());
else
whereClause+=(internshipProgDetail.getFacultyList()==0?"":" and facultyList="+internshipProgDetail.getFacultyList());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getNameExpert()||internshipProgDetail.getNameExpert().equals(""))?"":" nameExpert='"+internshipProgDetail.getNameExpert()+"'";
else
whereClause+=(null==internshipProgDetail.getNameExpert()||internshipProgDetail.getNameExpert().equals(""))?"":" and nameExpert='"+internshipProgDetail.getNameExpert()+"'";
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getMinSeat()==0?"":" minSeat="+internshipProgDetail.getMinSeat());
else
whereClause+=(internshipProgDetail.getMinSeat()==0?"":" and minSeat="+internshipProgDetail.getMinSeat());
if(whereClause.equals(""))
whereClause+=(internshipProgDetail.getMaxSeat()==0?"":" maxSeat="+internshipProgDetail.getMaxSeat());
else
whereClause+=(internshipProgDetail.getMaxSeat()==0?"":" and maxSeat="+internshipProgDetail.getMaxSeat());
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getUpdateBy()||internshipProgDetail.getUpdateBy().equals(""))?"":" updateBy='"+internshipProgDetail.getUpdateBy()+"'";
else
whereClause+=(null==internshipProgDetail.getUpdateBy()||internshipProgDetail.getUpdateBy().equals(""))?"":" and updateBy='"+internshipProgDetail.getUpdateBy()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getUpdateDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom()).equals("1111-11-11"))?"":" (updateDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getUpdateDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom()).equals("1111-11-11"))?"":" and (updateDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getUpdateDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingMode()||internshipProgDetail.getTrainingMode().equals(""))?"":" trainingMode='"+internshipProgDetail.getTrainingMode()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingMode()||internshipProgDetail.getTrainingMode().equals(""))?"":" and trainingMode='"+internshipProgDetail.getTrainingMode()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCertiTempl()||internshipProgDetail.getCertiTempl().equals(""))?"":" certiTempl='"+internshipProgDetail.getCertiTempl()+"'";
else
whereClause+=(null==internshipProgDetail.getCertiTempl()||internshipProgDetail.getCertiTempl().equals(""))?"":" and certiTempl='"+internshipProgDetail.getCertiTempl()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCircularNo()||internshipProgDetail.getCircularNo().equals(""))?"":" circularNo='"+internshipProgDetail.getCircularNo()+"'";
else
whereClause+=(null==internshipProgDetail.getCircularNo()||internshipProgDetail.getCircularNo().equals(""))?"":" and circularNo='"+internshipProgDetail.getCircularNo()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getCircularDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom()).equals("1111-11-11"))?"":" (circularDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtTo())+"')";
else
whereClause+=(null==internshipProgDetail.getCircularDtFrom()||DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom()).equals("1111-11-11"))?"":" and (circularDt between '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtFrom())+"' and '"+DateService.getDTSYYYMMDDFormat(internshipProgDetail.getCircularDtTo())+"')";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingType()||internshipProgDetail.getTrainingType().equals(""))?"":" trainingType='"+internshipProgDetail.getTrainingType()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingType()||internshipProgDetail.getTrainingType().equals(""))?"":" and trainingType='"+internshipProgDetail.getTrainingType()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingDuration()||internshipProgDetail.getTrainingDuration().equals(""))?"":" trainingDuration='"+internshipProgDetail.getTrainingDuration()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingDuration()||internshipProgDetail.getTrainingDuration().equals(""))?"":" and trainingDuration='"+internshipProgDetail.getTrainingDuration()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getMinQualification()||internshipProgDetail.getMinQualification().equals(""))?"":" minQualification='"+internshipProgDetail.getMinQualification()+"'";
else
whereClause+=(null==internshipProgDetail.getMinQualification()||internshipProgDetail.getMinQualification().equals(""))?"":" and minQualification='"+internshipProgDetail.getMinQualification()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getTrainingName()||internshipProgDetail.getTrainingName().equals(""))?"":" trainingName='"+internshipProgDetail.getTrainingName()+"'";
else
whereClause+=(null==internshipProgDetail.getTrainingName()||internshipProgDetail.getTrainingName().equals(""))?"":" and trainingName='"+internshipProgDetail.getTrainingName()+"'";
if(whereClause.equals(""))
whereClause+=(null==internshipProgDetail.getDeptCoordinating()||internshipProgDetail.getDeptCoordinating().equals(""))?"":" deptCoordinating='"+internshipProgDetail.getDeptCoordinating()+"'";
else
whereClause+=(null==internshipProgDetail.getDeptCoordinating()||internshipProgDetail.getDeptCoordinating().equals(""))?"":" and deptCoordinating='"+internshipProgDetail.getDeptCoordinating()+"'";
if(!whereClause.equals(""))
query+=" where "+whereClause;
System.out.println("Search Query= "+query);
    return query;
}
public ArrayList<InternshipProgDetail> getInternshipProgDetailList(InternshipProgDetail internshipProgDetail)
{
ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
String query=getDynamicQuery(internshipProgDetail);
System.out.println("Search Query= "+query);
try {
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
while(rs.next()) {
InternshipProgDetail internshipProgDetail2 =new InternshipProgDetail();
internshipProgDetail2.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipProgDetail2.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipProgDetail2.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipProgDetail2.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipProgDetail2.setSessionYearValue(rs.getString("sessionYear")==null?"":getValue(rs.getString("sessionYear"),"dd_sessionYear"));
internshipProgDetail2.setPrgTitle(rs.getString("prgTitle")==null?"":rs.getString("prgTitle"));
internshipProgDetail2.setFromDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("fromDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("fromDt")));
internshipProgDetail2.setToDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("toDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("toDt")));
internshipProgDetail2.setPrgCoord(rs.getInt("prgCoord")==0?0:rs.getInt("prgCoord"));
internshipProgDetail2.setVenue(rs.getString("venue")==null?"":rs.getString("venue"));
internshipProgDetail2.setTarget(rs.getString("target")==null?"":rs.getString("target"));
internshipProgDetail2.setStatus(rs.getString("status")==null?"":rs.getString("status"));
internshipProgDetail2.setCoordState(rs.getString("CoordState")==null?"":rs.getString("CoordState"));
internshipProgDetail2.setFacultyList(rs.getInt("facultyList")==0?0:rs.getInt("facultyList"));
internshipProgDetail2.setNameExpert(rs.getString("nameExpert")==null?"":rs.getString("nameExpert"));
internshipProgDetail2.setMinSeat(rs.getInt("minSeat")==0?0:rs.getInt("minSeat"));
internshipProgDetail2.setMaxSeat(rs.getInt("maxSeat")==0?0:rs.getInt("maxSeat"));
internshipProgDetail2.setUpdateBy(rs.getString("updateBy")==null?"":rs.getString("updateBy"));
internshipProgDetail2.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipProgDetail2.setTrainingMode(rs.getString("trainingMode")==null?"":rs.getString("trainingMode"));
internshipProgDetail2.setCertiTempl(rs.getString("certiTempl")==null?"":rs.getString("certiTempl"));
internshipProgDetail2.setCircularNo(rs.getString("circularNo")==null?"":rs.getString("circularNo"));
internshipProgDetail2.setCircularDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("circularDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("circularDt")));
internshipProgDetail2.setTrainingType(rs.getString("trainingType")==null?"":rs.getString("trainingType"));
internshipProgDetail2.setTrainingDuration(rs.getString("trainingDuration")==null?"":rs.getString("trainingDuration"));
internshipProgDetail2.setMinQualification(rs.getString("minQualification")==null?"":rs.getString("minQualification"));
internshipProgDetail2.setTrainingName(rs.getString("trainingName")==null?"":rs.getString("trainingName"));
internshipProgDetail2.setDeptCoordinating(rs.getString("deptCoordinating")==null?"":rs.getString("deptCoordinating"));
    	internshipProgDetailList.add(internshipProgDetail2);
    }
	}
    catch (Exception e) {
    	System.out.println(e);
	}
    return internshipProgDetailList;
}
	
public ArrayList<InternshipProgDetail> getInternshipProgDetailList(InternshipProgDetail internshipProgDetail,int pageNo,int limit)
{
ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
String query=getDynamicQuery(internshipProgDetail);
query+= " limit "+limit +" offset "+limit*(pageNo-1);
System.out.println("Search Query= "+query);
try {
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
while(rs.next()) {
InternshipProgDetail internshipProgDetail2 =new InternshipProgDetail();
internshipProgDetail2.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipProgDetail2.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipProgDetail2.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipProgDetail2.setSessionYear(rs.getString("sessionYear")==null?"":rs.getString("sessionYear"));
internshipProgDetail2.setSessionYearValue(rs.getString("sessionYear")==null?"":getValue(rs.getString("sessionYear"),"dd_sessionYear"));
internshipProgDetail2.setPrgTitle(rs.getString("prgTitle")==null?"":rs.getString("prgTitle"));
internshipProgDetail2.setFromDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("fromDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("fromDt")));
internshipProgDetail2.setToDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("toDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("toDt")));
internshipProgDetail2.setPrgCoord(rs.getInt("prgCoord")==0?0:rs.getInt("prgCoord"));
internshipProgDetail2.setVenue(rs.getString("venue")==null?"":rs.getString("venue"));
internshipProgDetail2.setTarget(rs.getString("target")==null?"":rs.getString("target"));
internshipProgDetail2.setStatus(rs.getString("status")==null?"":rs.getString("status"));
internshipProgDetail2.setCoordState(rs.getString("CoordState")==null?"":rs.getString("CoordState"));
internshipProgDetail2.setFacultyList(rs.getInt("facultyList")==0?0:rs.getInt("facultyList"));
internshipProgDetail2.setNameExpert(rs.getString("nameExpert")==null?"":rs.getString("nameExpert"));
internshipProgDetail2.setMinSeat(rs.getInt("minSeat")==0?0:rs.getInt("minSeat"));
internshipProgDetail2.setMaxSeat(rs.getInt("maxSeat")==0?0:rs.getInt("maxSeat"));
internshipProgDetail2.setUpdateBy(rs.getString("updateBy")==null?"":rs.getString("updateBy"));
internshipProgDetail2.setUpdateDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("updateDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("updateDt")));
internshipProgDetail2.setTrainingMode(rs.getString("trainingMode")==null?"":rs.getString("trainingMode"));
internshipProgDetail2.setCertiTempl(rs.getString("certiTempl")==null?"":rs.getString("certiTempl"));
internshipProgDetail2.setCircularNo(rs.getString("circularNo")==null?"":rs.getString("circularNo"));
internshipProgDetail2.setCircularDt(DateService.getDTDYYYYMMDDFormat(rs.getDate("circularDt")==null?DateService.getDefaultDtYYYYMMDD():rs.getDate("circularDt")));
internshipProgDetail2.setTrainingType(rs.getString("trainingType")==null?"":rs.getString("trainingType"));
internshipProgDetail2.setTrainingDuration(rs.getString("trainingDuration")==null?"":rs.getString("trainingDuration"));
internshipProgDetail2.setMinQualification(rs.getString("minQualification")==null?"":rs.getString("minQualification"));
internshipProgDetail2.setTrainingName(rs.getString("trainingName")==null?"":rs.getString("trainingName"));
internshipProgDetail2.setDeptCoordinating(rs.getString("deptCoordinating")==null?"":rs.getString("deptCoordinating"));
    	internshipProgDetailList.add(internshipProgDetail2);
    }
	}
    catch (Exception e) {
    	System.out.println(e);
	}
    return internshipProgDetailList;
}
	
	
	public static void main(String[] args) {
		
		InternshipProgDetailDBService internshipProgDetailDBService =new InternshipProgDetailDBService();
		
		
		
		 //Test-1 : Create InternshipProgDetail
		  
		  InternshipProgDetail internshipProgDetail = new InternshipProgDetail(); internshipProgDetail.setDefaultValues();
		  internshipProgDetailDBService.createInternshipProgDetail(internshipProgDetail);
		  
		 ArrayList<InternshipProgDetail> internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList();
		InternshipProgDetailService internshipProgDetailService =new InternshipProgDetailService();
		internshipProgDetailService.displayList(internshipProgDetailList);
		
	}
}
