package Actions;

import Exceptions.ArmyExceptions;
import Exceptions.UnitIsNotMageException;
import Exceptions.UnitIsNotWerewolf;
import Exceptions.UnitHasNotInfectActionException;
import Exceptions.UnitIsNotWarlockException;
import Mages.Mage;
import Mages.Warlock;
import Spells.Spell;
import States.State;
import Units.Unit;
import Units.Daemon;

public class Action {
    public void attack(Unit owner, Unit target) throws ArmyExceptions {
        System.out.print(owner.getTitle() + " " + owner.getName() + " attack ");
        System.out.println(target.getTitle() + " " + target.getName());

        target.takeDamage(owner.getDamage());

        target.counterAttack(owner);
    }

    public void takeDamage(Unit owner, int dmg) {
        owner.spendHp(dmg);
    }

    public void takeMagicDamage(Unit owner, int dmg) {
        this.takeDamage(owner, dmg);
    }

    public void takeMagicHeal(Unit owner, int hp) {
        owner.addHp(hp);
    }

    public void counterAttack(Unit owner, Unit target) throws ArmyExceptions {
        if ( owner.getHp() > 0 ) {
            target.takeDamage(owner.getDamage() / 2);

            System.out.print(owner.getTitle() + " " + owner.getName() + " counterAttack ");
            System.out.println(target.getTitle() + " " + target.getName());
        }
    }


    public void cast(Mage owner, String spellName, Unit target) throws ArmyExceptions, CloneNotSupportedException {
        throw new UnitIsNotMageException();
    }

    public void addSpell(Mage owner, String spellTitle, Spell spell) throws ArmyExceptions {
        throw new UnitIsNotMageException();
    }


    public void transform(Unit owner) throws ArmyExceptions {
        throw new UnitIsNotWerewolf();
    }

    public void infect(Unit owner, Unit target) throws ArmyExceptions {
        throw new UnitHasNotInfectActionException();
    }


    public Daemon daemon() throws ArmyExceptions {
        throw new UnitIsNotWarlockException();
    }

    public void summon(Warlock owner, String name) throws ArmyExceptions {
        throw new UnitIsNotWarlockException();
    }


    public void turnToWerewolf(Unit owner) throws ArmyExceptions {
        owner.changeStates(new State("Werewolf", 90, 25),
                new State("Wolf", 180, 50));

        owner.changeActions(new WerewolfAction(), new WolfAction());
        owner.changeUnitType("Turnskin");
    }

    public void turnToVampire(Unit owner) throws ArmyExceptions {
        owner.changeStates(new State("Vampire", 120, 40), null);

        owner.changeActions(new VampireAction(), null);
        owner.changeUnitType("Undead");
    }
}
