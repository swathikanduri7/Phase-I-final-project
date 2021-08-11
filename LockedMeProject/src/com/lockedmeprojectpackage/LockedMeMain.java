package com.lockedmeprojectpackage;

public class LockedMeMain 
{

	public static void main(String[] args) 
	{	
	FileOperations.createMainFolderIfNotPresent("main"); 
	MenuOptions.printWelcomeScreen("LockedMe", "Swathi Kanduri"); 
	HandleOptions.handleWelcomeScreenInput(); 
	}

}


