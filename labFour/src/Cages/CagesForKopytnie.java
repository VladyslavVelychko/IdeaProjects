package Cages;

import Animals.Kopytnie;

import java.util.ArrayList;

public class CagesForKopytnie <T extends Kopytnie> extends CagesForMammals<T>{
    public CagesForKopytnie() {
        this.inhabitant=new ArrayList<T>();
        this.maxPlaces=10;
    }
}
