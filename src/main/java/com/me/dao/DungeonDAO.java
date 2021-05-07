package com.me.dao;

import com.mycompany.pojo.Dungeon;
import com.mycompany.pojo.User;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DungeonDAO extends DAO {

    public List<Dungeon> getAllDungeons() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Dungeon> cq = cb.createQuery(Dungeon.class);
        Root<Dungeon> rootEntry = cq.from(Dungeon.class);
        CriteriaQuery<Dungeon> all = cq.select(rootEntry);
        cq.orderBy(cb.asc(rootEntry.get("name")));

        TypedQuery<Dungeon> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addDungeon(Dungeon Dungeon) {
        beginTransaction();
        getSession().save(Dungeon);
        commit();
    }

    public Dungeon searchDungeon(int id) {
        beginTransaction();
        Dungeon Dungeon = getSession().get(Dungeon.class, id);
        commit();
        return Dungeon;
    }

    public void updateDungeon(Dungeon Dungeon) {
        beginTransaction();
        getSession().update(Dungeon);
        commit();
    }

    public void deleteDungeon(Dungeon Dungeon) {
        beginTransaction();
        getSession().delete(Dungeon);
        commit();
    }

    public List<Dungeon> getAllDungeons(User user) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Dungeon> cq = cb.createQuery(Dungeon.class);
        Root<Dungeon> rootEntry = cq.from(Dungeon.class);
        cq.select(rootEntry).where(cb.le(rootEntry.get("lvl").as(int.class), user.getLvl()));
        cq.orderBy(cb.desc(rootEntry.get("lvl")));

        TypedQuery<Dungeon> allQuery = getSession().createQuery(cq);
        return allQuery.getResultList();
    }
}
