package com.me.dao;

import static com.me.dao.DAO.getSession;
import com.mycompany.pojo.User;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDAO extends DAO {

    public List<User> getAllUsers() {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        cq.orderBy(cb.asc(rootEntry.get("username")));

        TypedQuery<User> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    public void addUser(User user) {
        beginTransaction();
        getSession().save(user);
        commit();
    }
    
    public void addUser(String username, String password) {
        beginTransaction();
        System.out.println("In save User");
        getSession().save(new User(username,password));
        commit();
    }

    public User searchUser(int id) {
        beginTransaction();
        User user = getSession().get(User.class, id);
        commit();
        return user;
    }

    public User searchUser(String username) {
        CriteriaBuilder cb;
        cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("username"), username));

        System.out.println(all.toString());
        TypedQuery<User> allQuery = getSession().createQuery(all);
        return allQuery.getSingleResult();
    }

    public void updateUser(User user) {
        beginTransaction();
        getSession().update(user);
        commit();
    }

    public void deleteMonster(User user) {
        beginTransaction();
        getSession().delete(user);
        commit();
    }

}
