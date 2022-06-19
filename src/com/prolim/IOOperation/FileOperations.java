package com.prolim.IOOperation;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {

	// Initializing instance variables
	private File fileHandler;
	private String dir;
	private Scanner fileInputter = new Scanner(System.in);

	// Initializing getters and setters for the instance variables
	public File getFileHandler() {
		return fileHandler;
	}

	public void setFileHandler(File fileHandler) {
		this.fileHandler = fileHandler;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	// Constructor
	public FileOperations(String path) {
		this.dir = path;
		this.fileHandler = new File(path);
	}

	// Main menu Option 1: Display files in ascending order
	public void displayFilesInAscendingOrder() {

		// Storing name of all files in an array and sorting in ascending order
		File allFiles[] = this.fileHandler.listFiles();
		Arrays.sort(allFiles);

		// Iterating over the array and printing file names
		for (File fileIter : allFiles) {
			System.out.println(fileIter.getName());
		}
	}

	// Sub menu Option 1: Add file
	public void addFile() throws IOException {

		// Taking input of file name
		System.out.println("Enter file name");
		String filename = this.fileInputter.next();
		String path = this.dir + filename;

		// Generating a file hander for the path entered by user
		File fileCreatorObj = new File(path);

		// Creating new file and storing success code
		boolean isFileCreated = fileCreatorObj.createNewFile();

		// Printing success and failure messages
		if (isFileCreated) {
			System.out.println("File is created!");
		} else {
			System.out.println("File is not created. Please try again.");
		}
	}

	// Sub menu Option 2: Delete file
	public void deleteFile() throws IOException {

		// Taking input of file name
		System.out.println("Enter file name");
		String filename = this.fileInputter.next();
		String path = this.dir + filename;

		// Generating a file hander for the path entered by user
		File fileDeletorObj = new File(path);

		// Deleting file and storing success code
		boolean isFileDeleted = fileDeletorObj.delete();

		// Printing success and failure messages
		if (isFileDeleted) {
			System.out.println("File is deleted!");
		} else {
			if (fileDeletorObj.exists()) {
				System.out.println("File is not deleted. Please try again.");
			} else {
				System.out.println("File does not exist. Please try again.");
			}
		}
	}

	// Sub menu Option 3: Search file
	public void searchFile() {

		// Taking input of file name
		System.out.println("Enter file name:");
		String filename = this.fileInputter.next();

		// Generating a file hander for the path entered by user
		File fileSearchObj = new File(dir);

		// Initializing a file finding flag variable
		boolean fileFound = false;

		// Storing name of all files in an array
		File fileList[] = fileSearchObj.listFiles();

		// Iterating over all file names in the directory
		for (File fileIterator : fileList) {

			// If file is found, update the flag variable and break from the loop
			if (fileIterator.getName().equals(filename)) {
				fileFound = true;
				break;
			}
		}

		// Printing success and failure messages
		if (fileFound) {
			System.out.println("File found successfully!");
		} else {
			System.out.println("File is not found. Please try again.");
		}

	}

}
