/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "part")
    private String part;
    @Column(name = "atk")
    private int atk;
    @Column(name = "def")
    private int def;
    @Column(name = "spd")
    private int spd;
    @Column(name = "value")
    private int v;

    @Override
    public String toString() {
        String s = name + "," + part + "," + atk + "," + def + "," + spd + "," + v;
        return s;
    }

    public Equipment() {
    }

    public Equipment(String s) {
        this.id = Integer.parseInt(s);
    }

    public Equipment(String name, String s, int atk, int def, int spd, int val) {
        this.name = name;
        this.part = s;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.v = val;
    }

    public Equipment(int id, String name, String part, int atk, int def, int spd, int v) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.v = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String s) {
        this.part = s;
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

    public int getVal() {
        return v;
    }

    public void setVal(int val) {
        this.v = val;
    }

}
