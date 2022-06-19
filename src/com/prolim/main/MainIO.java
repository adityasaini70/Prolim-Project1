package com.prolim.main;

import java.io.IOException;
import java.util.Scanner;

import com.prolim.IOOperation.FileOperations;

public class MainIO {
	public static void main(String[] args) throws IOException {

		// Taking input from user for the directory
		Scanner dirAndOptionInputter = new Scanner(System.in);
		System.out.println("Welcome to LockedMe.com");
		System.out.println("Developer: Aditya Saini, Trainee");
		System.out.println("Developer telephone: +91 9991552342");
		System.out.println("Developer email: aditya.fr@prolim.com");
		System.out.println("Enter the path to directory");
		String pathDir = dirAndOptionInputter.next();

		// Initializing a file handler for the given path
		FileOperations fileOperationsObj = new FileOperations(pathDir);

		// Running an infinite loop
		while (true) {

			// Displaying main menu
			System.out.println(
					"Main Menu: Choose one of the following options:\nOption 1: Files in Ascending Order \nOption 2: File Operations \nOption 3: Close");

			// Taking option from main menu
			int mainMenuOption = dirAndOptionInputter.nextInt();

			// Running relevant methods in accordance with the option selected by user
			switch (mainMenuOption) {
			case 1:
				// Main menu Option 1: Display files in ascending order
				fileOperationsObj.displayFilesInAscendingOrder();
				break;
			case 2:
				// Main menu Option 2: File Operations
				while (true) {
					// Displaying sub menu
					System.out.println(
							"Sub Menu: Choose one of the following options:\nOption 1: Add a File \nOption 2: Delete a File \nOption 3: Search a File \nOption 4: Close submenu");

					// Taking user input for sub menu
					int subMenuOption = dirAndOptionInputter.nextInt();

					// Running relevant methods in accordance with the option selected by user

					if (subMenuOption == 1) {
						// Sub menu Option 1: Add File
						fileOperationsObj.addFile();
					} else if (subMenuOption == 2) {
						// Sub menu Option 2: Delete File
						fileOperationsObj.deleteFile();
					} else if (subMenuOption == 3) {
						// Sub menu Option 3: Search File
						fileOperationsObj.searchFile();
					} else if (subMenuOption == 4) {
						// Sub menu Option 4: Exit Sub menu
						break;
					} else {
						// Handling invalid inputs from user
						System.out.println("Please enter valid input.");
					}
				}
				break;
			case 3:
				// Main menu Option 3: Exit program
				System.exit(0);
			default:
				// Handling invalid inputs from user
				System.out.println("Please enter valid input.");
				break;
			}

		}

	}
}
