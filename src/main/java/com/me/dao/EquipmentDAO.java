package com.me.dao;

import com.mycompany.pojo.Equipment;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EquipmentDAO extends DAO {

    public List<Equipment> getAllEquipments() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Equipment> cq = cb.createQuery(Equipment.class);
        Root<Equipment> rootEntry = cq.from(Equipment.class);
        CriteriaQuery<Equipment> all = cq.select(rootEntry);
        cq.orderBy(cb.desc(rootEntry.get("part")), cb.asc(rootEntry.get("v")));

        TypedQuery<Equipment> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addEquipment(Equipment e) {
        beginTransaction();
        getSession().save(e);
        commit();
    }

    public Equipment searchEquipment(int equipmentID) {
        beginTransaction();
        Equipment e = getSession().get(Equipment.class, equipmentID);
        commit();
        return e;
    }

    public void updateEquipment(Equipment e) {
        beginTransaction();
        getSession().update(e);
        commit();
    }

    public void deleteEquipment(Equipment e) {
        beginTransaction();
        getSession().delete(e);
        commit();
    }

    public void addEquipment(String name, String part, int atk, int def, int spd, int value) {
        beginTransaction();
        getSession().save(new Equipment(name, part, atk, def, spd, value));
        commit();
    }

    public void updateEquipment(int id, String name, String part, int atk, int def, int spd, int value) {
        beginTransaction();
        getSession().update(new Equipment(id, name, part, atk, def, spd, value));
        commit();
    }

    public void deleteEquipment(int id, String name, String part, int atk, int def, int spd, int value) {
        beginTransaction();
        getSession().delete(new Equipment(id, name, part, atk, def, spd, value));
        commit();
    }
}
