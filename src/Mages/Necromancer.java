package Mages;

import Exceptions.ArmyExceptions;
import MageActions.NecromancerAction;
import Spells.FireBall;
import Spells.Heal;
import States.MageState;

public class Necromancer extends Mage {
    public Necromancer(String name, int hp, int mana, int damage) throws ArmyExceptions {
        super(name);
        this.state = new MageState("Necromancer", hp, mana, damage);
        this.action = new NecromancerAction();
        this.unitType = "Undead";
        this.mageType = "BattleMage";
        this.getSpellbook().put("Heal", new Heal(this));
        this.getSpellbook().put("FireBall", new FireBall(this));
    }

    public Necromancer(String name) throws ArmyExceptions {
        this(name, 80, 100, 10);
    }
}
