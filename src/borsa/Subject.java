package borsa;

public class Subject {
	private int subjectId;
	private int cash;
	private int [] stocks;
	private Period [] periods;
	private StockRating [] stockRatings;
	private int [] lastQuesAnswers;
	private BackgroundQuestions backgroundQuestion;
	private String email, phone;


	public Subject(int subId){
		this.subjectId=subId;
		initalizeHoldings();
		periods = new Period[Cons.NUM_OF_PERIODS];
		stockRatings = new StockRating[Cons.NUM_RATINGS_CHECK];
	}

	public Period[] getPeriods() {
		return periods;
	}

	public void initalizeHoldings() {
		cash = 10000;
		stocks = new int [Cons.NUM_OF_STOCKS];
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getStock(int stock){
		return stocks[stock];
	}
	
	public void setStock(int stock, int change){
		stocks[stock]=change;
	}
	
	public void buyStock(int stock, int sumOfCash){
		stocks[stock]+=sumOfCash;
		cash-=sumOfCash;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public int getStocksSum() {
		int temp = 0;
		for(int i=0;i<stocks.length;i++){
			temp += stocks[i];
		}
		return temp;
	}

	public StockRating[] getStockRatings() {
		return stockRatings;
	}
	
	public int[] getLastQuesAnswers() {
		return lastQuesAnswers;
	}
	
	public int getSummary() {
		return getCash()+getStocksSum();
	}
	
	public void savePeriod(int period, int [] changes){
		periods[period]=new Period(changes);
	}

	public void setLastQuesAnswers(int[] answers) {
		lastQuesAnswers = answers;
	}
	
	public void setStockRating(int periodNum, StockRating stockRating){
		int index;
		if(periodNum==1){
			index=0;
		}else if(periodNum==7){
			index=1;
		}else{
			index=2;
		}
		stockRatings[index] = stockRating;
	}

	public void resetBuys() {
		initalizeHoldings();
	}

	public BackgroundQuestions getBackgroundQuestion() {
		return backgroundQuestion;
	}

	public void setBackgroundQuestion(BackgroundQuestions backgroundQuestion) {
		this.backgroundQuestion = backgroundQuestion;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
