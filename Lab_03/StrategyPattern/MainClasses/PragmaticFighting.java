package StrategyPattern.MainClasses;

import StrategyPattern.MainClasses.Fight;
import StrategyPattern.Interfaces.Character;
import StrategyPattern.Interfaces.Hit;

public class PragmaticFighting extends Fight {
    public PragmaticFighting(Hit hitType, Character characterType) {
        super(hitType, characterType);
    }

    @Override
    public void BattleCry()
    {
        System.out.println("Adapt... Analyze... Achieve !");
    }

}
