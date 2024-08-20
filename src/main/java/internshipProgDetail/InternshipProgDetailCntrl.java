package internshipProgDetail;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class InternshipProgDetailCntrl
 */
@WebServlet("/internship/internshipProgDetail/internshipProgDetailCntrl")
public class InternshipProgDetailCntrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InternshipProgDetailCntrl() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page= request.getParameter("page");
		String opr = request.getParameter("opr");
		int pageNo = (null==request.getParameter("pageNo")?0:Integer.parseInt(request.getParameter("pageNo")));
		int limit= (null==request.getParameter("pageNo")?0:Integer.parseInt(request.getParameter("limit")));
		
		RequestDispatcher rd;
		InternshipProgDetailDBService internshipProgDetailDBService =new InternshipProgDetailDBService();
		InternshipProgDetail internshipProgDetail =new InternshipProgDetail();
		//Action for close buttons
		String homeURL=(null==request.getSession().getAttribute("homeURL")?"":(String)request.getSession().getAttribute("homeURL"));		
		if(page.equals("internshipProgDetailDashboard"))
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipProgDetailCntrl?page="+page+"&opr=showAll&pageNo="+pageNo+"&limit="+limit;
			request.getSession().setAttribute("homeURL",homeURL);
			
			if(opr.equals("showAll")) 
			{
				ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
				
				if(pageNo==0)
				internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList();
				else { //pagination
					int totalPages= internshipProgDetailDBService.getTotalPages(limit);
					internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipProgDetailList",internshipProgDetailList);
				rd = request.getRequestDispatcher("internshipProgDetailDashboard.jsp");
				rd.forward(request, response);
			} 
			else if(opr.equals("addNew")) //CREATE
			{
				internshipProgDetail.setDefaultValues();
				internshipProgDetail.displayValues();
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("addNewInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("edit")) //UPDATE
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail = internshipProgDetailDBService.getInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("updateInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
			//Begin: modified by Dr PNH on 06-12-2022
			else if(opr.equals("editNext")) //Save and Next
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail = internshipProgDetailDBService.getInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("updateNextInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("saveShowNext")) //Save, show & next
			{
				internshipProgDetail.setDefaultValues();
				internshipProgDetail.displayValues();
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				
				ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
				
				if(pageNo==0)
				internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList();
				else { //pagination
					int totalPages= internshipProgDetailDBService.getTotalPages(limit);
					internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipProgDetailList",internshipProgDetailList);
				rd = request.getRequestDispatcher("saveShowNextInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
			//End: modified by Dr PNH on 06-12-2022
			else if(opr.equals("delete")) //DELETE
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail.setId(id);
				internshipProgDetailDBService.deleteInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("deleteInternshipProgDetailSuccess.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("view")) //READ
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail = internshipProgDetailDBService.getInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("viewInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(page.equals("addNewInternshipProgDetail")) 
		{
			if(opr.equals("save"))
			{
				internshipProgDetail.setRequestParam(request);
				internshipProgDetail.displayValues();
				internshipProgDetailDBService.createInternshipProgDetail(internshipProgDetail);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				if(pageNo!=0) {//pagination
					int totalPages= internshipProgDetailDBService.getTotalPages(limit);
					homeURL="internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=showAll&pageNo="+totalPages+"&limit="+limit;
					request.getSession().setAttribute("homeURL", homeURL);
				}
				rd = request.getRequestDispatcher("addNewInternshipProgDetailSuccess.jsp");
				rd.forward(request, response);
			}
		}
		//Begin: modified by Dr PNH on 06-12-2022
		else if(page.equals("updateNextInternshipProgDetail")) 
		{
			if(opr.equals("update"))
			{
				internshipProgDetail.setRequestParam(request);
				internshipProgDetailDBService.updateInternshipProgDetail(internshipProgDetail);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				request.getSession().setAttribute("msg", "Record saved successfully");
				response.sendRedirect("internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=editNext&pageNo=0&limit=0&id=10");			}
		}
		else if(page.equals("saveShowNextInternshipProgDetail")) 
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0";
			request.getSession().setAttribute("homeURL",homeURL);
			if(opr.equals("addNew")) //save new record
			{
				internshipProgDetail.setRequestParam(request);
				internshipProgDetail.displayValues();
				internshipProgDetailDBService.createInternshipProgDetail(internshipProgDetail);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				if(pageNo!=0) {//pagination
					int totalPages= internshipProgDetailDBService.getTotalPages(limit);
					homeURL="internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=showAll&pageNo="+totalPages+"&limit="+limit;
					request.getSession().setAttribute("homeURL", homeURL);
				}
				request.getSession().setAttribute("msg", "Record saved successfully");
				response.sendRedirect("internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
				//rd = request.getRequestDispatcher("internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
				//rd.forward(request, response);
			}
			else if(opr.equals("edit"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail = internshipProgDetailDBService.getInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				
				ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
				if(pageNo==0)
				internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList();
				else { //pagination
					int totalPages= internshipProgDetailDBService.getTotalPages(limit);
					internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipProgDetailList",internshipProgDetailList);
				rd = request.getRequestDispatcher("saveShowNextInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("update"))
			{
				internshipProgDetail.setRequestParam(request);
				internshipProgDetailDBService.updateInternshipProgDetail(internshipProgDetail);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				request.getSession().setAttribute("msg", "Record updated successfully");
				response.sendRedirect("internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
			}
			else if(opr.equals("delete"))
			{
					int id = Integer.parseInt(request.getParameter("id"));
					internshipProgDetail.setId(id);
					internshipProgDetailDBService.deleteInternshipProgDetail(id);
					request.setAttribute("internshipProgDetail",internshipProgDetail);
					request.getSession().setAttribute("msg", "Record deleted successfully");
					response.sendRedirect("internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");		
			}
			else if(opr.equals("reset")||opr.equals("cancel"))
			{
					response.sendRedirect("internshipProgDetailCntrl?page=internshipProgDetailDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");		
			}
			
		}
		//End: modified by Dr PNH on 06-12-2022
		else if(page.equals("updateInternshipProgDetail")) 
		{
			if(opr.equals("update"))
			{
				internshipProgDetail.setRequestParam(request);
				internshipProgDetailDBService.updateInternshipProgDetail(internshipProgDetail);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("updateInternshipProgDetailSuccess.jsp");
				rd.forward(request, response);
			}
		}
		else if(page.equals("viewInternshipProgDetail")) 
		{
			if(opr.equals("print")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail = internshipProgDetailDBService.getInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("printInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
		}
		else if(page.equals("searchInternshipProgDetail"))
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipProgDetailCntrl?page="+page+"&opr=showAll&pageNo="+pageNo+"&limit="+limit;
			request.getSession().setAttribute("homeURL",homeURL);
			if(opr.equals("search")) 
			{
				internshipProgDetail.setRequestParam(request);
				internshipProgDetail.displayValues();
				request.getSession().setAttribute("internshipProgDetailSearch",internshipProgDetail);
				request.setAttribute("opr","search");
				ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
				if(pageNo==0)
				internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail);
				else { //pagination
					int totalPages=0;
					if(limit==0)
					totalPages=0;
					else
					totalPages=internshipProgDetailDBService.getTotalPages(internshipProgDetail,limit);
					pageNo=1;
					internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipProgDetailList",internshipProgDetailList);
				rd = request.getRequestDispatcher("searchInternshipProgDetail.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
//begin:code for download/print button
			else if(opr.equals("downloadPrint")) 
			{
				internshipProgDetail.setRequestParam(request);
				internshipProgDetail.displayValues();
				request.getSession().setAttribute("internshipProgDetailSearch",internshipProgDetail);
				request.setAttribute("opr","internshipProgDetail");
				ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
				if(pageNo==0)
				internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail);
				else { //pagination
					int totalPages=0;
					if(limit==0)
					totalPages=0;
					else
					totalPages=internshipProgDetailDBService.getTotalPages(internshipProgDetail,limit);
					pageNo=1;
					internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipProgDetailList",internshipProgDetailList);
				rd = request.getRequestDispatcher("searchInternshipProgDetailDownloadPrint.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			//end:code for download/print button
			
			else if(opr.equals("showAll")) 
			{
				internshipProgDetail=(InternshipProgDetail)request.getSession().getAttribute("internshipProgDetailSearch");
				ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
				if(pageNo==0)
				internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail);
				else { //pagination
					int totalPages= internshipProgDetailDBService.getTotalPages(internshipProgDetail,limit);
					internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipProgDetailList",internshipProgDetailList);
				rd = request.getRequestDispatcher("searchInternshipProgDetail.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("searchNext")||opr.equals("searchPrev")||opr.equals("searchFirst")||opr.equals("searchLast")) 
			{
				request.setAttribute("opr","search");
				internshipProgDetail=(InternshipProgDetail)request.getSession().getAttribute("internshipProgDetailSearch");
				ArrayList<InternshipProgDetail> internshipProgDetailList =new ArrayList<InternshipProgDetail>();
				if(pageNo==0)
				internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail);
				else { //pagination
					int totalPages= internshipProgDetailDBService.getTotalPages(internshipProgDetail,limit);
					internshipProgDetailList = internshipProgDetailDBService.getInternshipProgDetailList(internshipProgDetail,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipProgDetailList",internshipProgDetailList);
				rd = request.getRequestDispatcher("searchInternshipProgDetail.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("showNone"))
			{
				internshipProgDetail.setDefaultValues();
				internshipProgDetail.displayValues();
				request.getSession().setAttribute("internshipProgDetailSearch",internshipProgDetail);
				request.setAttribute("opr","showNone");
				rd = request.getRequestDispatcher("searchInternshipProgDetail.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("edit")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail = internshipProgDetailDBService.getInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("updateInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("delete")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail.setId(id);
				internshipProgDetailDBService.deleteInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("deleteInternshipProgDetailSuccess.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("view")) 
			{
 			int id = Integer.parseInt(request.getParameter("id"));
				internshipProgDetail = internshipProgDetailDBService.getInternshipProgDetail(id);
				request.setAttribute("internshipProgDetail",internshipProgDetail);
				rd = request.getRequestDispatcher("viewInternshipProgDetail.jsp");
				rd.forward(request, response);
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void main(String[] args) throws URISyntaxException {
		URI uri = new URI("page=updateInternshipProgDetail&opr=close&homePage=internshipProgDetailDashboard");
		String v = uri.getQuery();
		
	}
}
