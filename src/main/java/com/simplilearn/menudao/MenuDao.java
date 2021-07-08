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
			 Files.list(Paths.get(drivename)).filter(Files::isRegularFile).sorted().forEach(System.out::println);
		 	} catch (IOException e) {
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
