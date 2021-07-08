package com.simplilearn.mainmenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.menuservice.MenuService;
import com.app.menuservice.SubMenuService;
import com.simplilearn.menudao.MenuDao;

public class SubMenu implements SubMenuService {
	
	ArrayList<String> choice=new ArrayList<>();
	MenuDao menu=null;
	
	public SubMenu() {
		choice.add("1. Create A File");
		choice.add("2. Delete A File");
		choice.add("3. Search A File");
		choice.add("4. Return to Main Menu");
	}


	@Override
	public void GetInputFromUserforSubMenu() {
		// user input
		
				 int option  = 0;
			        while ((option = this.getInput()) != 4) {
			            this.FileSubMenu(option);
			        }
		
	}
	public int getInput() {
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
	public void DisplaySubMenu() {
		System.out.println("File Menu Options:");
        for (String ch : choice)  {
            System.out.println(ch);
        }
		
	}


	@Override
	public void FileSubMenu(int option) {
		switch(option) {

        case 1: // Create new a File
            menu=new MenuDao();
            menu.CreateFile();
            //menu.ShowFiles();
            this.DisplaySubMenu();
            break;
        case 2: // Delete a File
        	menu=new MenuDao();
        	menu.DeleteFile();
        	//menu.ShowFiles();
        	this.DisplaySubMenu();
            break;
        case 3: // Search File
        	  menu=new MenuDao();
        	  menu.SearchFile();
        	  this.DisplaySubMenu();
              
            break;
        
            /*
        case 4: // Return to Menu
        	
        	ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
            ScreenService.getCurrentScreen().Show();
            ScreenService.getCurrentScreen().GetUserInput();
            
            break;
            */
        default:
            System.out.println("Invalid Option");
            break;
            
            
    }

		
	}
	
	
	
	
	
	
}
