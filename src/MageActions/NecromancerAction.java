package MageActions;

import Exceptions.ArmyExceptions;
import Exceptions.UnitIsImmuneToTurnException;
import Mages.Mage;
import Units.Unit;

public class NecromancerAction  extends MageAction {
    private void addUnitsToSets(Unit necr, Unit target) {
        if ( target.getHp() > 0 ) {
            necr.addObservable(target);
            target.addObserver(necr);
        }
    }

    @Override
    public void attack(Unit owner, Unit target) throws ArmyExceptions {
        super.attack(owner, target);
        this.addUnitsToSets(owner, target);
    }

    @Override
    public void counterAttack(Unit owner, Unit target) throws ArmyExceptions {
        super.counterAttack(owner, target);
        this.addUnitsToSets(owner, target);
    }

    @Override
    public void cast(Mage owner, String spellName, Unit target) throws ArmyExceptions, CloneNotSupportedException {
        super.cast(owner, spellName, target);
        this.addUnitsToSets(owner, target);
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
