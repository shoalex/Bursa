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

	public static final int INPUTֹ_ERROR = 0;
	public static final int STOCKֹ_ERROR = 1;
	public static final int CASHֹ_ERROR = 2;

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

	public static final String STOCK_SCREEN_EXPLAIN_TEXT = " בהתבסס על המידע הקיים ברשותך, העזר במקרא הבא וליד כל סימן רשום איזו מניה (A-F) מתארת לדעתך בצורה הטובה ביותר את שצפוי לכל אחת מהמניות בעתיד? ";
	public static final String ENTER_ID = " הכנס מספר שאלון: ";
	public static final String START_BUTTON = " התחל ";
	public static final String BUY_OR_SELL_TEXT = " רכישת ומכירת מניותך ";
	public static final String ERROR_MASSAGE = " סכומים לא תואמים, נא לתקן ";
	public static final String AFTER_CHANGE_TEXT = " סה\"כ שווי החזקה לתקופה זו ";
	public static final String ERROR_STOCKS_WINDOW = " נא לבחור מניה אחת בכל עמודה ";
	public static final String INPUT_TEXT_FIRST_PERIOD = " שווי ההחזקה ";
	public static final String SUM_TEXT = "סה\"כ";
	public static final String CONTINUE = " המשך ";
	public static final String CLEAR_FORM = " נקה טופס ";
	public static final String LAST_TITLE = " גישתך ביחס להחזקת מניות ";
	public static final String LAST_TEXT = " לפניך מספר היגדים הבאים לבחון את גישת ההשקעות שלך בשוק ההון. עבור כל היגד ברשימה אנא סמן את מידת הסכמתך עם ההיגד כאשר: <br> 1 - לא מסכים כלל<br>2 - מסכים במידה מועטה<br>3 - מסכים חלקית<br>4 - מסכים<br>5 - מסכים בהחלט<br> ";
	public static final String AGREEMENT_TEXT = " שלום רב!  <br><br>אנו פונים אליך סטודנט יקר, בבקשה להשתתף במחקר העוסק בקבלת החלטות כלכליות.<br>במסגרת המחקר, אנו מבקשים שתשתתף במילוי השאלון הבא, המאופיין בדיסקרטיות ואנונימיות, <br> הבוחן את התנהגות המשקיע הרציונאלי בתנאי שוק שונים.<br><br>אינך חייב להשתתף במחקר. אם תחליט להשתתף, זכותך המלאה לא לענות על כל השאלות, כמו גם להפסיק בכל שלב שתרצה.<br> יחד עם זאת, נבקש להדגיש כי השתתפותך חיונית להבנה של סוגיה כלכלית וחשוב לנו שתענה על כל השאלות.<br><br>השאלון אינו מבחן, ואין לו תשובות \"נכונות\" או \"לא נכונות\". <br><br> אנא ענה על השאלון ע\"פ שיקול דעתך ובהתאם לתחושותיך. כל תשובותיך הינן חסויות ותשמשנה לצרכי מחקר בלבד. <br>בפרסום התוצאות לא יופיעו פרטים מזהים של המשתתפים.<br><br>בכל שלב תוכל לבקש עזרה מהנסיין.<br><br>אנו מודים לך מראש על נכונותך להשתתף במחקר זה.<br><br><br>הערה: <br>השאלון מתייחס לגברים ונשים כאחד, אך מנוסח בלשון זכר מטעמי נוחות בלבד.<br><br>תודה על שיתוף הפעולה ! ";
	public static final String ACCEPT_TEXT = " אני מאשר שקראתי ";
	public static final String FIRST_PERIOD_HELP1 = " <strong>תקופה אפס:</strong> <br> בטבלה שלפניך מוצגות המניות השונות עם המחירים הנוכחיים שלהן. <br>עליך לחלק את הסכום העומד לרשותך, בסך 10,000 ש\"ח בין המניות השונות. נא תעד את החלוקה בטבלה.<br>";
	public static final String FIRST_PERIOD_HELP2 = " שים לב:   <br>א. הנך רשאי לחלק את הכסף כרצונך <br>ב. לא ניתן ללוות כסף או לסחור במניה בחסר (\"שורט\") <br>ג. כסף שלא הושקע במניות, נשאר במזומן ואינו צובר ריבית. <br> ";
	public static final String PERIOD_TITLE = " תקופה ";
	public static final String PERIOD_TITLE_DEMO = " - דוגמא ";
	public static final String AGREEMENT_TITLE = " שאלון בנושא קבלת החלטות כלכליות ";
	public static final String BACK_TITLE = " שאלות רקע ";
	public static final String DATABASE_CONNECTING = " מתחבר לשרת... ";
	public static final String THANK_YOU_TEXT = " תודה שהקדשת מזמנך למילוי השאלון. <br>במידה ותרצה לקחת חלק בניסויים נוספים שלנו תוכל להשאיר כתובת מייל לחזרה אליך. <br><strong> תודה רבה על השתתפותך!</strong> ";
	public static final String THANK_YOU_TEXT_2 = " פרטיך נשמרו. <br> תודה רבה על השתתפותך!";
	public static final String CURRENT_STOCK_PRICE = " מחיר מניה נוכחי ";
	public static final String DATABASE_ERROR  = " שגיאה בחיבור! ";
	public static final String DATABASE_CONNECTED = " החיבור נוצר בהצלחה! ";
	public static final String SAVE_MAIL = " אישור ";
	public static final String INPUT_ERROR_MESSAGE = " נא לבדוק שלמות ותקינות הפרטים ";
	public static final String CHOISE_HEAD = " המניה המתאימה לדעתי ";
	public static final String SETTINGS_TITLE = " הגדרות מערכת ";
	public static final String SUMMARY_TITLE = " סיכום תיק ההשקעה ";
	public static final String MAP_TEXT_STOCK_SCREEN = " <strong> השתמש במקרא הבא: </strong> <br> ++   : מנייה בעלת סיכוי להציג את מגמת העלייה החזקה ביותר <br>+     : מניה בעלת סיכוי להציג מגמת עלייה שנייה חזקה ביותר. <br>0     :  מנייה שלא צפויה להציג שינוי במחיר <br>-      :  מניה שצפויה להציג ירידה במחיר <br>-  -   :  מניה שצפויה להציג ירידה חזקה ביותר במחיר <br><br><strong> שים לב: לכל מניה ניתן לסמן אפשרות אחת בלבד </strong> ";
	public static final String SETTINGS_BUTTON = " הגדרות ";

	public static final String [] LAST_QUES = {
			" 1.אני מעדיף למכור מניות בכל רווח שהוא בכדי להבטיח רווח אפילו מינימאלי ",
			" 2.כשהמניה בה אני מושקע בירידה, קיים בי חשש גדול שהיא תרד יותר ",
			" 3.לרוב אני ממשיך להחזיק במניה מפסידה כי אני מאמין שמגמת השוק תשתנה באופן שיטיב עימי ",
			" 4.אני מעדיף להיפטר מכל מניה מפסידה, גם כאשר ההפסד שלי טרם המכירה קטן ",
			" 5.אני מתכנן מראש את אופן ההתנהלות שלי בשוק ההון לפני קבלת החלטת השקעה ",
			" 6.שוק המניות יכול לנבא את מחירי המניות העתידיים בהתבסס על תנועות העבר ",
			" 7.החלטות מסחר שלי נגזרות מפעילות מניות בעבר וללא קשר לביצועים שלהם כיום "
	};

	public static final String [][] BACK_QUES = {
			{" מין: "," גיל: "},
			{" ארץ לידה: "," שנת לידה: "},
			{" מצב משפחתי: "},
			{" השכלה: "},
			{" אם הנך בעל תואר אקדמי, האם השכלתך האקדמית כוללת לימודי כלכלה או/ו מנהל עסקים? "},
			{" ציין את הכנסתך ברוטו לחודש: "},
			{" רמת שליטך במחסר בשוק ההון: "},
			{" תכיפות המעורבות שלך בשוק ההון: "}
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
			" שרת: ",
			" פורט: ",
			" משתמש: ",
			" סיסמא: "
	};

	public static final String[] SUMMARY_TEXT = {
			" סה\"כ ",
			" מזומן ",
			" מניות "
	};

	public static final String[] SETTINGS_BUTTON_TEXT = {
			" שמור ",
			" ביטול "
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
			" קלט לא חוקי ",
			" מכירת מניה לא חוקית ",
			" אין מספיק מזומן לקנייה "
	};

	public static final String[] FRIST_PERIOD_TEXTS = { 
			" סה\"כ נכסים ",
			" יתרת מזומן ",
			" שווי מניות "
	};

	public static final String[] HELP_TEXT = {
			//			"<strong>המשך </strong><br><br> לאור אירועים כלכליים המתרחשים בארץ ובעולם ובעקבות פעילות שוק ההון, חלים שינויים במחירי המניות בבורסה.  <br>בעמודים הבאים מתוארים מחירי המניות במשך מספר תקופות זמן עוקבות. <br>בכל תקופה, יהיה עליך להחליט אילו מניות אתה קונה או מוכר, ובאלו סכומים. <br> - עבור רכישה – כתוב את סכום הרכישה בשורת \"סכום מכירה / רכישה \". <br> - עבור מכירה – כתוב את סכום המכירה בשורת \"סכום מכירה / רכישה\" בסימן שלילי (מינוס). <br> - עבור המשך החזקה – רשום 0 בשורת \"סכום מכירה / רכישה\". <br><br>כמו כן, בכל תקופה יהיה עליך לתעד את סכום הכסף במזומן העומד לרשותך. ע\"פ סכום זה תדע מהי מגבלת התקציב שלך עבור התקופה הבאה.  <br> ",
			" הנח כי לרשותך 10,000 ש\"ח אותם אתה יכול להשקיע. <br>בפניך קיימת האפשרות לסחור (למכור ולקנות) 6 מניות שונות הנסחרות בבורסה, המסומנות באותיות A-F.<br><br>מחירי המניות נקבעים כלהלן:<br>בכל תקופה בניסוי, יכול המחיר של כל אחת מהמניות לעלות או לרדת.<br>סיכויי העליה של המחיר שונים בין שש המניות, אך קבועים עבור כל מניה לאורך כל תקופות הניסוי.<br>העלייה והירידה במחיר כל מניה בלתי תלויות באלו של המניות האחרות.<br><br>סיכויי העלייה התקופתית של מחירי המניות הם כלהלן:<br> <br>עבור מניה אחת (שתסומן ++), סיכוי העליה הוא 65%<br>עבור מניה אחת (שתסומן +), סיכוי העליה הוא 55%<br>עבור 2 מניות (שיסומנו 0), סיכוי העליה הוא 50%<br>עבור מניה אחת (שתסומן -), סיכוי העליה הוא 45%<br>עבור מניה אחת (שתסומן --), סיכוי העליה הוא 35%<br> <br>היות והמחירים משתנים בכל תקופה, הסיכוי שמחיר מניה מסויימת ירד הוא תמיד 1 פחות הסיכוי שמחירה יעלה.<br><br>בכל שלב, ועבור כל מניה, לאחר שנקבע אם מחירה עלה או ירד, נקבע באופן אקראי האם המחיר עלה או ירד ב 1, 3, או 5 ש\"ח.<br>שלוש האפשרויות הן שוות סיכוי ובלתי תלויות בין המניות.<br>(ההסתברות שמניה תעלה אינו מתואם לגודל השינוי במחיר).<br> ",
			" בכל תקופה, יהיה עליך להחליט אילו מניות אתה קונה או מוכר, ובאלו סכומים. <br>- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; עבור רכישה – כתוב את סכום הרכישה בשורת \"סכום מכירה / רכישה\". <br>- &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;עבור מכירה – כתוב את סכום המכירה בשורת \"סכום מכירה / רכישה\" <strong> בסימן שלילי (מינוס) </strong> . <br>- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; עבור המשך החזקה – <strong> רשום \"0\" </strong> (אפס) בשורת \"סכום מכירה / רכישה\". <br><br> עליך לחלק את הסכום העומד לרשותך, בסך 10,000 ש\"ח בין המניות השונות. נא תעד את החלוקה בטבלה. <br><br>שים לב:   <br>א. הנך רשאי לחלק את הכסף כרצונך <br>ב. לא ניתן ללוות כסף או לסחור במניה בחסר (\"שורט\") <br>ג. כסף שלא הושקע במניות, נשאר במזומן ואינו צובר ריבית. <br> ",
			" <strong> דוגמא: </strong> <br><br>בתקופה 1, המשקיע בחר לקנות:  מניה A ב- 500, מניה B ב- 3000, מניה C ב- 2000.  נניח כי תיקו של המשקיע לאחר הרכישה הוא:<br> ",
			" <strong> המשך הדוגמא: </strong> בתקופה 2, לאחר שמחיר המניות השתנה - המשקיע בחר לבצע 3 פעולות: <br>רכש מניה A ב- 1,200 ₪ ,  מכר מניה B ב- 1,000 ₪ ,  המשיך להחזיק באותה כמות של מניה C <br>להלן אופן הסימון של פעולות אלה בטבלה: <br> ",
			" <strong> המשך הדוגמא: </strong> בכדי לוודא שאכן אופן מילוי הטבלה ברור, נציג כעת גם את תקופה מס' 3: <br>המשקיע בחר לבצע בתקופה זו 3 פעולות: <br>מכר 2000 ממניה A. <br>קנה 1000 ממניה B. <br>מכר 1500 ממניה C. <br><br>להלן אופן הסימון של פעולות אלה בטבלה: <br> ",
			" כרגע עומד להתחיל הסיבוב האמיתי שלפיו ישמרו הנתונים.  <br><br> לחץ המשך ברגע שאתה מוכן להתחיל בשאלון. <br> "
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


