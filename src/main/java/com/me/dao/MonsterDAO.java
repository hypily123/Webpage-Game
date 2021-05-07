package com.me.dao;

import com.mycompany.pojo.Monster;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MonsterDAO extends DAO {

    public List<Monster> getAllMonsters() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Monster> cq = cb.createQuery(Monster.class);
        Root<Monster> rootEntry = cq.from(Monster.class);
        CriteriaQuery<Monster> all = cq.select(rootEntry);
        cq.orderBy(cb.asc(rootEntry.get("name")));

        TypedQuery<Monster> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addMonster(Monster monster) {
        beginTransaction();
        getSession().save(monster);
        commit();
    }

    public Monster searchMonster(int id) {
        beginTransaction();
        Monster monster = getSession().get(Monster.class, id);
        commit();
        return monster;
    }

    public void updateMonster(Monster monster) {
        beginTransaction();
        getSession().update(monster);
        commit();
    }

    public void deleteMonster(Monster monster) {
        beginTransaction();
        getSession().delete(monster);
        commit();
    }

}
