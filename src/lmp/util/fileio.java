package lmp.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class fileio {
	
	File file = new File("");
	
	public void FileRW() {
		
		try {
	        FileReader fr = new FileReader(file);
	        FileWriter fw = new FileWriter(new File(""));
	        BufferedReader br = new BufferedReader(fr);
	        BufferedWriter bw = new BufferedWriter(fw);
	        String line = "";
	        while((line = br.readLine()) != null) {
//	            System.out.print(br.read());
	            System.out.println(line);
	            bw.write(line);
	            bw.newLine();
	        }
	        bw.write("\nThis is copied...");
	        bw.flush();
	        bw.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("Finished!");
		}
		
}
