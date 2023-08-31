package StrategyPattern.HitClasses;

import StrategyPattern.Interfaces.Hit;

public class ComboHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Combo Hit";
    }
}
