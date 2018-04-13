package Spells;

import Exceptions.ArmyExceptions;
import Exceptions.OutOfManaException;
import Mages.Mage;
import Units.Unit;

public class HealerSpell extends Spell {
    public HealerSpell(Mage owner, String title, int power, int cost) {
        super(owner,title, cost);

        if ( owner.getMageType().equals("HealerMage") ) {
            this.power = power;
        } else {
            this.power = power / 2;
        }
    }

    @Override
    public void cast(Unit target) throws ArmyExceptions {
        if ( this.owner.getMana() < this.cost ) {
            throw new OutOfManaException();
        }

        target.takeMagicHeal(this.power);
        this.owner.spendMana(this.cost);
    }
}
