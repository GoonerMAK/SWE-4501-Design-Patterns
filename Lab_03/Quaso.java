public class Quaso
{
    private static Quaso uniqueInstance;
    private String flavor;
    private boolean isFresh;

    private Quaso()
    {
        isFresh = true;
    }

    public static Quaso getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Quaso();
        }
        return uniqueInstance;
    }

    public void setFlavor(String flavor)
    {
        if (isFresh)
        {
            this.flavor = flavor;
        }
        else
        {
            System.out.println("The Quaso is no longer fresh to set it as a new flavor.");
        }
    }

    public String getFlavor()
    {
        return flavor;
    }

    public void eat()
    {
        if (isFresh)
        {
            System.out.println("Enjoy the " + flavor + " flavoured Quaso!");
        }
        else
        {
            System.out.println("This Quaso is no longer fresh. Consider getting a new one.");
        }
    }

    public void describeCroissant()
    {
        System.out.println("Croissant Flavor: " + flavor);
        System.out.println("Freshness Status: " + (isFresh ? "Fresh" : "Not Fresh"));
    }

    public void setStale()
    {
        isFresh = false;
    }


    public static void main(String[] args)
    {
        // Setting Strawberry Flavour
        Quaso strawberryCroissant = Quaso.getInstance();
        strawberryCroissant.setFlavor("Strawberry");
        System.out.println("Strawberry Croissant: " + strawberryCroissant.getFlavor());

        // Setting Chocolate Flavour
        Quaso chocolateCroissant = Quaso.getInstance();
        chocolateCroissant.setFlavor("Chocolate");

        // Displaying flavors
        System.out.println("Strawberry Croissant: " + strawberryCroissant.getFlavor());
        System.out.println("Chocolate Croissant: " + chocolateCroissant.getFlavor());

        strawberryCroissant.eat(); // Fresh, enjoy!
        chocolateCroissant.eat(); // Will it be Fresh?

        Quaso plainCroissant = Quaso.getInstance();
        plainCroissant.setFlavor("Plain");

        plainCroissant.eat();

        // Describing croissants
        strawberryCroissant.describeCroissant();

        strawberryCroissant.setStale();

        chocolateCroissant.describeCroissant();
        plainCroissant.describeCroissant();

    }

}
