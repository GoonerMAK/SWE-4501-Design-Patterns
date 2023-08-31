class Croissant
{
    private static Croissant uniqueInstance;
    private String flavor;
    private boolean isFresh;

    private Croissant()
    {
        isFresh = true;
    }

    public static Croissant getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Croissant();
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
            System.out.println("The Croissant is no longer fresh to set it as a new flavor.");
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
            System.out.println("This Croissant is no longer fresh. Consider getting a new one.");
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

}


class Bakery
{
    public static void main(String[] args)
    {
        // Setting Strawberry Flavour
        Croissant strawberryCroissant = Croissant.getInstance();
        strawberryCroissant.setFlavor("Strawberry");
        System.out.println("Strawberry Croissant: " + strawberryCroissant.getFlavor());

        // Setting Chocolate Flavour
        Croissant chocolateCroissant = Croissant.getInstance();
        chocolateCroissant.setFlavor("Chocolate");

        // Displaying flavors
        System.out.println("Strawberry Croissant: " + strawberryCroissant.getFlavor());
        System.out.println("Chocolate Croissant: " + chocolateCroissant.getFlavor());

        strawberryCroissant.eat(); // Fresh, enjoy!
        chocolateCroissant.eat(); // Will it be Fresh?

        Croissant plainCroissant = Croissant.getInstance();
        plainCroissant.setFlavor("Plain");

        plainCroissant.eat();

        // Describing croissants
        strawberryCroissant.describeCroissant();

        strawberryCroissant.setStale();

        chocolateCroissant.describeCroissant();
        plainCroissant.describeCroissant();

    }
}