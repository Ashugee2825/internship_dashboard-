package internshipCoordinator;

import java.util.ArrayList;

public class InternshipCoordinatorService {

	public void displayList(ArrayList<InternshipCoordinator> internshipCoordinatorList)
	{
		internshipCoordinatorList.forEach((internshipCoordinator) -> print(internshipCoordinator));
	}
	
	public void print(InternshipCoordinator internshipCoordinator)
	{
		internshipCoordinator.displayValues();
	}
	
}
