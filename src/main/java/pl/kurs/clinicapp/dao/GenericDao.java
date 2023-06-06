package pl.kurs.clinicapp.dao;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional
@Repository
public abstract class GenericDao<T, K>  {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public GenericDao() {
        type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
    public T get(K key) {
        T find = entityManager.find(type, key);
        return find;
    }
    public void save(T entity) {
        entityManager.persist(entity);

    }

}
