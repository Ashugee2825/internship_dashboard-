package internshipProgDetail;

import java.util.ArrayList;

public class InternshipProgDetailService {

	public void displayList(ArrayList<InternshipProgDetail> internshipProgDetailList)
	{
		internshipProgDetailList.forEach((internshipProgDetail) -> print(internshipProgDetail));
	}
	
	public void print(InternshipProgDetail internshipProgDetail)
	{
		internshipProgDetail.displayValues();
	}
	
}
