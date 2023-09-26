/* The Interface: Hit */
interface Hit
{
    int Damage();
    String PerformHit();
}

interface HitDecorator extends Hit {
    Hit getDecoratedHit();
}



/* Classes that implements the Interface: Hit */

class NormalHit implements Hit
{
    @Override
    public String PerformHit() {
        return "hits a Normal Hit";
    }

    @Override
    public int Damage() { return 100; }
}

class ChargedHit implements Hit
{
    @Override
    public String PerformHit() {
        return "hits a Charged Hit";
    }

    @Override
    public int Damage() { return 200; }
}

class CriticalHit implements Hit
{
    @Override
    public String PerformHit() {
        return "hits a Critical Hit";
    }

    @Override
    public int Damage() { return 350; }
}

class ComboHit implements Hit
{
    @Override
    public String PerformHit() {
        return "hits a Combo Hit";
    }

    @Override
    public int Damage() { return 175; }
}

class PlungeHit implements Hit
{
    @Override
    public String PerformHit() {
        return "hits a Plunged Hit";
    }

    @Override
    public int Damage() { return 150; }
}


class ShieldHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Shield Hit";
    }

    @Override
    public int Damage() {
        return 50;
    }
}

class RangedHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Ranged Hit";
    }

    @Override
    public int Damage() { return 120; }
}




/* The Interface: Character */
interface Character
{
    String GetCharacter();
}


/* Classes that implements the Interface: Character */

class Wizard implements Character {
    @Override
    public String GetCharacter() { return "Wizard"; }
}

class Hero implements Character {
    @Override
    public String GetCharacter() { return "Hero"; }
}

class Mage implements Character {
    @Override
    public String GetCharacter() { return "Mage"; }
}

class Outlaw implements Character {
    @Override
    public String GetCharacter() { return "Outlaw"; }
}

class Vigilante implements Character {
    @Override
    public String GetCharacter() { return "Vigilante"; }
}


/*  The Parent Class: Fight */

abstract class Fight
{
    private Hit hitType;
    private Character characterType;

    public Fight(Hit hitType, Character characterType)
    {
        this.hitType = hitType;
        this.characterType = characterType;
    }

    public abstract void PerformActions();

    public abstract void BattleCry();

    protected Hit getHitType() { return hitType; }

    protected Character getCharacterType() { return characterType; }
}


/*  The Child Classes  */

class PragmaticFighting extends Fight
{
    public PragmaticFighting(Hit hitType, Character characterType)
    {
        super(hitType, characterType);
    }

    @Override
    public void PerformActions()
    {
        System.out.println(getCharacterType().GetCharacter() + " " + getHitType().PerformHit() + " and does " + getHitType().Damage() + " Damage");
    }

    @Override
    public void BattleCry()
    {
        System.out.println("Adapt... Analyze... Achieve !");
    }
}


class AggressiveFighting extends Fight
{
    public AggressiveFighting(Hit hitType, Character characterType) {
        super(hitType, characterType);
    }

    @Override
    public void PerformActions()
    {
        System.out.println(getCharacterType().GetCharacter() + " " + getHitType().PerformHit() + " and does " + getHitType().Damage() + " Damage");
    }

    @Override
    public void BattleCry()
    {
        System.out.println("Give everything out in the battle field!");
    }
}



/* Factory for creating Hit objects */

class HitFactory {
    public static Hit createHit(String type) {
        type = type.toLowerCase();
        if ("normal".equals(type)) {
            return new NormalHit();
        } else if ("charged".equals(type)) {
            return new ChargedHit();
        } else if ("critical".equals(type)) {
            return new CriticalHit();
        } else if ("combo".equals(type)) {
            return new ComboHit();
        } else if ("plunge".equals(type)) {
            return new PlungeHit();
        } else if ("shield".equals(type)) {
            return new ShieldHit();
        } else if ("ranged".equals(type)) {
            return new RangedHit();
        } else {
            throw new IllegalArgumentException("Invalid Hit type: " + type);
        }
    }
}


/* Factory for creating Character objects */

class CharacterFactory {
    public static Character createCharacter(String type) {
        type = type.toLowerCase();
        if ("wizard".equals(type)) {
            return new Wizard();
        } else if ("hero".equals(type)) {
            return new Hero();
        } else if ("mage".equals(type)) {
            return new Mage();
        } else if ("outlaw".equals(type)) {
            return new Outlaw();
        } else if ("vigilante".equals(type)) {
            return new Vigilante();
        } else {
            throw new IllegalArgumentException("Invalid Character type: " + type);
        }
    }
}



class ChargedPlungeHit implements HitDecorator {
    private final Hit decoratedHit;

    public ChargedPlungeHit(Hit decoratedHit) {
        this.decoratedHit = decoratedHit;
    }

    @Override
    public String PerformHit() {
        return decoratedHit.PerformHit() + " and does a Charged Plunge Attack";
    }

    @Override
    public int Damage() {
        return decoratedHit.Damage() + 90;
    }

    @Override
    public Hit getDecoratedHit() {
        return decoratedHit;
    }
}


class CriticalShieldedRangeHit implements HitDecorator {
    private final Hit decoratedHit;

    public CriticalShieldedRangeHit(Hit decoratedHit) {
        this.decoratedHit = decoratedHit;
    }

    @Override
    public String PerformHit() {
        return decoratedHit.PerformHit() + " and does a Critical Shielded Range Attack";
    }

    @Override
    public int Damage() {
        return decoratedHit.Damage() + 120;
    }

    @Override
    public Hit getDecoratedHit() {
        return decoratedHit;
    }
}

/*   Driver Class   */
class FightCheck
{
    public static void main(String[] args)
    {
        Hit criticalHit = HitFactory.createHit("Critical");
        Character character = CharacterFactory.createCharacter("Hero");

        Fight AggressiveAction = new AggressiveFighting(criticalHit, character);
        AggressiveAction.BattleCry();
        AggressiveAction.PerformActions();

        HitDecorator criticalShieldedRangeHit = new CriticalShieldedRangeHit(criticalHit);
        character = CharacterFactory.createCharacter("vigilante");

        Fight PragmaticAction = new PragmaticFighting(criticalShieldedRangeHit, character);
        PragmaticAction.BattleCry();
        PragmaticAction.PerformActions();
    }
}
