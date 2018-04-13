package Actions;

import Exceptions.ArmyExceptions;
import Exceptions.UnitIsImmuneToTurnException;
import Units.Unit;

public class VampireAction extends Action {
    @Override
    public void attack(Unit owner, Unit target) throws ArmyExceptions {
        if ( !target.getUnitType().equals("Undead") ) {
            owner.addHp(target.getMaxHp() / 10);
        }
        super.attack(owner, target);
    }

    @Override
    public void counterAttack(Unit owner, Unit target) throws ArmyExceptions {
        super.counterAttack(owner, target);
        if ( !target.getUnitType().equals("Undead") ) {
            owner.addHp(target.getMaxHp() / 20);
        }
    }

    @Override
    public void infect(Unit owner, Unit target) throws ArmyExceptions {
        String tmp = target.getTitle();

        target.turnToVampire();

        System.out.print(owner.getTitle() + " " + owner.getName() + " infect ");
        System.out.println(tmp + " " + target.getName());
    }

    @Override
    public void turnToWerewolf(Unit owner) throws ArmyExceptions {
        throw new UnitIsImmuneToTurnException();
    }

    @Override
    public void turnToVampire(Unit owner) throws ArmyExceptions {
        throw new UnitIsImmuneToTurnException();
    }
}
