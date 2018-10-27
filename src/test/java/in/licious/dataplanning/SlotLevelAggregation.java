package in.licious.dataplanning;

import in.licious.util.ReadData;

public class SlotLevelAggregation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadData rd = new ReadData();
		
		String excelfilepath=("C:\\Users\\vishwa\\git\\SeleniumWebDriver\\ExcelData\\Data Planning Automation Excel.xlsx");
		
		//String SlotlevelAggregation = null; Pass the null value
		for (int i=1; i<6; i++) {
			
			
			for (int j=1; j<2; j++) {
				
				String aggregationdata=rd.readDataFromExcel(excelfilepath, "SlotlevelAggregation", i, j);
				
				//String aggregationdata1=rd.readDataFromExcel(excelfilepath, "SlotlevelAggregation", i, j);
				
				System.out.println(aggregationdata);
				
				//System.out.println(aggregationdata1);
				
			}
			
			//System.out.println();
			//System.out.println(aggregationdata);
			
		}
		
		//String aggregationdata=rd.readDataFromExcel(excelfilepath, "SlotlevelAggregation", 1, 0);
		
		//String SlotlevelAggregation=null;
		
		// To get the number of rows present in sheet
				//int totalNoOfRows = SlotlevelAggregation.getRows();
		
		//rd.getRows();

		
		//System.out.println(aggregationdata);
		
		

	}

}
