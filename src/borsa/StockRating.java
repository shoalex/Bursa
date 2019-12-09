package borsa;

public class StockRating {

	private String [] stocksRatings;

	public StockRating(){
		stocksRatings = new String[Cons.NUM_OF_STOCKS];
	}

	public void setStockRating(int level, String stock){
		stocksRatings[level]=stock;
	}
	
	public String getStockRating(int level){
		return stocksRatings[level];
	}

	public String toString(){
		String temp = "";
		for(int i=0;i<stocksRatings.length;i++){
			temp+=stocksRatings[i];
		}
		return temp;
	}
}
