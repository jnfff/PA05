package lesson19;

public class HealthyPerson extends Person{


	public HealthyPerson() {
		super();
		infectionProb = 0.25;
		recoveryTime = 3;
	}

	public void tryToMove() {
		if (!this.infected){
			super.tryToMoveRandomly();
		}
	}

}
