package bug;



/**
 * Troubling Rank Bugs Sample.
 */
public class TroublingRankBugs {

	/**
	 * Le synchronized est vide
	 */
	private void emptySynchronized() {
		synchronized (this) {
			// Forgot implementation
		}
	}

	/**
	 * SLe thread qui a le verrou dort ce qui n'est pas très normal
	 * 
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	private void sleepInSynchronized() throws InterruptedException {
		synchronized (this) {
			Thread.sleep(5000);
		}
	}

	/**
	 * méthode main.
	 * 
	 * @param args
	 *            the args
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		TroublingRankBugs instance = new TroublingRankBugs();
		instance.emptySynchronized();
		instance.sleepInSynchronized();
	}
}
