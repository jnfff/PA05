package lesson19;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numFrequentFlier;
  int numHealthy;
  int numOthers;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numOthers, int numFrequentFlier, int numHealthy){
    super(numShelterInPlace + numEssential + numFrequentFlier + numHealthy + numOthers);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numFrequentFlier = numFrequentFlier;
    this.numHealthy = numHealthy;
    this.numOthers = numOthers;
  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }

    for(int i=0; i<this.numOthers; i++){
      this.addPerson(new Skeptic());
    }

    for(int i=0; i<this.numFrequentFlier; i++){
      this.addPerson(new FrequentFlier());
    }

    for(int i=0; i<this.numHealthy; i++){
      this.addPerson(new HealthyPerson());
    }
  }
}
