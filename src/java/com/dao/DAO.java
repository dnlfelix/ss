package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {

    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public void adiciona(T t) {

        // consegue a entity manager
        EntityManager em = new JPAUtil().getEntityManager();

        // abre transacao
        em.getTransaction().begin();

        // persiste o objeto
        em.persist(t);

        // commita a transacao
        em.getTransaction().commit();

        // fecha a entity manager
        em.close();
    }

    public void remove(T t) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(t));

        em.getTransaction().commit();
        em.close();
    }

    public void atualiza(T t) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    public List<T> listaTodos() {
        try {

            EntityManager em = new JPAUtil().getEntityManager();
            CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
            query.select(query.from(classe));

            List<T> lista = em.createQuery(query).getResultList();
            em.close();

            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
            return null;
        }

    }

    public T buscaPorId(Long id) {
        EntityManager em = new JPAUtil().getEntityManager();
        T instancia = em.find(classe, id);
        em.close();
        return instancia;
    }

    public int contaTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
        long result = (Long) em.createQuery("select count(n) from imovel n")
                .getSingleResult();
        em.close();

        return (int) result;
    }

    public List<T> listaTodosPaginada(int firstResult, int maxResults) {
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        List<T> lista = em.createQuery(query).setFirstResult(firstResult)
                .setMaxResults(maxResults).getResultList();

        em.close();
        return lista;
    }

    public List<T> buscaPorQuery(String nomeQuery, String parametro, String pValor) {
        EntityManager em = new JPAUtil().getEntityManager();
        List<T> lista;
        try {
            Query query = em.createNamedQuery(nomeQuery);
            query.setParameter(parametro, pValor);
            lista = query.getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

}
