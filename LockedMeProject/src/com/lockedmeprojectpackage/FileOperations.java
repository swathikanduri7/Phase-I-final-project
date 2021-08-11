package com.lockedmeprojectpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class FileOperations 
{
	//global declaration to read the data
	static Scanner in = new Scanner(System.in);
	public static void createMainFolderIfNotPresent(String folderName) 
	{

		File file = new File(folderName);
		// If file doesn't exist, create the main folder
		if (!file.exists()) 
		{
			file.mkdirs();
		}
	}
	/**method to searchFileNameInFolder
	 * 
	 * @param folderpath
	 * @param filename
	 * @param return
	 */
	public static void searchFileNameInFolder(String folderpath) 
	{
		String fileName=null;
		//Scanner in = new Scanner(System.in);
			System.out.println("Enter File name to search ::");
			fileName = in.nextLine();
			List<String> fileNames=FileManager.getAllFiles(folderpath);
			 fileNames=FileManager.getAllFiles(folderpath);
			
			 if(fileNames.contains(fileName))
					System.out.println("File exists in folder");
					else
					System.out.println("File does not exists in folder");
					
			}
	/**
	 * method to readFilefromFolder
	 * @param folderpath
	 * @param fileName
	 * @param return
	 * 
	 */
		public static void readFilefromFolder(String folderpath) 
	{
		//To get the files from folderPath
				List<String> fileNames=FileManager.getAllFiles(folderpath);
				
				//loop for list of files
		        for(String f:fileNames)
		        {
		        	System.out.println(" file name :: " +f);		
				}
		
	}
	
	//code for writeContent to file
	public static void writeContentToNewFileName(String folderpath) 
	{
		List<String> content = new ArrayList<>();
		String fileName=null;
				
		System.out.println("enter file name :: ");
		//read string as filename
		fileName=in.nextLine();				
		
		System.out.println("enter content to write in to file :: ");
		//read string as content and append to list
		content.add(in.nextLine());
		
		FileManager.createFiles(folderpath, fileName, content);
		
			
	}
	
	//code for deleting a file
			/**
			 * this method will delete the file name if it exists 
			 * @param folderpath
			 * @param fileName
			 * @return
			 * 
			 */
	public static void deleteFileFromFolder(String folderpath) 
	{
		String fileName=null;
		System.out.println("Enter the file name to be deleted:");
		fileName=in.nextLine();
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
		
		if(isDeleted)
			System.out.println("File deleted successfully");
			else
			System.out.println("either file not there or some access issue");
			
	}
	
	//code for displaying all files
	/**method to display all files(display files in ascending order)
	 * @param folderpath
	 * @param path
	 * @param return
	 */
	public static void displayAllFiles(String path) 
	{
		FileOperations.createMainFolderIfNotPresent("main");
		// All required files and folders inside "main" folder relative to current
		// folder
		System.out.println("Displaying all files in ascending order\n");
		// listFilesInDirectory displays files along with folder structure
		List<String> filesListNames = FileOperations.listFilesInDirectory(path, 0, new
		ArrayList<String>());
		System.out.println("Displaying all files in ascending order\n");
		Collections.sort(filesListNames);
		filesListNames.stream().forEach(System.out::println);
		}
		public static List<String> listFilesInDirectory(String path, int indentationCount,
		List<String> fileListNames) 
		{
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);
		Collections.sort(filesList);
		if (files != null && files.length > 0) 
		{
		for (File file : filesList) {
		//System.out.print(" ".repeat(indentationCount * 2));
		if (file.isDirectory()) 
		{
		System.out.println("`-- " + file.getName());
		// Recursively indent and display the files
		fileListNames.add(file.getName());
		listFilesInDirectory(file.getAbsolutePath(), indentationCount + 1, fileListNames);
		} else {
		System.out.println("|-- " + file.getName());
		fileListNames.add(file.getName());
		}
		}
		} else {
		//System.out.print(" ".repeat(indentationCount * 2));
		System.out.println("|-- Empty Directory");
		}
		System.out.println();
		return fileListNames;
		}
	
}
