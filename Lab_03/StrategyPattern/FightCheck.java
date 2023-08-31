package StrategyPattern;

import StrategyPattern.CharacterClasses.Hero;
import StrategyPattern.CharacterClasses.Vigilante;
import StrategyPattern.MainClasses.AggressiveFighting;
import StrategyPattern.MainClasses.Fight;
import StrategyPattern.HitClasses.ChargedHit;
import StrategyPattern.HitClasses.RangedHit;
import StrategyPattern.MainClasses.PragmaticFighting;

public class FightCheck
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
