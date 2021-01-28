package com.example.demo.dao;

import com.example.demo.entity.CPU;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DaoImpl implements DAO {

    private final EntityManager entityManager;

    @Autowired
    public DaoImpl(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    @Transactional
    public List findAll(String q) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Object findById(Object table, int id) {
        Session session = entityManager.unwrap((Session.class));
        Query query = session.createQuery("from " + table + " where id = " + id);
        return query.getResultList().get(0);
    }

    @Override
    @Transactional
    public void save(Object obj) {
        Session session = entityManager.unwrap((Session.class));
        session.saveOrUpdate(obj);
    }

    @Override
    @Transactional
    public void deleteById(String table, int id) {
        Session session = entityManager.unwrap((Session.class));
        Query query = session.createQuery("delete from " + table + " where id = " + id);
        query.executeUpdate();

    }


}
