package borsa;

public class BackgroundQuestions {
	
	private String gender;
	private double age;
	private String country_of_birth;
	private int year_of_immigration;
	private String family_status;
	private String eductionLevel;
	private String is_academic_degree;
	private String income;
	private String level_of_control_capital_market;
	private String frequently_involved_capital_market;
	
	public BackgroundQuestions(String gender, int age, String country_of_birth, int year_of_immigration,
				String family_status, String is_academic_degree, String income, String level_of_control_capital_market,
				String frequently_involved_capital_market) {
			this.gender = gender;
			this.age = age;
			this.country_of_birth = country_of_birth;
			this.year_of_immigration = year_of_immigration;
			this.family_status = family_status;
			this.is_academic_degree = is_academic_degree;
			this.income = income;
			this.level_of_control_capital_market = level_of_control_capital_market;
			this.frequently_involved_capital_market = frequently_involved_capital_market;
		}
	
	public BackgroundQuestions(){
		
	}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public double getAge() {
			return age;
		}

		public void setAge(double age) {
			this.age = age;
		}

		public String getCountry_of_birth() {
			return country_of_birth;
		}

		public void setCountry_of_birth(String country_of_birth) {
			this.country_of_birth = country_of_birth;
		}

		public int getYear_of_immigration() {
			return year_of_immigration;
		}

		public void setYear_of_immigration(int year_of_immigration) {
			this.year_of_immigration = year_of_immigration;
		}

		public String getFamily_status() {
			return family_status;
		}

		public void setFamily_status(String family_status) {
			this.family_status = family_status;
		}

		public String getIs_academic_degree() {
			return is_academic_degree;
		}

		public void setIs_academic_degree(String is_academic_degree) {
			this.is_academic_degree = is_academic_degree;
		}

		public String getIncome() {
			return income;
		}

		public void setIncome(String income) {
			this.income = income;
		}

		public String getLevel_of_control_capital_market() {
			return level_of_control_capital_market;
		}

		public void setLevel_of_control_capital_market(String level_of_control_capital_market) {
			this.level_of_control_capital_market = level_of_control_capital_market;
		}

		public String getFrequently_involved_capital_market() {
			return frequently_involved_capital_market;
		}

		public void setFrequently_involved_capital_market(String frequently_involved_capital_market) {
			this.frequently_involved_capital_market = frequently_involved_capital_market;
		}

		public String getEductionLevel() {
			return eductionLevel;
		}

		public void setEductionLevel(String eductionLevel) {
			this.eductionLevel = eductionLevel;
		}
}
