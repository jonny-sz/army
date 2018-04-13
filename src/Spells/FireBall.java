package Spells;

import Mages.Mage;

public class FireBall extends BattleSpell {
    public FireBall(Mage owner, int power, int cost) {
        super(owner, "FireBall", power, cost);
    }

    public FireBall(Mage owner) {
        this(owner, 30, 25 );
    }
}
