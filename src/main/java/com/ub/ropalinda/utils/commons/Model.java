package com.ub.ropalinda.utils.commons;

import com.ub.ropalinda.utils.UtilsDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Base model for all the business logic, persitense and external comunication
 *
 * @author Ulises Beltrán Gómez
 * @param <T> Entity class
 * @param <K> Entity primary key type
 */
public class Model<T extends IEntity<K>, K> {

    private Class<T> clazz;

    public Model(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Find all the entities of this model
     *
     * @param from index to start pagination
     * @param to index to end pagination
     * @return list with entities of this model
     */
    public List<T> findAll(Integer from, Integer to) {
        EntityManager em = UtilsDB.getEMFactoryCG().createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<T> root = cq.from(clazz);
            cq.select(root).where(cb.equal(root.get("active"), true));
            Query q = em.createQuery(cq);
            paginateQuery(q, from, to);
            return q.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Find all the entities of this model filtered and related with the params
     * in queryParam
     *
     * @param select the query param from the uri
     * @param from index to start pagination
     * @param to index to end pagination
     * @return list of mapped properties
     */
    public List<Map<String, Object>> findAll(String select, Integer from, Integer to) {
        EntityManager em = UtilsDB.getEMFactoryCG().createEntityManager();
        try {
            return queryParamResponse(select, from, to);
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Find an entity by searching the id
     *
     * @param id identifier of the entity
     * @return entity finded or null
     */
    public T findById(K id) {
        return this.createEm().find(clazz, id);
    }

    /**
     * Persist the entity in database
     *
     * @param t entity to persist
     * @return the entity persisted
     */
    public T persist(T t) {
        EntityManager em = this.createEm();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return t;
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Updates an entity in database
     *
     * @param t entity to update
     */
    public void update(T t) {
        EntityManager em = this.createEm();
        try {
            em.getTransaction().begin();
            em.merge(t); //merge in the persistence context
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Deletes an entity in database
     *
     * @param id identifier of the entity to delete
     * @throws Exception if the entity is not found
     */
    public void delete(K id) throws Exception {
        EntityManager em = this.createEm();
        try {
            em.getTransaction().begin();
            T entity = em.find(clazz, id);
            if (entity != null) {
                entity.setActive(false);
                em.merge(entity);
            } else {
                throw new Exception("Not found with the id: " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Counts in database the number of entities existing
     *
     * @return number of entities
     */
    public long count() {
        EntityManager em = this.createEm();
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(clazz)));
        return em.createQuery(cq).getSingleResult();
    }

    /**
     * Set the page to query with the from and to query param
     *
     * @param q query to set tha page
     * @param from index to start the query
     * @param to index to stop que query
     */
    protected void paginateQuery(Query q, Integer from, Integer to) {
        if (from != null && to != null) {
            q.setMaxResults(to - from + 1);
            q.setFirstResult(from);
        } else {
            if (to != null) {
                q.setMaxResults(to);
            }
        }
    }

    /**
     * Creates de result set mapped as a generic list from the query string
     * provided
     *
     * @param select contains the columns and filters
     * @param from pagination index from
     * @param to pagination index to
     * @return result set mapped with properties names
     */
    protected List<Map<String, Object>> queryParamResponse(String select, Integer from, Integer to) {
        String entityName = this.clazz.getSimpleName();
        String queryToExcecute = "SELECT ";
        String queryFrom = " From " + entityName + " t";
        Set<String> querySelects = new LinkedHashSet<>();
        Set<String> queryWheres = new LinkedHashSet<>();
        Set<String> queryFroms = new LinkedHashSet<>();
        String[] querySelections = select.split(",");        
        for (String selection : querySelections) {
            String whereSelection = whereSelection(selection);
            if (whereSelection.isEmpty()) {
                querySelects.add("t." + selection);
            } else {
                if (whereSelection.equals("><")) { //between operator
                    String[] selectionParts = selection.split(whereSelection);
                    String[] values = selectionParts[1].split("\\|");
                    querySelects.add("t." + selectionParts[0]);
                    queryWheres.add("t." + selectionParts[0] + " BETWEEN " + values[0] + " AND " + values[1]);
                } else {
                    String[] selectionParts = selection.split(whereSelection);
                    querySelects.add("t." + selectionParts[0]);
                    queryWheres.add("t." + selectionParts[0] + " " + whereSelection + " " + selectionParts[1]);
                }
            }
        }

        queryToExcecute += String.join(",", querySelects);
        queryToExcecute += queryFrom + String.join("", queryFroms);
        if (!queryWheres.isEmpty()) {
            queryToExcecute += " WHERE " + String.join(" AND ", queryWheres);
        }
        Query query = this.createEm().createQuery(queryToExcecute);
        paginateQuery(query, from, to);

        //mapping to the list of object array into maps with the properties requested
        List<Object[]> result = query.getResultList();
        List<Map<String, Object>> mappedResults = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            HashMap<String, Object> mappedResult = new HashMap<>(querySelects.size());
            for (String querySelect : querySelects) {
                String[] selectParts = querySelect.split("\\.");
                if (selectParts.length == 2) {
                    mappedResult.put(selectParts[1], result.get(i)[index]);
                } else {
                    mappedResult.put(selectParts[selectParts.length - 2] + "_" + selectParts[selectParts.length - 1], result.get(i)[index]);
                }
                index++;
            }
            index = 0;
            mappedResults.add(mappedResult);
        }
        return mappedResults;
    }

    /**
     * check if there is a where condition in a selection
     *
     * @param selection the field selection
     * @return the operator to use in the where clause like '=' or '!='
     */
    protected String whereSelection(String selection) {
        if (selection.contains(">=")) {
            return ">=";
        }
        if (selection.contains("<=")) {
            return "<=";
        }
        if (selection.contains("><")) { //between, its important the order of the questions
            return "><";
        }
        if (selection.contains("!=")) {
            return "!=";
        }
        if (selection.contains("=")) {
            return "=";
        }
        if (selection.contains(">")) {
            return ">";
        }
        if (selection.contains("<")) {
            return "<";
        }
        return "";
    }

    /**
     * Generic map from a native query
     *
     * @param resultSet result set from a native query
     * @param columnsNames columns names in the correct order to map
     * @return list with a map of the properties in the columns of the result
     * set
     */
    public static List<Map> resultSetMap(List<Object[]> resultSet, String... columnsNames) {
        List<Map> mappedResults = new ArrayList<>();
        for (int i = 0; i < resultSet.size(); i++) {
            Map mappedResult = new HashMap(columnsNames.length);
            for (int j = 0; j < columnsNames.length; j++) {
                mappedResult.put(columnsNames[j], resultSet.get(i)[j]);
            }
            mappedResults.add(mappedResult);
        }
        return mappedResults;
    }

    /**
     * Creates an entity manager
     *
     * @return entity manager
     */
    protected EntityManager createEm() {
        return UtilsDB.getEMFactoryCG().createEntityManager();
    }
}
