

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.*;
 

public class Files {
	
	static String[] arrayLength = new String[50];
	static int level = 0;
	    public static void main(String args[]) {
	        File root = new File("E:\\CISC3150");
	        if (!root.exists()) {
	            System.out.println("Invalid directory: " + root.getName());
	            return;
	        }
	        Writer writer = null;
	        
			  try {
			      writer = new BufferedWriter(new OutputStreamWriter(
			      new FileOutputStream("dir_tree.txt"), "utf-8"));
			      writer.write(root.getName()+"\r\n");
			      ListDirectory(root, "", (BufferedWriter) writer);
			  } catch (IOException ex) {
			  } finally {
			     try {writer.close();} catch (Exception ex) {}
			  }
	    }

	    public static String ListDirectory(File root, String rtr, BufferedWriter writer) throws IOException {
	        File files[] = root.listFiles();
	        if (files != null) {
	            for (int i = 0; i < files.length; i++) {
	            	if (level == 0) {
	            		arrayLength[i] = files[files.length-1].getName(); level++;
	            		System.out.println(arrayLength[0]);
	            	}
	                if (files[i].isDirectory()) {
	                	 writer.write(rtr + "+--" + files[i].getName()+"\r\n");
	                	 if(files[i].getName().equals(arrayLength[0]))
	                		 ListDirectory(files[i], rtr + "   ", writer);
	                	 else
	                		 ListDirectory(files[i], rtr + "¦  ", writer);
	                } else {
	                	 writer.write(rtr + "+--" + files[i].getName().toString()+"\r\n");
	                }
	            }
	        }
			return rtr;
	    }
	}