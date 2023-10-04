interface Prototype {
    Croissant clone();
}

class Croissant implements Prototype {
    private String flavor;
    boolean isFresh;

    public Croissant() {
        this.isFresh = true;
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

    public Croissant clone() {
        Croissant clone = new Croissant();
        clone.setFlavor(this.getFlavor());
        clone.isFresh = this.isFresh;
        return clone;
    }
}

class ChocolateCroissant extends Croissant {
    private boolean hasChocolateChips;

    public ChocolateCroissant() {
        super(); // Call the constructor of the superclass (Croissant)
        this.hasChocolateChips = false; // Default to no chocolate chips
    }

    // Additional constructor to set chocolate chip status
    public ChocolateCroissant(boolean hasChocolateChips) {
        super(); // Call the constructor of the superclass (Croissant)
        this.hasChocolateChips = hasChocolateChips;
    }

    // Method to check if it has chocolate chips
    public boolean hasChocolateChips() {
        return hasChocolateChips;
    }

    // Method to add chocolate chips
    public void addChocolateChips() {
        if (super.isFresh) {
            hasChocolateChips = true;
            System.out.println("Chocolate chips added to the Chocolate Croissant.");
        } else {
            System.out.println("This Croissant is no longer fresh. Consider getting a new one.");
        }
    }

    @Override
    public void describeCroissant() {
        super.describeCroissant(); // Call the describeCroissant method of the superclass
        System.out.println("Has Chocolate Chips: " + (hasChocolateChips ? "Yes" : "No"));
    }
}

public class Bakery {
    public static void main(String[] args) {
        ChocolateCroissant chocoCroissant = new ChocolateCroissant();
        chocoCroissant.setFlavor("Chocolate");
        chocoCroissant.addChocolateChips();

        System.out.println("Chocolate Croissant Flavor: " + chocoCroissant.getFlavor());
        chocoCroissant.describeCroissant();
    }
}


