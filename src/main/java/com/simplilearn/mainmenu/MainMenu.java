package com.simplilearn.mainmenu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



import com.app.menuservice.MenuService;
import com.simplilearn.menudao.MenuDao;

public class MainMenu implements MenuService{
	
	private String projectName="Application Name :Vertual Key Repository";
	private String  developedBy="Developed By :Surekha Jagtap";
	private String contactUs="Contact US :www.Vertual.com";
	
	private ArrayList<String> options = new ArrayList<>();
	
	public MainMenu()
	{
	  options.add("1. Show List of Files");
      options.add("2. File Options Menu");
      options.add("3. Quit");
      }
	
	public void ApplicationDetails() {
		System.out.println(projectName);
		System.out.println(developedBy);
		System.out.println(contactUs);
		this.DisplayMainMenu();
	}



	@Override
	public void GetInputFromUser() {
		// user input
		
		 int option  = 0;
	        while ((option = this.getInput()) != 3) {
	            this.FileMainMenu(option);
	        }
	}
	  private int getInput() {
	        Scanner input = new Scanner(System.in);

	        int returnOption = 0;
	        try {
	            returnOption = input.nextInt();
	        }
	        catch (InputMismatchException ex) {

	        }
	        return returnOption;

	    }
	
	@Override
	public void DisplayMainMenu() {
		System.out.println("Main Menu");
        for (String option : options)  {
            System.out.println(option);
        }
		
	}
	@Override
	public void FileMainMenu(int option) {
		MenuDao menu=new MenuDao();
		switch(option) {
		case 1:
				menu.ShowFiles();
				this.DisplayMainMenu();
				break;
		case 2:
			 	
			SubMenu s=new SubMenu();
			s.DisplaySubMenu();
			s.GetInputFromUserforSubMenu();
			this.DisplayMainMenu();
			 	break;
		 default:
             System.out.println("Invalid Option");
             break;
		}
		
	}
	
	

}
