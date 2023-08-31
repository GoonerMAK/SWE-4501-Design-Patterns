package StrategyPattern.CharacterClasses;

import StrategyPattern.Interfaces.Character;

public class Outlaw implements Character {
    @Override
    public String GetCharacter() {
        return "Outlaw";
    }
}
