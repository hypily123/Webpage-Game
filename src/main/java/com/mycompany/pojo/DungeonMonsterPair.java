/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Jian Xiao
 */
@Entity
@Table(name = "`dungeon-monster pair`")
public class DungeonMonsterPair implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "dungeonID")
    private int dungeonID;
    @Column(name = "monsterID")
    private int monsterID;
    @Column(name = "wave")
    private int wave;

    @Override
    public String toString() {
        String s = id + "," + dungeonID + "," + monsterID + "," + wave;
        return s;
    }

    public DungeonMonsterPair(String s) {
        this.id = Integer.parseInt(s);
    }

    public DungeonMonsterPair() {
    }

    public DungeonMonsterPair(int id, int dungeonID, int monsterID, int wave) {
        this.id = id;
        this.dungeonID = dungeonID;
        this.monsterID = monsterID;
        this.wave = wave;
    }

    public DungeonMonsterPair(int dungeonID, int monsterID, int wave) {
        this.dungeonID = dungeonID;
        this.monsterID = monsterID;
        this.wave = wave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDungeonID() {
        return dungeonID;
    }

    public void setDungeonID(int dungeonID) {
        this.dungeonID = dungeonID;
    }

    public int getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

}
