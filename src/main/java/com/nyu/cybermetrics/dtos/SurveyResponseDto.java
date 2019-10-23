package com.nyu.cybermetrics.dtos;

import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public class SurveyResponseDto {

    private Timestamp date;
    private AttackActors attackActors;
    private Weapons weapons;
    private Effects effects;
    private AttackTargets attackTargets;
    private Defenses defenses;
    private OverallPerceptions overallPerceptions;

    public SurveyResponseDto() {

        attackActors = new AttackActors();
        weapons = new Weapons();
        effects = new Effects();
        attackTargets = new AttackTargets();
        defenses = new Defenses();
        overallPerceptions = new OverallPerceptions();
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public AttackActors getAttackActors() {
        return attackActors;
    }

    public void setAttackActors(AttackActors attackActors) {
        this.attackActors = attackActors;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Effects getEffects() {
        return effects;
    }

    public void setEffects(Effects effects) {
        this.effects = effects;
    }

    public AttackTargets getAttackTargets() {
        return attackTargets;
    }

    public void setAttackTargets(AttackTargets attackTargets) {
        this.attackTargets = attackTargets;
    }

    public Defenses getDefenses() {
        return defenses;
    }

    public void setDefenses(Defenses defenses) {
        this.defenses = defenses;
    }

    public OverallPerceptions getOverallPerceptions() {
        return overallPerceptions;
    }

    public void setOverallPerceptions(OverallPerceptions overallPerceptions) {
        this.overallPerceptions = overallPerceptions;
    }

    @Override
    public String toString() {
        return "SurveyResponseDto{" +
                "date=" + date +
                ", attackActors=" + attackActors +
                ", weapons=" + weapons +
                ", effects=" + effects +
                ", attackTargets=" + attackTargets +
                ", defenses=" + defenses +
                '}';
    }
}
