package Spells;

import Mages.Mage;

public class Heal extends HealerSpell {
    public Heal(Mage owner, int power, int cost) {
        super(owner, "Heal", power, cost);
    }

    public Heal(Mage owner) {
        this(owner, 30, 25 );
    }
}
