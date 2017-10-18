package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedWriter;

public class Connectivity {

	private String path = "D:/Github/Web/642/Assignment4.2/WebContent/";
	private String fileName = "Student-Info.txt";
	public Connectivity() {}

	public BufferedWriter getWriter() {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		File file = new File(path,fileName);
		
		try {
			if(!file.exists()) {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
			}
			else {
				fw = new FileWriter(file,true);
				bw = new BufferedWriter(fw);
			}
		}
		catch(IOException ex) {
			System.out.println("File Writer Exception "+ex);
		}
		
		return bw;
	}
	
	
	public Scanner getReader() {
		Scanner br = null;
		FileReader fr = null;
		File file = new File(path,fileName);
		
		try {
			
			fr = new FileReader(file);
			br = new Scanner(fr);			
		}
		catch(IOException ex) {
			System.out.println("File Reader Exception "+ex);
		}
		
		return br;
	}
	
	
	
	
	
	
	

}
