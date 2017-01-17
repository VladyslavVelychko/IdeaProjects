package Cages;

import Animals.Bird;

import java.util.ArrayList;

public class CagesForBirds <T extends Bird> extends Cage<T>{
    public CagesForBirds() {
        this.inhabitant = new ArrayList<T>();
        this.maxPlaces=10;
    }
}
