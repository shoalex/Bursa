package borsa;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SaveExcel {
	public void saveData() throws Exception{
		try {
			SQLConnect connect = null;
			try {
				connect = new SQLConnect();
			} catch (Exception e1) {
				e1.printStackTrace();
				return;
			}
			PrintWriter out = new PrintWriter("data.xml", "utf-8");
			
			String dataToXMLString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
					+ "<?mso-application progid=\"Excel.Sheet\"?>\n"
					+ "<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\" \n"
					+ "xmlns:o=\"urn:schemas-microsoft-com:office:office\" \n"
					+ "xmlns:x=\"urn:schemas-microsoft-com:office:excel\" \n"
					+ "xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\" \n"
					+ "xmlns:html=\"http://www.w3.org/TR/REC-html40\"> \n";
			try {
				dataToXMLString+=connect.getXMLSubjectsString();
				dataToXMLString+=connect.getXMLPeriodString();
				dataToXMLString+=connect.getXMLPrefferedString();
				dataToXMLString+=connect.getXMLQuestionsString();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		out.println(dataToXMLString+"</Workbook>");
		out.flush();
		out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
