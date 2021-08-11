package com.lockedmeprojectpackage;

import java.util.Scanner;

public class HandleOptions 
{
	//read/input the data from user
	static Scanner sc = new Scanner(System.in);
	public static void handleWelcomeScreenInput() 
	{
		boolean running = true;
			do {
			try 
			{
				MenuOptions.displayMenu();

				int input = sc.nextInt();
				//switch case to display the name of the files
				switch (input) 
				{
				case 1:
					System.out.println("Display the name of the files added to the \"main\" folder");
					FileOperations.readFilefromFolder("main");
					break;
				case 2:
					System.out.println("Enter the name of the file to be added 	to the \"main\" folder");
					FileOperations.writeContentToNewFileName("main");
					break;
				case 3:
					System.out.println("Enter the name of the file to be deleted from \"main\" folder"); 
					FileOperations.deleteFileFromFolder("main");
					break;
					
				case 4:
					System.out.println("Enter the name of the file to be searched from \"main\" folder"); 
					FileOperations.searchFileNameInFolder("main");
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
		
	}
	/**
	 * method to handle file menu options
	 * 
	 */

	public static void handleFileMenuOptions() 
	{
		boolean running = true;
			do {
			try {
				MenuOptions.displayMenu();

				int input = sc.nextInt();
				switch (input) {
				case 1:
					System.out.println("Display the name of the files added to the \"main\" folder");
					FileOperations.readFilefromFolder("main");
					break;
				case 2:
					System.out.println("Enter the name of the file to be added 	to the \"main\" folder");
					FileOperations.writeContentToNewFileName("main");
					break;
				case 3:
					System.out.println("Enter the name of the file to be searched from \"main\" folder"); 
					FileOperations.searchFileNameInFolder("main");
					break;
				case 4:
					System.out.println("Enter the name of the file to be deleted from \"main\" folder"); 
					FileOperations.deleteFileFromFolder("main");
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
		sc.close();
	} 
	

}
