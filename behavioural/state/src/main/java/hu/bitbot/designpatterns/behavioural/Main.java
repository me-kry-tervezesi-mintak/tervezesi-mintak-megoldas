package hu.bitbot.designpatterns.behavioural;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DvdPlayerContext dvdPlayerContext = new DvdPlayerContext();
		dvdPlayerContext.setLength(1000);

		DvdThread dvdThread = new DvdThread();
		dvdThread.setDvdPlayerContext(dvdPlayerContext);
		dvdThread.start();

		OPERATIONS choice;
		do {
			choice = menu();
			switch (choice) {
				case STOP:
					dvdPlayerContext.stop();
					break;
				case PLAY:
					dvdPlayerContext.play();
					break;
				case FORWARD:
					dvdPlayerContext.forward10Frame();
					break;
				case BACKWARD:
					dvdPlayerContext.backward10Frame();
					break;
				case PAUSE:
					dvdPlayerContext.pause();
					break;
				case QUIT:
					dvdThread.terminate();
					break;
				default:
					// The user input an unexpected choice.
			}
		} while (choice != OPERATIONS.QUIT);
	}

	private static OPERATIONS menu() {

		int selection;
		Scanner input = new Scanner(System.in);

		System.out.println("Choose from these choices");
		System.out.println("-------------------------\n");
		System.out.println(OPERATIONS.STOP.ordinal() + " - Stop");
		System.out.println(OPERATIONS.PLAY.ordinal() + " - Play");
		System.out.println(OPERATIONS.FORWARD.ordinal() + " - forward 10 frame");
		System.out.println(OPERATIONS.BACKWARD.ordinal() + " - backward 10 frame");
		System.out.println(OPERATIONS.PAUSE.ordinal() + " - pause");
		System.out.println(OPERATIONS.QUIT.ordinal() + " - Quit");

		selection = input.nextInt();
		return OPERATIONS.values()[selection];
	}
}
