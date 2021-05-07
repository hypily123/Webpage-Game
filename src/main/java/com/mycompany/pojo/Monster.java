/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import javax.persistence.*;

/**
 *
 * @author Jian Xiao
 */
@Entity
@Table(name = "monster")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monsterID")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lvl")
    private int lvl;
    @Column(name = "hp")
    private int hp;
    @Column(name = "atk")
    private int atk;
    @Column(name = "def")
    private int def;
    @Column(name = "spd")
    private int spd;
    @Column(name = "exp")
    private int exp;
    @Column(name = "loot")
    private int loot;

    public Monster() {
    }

    @Override
    public String toString() {
        String s = id + "," + name + "," + lvl + "," + hp + "," + atk + "," + def + "," + spd + "," + exp + "," + loot;
        return s;
    }

    public Monster(String s) {
        this.id = Integer.parseInt(s);
    }

    public Monster(int id, String name, int lvl, int hp, int atk, int def, int spd, int exp, int loot) {
        this.id = id;
        this.name = name;
        this.lvl = lvl;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.exp = exp;
        this.loot = loot;
    }

    public Monster(String name, int lvl, int hp, int atk, int def, int spd, int exp, int loot) {
        this.name = name;
        this.lvl = lvl;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.exp = exp;
        this.loot = loot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

}
