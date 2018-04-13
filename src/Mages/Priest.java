package Mages;

import Exceptions.ArmyExceptions;
import MageActions.PriestAction;
import Spells.FireBall;
import Spells.Heal;
import States.MageState;

public class Priest extends Mage {
    public Priest(String name, int hp, int mana, int damage) throws ArmyExceptions {
        super(name);
        this.state = new MageState("Priest", hp, mana, damage);
        this.action = new PriestAction();
        this.mageType = "HealerMage";
        this.getSpellbook().put("Heal", new Heal(this));
        this.getSpellbook().put("FireBall", new FireBall(this));
    }

    public Priest(String name) throws ArmyExceptions {
        this(name, 60, 100, 10);
    }
}
