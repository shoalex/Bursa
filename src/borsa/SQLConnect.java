package borsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class SQLConnect{

	private Connection connect;

	public static String parameters[];
	private static final String DB_NAME = "bursa";

	private static final String CREATE_TABLE_SUBJECT = "CREATE TABLE IF NOT EXISTS subjects "
			+ "(subject_id INT NOT NULL, "
			+ "sex NVARCHAR(6),"
			+ "age INT,"
			+ "birth_country NVARCHAR(30),"
			+ "aliya_year INT,"
			+ "family_status NVARCHAR(30),"
			+ "education NVARCHAR(30),"
			+ "edu_economics_free_text NVARCHAR(250),"
			+ "income NVARCHAR(30),"
			+ "control_of_stock NVARCHAR(50),"
			+ "involvment_in_stock NVARCHAR(50),"
			+ "email NVARCHAR(50),"
			+ "telephone NVARCHAR(15),"
			+ "PRIMARY KEY (subject_id)"
			+ ");";

	private static final String CREATE_TABLE_PREFFERED = "CREATE TABLE IF NOT EXISTS preffered "
			+ "(sub_id INT NOT NULL, "
			+ "period INT NOT NULL, "
			+ "highest NVARCHAR(1) NOT NULL, "
			+ "high NVARCHAR(1) NOT NULL, "
			+ "unchanged_1 NVARCHAR(1) NOT NULL, "
			+ "unchanged_2 NVARCHAR(1) NOT NULL, "
			+ "low NVARCHAR(1) NOT NULL, "
			+ "lowest NVARCHAR(1) NOT NULL, "
			+ "FOREIGN KEY (sub_id) "
			+ "REFERENCES subjects (subject_id)"
			+ ");";

	private static final String CREATE_TABLE_QUESTIONS = "CREATE TABLE IF NOT EXISTS questions ("
			+"sub_id INT NOT NULL, "
			+"que_id INT NOT NULL, "
			+"ans INT NOT NULL, "
			+"FOREIGN KEY (sub_id) "
			+"REFERENCES subjects (subject_id)"
			+");";

	private static final String CREATE_TABLE_PERIOD = "CREATE TABLE IF NOT EXISTS period ("
			+"sub_id INT NOT NULL, "
			+"period_no INT NOT NULL, "
			+"stock_a INT NOT NULL, "
			+"stock_b INT NOT NULL, "
			+"stock_c INT NOT NULL, "
			+"stock_d INT NOT NULL, "
			+"stock_e INT NOT NULL, "
			+"stock_f INT NOT NULL, "
			+"FOREIGN KEY (sub_id) "
			+"REFERENCES subjects (subject_id) "
			+");";

	private static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS "+DB_NAME;

	public SQLConnect() throws Exception{
		parameters = getParameters();
		Class.forName("com.mysql.jdbc.Driver");
		connect();
		connect.close();
	}

	private void createScheme() throws Exception {
		connect.createStatement().executeUpdate(CREATE_DATABASE);
		connect.createStatement().executeUpdate("USE "+DB_NAME);
		connect.createStatement().executeUpdate(CREATE_TABLE_SUBJECT);
		connect.createStatement().executeUpdate(CREATE_TABLE_PREFFERED);
		connect.createStatement().executeUpdate(CREATE_TABLE_QUESTIONS);
		connect.createStatement().executeUpdate(CREATE_TABLE_PERIOD);
	}

	public void connect() throws Exception {
		connect = DriverManager.getConnection("jdbc:mysql://"+parameters[Cons.IP]+":"+parameters[Cons.PORT]+"?useUnicode=true&characterEncoding=UTF-8&user="+parameters[Cons.USER]+"&password="+parameters[Cons.PASS]);
		try{
			connect.createStatement().executeUpdate("USE "+DB_NAME);
		}catch(Exception e){
			createScheme();
		}
	}

	public void saveSubjectID(int id) throws Exception{
		connect();
		connect.createStatement().executeUpdate("INSERT INTO subjects (subject_id) values("+id+")");
		connect.close();
	}

	public boolean isIDExists(int id) throws Exception {
		connect();
		ResultSet set = connect.createStatement().executeQuery("SELECT * FROM subjects WHERE subject_id="+id);
		if(set.first()){
			connect.close();
			return true;
		}
		connect.close();
		return false;
	}

	public void saveBackground(Subject subject) throws Exception {
		connect();
		connect.createStatement().executeUpdate("UPDATE subjects SET"
				+ " sex=\'"+subject.getBackgroundQuestion().getGender()+"\',"
				+ " age="+subject.getBackgroundQuestion().getAge()+","
				+ " birth_country=\'"+subject.getBackgroundQuestion().getCountry_of_birth()+"\',"
				+ " aliya_year="+subject.getBackgroundQuestion().getYear_of_immigration()+","
				+ " family_status=\'"+subject.getBackgroundQuestion().getFamily_status()+"\',"
				+ " education=\'"+subject.getBackgroundQuestion().getEductionLevel()+"\',"
				+ " edu_economics_free_text=\'"+subject.getBackgroundQuestion().getIs_academic_degree()+"\',"
				+ " income=\'"+subject.getBackgroundQuestion().getIncome()+"\',"
				+ " control_of_stock=\'"+subject.getBackgroundQuestion().getLevel_of_control_capital_market()+"\',"
				+ " involvment_in_stock=\'"+subject.getBackgroundQuestion().getFrequently_involved_capital_market()+"\'"
				+ " WHERE subject_id="+subject.getSubjectId());
		connect.close();
	}
	
	public void saveEmail(Subject subject) throws Exception{
		connect();
		connect.createStatement().executeUpdate("UPDATE subjects SET"
				+ " email=\'"+subject.getEmail()+"\',"
				+ " telephone=\'"+subject.getPhone()+"\'"
				+ "WHERE subject_id="+subject.getSubjectId());
		connect.close();
	}

	public void savePerionds(Subject subject) throws Exception {
		
		connect();
		for(int i=1;i<subject.getPeriods().length;i++){
			String sql = "INSERT INTO period VALUES("
					+ subject.getSubjectId()+", "
					+ i+", ";
			for(int j=0;j<subject.getPeriods()[i].getChanges().length;j++){
				sql+=subject.getPeriods()[i].getChanges()[j];
				if(j==subject.getPeriods()[i].getChanges().length-1){ 
					sql+=")";
					continue;
				}
				sql+=", ";
			}
			connect.createStatement().executeUpdate(sql);
			
		}
		connect.close();
	}
	
	public void savePreffereds(Subject subject) throws Exception{
		connect();
		
		for(int i=0;i<subject.getStockRatings().length;i++){
			String sql = "INSERT INTO preffered VALUES("
					+ subject.getSubjectId()+", "
					+ (i+1)+", ";
			for(int j=0;j<Cons.NUM_OF_STOCKS;j++){
				sql+="\'"+subject.getStockRatings()[i].getStockRating(j)+"\'";
				if(j==Cons.NUM_OF_STOCKS-1){ 
					sql+=")";
					continue;
				}
				sql+=", ";
			}
			connect.createStatement().executeUpdate(sql);
		}
		
		connect.close();
	}

	public void saveLastQuestions(Subject subject) throws Exception {
		connect();
		
		for(int i=0;i<Cons.NUM_OF_LAST_QUES;i++){
			connect.createStatement().executeUpdate("INSERT INTO questions VALUES("
					+ subject.getSubjectId()+", "
					+ (i+1)+", "
					+subject.getLastQuesAnswers()[i]
					+ ")");
		}
		
		connect.close();
	}
	
	public String getXMLQuestionsString() throws Exception{
		connect();
		String getSubjectsQuery = "SELECT * FROM questions ORDER BY sub_id, que_id";
		ResultSet result = connect.createStatement().executeQuery(getSubjectsQuery);
		int NUM_OF_COLUMNS = result.getMetaData().getColumnCount();
		String resultStr = "<Worksheet ss:Name=\"questions\">	<Table>		<Row>			<Cell><Data ss:Type=\"String\">sub_id</Data></Cell>			<Cell><Data ss:Type=\"String\">que_id</Data></Cell>			<Cell><Data ss:Type=\"String\">ans</Data></Cell>		</Row>";
		result.first();
		while(!result.isAfterLast()){
			resultStr+="<Row>";
			for(int column=1;column<NUM_OF_COLUMNS+1;column++){
				String type = "\"Number\"";
				resultStr+="<Cell><Data ss:Type="+type+">"+result.getString(column)+"</Data>"+
				"</Cell>";
			}
			resultStr+="</Row>";
			result.next();
		}
		return resultStr+"</Table></Worksheet>";
	}
	
	public String getXMLPrefferedString() throws Exception{
		connect();
		String getSubjectsQuery = "SELECT * FROM preffered ORDER BY sub_id, period";
		ResultSet result = connect.createStatement().executeQuery(getSubjectsQuery);
		int NUM_OF_COLUMNS = result.getMetaData().getColumnCount();
		String resultStr = "<Worksheet ss:Name=\"preffered\">	<Table>		<Row>			<Cell><Data ss:Type=\"String\">sub_id</Data></Cell>			<Cell><Data ss:Type=\"String\">period</Data></Cell>			<Cell><Data ss:Type=\"String\">highest</Data></Cell>			<Cell><Data ss:Type=\"String\">high</Data></Cell>			<Cell><Data ss:Type=\"String\">unchanged_1</Data></Cell>			<Cell><Data ss:Type=\"String\">unchanged_2</Data></Cell>			<Cell><Data ss:Type=\"String\">low</Data></Cell>			<Cell><Data ss:Type=\"String\">lowest</Data></Cell>		</Row>";
		result.first();
		while(!result.isAfterLast()){
			resultStr+="<Row>";
			for(int column=1;column<NUM_OF_COLUMNS+1;column++){
				String type = "\"String\"";
				if(column==2 || column==1){
					type = "\"Number\"";
				}
				resultStr+="<Cell><Data ss:Type="+type+">"+result.getString(column)+"</Data>"+
				"</Cell>";
			}
			resultStr+="</Row>";
			result.next();
		}
		
		return resultStr+"</Table></Worksheet>";
	}
	
	public String getXMLPeriodString() throws Exception{
		connect();
		String getSubjectsQuery = "SELECT * FROM period ORDER BY sub_id, period_no";
		ResultSet result = connect.createStatement().executeQuery(getSubjectsQuery);
		int NUM_OF_COLUMNS = result.getMetaData().getColumnCount();
		String resultStr = "<Worksheet ss:Name=\"periods\">\n"
				+ "<Table>\n"
				+ "<Row>\n"
				+ "<Cell><Data ss:Type=\"String\">sub_id</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">period_no</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">stock_a</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">stock_b</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">stock_c</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">stock_d</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">stock_e</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">stock_f</Data></Cell>\n"
				+ "</Row>\n";
		result.first();
		while(!result.isAfterLast()){
			resultStr+="<Row>\n";
			for(int column=1;column<NUM_OF_COLUMNS+1;column++){
				String type = "\"Number\"";
				resultStr+="<Cell><Data ss:Type="+type+">"+result.getString(column)+"</Data>"+
				"</Cell>\n";
			}
			resultStr+="</Row>\n";
			result.next();
		}
		
		return resultStr+"</Table></Worksheet>";
		
	}
	
	public String getXMLSubjectsString() throws Exception{

		connect();
		String getSubjectsQuery = "SELECT * FROM subjects ORDER BY subject_id";
		ResultSet result = connect.createStatement().executeQuery(getSubjectsQuery);
		int NUM_OF_COLUMNS = result.getMetaData().getColumnCount();
		String resultStr = "<Worksheet ss:Name=\"subjects\">\n"
				+ "<Table>\n"
				+ "<Row>\n"
				+ "<Cell><Data ss:Type=\"String\">subject_id</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">sex</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">age</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">birth_country</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">aliya_year</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">family_status</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">education</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">edu_economics_free_text</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">income</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">control_of_stock</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">involvment_in_stock</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">email</Data></Cell>\n"
				+ "<Cell><Data ss:Type=\"String\">telephone</Data></Cell>\n"
				+ "</Row>\n";
		result.first();
		while(!result.isAfterLast()){
			resultStr+="<Row>\n";
			for(int column=1;column<NUM_OF_COLUMNS+1;column++){
				String type = "\"String\"";
				if(column==1||column==3||column==5){
					type = "\"Number\"";
				}
				String temp = result.getString(column);
				if(temp==null) temp = "";
				resultStr+="<Cell><Data ss:Type="+type+">"+temp+"</Data>"+
				"</Cell>+\n";
			}
			resultStr+="</Row>\n";
			result.next();
		}
		return resultStr+"</Table>\n</Worksheet>\n";
	}

	public static String getIP() {
		return parameters[Cons.IP];
	}

	public static String getPORT() {
		return parameters[Cons.PORT];
	}

	public static String getUSER() {
		return parameters[Cons.USER];
	}

	public static String getPASS() {
		return parameters[Cons.PASS];
	}

	public static void setIP(String iP) {
		parameters[Cons.IP] = iP;
	}

	public static void setPORT(String pORT) {
		parameters[Cons.PORT] = pORT;
	}

	public static void setUSER(String uSER) {
		parameters[Cons.USER] = uSER;
	}

	public static void setPASS(String pASS) {
		parameters[Cons.PASS] = pASS;
	}
	
	public String[] getParameters(){
		return new Files().loadData();
	}
	
}
