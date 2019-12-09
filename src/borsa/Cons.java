package borsa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.border.LineBorder;


public class Cons {
	//the changes that happen to the borsa in every period
	private static final int [][] PERIOD_CHANGES = {
			//		{40, 70, 180, 60, 80, 100},
			//		{50, 100, 150, 70, 90, 120},
			//		{80, 50, 120, 100, 150, 100},
			//		{90, 40, 140, 110, 120, 70},
			//	 A	 B	 C	  D	  E	   F
			{79, 53, 125, 95, 145, 97}, 	//0
			{80, 50, 120, 100, 150, 100}, 	//1
			{81, 53, 119, 95, 153, 105},	//2
			{86, 48, 124, 90, 152, 100},	//3
			{91, 43, 125, 93, 155, 105},	//4
			{92, 46, 128, 96, 150, 108},	//5
			{91, 51, 125, 91, 149, 113},	//6
			{88, 46, 124, 88, 154, 118},	//7
			{85, 47, 119, 85, 155, 123},	//8
			{86, 48, 118, 86, 154, 122},	//9
			{83, 47, 115, 85, 151, 127},	//10
			{86, 42, 114, 86, 149, 128},	//11
			{91, 37, 115, 91, 144, 129},	//12
			{86, 36, 114, 92, 145, 128},	//13
			{81, 39, 109, 91, 142, 129},	//14
	};

	//	private static final int [][] DEMO_PERIOD_CHANGES = {
	//			{50, 100, 150, 70, 90, 120},
	//			{80, 50, 120, 100, 150, 100},
	//			{90, 40, 140, 110, 120, 70}
	//	};

	public static final int GAP = 40;
	public static final int WINDOW_WIDTH = 951;
	public static final int WINDOW_HEIGHT = 717;
	public static final int TITLE_WIDTH = 500;
	public static final int TITLE_HEIGHT = 50;
	public static final int TITLE_Y = 10;
	public static final int CONTINUE_BUTTON_HEIGHT = 45;
	public static final int CONTINUE_BUTTON_WIDTH = 150;
	public static final int BACK_QUES_START_X = WINDOW_WIDTH-25;
	public static final int SETTINGS_LABEL_WIDTH = 170;

	public static final Rectangle BUTTON_RECT = new Rectangle(25, 619, Cons.CONTINUE_BUTTON_WIDTH, Cons.CONTINUE_BUTTON_HEIGHT);
	public static final Rectangle TITLE_RECT = new Rectangle((Cons.WINDOW_WIDTH/2)-(Cons.TITLE_WIDTH/2), Cons.TITLE_Y, Cons.TITLE_WIDTH, Cons.TITLE_HEIGHT);
	public static final Rectangle FIRST_LABEL_SETTINGS = new Rectangle((WINDOW_WIDTH/2), (int)(TITLE_RECT.getY()+GAP+50), SETTINGS_LABEL_WIDTH, CONTINUE_BUTTON_HEIGHT);
	public static final Rectangle FIRST_INPUT_SETTINGS = new Rectangle(FIRST_LABEL_SETTINGS.x-GAP-FIRST_LABEL_SETTINGS.width, FIRST_LABEL_SETTINGS.y, SETTINGS_LABEL_WIDTH, CONTINUE_BUTTON_HEIGHT);
	public static final Rectangle WINDOW_RECT = new Rectangle(0, 0, Cons.WINDOW_WIDTH, Cons.WINDOW_HEIGHT);

	public static final LineBorder LINE_BORDER_REGULAR = new LineBorder(Color.BLACK, 1);

	public static final int GENDER = 0;
	public static final int AGE = 1;
	public static final int BIRTH = 2;
	public static final int FAMILY_STATUS = 5;
	public static final int EDUCATION = 5;
	public static final int ECONOMY_EDUCATION = 2;
	public static final int INCOME = 6;
	public static final int KNOWLEDGE = 4;
	public static final int INVOLVMENT = 4;

	public static final int DEMO_NUM_OF_ROUNDS = 2;
	public static final int NUM_RATINGS_CHECK = 3;
	public static final int NUM_OF_STOCKS = 6;
	public static final int NUM_OF_PERIODS = 15;
	public static final int NUM_OF_LAST_CHOICES = 5;
	//	public static final int NUM_OF_LAST_QUES = 7;
	public static final int NUM_OF_LAST_QUES = 4;
	public static final int NUM_OF_FIRST_SCREEN_QUES = 4;
	public static final int NUM_OF_SETTINGS_INPUTS = 4;
	public static final int NUM_OF_SETTINGS_BUTTONS = 2;

