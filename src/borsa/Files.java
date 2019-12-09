package borsa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Files {
	
	private static final String FILENAME = "data";
	
	public String[] loadData(){
		String [] temp;
		try{
			FileInputStream inPath = new FileInputStream(FILENAME);
			ObjectInputStream in = new ObjectInputStream(inPath);
			temp = (String[]) in.readObject();
			in.close();
		}catch(Exception e){
			System.err.println("LOAD ERROR");
			temp = Cons.DEFAULT_SETTINGS;
		}
		return temp;
	}

	public void saveData(String [] data){
		try {
			FileOutputStream outPath = new FileOutputStream(FILENAME);
			ObjectOutputStream out = new ObjectOutputStream(outPath);
			out.writeObject(data);
			out.close();
		} catch (Exception e) {
			System.out.println("SAVE ERROR");
			e.printStackTrace();
		}
	}
	
}
