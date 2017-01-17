package Cages;

import Animals.Lion;

import java.util.ArrayList;

public class CagesForLions <T extends Lion> extends CagesForMammals<T>{
    public CagesForLions() {
        this.inhabitant=new ArrayList<T>();
        this.maxPlaces=3;
    }
}