	public static final int INPUT�_ERROR = 0;
	public static final int STOCK�_ERROR = 1;
	public static final int CASH�_ERROR = 2;

	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;
	public static final int F = 5;

	public static final int HIGHEST = 0;
	public static final int HIGH = 1;
	public static final int UNCHANGED_1 = 2;
	public static final int UNCHANGED_2 = 3;
	public static final int LOW = 4;
	public static final int LOWEST = 5;

	public static final int IP = 0;
	public static final int PORT = 1;
	public static final int USER = 2;
	public static final int PASS = 3;

	public static final Font REGUALAR = new Font("Arial", Font.PLAIN, 17);
	public static final Font BOLD = new Font("Arial", Font.BOLD, 17);
	public static final Font TITLE = new Font("Arial", Font.BOLD, 20);

	public static final String STOCK_SCREEN_EXPLAIN_TEXT = " ������ �� ����� ����� ������, ���� ����� ��� ���� �� ���� ���� ���� ���� (A-F) ����� ����� ����� ����� ����� �� ����� ��� ��� ������� �����? ";
	public static final String ENTER_ID = " ���� ���� �����: ";
	public static final String START_BUTTON = " ���� ";
	public static final String BUY_OR_SELL_TEXT = " ����� ������ ������ ";
	public static final String ERROR_MASSAGE = " ������ �� ������, �� ���� ";
	public static final String AFTER_CHANGE_TEXT = " ��\"� ���� ����� ������ �� ";
	public static final String ERROR_STOCKS_WINDOW = " �� ����� ���� ��� ��� ����� ";
	public static final String INPUT_TEXT_FIRST_PERIOD = " ���� ������ ";
	public static final String SUM_TEXT = "��\"�";
	public static final String CONTINUE = " ���� ";
	public static final String CLEAR_FORM = " ��� ���� ";
	public static final String LAST_TITLE = " ����� ���� ������ ����� ";
	public static final String LAST_TEXT = " ����� ���� ������ ����� ����� �� ���� ������� ��� ���� ����. ���� �� ���� ������ ��� ��� �� ���� ������ �� ����� ����: <br> 1 - �� ����� ���<br>2 - ����� ����� �����<br>3 - ����� �����<br>4 - �����<br>5 - ����� �����<br> ";
	public static final String AGREEMENT_TEXT = " ���� ��!  <br><br>��� ����� ���� ������ ���, ����� ������ ����� ����� ����� ������ �������.<br>������ �����, ��� ������ ������ ������ ������ ���, �������� ���������� ����������, <br> ����� �� ������� ������ ��������� ����� ��� �����.<br><br>���� ���� ������ �����. �� ����� ������, ����� ����� �� ����� �� �� ������, ��� �� ������ ��� ��� �����.<br> ��� �� ���, ���� ������ �� �������� ������ ����� �� ����� ������ ����� ��� ����� �� �� ������.<br><br>������ ���� ����, ���� �� ������ \"������\" �� \"�� ������\". <br><br> ��� ��� �� ������ �\"� ����� ���� ������ ���������. �� �������� ���� ������ ������� ����� ���� ����. <br>������ ������� �� ������ ����� ����� �� ��������.<br><br>��� ��� ���� ���� ���� �������.<br><br>��� ����� �� ���� �� ������� ������ ����� ��.<br><br><br>����: <br>������ ������ ������ ����� ����, �� ����� ����� ��� ����� ����� ����.<br><br>���� �� ����� ������ ! ";
	public static final String ACCEPT_TEXT = " ��� ���� ������ ";
	public static final String FIRST_PERIOD_HELP1 = " <strong>����� ���:</strong> <br> ����� ������ ������ ������ ������ �� ������� �������� ����. <br>���� ���� �� ����� ����� ������, ��� 10,000 �\"� ��� ������ ������. �� ��� �� ������ �����.<br>";
	public static final String FIRST_PERIOD_HELP2 = " ��� ��:   <br>�. ��� ���� ���� �� ���� ������ <br>�. �� ���� ����� ��� �� ����� ����� ���� (\"����\") <br>�. ��� ��� ����� ������, ���� ������ ����� ���� �����. <br> ";
	public static final String PERIOD_TITLE = " ����� ";
	public static final String PERIOD_TITLE_DEMO = " - ����� ";
	public static final String AGREEMENT_TITLE = " ����� ����� ���� ������ ������� ";
	public static final String BACK_TITLE = " ����� ��� ";
	public static final String DATABASE_CONNECTING = " ����� ����... ";
	public static final String THANK_YOU_TEXT = " ���� ������ ����� ������ ������. <br>����� ����� ���� ��� �������� ������ ���� ���� ������ ����� ���� ����� ����. <br><strong> ���� ��� �� ��������!</strong> ";
	public static final String THANK_YOU_TEXT_2 = " ����� �����. <br> ���� ��� �� ��������!";
	public static final String CURRENT_STOCK_PRICE = " ���� ���� ����� ";
	public static final String DATABASE_ERROR  = " ����� ������! ";
	public static final String DATABASE_CONNECTED = " ������ ���� ������! ";
	public static final String SAVE_MAIL = " ����� ";
	public static final String INPUT_ERROR_MESSAGE = " �� ����� ����� ������� ������ ";
	public static final String CHOISE_HEAD = " ����� ������� ����� ";
	public static final String SETTINGS_TITLE = " ������ ����� ";
	public static final String SUMMARY_TITLE = " ����� ��� ������ ";
	public static final String MAP_TEXT_STOCK_SCREEN = " <strong> ����� ����� ���: </strong> <br> ++   : ����� ���� ����� ����� �� ���� ������ ����� ����� <br>+     : ���� ���� ����� ����� ���� ����� ����� ���� �����. <br>0     :  ����� ��� ����� ����� ����� ����� <br>-      :  ���� ������ ����� ����� ����� <br>-  -   :  ���� ������ ����� ����� ���� ����� ����� <br><br><strong> ��� ��: ��� ���� ���� ���� ������ ��� ���� </strong> ";
	public static final String SETTINGS_BUTTON = " ������ ";

