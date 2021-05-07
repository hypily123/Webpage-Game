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
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    private String role;
    @Column(name = "lvl")
    private int lvl;
    @Column(name = "exp")
    private int exp;
    @Column(name = "vit")
    private int vit;
    @Column(name = "pow")
    private int pow;
    @Column(name = "str")
    private int str;
    @Column(name = "dex")
    private int dex;
    @Column(name = "intelligence")
    private int intelligence;
    @Column(name = "points")
    private int points;
    @Column(name = "gold")
    private int gold;

    @Override
    public String toString() {
        return this.username + "," + this.password;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role ="player";
        this.lvl = 1;
        this.exp = 0;
        this.vit = 5;
        this.pow = 5;
        this.str = 5;
        this.dex = 5;
        this.intelligence = 5;
        this.points = 0;
        this.gold = 0;
    }

    public User(String username, String password, String s) {
        this.username = username;
        this.password = password;
        this.role = s;
    }

    public User(String username, String password, String s, int lvl, int exp, int vit, int pow, int str, int dex, int intelligence, int points, int gold) {
        this.username = username;
        this.password = password;
        this.role = s;
        this.lvl = lvl;
        this.exp = exp;
        this.vit = vit;
        this.pow = pow;
        this.str = str;
        this.dex = dex;
        this.intelligence = intelligence;
        this.points = points;
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String s) {
        this.role = s;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

}
