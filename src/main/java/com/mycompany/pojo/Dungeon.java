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
@Table(name = "dungeon")
public class Dungeon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dungeonID")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lvl")
    private int lvl;
    @Column(name = "waves")
    private int waves;

    public Dungeon() {
    }

    @Override
    public String toString() {
        String s = id + "," + name + "," + lvl + "," + waves;
        return s;
    }

    public Dungeon(String s) {
        this.id = Integer.parseInt(s);
    }

    public Dungeon(int id, String name, int lvl, int waves) {
        this.id = id;
        this.name = name;
        this.lvl = lvl;
        this.waves = waves;
    }

    public Dungeon(String name, int lvl, int waves) {
        this.name = name;
        this.lvl = lvl;
        this.waves = waves;
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

    public int getWaves() {
        return waves;
    }

    public void setWaves(int waves) {
        this.waves = waves;
    }

}
