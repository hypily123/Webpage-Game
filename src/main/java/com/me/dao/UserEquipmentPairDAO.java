/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import static com.me.dao.DAO.getSession;
import com.mycompany.pojo.UserEquipmentPair;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

public class UserEquipmentPairDAO extends DAO {

    public List<UserEquipmentPair> getAllUserEquipmentPair() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<UserEquipmentPair> cq = cb.createQuery(UserEquipmentPair.class);
        Root<UserEquipmentPair> rootEntry = cq.from(UserEquipmentPair.class);
        CriteriaQuery<UserEquipmentPair> all = cq.select(rootEntry);
        cq.orderBy(cb.asc(rootEntry.get("username")), cb.asc(rootEntry.get("equipmentName")));

        TypedQuery<UserEquipmentPair> allQuery = getSession().createQuery(all);
        allQuery.unwrap(org.hibernate.Query.class).getQueryString();
        return allQuery.getResultList();
    }

    public List<UserEquipmentPair> getAllUserEquipmentPair(String username) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<UserEquipmentPair> cq = cb.createQuery(UserEquipmentPair.class);
        Root<UserEquipmentPair> rootEntry = cq.from(UserEquipmentPair.class);
        CriteriaQuery<UserEquipmentPair> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("username"), username));
        cq.orderBy(cb.asc(rootEntry.get("equipmentID")));

        TypedQuery<UserEquipmentPair> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addUserEquipmentPair(UserEquipmentPair UserEquipmentPair) {
        beginTransaction();
        getSession().save(UserEquipmentPair);
        commit();
    }

    public void updateUserEquipmentPair(UserEquipmentPair UserEquipmentPair) {
        beginTransaction();
        getSession().update(UserEquipmentPair);
        commit();
    }

    public void deleteUserEquipmentPair(UserEquipmentPair UserEquipmentPair) {
        beginTransaction();
        getSession().delete(UserEquipmentPair);
        commit();
    }

    public void addUserEquipmentPair(String username, int equipmentID, String part) {
        beginTransaction();
        getSession().save(new UserEquipmentPair(username, equipmentID, part));
        commit();
    }

    public void updateUserEquipmentPair(String username, int equipmentID, String part) {
        try {
            beginTransaction();
            getSession().update(new UserEquipmentPair(username, equipmentID, part));
            commit();
        } catch (Exception e) {
            beginTransaction();
            getSession().save(new UserEquipmentPair(username, equipmentID, part));
            commit();
        }
    }

    public void deleteUserEquipmentPair(String username, int equipmentID, String part) {
        beginTransaction();
        getSession().delete(new UserEquipmentPair(username, equipmentID, part));
        commit();
    }

    public void deleteUserEquipmentPair(String username, String part) {
        beginTransaction();
        getSession().delete(searchUserEquipmentPair(username, part));
        commit();
    }

    public List<UserEquipmentPair> searchUserEquipmentPair(String username) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<UserEquipmentPair> cq = cb.createQuery(UserEquipmentPair.class);
        Root<UserEquipmentPair> rootEntry = cq.from(UserEquipmentPair.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(rootEntry.get("username"), username));

        cq.select(rootEntry)
                .where(predicates.toArray(new Predicate[]{}));
        cq.orderBy(cb.asc(rootEntry.get("part")));

        TypedQuery<UserEquipmentPair> allQuery = getSession().createQuery(cq);
        allQuery.unwrap(org.hibernate.Query.class).getQueryString();
        return allQuery.getResultList();
    }

    public UserEquipmentPair searchUserEquipmentPair(String username, String part) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<UserEquipmentPair> cq = cb.createQuery(UserEquipmentPair.class);
        Root<UserEquipmentPair> rootEntry = cq.from(UserEquipmentPair.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(rootEntry.get("username"), username));
        predicates.add(cb.equal(rootEntry.get("part"), part));

        cq.select(rootEntry)
                .where(predicates.toArray(new Predicate[]{}));

        TypedQuery<UserEquipmentPair> allQuery = getSession().createQuery(cq);
        allQuery.unwrap(org.hibernate.Query.class).getQueryString();
        return allQuery.getSingleResult();
    }
}
