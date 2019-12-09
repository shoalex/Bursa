package borsa;

public class Lquestion {
	private int question;
	private int answers;
	private int userInput;
	
	public Lquestion(int question, int answers, int userInput) {
		
		this.question = question;
		this.answers = answers;
		this.userInput = userInput;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}


	public int getAnswers() {
		return answers;
	}

	public void setAnswers(int answers) {
		this.answers = answers;
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}




}
