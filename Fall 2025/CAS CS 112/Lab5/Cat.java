package Lab5;
/*
 * Cat.java
 *
 * A simple class representing a cat.
 */

public class Cat extends Animal {
    private boolean isShortHaired;

    public Cat() {
	super("Mycatt", 3);
    }

    public Cat(String name, boolean shortHaired){
        super(name, 3);
        this.isShortHaired = shortHaired;
    }

    public boolean isShortHaired() {
        return this.isShortHaired;
    }
    
    public boolean isExtroverted() {
        return false;
    }
}
