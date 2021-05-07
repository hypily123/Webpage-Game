/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import javax.persistence.*;

@Entity
@Table(name = "inBattle")
public class InBattle {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "curHP")
    private int curHP;
    @Column(name = "dungeonID")
    private int dungeonID;
    @Column(name = "wave")
    private int wave;

    public InBattle() {
    }

    public InBattle(String username, int curHP, int dungeonID) {
        this.username = username;
        this.curHP = curHP;
        this.dungeonID = dungeonID;
        this.wave = 1;
    }

    public InBattle(String username, int curHP, int dungeonID, int wave) {
        this.username = username;
        this.curHP = curHP;
        this.dungeonID = dungeonID;
        this.wave = wave;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCurHP() {
        return curHP;
    }

    public void setCurHP(int curHP) {
        this.curHP = curHP;
    }

    public int getDungeonID() {
        return dungeonID;
    }

    public void setDungeonID(int dungeonID) {
        this.dungeonID = dungeonID;
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

}
