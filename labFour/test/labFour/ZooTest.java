package labFour;

import Animals.*;
import Cages.Cage;
import Cages.CagesForBirds;
import Cages.CagesForKopytnie;
import Cages.CagesForLions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

public class ZooTest {

    @Test
    public void getCountsOfAnimalsTest() throws Exception {
        Random random = new Random();

        Cage<Bird> cage1 = new CagesForBirds<>();
        int birdsCount = random.nextInt(cage1.getMaxPlaces());
        for (int i = 0; i < birdsCount; i++){
            cage1.addInhabitant(new Eagle());
        }

        Cage<Kopytnie> cage2 = new CagesForKopytnie<>();
        int kopytnieCount = random.nextInt(cage2.getMaxPlaces());
        for (int i = 0; i < kopytnieCount; i++){
            cage2.addInhabitant(new Giraf());
        }

        Cage<Lion> cage3 = new CagesForLions<>();
        int lionsCount = random.nextInt(cage3.getMaxPlaces());
        for (int i = 0; i < lionsCount; i++){
            cage3.addInhabitant(new Lion());
        }

        Zoo testZoo = new Zoo();

        testZoo.addCage(cage1);
        testZoo.addCage(cage2);
        testZoo.addCage(cage3);


        Assert.assertEquals(lionsCount + kopytnieCount + birdsCount, testZoo.getCountOfAnimals());
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void removeFailTest() throws Exception {
        exception.expect(NoAnimalException.class);
        Cage<Kopytnie> cage = new CagesForKopytnie<>();
        cage.removeInhabitant();
    }

    @Test
    public void addFailTest() throws Exception {
        exception.expect(FullCagesException.class);
        Cage<Lion> cage = new CagesForLions<>();

        for (int i = 0; i < cage.getMaxPlaces() + 1; i++){
            cage.addInhabitant(new Lion());
        }
    }

}