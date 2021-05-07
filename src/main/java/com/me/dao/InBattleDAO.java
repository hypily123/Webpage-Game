package com.me.dao;

import com.mycompany.pojo.InBattle;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class InBattleDAO extends DAO {

    public List<InBattle> getAllInBattles() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<InBattle> cq = cb.createQuery(InBattle.class);
        Root<InBattle> rootEntry = cq.from(InBattle.class);
        CriteriaQuery<InBattle> all = cq.select(rootEntry);
        cq.orderBy(cb.asc(rootEntry.get("username")));

        TypedQuery<InBattle> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addInBattle(InBattle InBattle) {
        beginTransaction();
        getSession().save(InBattle);
        commit();
    }

    public InBattle searchInBattle(String username) {
        beginTransaction();
        InBattle InBattle = getSession().get(InBattle.class, username);
        commit();
        return InBattle;
    }

    public void updateInBattle(InBattle InBattle) {
        beginTransaction();
        getSession().update(InBattle);
        commit();
    }

    public void deleteInBattle(InBattle InBattle) {
        beginTransaction();
        getSession().delete(InBattle);
        commit();
    }

    public void addInBattle(String username, int curHP, int dungeonID) {
        beginTransaction();
        getSession().save(new InBattle(username, curHP, dungeonID));
        commit();
    }
}
