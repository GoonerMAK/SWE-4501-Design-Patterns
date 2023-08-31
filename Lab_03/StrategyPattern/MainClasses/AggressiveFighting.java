package StrategyPattern.MainClasses;

import StrategyPattern.Interfaces.Character;
import StrategyPattern.Interfaces.Hit;

public class AggressiveFighting extends Fight {
    public AggressiveFighting(Hit hitType, Character characterType) {
        super(hitType, characterType);
    }

}
