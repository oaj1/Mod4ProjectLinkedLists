import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner; // Import the Scanner class

public class VideoStore {
	ListInterface<Video> videos; // ListInterface object of type Video
	ListInterface<Customer> customers; // ListInterface object of type Customer

	public VideoStore(String type, int arg1, int arg2, int arg3) {
		if (type.equals("SLL")) {
			videos = new SLL<Video>();// initialize SLL video
			customers = new SLL<Customer>();// initialize SLL customer
		} else {
			videos = new DLL<Video>();// initialize DLL video
			customers = new DLL<Customer>();// initialize DLL video
		}

		// here is where I generate random videos
		// create arg1 number of video objects
		for (int i = 0; i < arg1; i++) {
			Video video = new Video(i + "");// this creates video objects arg1 times
			videos.add(video); // here we add the videos
		}

		// here is where I generate random customers
		// create arg2 number of video objects
		for (int i = 0; i < arg2; i++) {
			Customer customer = new Customer(i + "");// this creates video objects arg1 times
			customers.add(customer); // here we add the videos
		}

		// Here is where I'll check if the video is in store
		// loop arg3 number of video objects
		Random rand = new Random(); // this is an instance of the random class
		long start = System.currentTimeMillis();
		for (int i = 0; i < arg3; i++) {

			String stringRadom = rand.nextInt(arg1) + ""; // this generates random videos of length arg1, and makes the
															// interger into a String
			Video getVid = videos.get(new Video(stringRadom));
			

		}
		long end = System.currentTimeMillis();
		long elapsed = end-start;
		System.out.println("Time Elapsed " + elapsed + " ms");
	}

	// @SuppressWarnings("rawtypes")
	public VideoStore(String type, Scanner input) {// Constructor

		if (type.equals("SLL")) {
			videos = new SLL<Video>();// initialize SLL video
			customers = new SLL<Customer>();// initialize SLL customer
		} else {
			videos = new DLL<Video>();// initialize DLL video
			customers = new DLL<Customer>();// initialize DLL video
		}

		// Create a loop that continues to print menu after option selection up until
		// option 13 is selected to exit
		while (true) {
			printMenu();

			String line = input.nextLine().trim(); // Get user input variable, if user enters a space etc, trim will
													// handle

			if (line.equals("1")) {
				System.out.println("Please Enter Video Title: ");
				String video = input.nextLine();
				videos.add(new Video(video));// creates a videos object and passes it to the add method
			}

			else if (line.equals("2")) {
				System.out.println("Please Enter Video Title: ");
				String video = input.nextLine();
				videos.delete(new Video(video));// creates a videos object and passes it to the delete method

			} else if (line.equals("3")) {
				System.out.println("Please Enter Customer: ");
				String customer = input.nextLine();
				customers.add(new Customer(customer));// creates a customers object and passes it to the add method
			} else if (line.equals("4")) {
				System.out.println("Please Enter Customer Name:");
				String customer = input.nextLine();
				customers.delete(new Customer(customer));// creates customers object and passes it to the delete method

			} else if (line.equals("5")) { // The below code gets a video entered, passes that object into getBid, if is
											// available print, else print not available
				System.out.println("Please Enter Video Title: ");
				String video = input.nextLine();
				Video getVid = videos.get(new Video(video));
				if (getVid == null) {
					System.out.println("No video was found by title: " + video);
				} else {
					if (getVid.isAvailable()) {
						System.out.println(video + " is available");
					} else {
						System.out.println(video + "is NOT available");
					}
				}
			} else if (line.equals("6")) {
				System.out.println("Please enter video to check out");
				String video = input.nextLine();
				Video getVid = videos.get(new Video(video));// creates video object and passes it to the get method
				if (getVid == null) {
					System.out.println("No video was found by title: " + video);
				}

				else if (getVid.isAvailable()) {
					getVid.notAvailable();
				}

			} else if (line.equals("7")) {
				System.out.println("Please enter video to check in");
				String videoIn = input.nextLine();
				Video getVid = videos.get(new Video(videoIn)); // uses the get method, and then checks if available is
																// true
				if (getVid == null) {
					System.out.println("No video was found by title: " + videoIn);
				}

				else if (getVid.isAvailable()) {
					System.out.println("Video: " + videoIn + " already available");
				}

				else if (!getVid.isAvailable()) {
					System.out.println("Video: " + videoIn + " has been checked out and is now checked in");
					getVid.makeAvailable();
				}

			} else if (line.equals("8")) {
				System.out.println("All Customers: ");
				customers.print(); // prints all customers
			}

			else if (line.equals("9")) {
				System.out.println("All Videos: ");
				videos.print();// prints all videos
			}

			else if (line.equals("10")) {

				System.out.println("In Store Videos");
				Iterator<Video> iterator = videos.iterator(); // Here is used the iterator to go over all the videos, if
																// is available, print
				while (iterator.hasNext()) {
					Video video = iterator.next();
					if (video.isAvailable()) {
						System.out.println(video);
					}
				}
			} else if (line.equals("11")) {

				System.out.println("Checked Out Store Videos");
				Iterator<Video> iterator = videos.iterator(); // Here is used the iterator to go over all the videos, if
																// is available, print
				while (iterator.hasNext()) {
					Video video = iterator.next();
					if (!video.isAvailable()) {
						System.out.println(video);
					}
				}
			}

			else if (line.equals("13")) {
				System.out.println("Goodbye");
				break;
			}
		}
	}

	public void printMenu() { // This method prints the menu

		System.out.println("1: To add a video"); // add a video
		System.out.println("2: To delete a video"); // delete a video
		System.out.println("3: To add a customer"); // add customer
		System.out.println("4: To delete a customer");// delete customer
		System.out.println("5: Check if particular video is in store");// To check if video is in store
		System.out.println("6: Check out a video");// To check out a video
		System.out.println("7: Check in a video");// To check out a video
		System.out.println("8: To list customers"); // list all customers
		System.out.println("9: To list videos"); // list all videos
		System.out.println("10: To print in-store videos");// print in-store videos
		System.out.println("11: To print checked out videos");// print in-store videos
		System.out.println("13: To exit"); // exit the program

	}

	public static void main(String[] args) {
		/**
		 * use input to read argument of either SLL or DLL
		 */
		Scanner input = new Scanner(System.in);
		String arg;
		int arg2;
		int arg3;
		int arg4;

		if (args.length == 0) {
			System.out.println("Enter in either SLL or DLL: ");
			arg = input.nextLine().toUpperCase();
			// return;
		} else {
			arg = args[0].toUpperCase();
			if (args.length == 4) {
				if (arg.equals("SLL") || arg.equals("DLL")) {
					try {

						arg2 = Integer.parseInt(args[1]);
						arg3 = Integer.parseInt(args[2]);
						arg4 = Integer.parseInt(args[3]);

						new VideoStore(arg, arg2, arg3, arg4);
						System.exit(0);

					} catch (NumberFormatException e) {
						System.out.println(e);
						System.out.println("Please enter in 3 integer values after typing SLL or DLL");
						System.exit(0);
					}
				}
			} else if (args.length != 1) {
				System.out.println("Error, the number of arguements entered is wrong");
				System.exit(0);
			}
		}
		if (arg.equals("SLL") || arg.equals("DLL")) {
			new VideoStore(arg, input); // create Video Store object, pass in both the argument and the input of either
										// SLL or DLL
		} else {
			System.out.println("Invalid entry, please type in either SLL or DLL");
		}

		input.close();// close scanner

	}

}
