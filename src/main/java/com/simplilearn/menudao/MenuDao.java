package com.simplilearn.menudao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MenuDao {
	//Showing File List 
public void ShowFiles() {
	File directories[]=File.listRoots();
	String drive=null;
	 for(File directory:directories) {
        // System.out.println(directory);
	 drive=directory.toString();
	 }
	 System.out.println("Files from drive :: "+drive);
    try {
		Files.list(Paths.get(drive)).filter(Files::isRegularFile).sorted().forEach(System.out::println);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
