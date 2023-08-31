package StrategyPattern.CharacterClasses;

import StrategyPattern.Interfaces.Character;

public class Wizard implements Character {
    @Override
    public String GetCharacter() {
        return "Wizard";
    }
}
