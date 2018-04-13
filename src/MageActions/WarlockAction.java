package MageActions;

import Exceptions.ArmyExceptions;
import Exceptions.OutOfDaemonException;
import Exceptions.MoreThanOneDaemon;
import Exceptions.OutOfManaException;
import Mages.Warlock;
import Units.Daemon;

public class WarlockAction extends MageAction {
    private Daemon daemon;

    @Override
    public Daemon daemon() throws ArmyExceptions {
        if ( this.daemon == null ) {
            throw new OutOfDaemonException();
        }
        return this.daemon;
    }

    @Override
    public void summon(Warlock owner, String name) throws ArmyExceptions {
        int summonCost = 50;

        if ( this.daemon != null ) {
            if ( this.daemon.getHp() > 0 ) {
                throw new MoreThanOneDaemon();
            }
        }

        if ( owner.getMana() < summonCost ) {
            throw new OutOfManaException();
        }

        this.daemon = new Daemon(name);
        owner.spendMana(summonCost);

        System.out.println(owner.getTitle() + " " + owner.getName() + " summon Daemon " + this.daemon.getName());
    }
}
