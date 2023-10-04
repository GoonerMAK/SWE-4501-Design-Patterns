import java.util.Objects;

class Croissant implements Cloneable {
    private String flavor;
    private boolean isFresh;

    public Croissant() {
        isFresh = true;
    }

    public void setFlavor(String flavor) {
        if (isFresh) {
            this.flavor = flavor;
        } else {
            System.out.println("The Croissant is no longer fresh to set it as a new flavor.");
        }
    }

    public String getFlavor() {
        return flavor;
    }

    public void eat() {
        if (isFresh) {
            System.out.println("Enjoy the " + flavor + " flavored Croissant!");
        } else {
            System.out.println("This Croissant is no longer fresh. Consider getting a new one.");
        }
    }

    public void describeCroissant() {
        System.out.println("Croissant Flavor: " + flavor);
        System.out.println("Freshness Status: " + (isFresh ? "Fresh" : "Not Fresh"));
    }

    public void setStale() {
        isFresh = false;
    }

    @Override
    public Croissant clone() {
        try {
            return (Croissant) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

class Bakery {
    public static void main(String[] args) {
        Croissant prototypeCroissant = new Croissant();
        prototypeCroissant.setFlavor("Original");

        Croissant strawberryCroissant = prototypeCroissant.clone();
        strawberryCroissant.setFlavor("Strawberry");

        Croissant chocolateCroissant = prototypeCroissant.clone();
        chocolateCroissant.setFlavor("Chocolate");

        // Displaying flavors
        System.out.println("Strawberry Croissant: " + strawberryCroissant.getFlavor());
        System.out.println("Chocolate Croissant: " + chocolateCroissant.getFlavor());

        strawberryCroissant.eat(); // Fresh, enjoy!
        chocolateCroissant.eat(); // Fresh, enjoy!

        Croissant plainCroissant = prototypeCroissant.clone();
        plainCroissant.setFlavor("Plain");

        plainCroissant.eat(); // Fresh, enjoy!

        // Describing croissants
        strawberryCroissant.describeCroissant();
        chocolateCroissant.describeCroissant();
        plainCroissant.describeCroissant();
    }
}