	public static final String [] LAST_QUES = {
			" 1.��� ����� ����� ����� ��� ���� ���� ���� ������ ���� ����� �������� ",
			" 2.������� �� ��� ����� ������, ���� �� ��� ���� ���� ��� ���� ",
			" 3.���� ��� ����� ������ ����� ������ �� ��� ����� ����� ���� ����� ����� ����� ���� ",
			" 4.��� ����� ������ ��� ���� ������, �� ���� ����� ��� ��� ������ ��� ",
			" 5.��� ����� ���� �� ���� �������� ��� ���� ���� ���� ���� ����� ����� ",
			" 6.��� ������ ���� ���� �� ����� ������ �������� ������ �� ������ ���� ",
			" 7.������ ���� ��� ������ ������� ����� ���� ���� ��� �������� ���� ���� "
	};

	public static final String [][] BACK_QUES = {
			{" ���: "," ���: "},
			{" ��� ����: "," ��� ����: "},
			{" ��� ������: "},
			{" �����: "},
			{" �� ��� ��� ���� �����, ��� ������ ������� ����� ������ ����� ��/� ���� �����? "},
			{" ���� �� ������ ����� �����: "},
			{" ��� ����� ����� ���� ����: "},
			{" ������ �������� ��� ���� ����: "}
	};

	public static final String [] STOCKS_LEVELS = {
			"+ +",
			"+",
			"0",
			"0",
			"-",
			"- -"
	};

	public static final String [] SETTING_TEXTS = {
			" ���: ",
			" ����: ",
			" �����: ",
			" �����: "
	};

	public static final String[] SUMMARY_TEXT = {
			" ��\"� ",
			" ����� ",
			" ����� "
	};

	public static final String[] SETTINGS_BUTTON_TEXT = {
			" ���� ",
			" ����� "
	};

	public static final String[] DEFAULT_SETTINGS = {
			"46.121.82.100",
			"3306",
			"sqluser",
			"1234"
	};

	public static final String[] STOCKS = {
			" ",
			"A",
			"B",
			"C",
			"D",
			"E",
			"F"
	};

	public static final String[] ERROR_MASSAGES = {
			" ��� �� ���� ",
			" ����� ���� �� ����� ",
			" ��� ����� ����� ������ "
	};

	public static final String[] FRIST_PERIOD_TEXTS = { 
			" ��\"� ����� ",
			" ���� ����� ",
			" ���� ����� "
	};

