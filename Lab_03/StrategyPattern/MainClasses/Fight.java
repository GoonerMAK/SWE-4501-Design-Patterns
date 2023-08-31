package StrategyPattern.MainClasses;

import StrategyPattern.Interfaces.Character;
import StrategyPattern.Interfaces.Hit;

public class Fight
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


