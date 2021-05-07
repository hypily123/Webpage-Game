package com.me.dao;

import com.mycompany.pojo.Inventory;
import com.mycompany.pojo.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class InventoryDAO extends DAO {

    public List<Inventory> getAllInventorys() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Inventory> cq = cb.createQuery(Inventory.class);
        Root<Inventory> rootEntry = cq.from(Inventory.class);
        CriteriaQuery<Inventory> all = cq.select(rootEntry);
        cq.orderBy(cb.asc(rootEntry.get("username")), cb.asc(rootEntry.get("equipmentName")));

        TypedQuery<Inventory> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addInventory(Inventory Inventory) {
        beginTransaction();
        getSession().save(Inventory);
        commit();
    }

    public Inventory searchInventory(int id) {
        beginTransaction();
        Inventory Inventory = getSession().get(Inventory.class, id);
        commit();
        return Inventory;
    }

    public void updateInventory(Inventory Inventory) {
        beginTransaction();
        getSession().update(Inventory);
        commit();
    }

    public void deleteInventory(Inventory Inventory) {
        beginTransaction();
        getSession().delete(Inventory);
        commit();
    }

    public List<Inventory> getAllInventorys(User user) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Inventory> cq = cb.createQuery(Inventory.class);
        Root<Inventory> rootEntry = cq.from(Inventory.class);
        cq.select(rootEntry).where(cb.equal(rootEntry.get("username"), user.getUsername()));
        cq.orderBy(cb.asc(rootEntry.get("equipmentID")));

        TypedQuery<Inventory> allQuery = getSession().createQuery(cq);
        return allQuery.getResultList();
    }

    public void addInventory(String username, int EquipmentID) {
        beginTransaction();
        getSession().save(new Inventory(username, EquipmentID));
        commit();
    }

    public void deleteInventory(String username, int EquipmentID) {
        List<Inventory> loi = getAllInventorys(username, EquipmentID);
        beginTransaction();
        getSession().delete(loi.get(0));
        commit();
    }

    public List<Inventory> getAllInventorys(String username, int EquipmentID) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Inventory> cq = cb.createQuery(Inventory.class);
        Root<Inventory> rootEntry = cq.from(Inventory.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(rootEntry.get("username"), username));
        predicates.add(cb.equal(rootEntry.get("equipmentID"), EquipmentID));

        cq.select(rootEntry).where(predicates.toArray(new Predicate[]{}));
        cq.orderBy(cb.asc(rootEntry.get("equipmentID")));

        TypedQuery<Inventory> allQuery = getSession().createQuery(cq);
        allQuery.unwrap(org.hibernate.Query.class).getQueryString();
        return allQuery.getResultList();
    }
}
