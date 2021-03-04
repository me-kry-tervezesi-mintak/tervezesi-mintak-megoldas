package hu.bitbot.designpatterns.behavioural.state;

/**
 * Created by zoltankrizsan on 2017. 01. 16..
 */
public class DvdThread  implements Runnable {
	private boolean running;
	private Thread thread;

	public void setDvdPlayerContext(DvdPlayerContext dvdPlayerContext) {
		this.dvdPlayerContext = dvdPlayerContext;
	}

	DvdPlayerContext dvdPlayerContext;

	public DvdThread() {
		running = true;
	}

	public void run() {
		try {
			while(running) {
				System.out.println(dvdPlayerContext.toString());
				dvdPlayerContext.spin();
				Thread.sleep(1000);
			}
		}catch (InterruptedException ex) {
			System.out.println("DvdPlayerContext interrupted.");
		}
	}

	public void start() {
		thread = new Thread(this, "DvdPlayerContext");
		thread.start();
	}


	public void terminate() {
		running = false;
	}
}
