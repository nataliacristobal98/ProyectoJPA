package es.natalia.proyecto_final.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

  @PersistenceContext
  protected EntityManager em; // Métodos de Hibernate
  protected final Class<T> entityClass; // Clases propias creadas

  public GenericDAOImpl(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  @Override
  public Optional<T> findById(K id) {
    return Optional.ofNullable(em.find(entityClass, id));
  }

  @Override
  public List<T> findAll() {
    return em.createQuery("SELECT c FROM " + this.entityClass.getCanonicalName() + " c", this.entityClass).getResultList();
  }

  @Override
  public void create(T entity) {
    em.persist(entity);
  }

  @Override
  public T save(T entity) {
    return em.merge(entity);
  }

}
