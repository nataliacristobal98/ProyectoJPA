package es.natalia.proyecto_final.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, K> {

  // Optional -> Devuelve algo si encuentra ese algo
  Optional<T> findById(K id);

  List<T> findAll();

  void create(T entity);

  // Save y Update son el mismo método
  T save(T entity);

}
