package StrategyPattern.CharacterClasses;

import StrategyPattern.Interfaces.Character;

public class Hero implements Character {
    @Override
    public String GetCharacter() {
        return "Hero";
    }
}
