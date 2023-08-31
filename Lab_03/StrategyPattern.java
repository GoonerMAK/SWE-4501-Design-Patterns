
/* The Interface: Hit */
interface Hit
{
    String PerformHit();
}


/* Classes that implements the Interface: Hit */

class NormalHit implements Hit
{
    @Override
    public String PerformHit() {
        return "hits a Normal Hit";
    }
}

class ChargedHit implements Hit
{
    @Override
    public String PerformHit() {
        return "hits a Charged Hit";
    }
}

class CriticalHit implements Hit
{
    @Override
    public String PerformHit() {
        return "It's a Critical Hit";
    }
}

class ComboHit implements Hit
{
    @Override
    public String PerformHit() {
        return "It's a Combo Hit";
    }
}

class PlungeHit implements Hit
{
    @Override
    public String PerformHit() {
        return "It's a Plunged Hit";
    }
}


class ShieldHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Shield Hit";
    }
}

class RangedHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Ranged Hit";
    }
}



/* The Interface: Character */
interface Character
{
    String GetCharacter();
}

/* Classes that implements the Interface: Character */

class Wizard implements Character {
    @Override
    public String GetCharacter() {
        return "Wizard";
    }
}

class Hero implements Character {
    @Override
    public String GetCharacter() {
        return "Hero";
    }
}

class Mage implements Character {
    @Override
    public String GetCharacter() {
        return "Mage";
    }
}

class Outlaw implements Character {
    @Override
    public String GetCharacter() {
        return "Outlaw";
    }
}

class Vigilante implements Character {
    @Override
    public String GetCharacter() {
        return "Vigilante";
    }
}


/*  The Parent Class: Fight */

class Fight
{
    private Hit hitType;
    private Character characterType;

    public Fight(Hit hitType, Character characterType)
    {
        this.hitType = hitType;
        this.characterType = characterType;
    }

    public void PerformActions()
    {
        System.out.println(characterType.GetCharacter() + " " + hitType.PerformHit());
    }

    public void BattleCry()
    {
        System.out.println("Give everything out in the battle field!");
    }

}


/*  The Child Classes  */

class PragmaticFighting extends Fight {
    public PragmaticFighting(Hit hitType, Character characterType) {
        super(hitType, characterType);
    }

    @Override
    public void BattleCry()
    {
        System.out.println("Adapt... Analyze... Achieve !");
    }
}

class AggressiveFighting extends Fight {
    public AggressiveFighting(Hit hitType, Character characterType) {
        super(hitType, characterType);
    }
}



/*   Driver Class   */
class FightCheck
{
    public static void main(String[] args)
    {
        Fight AggressiveAction = new AggressiveFighting(new ChargedHit(), new Hero());
        AggressiveAction.BattleCry();
        AggressiveAction.PerformActions();

        Fight PragmaticAction = new PragmaticFighting(new RangedHit(), new Vigilante());
        PragmaticAction.BattleCry();
        PragmaticAction.PerformActions();
    }
}