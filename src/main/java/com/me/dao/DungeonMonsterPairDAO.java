/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import static com.me.dao.DAO.getSession;
import com.mycompany.pojo.DungeonMonsterPair;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DungeonMonsterPairDAO extends DAO {

    public List<DungeonMonsterPair> getAllDungeonMonsterPairs() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<DungeonMonsterPair> cq = cb.createQuery(DungeonMonsterPair.class);
        Root<DungeonMonsterPair> rootEntry = cq.from(DungeonMonsterPair.class);
        CriteriaQuery<DungeonMonsterPair> all = cq.select(rootEntry);
        cq.orderBy(cb.asc(rootEntry.get("dungeonID")), cb.asc(rootEntry.get("wave")), cb.asc(rootEntry.get("monsterID")));

        TypedQuery<DungeonMonsterPair> allQuery = getSession().createQuery(all);
        allQuery.unwrap(org.hibernate.Query.class).getQueryString();
        return allQuery.getResultList();
    }

    public List<DungeonMonsterPair> getAllDungeonMonserPairs(int DungeonID) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<DungeonMonsterPair> cq = cb.createQuery(DungeonMonsterPair.class);
        Root<DungeonMonsterPair> rootEntry = cq.from(DungeonMonsterPair.class);
        CriteriaQuery<DungeonMonsterPair> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("dungeonID"), DungeonID));
        cq.orderBy(cb.asc(rootEntry.get("wave")), cb.asc(rootEntry.get("monster")));

        TypedQuery<DungeonMonsterPair> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addDungeonMonsterPair(DungeonMonsterPair DungeonMonsterPair) {
        beginTransaction();
        getSession().save(DungeonMonsterPair);
        commit();
    }

    public DungeonMonsterPair searchDungeonMonsterPair(int dungeonID) {
        beginTransaction();
        DungeonMonsterPair DungeonMonsterPair = getSession().get(DungeonMonsterPair.class, dungeonID);
        commit();
        return DungeonMonsterPair;
    }

    public void updateDungeonMonsterPair(DungeonMonsterPair DungeonMonsterPair) {
        beginTransaction();
        getSession().update(DungeonMonsterPair);
        commit();
    }

    public void deleteDungeonMonsterPair(DungeonMonsterPair DungeonMonsterPair) {
        beginTransaction();
        getSession().delete(DungeonMonsterPair);
        commit();
    }

    public void addDungeonMonsterPair(int dungeonID, int monsterID, int wave) {
        beginTransaction();
        System.out.println("In save DungeonMonsterPair");
        getSession().save(new DungeonMonsterPair(dungeonID, monsterID, wave));
        commit();
    }

    public void updateDungeonMonsterPair(int id, int dungeonID, int monsterID, int wave) {
        beginTransaction();
        getSession().update(new DungeonMonsterPair(id, dungeonID, monsterID, wave));
        commit();
    }

    public void deleteDungeonMonsterPair(int id, int dungeonID, int monsterID, int wave) {
        beginTransaction();
        getSession().delete(new DungeonMonsterPair(id, dungeonID, monsterID, wave));
        commit();
    }

    public List<DungeonMonsterPair> searchDungeonMonsterPair(int dungeonID, int wave) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<DungeonMonsterPair> cq = cb.createQuery(DungeonMonsterPair.class);
        Root<DungeonMonsterPair> rootEntry = cq.from(DungeonMonsterPair.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(rootEntry.get("dungeonID"), dungeonID));
        predicates.add(cb.equal(rootEntry.get("wave"), wave));

        cq.select(rootEntry).where(predicates.toArray(new Predicate[]{}));
        cq.orderBy(cb.asc(rootEntry.get("monsterID")));

        TypedQuery<DungeonMonsterPair> allQuery = getSession().createQuery(cq);
        allQuery.unwrap(org.hibernate.Query.class).getQueryString();
        return allQuery.getResultList();
    }
}
