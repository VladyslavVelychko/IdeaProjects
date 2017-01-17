package Cages;

import Animals.Animal;
import labFour.FullCagesException;
import labFour.NoAnimalException;

import java.util.List;

public abstract class Cage <T extends Animal> {

    protected List<T> inhabitant;
    protected int maxPlaces;

    public int getMaxPlaces() {
        return maxPlaces;
    }

    public int getOccupiedPlaces() {
        return inhabitant.size();
    }
    public void removeInhabitant ()throws NoAnimalException
    {
        if (getOccupiedPlaces()<1) {
            throw new NoAnimalException();
        }
        inhabitant.remove(inhabitant.size()-1);
    }

    public void addInhabitant(T animal)throws FullCagesException
    {
        if(getOccupiedPlaces() >= getMaxPlaces()) {
            throw new FullCagesException();
        }
        inhabitant.add(animal);
    }

}
