package internshipRegd;

import java.util.ArrayList;

public class InternshipRegdService {

	public void displayList(ArrayList<InternshipRegd> internshipRegdList)
	{
		internshipRegdList.forEach((internshipRegd) -> print(internshipRegd));
	}
	
	public void print(InternshipRegd internshipRegd)
	{
		internshipRegd.displayValues();
	}
	
}