	public static final String[] HELP_TEXT = {
			//			"<strong>���� </strong><br><br> ���� ������� ������� �������� ���� ������ ������� ������ ��� ����, ���� ������� ������ ������ ������.  <br>������� ����� ������� ����� ������ ���� ���� ������ ��� ������. <br>��� �����, ���� ���� ������ ���� ����� ��� ���� �� ����, ����� ������. <br> - ���� ����� � ���� �� ���� ������ ����� \"���� ����� / ����� \". <br> - ���� ����� � ���� �� ���� ������ ����� \"���� ����� / �����\" ����� ����� (�����). <br> - ���� ���� ����� � ���� 0 ����� \"���� ����� / �����\". <br><br>��� ��, ��� ����� ���� ���� ���� �� ���� ���� ������ ����� ������. �\"� ���� �� ��� ��� ����� ������ ��� ���� ������ ����.  <br> ",
			" ��� �� ������ 10,000 �\"� ���� ��� ���� ������. <br>����� ����� ������� ����� (����� ������) 6 ����� ����� ������� ������, �������� ������� A-F.<br><br>����� ������ ������ �����:<br>��� ����� ������, ���� ����� �� �� ��� ������� ����� �� ����.<br>������ ����� �� ����� ����� ��� �� ������, �� ������ ���� �� ���� ����� �� ������ ������.<br>������ ������� ����� �� ���� ���� ������ ���� �� ������ ������.<br><br>������ ������ �������� �� ����� ������ �� �����:<br> <br>���� ���� ��� (������ ++), ����� ����� ��� 65%<br>���� ���� ��� (������ +), ����� ����� ��� 55%<br>���� 2 ����� (������� 0), ����� ����� ��� 50%<br>���� ���� ��� (������ -), ����� ����� ��� 45%<br>���� ���� ��� (������ --), ����� ����� ��� 35%<br> <br>���� �������� ������ ��� �����, ������ ����� ���� ������� ��� ��� ���� 1 ���� ������ ������ ����.<br><br>��� ���, ����� �� ����, ���� ����� �� ����� ��� �� ���, ���� ����� ����� ��� ����� ��� �� ��� � 1, 3, �� 5 �\"�.<br>���� ��������� �� ���� ����� ����� ������ ��� ������.<br>(�������� ����� ���� ���� ����� ����� ������ �����).<br> ",
			" ��� �����, ���� ���� ������ ���� ����� ��� ���� �� ����, ����� ������. <br>- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ���� ����� � ���� �� ���� ������ ����� \"���� ����� / �����\". <br>- &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;���� ����� � ���� �� ���� ������ ����� \"���� ����� / �����\" <strong> ����� ����� (�����) </strong> . <br>- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ���� ���� ����� � <strong> ���� \"0\" </strong> (���) ����� \"���� ����� / �����\". <br><br> ���� ���� �� ����� ����� ������, ��� 10,000 �\"� ��� ������ ������. �� ��� �� ������ �����. <br><br>��� ��:   <br>�. ��� ���� ���� �� ���� ������ <br>�. �� ���� ����� ��� �� ����� ����� ���� (\"����\") <br>�. ��� ��� ����� ������, ���� ������ ����� ���� �����. <br> ",
			" <strong> �����: </strong> <br><br>������ 1, ������ ��� �����:  ���� A �- 500, ���� B �- 3000, ���� C �- 2000.  ���� �� ���� �� ������ ���� ������ ���:<br> ",
			" <strong> ���� ������: </strong> ������ 2, ���� ����� ������ ����� - ������ ��� ���� 3 ������: <br>��� ���� A �- 1,200 � ,  ��� ���� B �- 1,000 � ,  ����� ������ ����� ���� �� ���� C <br>���� ���� ������ �� ������ ��� �����: <br> ",
			" <strong> ���� ������: </strong> ���� ����� ���� ���� ����� ����� ����, ���� ��� �� �� ����� ��' 3: <br>������ ��� ���� ������ �� 3 ������: <br>��� 2000 ����� A. <br>��� 1000 ����� B. <br>��� 1500 ����� C. <br><br>���� ���� ������ �� ������ ��� �����: <br> ",
			" ���� ���� ������ ������ ������ ����� ����� �������.  <br><br> ��� ���� ���� ���� ���� ������ ������. <br> "
	};


	public static int[] getBorsaChange(int period){
		return PERIOD_CHANGES[period];
	}

	public static boolean contains(JTextField[] array, KeyEvent e) {
		for(int i=0;i<array.length;i++){
			if(e.getSource()==array[i]){
				return true;
			}
		}
		return false;
	}

	public static String alignTextRight(String text) {
		return "<html><head><style>body{text-align: right}</style></head><body>"+text+"</body></html>";
	}

	public static final String cleanText(String act) {
		String text = "";
		for(int i=0;i<act.length();i++){
			if(act.charAt(i)!="'".charAt(0) || act.charAt(i)!='"')
				text+=act.charAt(i);
		}
		return text;
	}

	public static boolean chkMail(String temp){
		int count = 0;
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i)=='@')
				count++;
		}
		if(count==1){
			return true;
		}
		return false;
	}

}


