public abstract class Player {

    final void Play()               // Template Method
    {
        WarmUp();
        Strategize();
        Execute();
        Rest();
    }

    final void WarmUp()                 // Common for every sub-classes (Concrete Method)
    {
        System.out.println("Exercise");
    }

    abstract void Strategize();         // Primitive method

    abstract void Execute();              // Primitive method

    void Rest()                       //  Hook method
    {
        System.out.println("Take some Rest");
    }

}


class Footballer extends Player
{
    @Override
    void Strategize()               // Primitive method
    {
        System.out.println("Strategize Football Formation");
    }

    @Override
    void Execute()                 // Primitive method
    {
        System.out.println("Execute Football Formation");
    }

    @Override
    void Rest()                 // Overriding the Hook method
    {
        System.out.println("Take a bit more rest than usual");
    }

}


class Cricketer extends Player
{
    @Override
    void Strategize()                // Primitive method
    {
        System.out.println("Strategize Powerplay");
    }

    @Override
    void Execute()                 // Primitive method
    {
        System.out.println("Execute Powerplay Plan");
    }

}