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
@Table(name = "`user-equipment pair`")
public class UserEquipmentPair implements Serializable {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "equipmentID")
    private int equipmentID;
    @Id
    @Column(name = "part")
    private String part;

    @Override
    public String toString() {
        return this.username + "," + this.equipmentID + "," + this.part;
    }

    public UserEquipmentPair() {
    }

    public UserEquipmentPair(String username, int equipmentID, String part) {
        this.username = username;
        this.equipmentID = equipmentID;
        this.part = part;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

}
