package labFour;

import Animals.*;
import Cages.Cage;
import Cages.CagesForLions;
import Cages.CagesForBirds;
import Cages.CagesForKopytnie;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Cage<? extends Animal>> cages = new ArrayList<>();

    public int getCountOfAnimals (){
        int animalsInTheZoo=0;
        for (Cage cage: cages) {
            if (cage!=null && cage.getOccupiedPlaces()>0) {
                animalsInTheZoo+=cage.getOccupiedPlaces();
            }
        }
        return animalsInTheZoo;
    }
    public void addCage(Cage<? extends Animal> cage){
        this.cages.add(cage);
    }

    public static Zoo zoo;

    public static void main(String[] args) throws FullCagesException, NoAnimalException {
        Cage<Lion> lions = new CagesForLions<>();
        Cage<Kopytnie> kopytnie = new CagesForKopytnie<>();
        Cage<Eagle> eagles = new CagesForBirds<>();

        Cage<? extends Mammal> test = new CagesForLions<Lion>();

        lions.addInhabitant(new Lion());
        //lions.addInhabitant(new Zebra());
        kopytnie.addInhabitant(new Zebra());
        kopytnie.addInhabitant(new Giraf());

        eagles.addInhabitant(new Eagle());
        //eagles.addInhabitant(new Giraf());
        //eagles.addInhabitant(new Lion());

        zoo = new Zoo();
        zoo.addCage(lions);
        zoo.addCage(kopytnie);
        zoo.addCage(eagles);

        System.out.println(zoo.getCountOfAnimals());
    }
}