package com.simplilearn.menudao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MenuDao {
	
	 public static String drivename =null;
	 public MenuDao() {
		 File directories[]=File.listRoots();
		//a drive is selected from system
			
		 for(File directory:directories) {
	        // System.out.println(directory);
			 drivename=directory.toString();
		 }
	 }
	
	//Showing File List 
	 public void ShowFiles() {
		
	 if(drivename!=null) {
		 try {
			 //List of all files and directories
			 File directoryPath = new File(drivename);
			 String contents[] = directoryPath.list();
			 if(contents.length<0) {
				 System.out.println(drivename+"Empty directory,No file and folder available.");
			 }else {
			 System.out.println("List of files and directories of drive : "+ drivename);
		      for(int i=0; i<contents.length; i++) {
		         System.out.println(contents[i]);
		      }}
		 	} catch (Exception e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
	    }
	 }
	 
	 //Create a new file 
	 public void CreateFile()
	 {
		 boolean flage;
		 
		 System.out.println("Please Enter the Filename:");
		 String fileName = this.getInput();
		 if(drivename!=null) {
			 try {
				 File file = new File(drivename+fileName);
				flage= file.createNewFile();
				 if(flage) {
					 System.out.println("file has been created Successfully :  "+file.getCanonicalPath()); //returns the path string   
				 }else {
					 System.out.println("file name already exist with name :  "+fileName+" on drive  "+file.getCanonicalPath()); //returns the path string   
				 }
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 }
	 }
	 //Delete a file
	 public void DeleteFile() {
		
		 System.out.println("Please Enter the Filename to be Deleted:");
		 String fileName = this.getInput();
		 File file= new File(drivename+fileName);
		// File file= new File("D:\\DEMO\\"+fileName);
		 if(file.delete())                      //returns Boolean value  
		 {  
		 System.out.println(file.getName() + " file deleted Successfully......");   //getting and printing the file name  
		 }  
		 else  
		 {  
		 System.out.println("failed to delete.........");  
		 } 
	 }
	 
	 
	 //Search user specified file
	 public void SearchFile()
	 {	
		 Boolean flag = false;
		 System.out.println("Please Enter the Filename to be Searched :");
		 String fileName = this.getInput();
		 File file=new File(drivename);
		 File[] list = file.listFiles();
		  for(File f:list) {
			  String name = f.getName();
			  if(name.equals(fileName)) {
				  System.out.println("File Found  : "+drivename+fileName);
				  flag=true;
			  }
		  }
		  if(!flag) {
			  System.out.println("File not Found  : "+drivename+fileName);
		  }
		 System.out.println();
		
		
	 }
	 
	 private String getInput() {

	        Scanner in = new Scanner(System.in);
	        return(in.nextLine());

	    }

}
