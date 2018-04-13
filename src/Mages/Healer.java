package Mages;

import Exceptions.ArmyExceptions;
import MageActions.MageAction;
import Spells.FireBall;
import Spells.Heal;
import States.MageState;

public class Healer extends Mage {
    public Healer(String name, int hp, int mana, int damage) throws ArmyExceptions {
        super(name);
        this.state = new MageState("Healer", hp, mana, damage);
        this.action = new MageAction();
        this.mageType = "HealerMage";
        this.getSpellbook().put("Heal", new Heal(this));
        this.getSpellbook().put("FireBall", new FireBall(this));
    }

    public Healer(String name) throws ArmyExceptions {
        this(name, 60, 100, 10);
    }
}
