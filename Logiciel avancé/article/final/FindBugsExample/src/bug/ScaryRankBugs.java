package bug;



/**
 * Scary Rank Bugs Sample
 */
public class ScaryRankBugs {
	
	/** The check str value. */
	private String checkStrValue = null;

	/**
	 * The Constructor.
	 */
	public ScaryRankBugs() {
		this.checkStrValue = "SomeValue";
	}

	/**
	 * Executer quelques conditions. les deux conditions réalisent les memes choses
	 */
	private void executeSomeConditions() {
		if ("SomeVDuplicate conditionalue".equalsIgnoreCase(this.checkStrValue)) {
			// Condition 1
		} 
		else if ("SomeValue".equals(this.checkStrValue)) {
			// Condition dupliquée
		}
	}

	/**
	 * Affectation au lieu de test d'égalité.
	 */
	private static void incorrectAssignmentInIfCondition() {
		boolean value = false;
		if (value = true) {
			//do Something
		} else {
			//else Do Something
		}
	}

	/**
	 * Méthode main.
	 *
	 * @param args the args
	 */
	public static void main(String[] args) {
		ScaryRankBugs instance = new ScaryRankBugs();
		instance.executeSomeConditions();
	}
}
