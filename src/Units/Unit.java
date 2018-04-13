package Units;

import Exceptions.ArmyExceptions;
import Exceptions.UnitHasNotAltStateException;
import Exceptions.UnitIsDeadException;
import States.State;
import Actions.Action;

import java.util.HashSet;

public abstract class Unit {
    protected String name;
    protected State state;
    protected State altState;
    protected Action action;
    protected Action altAction;
    protected String unitType;

    protected HashSet<Unit> observers;
    protected HashSet<Unit> observables;

    protected void ensureIsAlive() throws ArmyExceptions {
        if ( this.getHp() == 0 ) {
            throw new UnitIsDeadException();
        }
    }

    public Unit(String name) {
        this.name = name;
        this.unitType = "None";
        this.observers = new HashSet<>();
        this.observables = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.state.getTitle();
    }

    public String getUnitType() {
        return this.unitType;
    }

    public int getHp() {
        return this.state.getHp();
    }

    public int getMaxHp() {
        return this.state.getMaxHp();
    }

    public int getDamage() {
        return this.state.getDamage();
    }

    public HashSet<Unit> getObservers() {
        return this.observers;
    }

    public HashSet<Unit> getObservables() {
        return this.observables;
    }


    public void addHp(int hp) {
        this.state.addHp(hp);
    }

    public void spendHp(int hp) {
        this.state.spendHp(hp);
    }


    public void swapStates() throws ArmyExceptions {
        this.ensureIsAlive();

        if ( this.altState == null ) {
            throw new UnitHasNotAltStateException();
        }

        float coef = (float)(this.altState.getMaxHp()) / this.getMaxHp();
        int newHp = (int)(this.getHp() * coef);
        State tmp = this.state;

        this.altState.setHp(newHp);

        this.state = this.altState;
        this.altState = tmp;
    }

    public void changeStates(State newState, State newAltState) throws ArmyExceptions {
        this.ensureIsAlive();

        this.altState = newState;
        this.swapStates();
        this.altState = newAltState;
    }

    public void swapActions() throws ArmyExceptions {
        this.ensureIsAlive();

        Action tmp = this.action;
        this.action = this.altAction;
        this.altAction = tmp;
    }

    public void changeActions(Action newAction, Action newAltAction) throws ArmyExceptions {
        this.ensureIsAlive();

        this.altAction = newAction;
        this.swapActions();
        this.altAction = newAltAction;
    }

    public void changeUnitType(String newType) {
        this.unitType = newType;
    }


    public void attack(Unit target) throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.attack(this, target);
    }

    public void counterAttack(Unit target) throws ArmyExceptions {
        this.action.counterAttack(this, target);
    }

    public void takeDamage(int dmg) throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.takeDamage(this, dmg);

        if ( this.getHp() == 0 ) {
            this.notifyObservers();
            this.notifyObservables();
        }
    }

    public void takeMagicDamage(int dmg) throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.takeMagicDamage(this, dmg);

        if ( this.getHp() == 0 ) {
            this.notifyObservers();
            this.notifyObservables();
        }
    }

    public void takeMagicHeal(int hp) throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.takeMagicHeal(this, hp);
    }


    public void transform() throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.transform(this);
    }

    public void infect(Unit target) throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.infect(this, target);
    }


    public void turnToWerewolf() throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.turnToWerewolf(this);
    }

    public void turnToVampire() throws ArmyExceptions {
        this.ensureIsAlive();

        this.action.turnToVampire(this);
    }


    public void addObserver(Unit unit) {
        this.observers.add(unit);
    }

    public void addObservable(Unit unit) {
        this.observables.add(unit);
    }

    public void notifyObservers() {
        for ( Unit unit: this.observers ) {
            unit.removeObservable(this);
            unit.addHp(this.getMaxHp() / 10);

            System.out.println(this.getName() + " send " + (this.getMaxHp()/10) + " hp to " + unit.getName());
        }
        this.observers.clear();
    }

    public void notifyObservables() {
        for ( Unit unit: this.observables ) {
            unit.removeObserver(this);
        }
        this.observables.clear();
    }

    public void removeObserver(Unit unit) {
        this.observers.remove(unit);
    }

    public void removeObservable(Unit unit) {
        this.observables.remove(unit);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(this.name);

        out.append(" ").append(this.state);

        return out.toString();
    }
}
