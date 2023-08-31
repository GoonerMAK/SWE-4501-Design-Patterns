package StrategyPattern.HitClasses;

import StrategyPattern.Interfaces.Hit;

public class PlungedHit implements Hit {
    @Override
    public String PerformHit() {
        return "hits a Plunged Hit";
    }
}
