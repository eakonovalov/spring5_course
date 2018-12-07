package com.eakonovalov.spring5petclinic.data.repositories;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class MapRepository<T, ID> implements JpaRepository<T, ID> {

    private Map<ID, T> store = new HashMap<>();

    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<T> findAll(Sort sort) {
        return findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        List<T> found = new ArrayList<>();
        ids.forEach(id -> {
            T t = store.get(id);
            if (t != null) found.add(t);
        });

        return found;
    }

    @Override
    public long count() {
        return store.size();
    }

    @Override
    public void deleteById(ID id) {
        store.remove(id);
    }

    @Override
    public void delete(T t) {
        store.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {
        List<T> toRemove = new ArrayList<>();
        iterable.forEach(toRemove::add);
        store.entrySet().removeIf(entry -> toRemove.contains(entry.getValue()));
    }

    @Override
    public void deleteAll() {
        store.clear();
    }

    @Override

    public <S extends T> S save(S s) {
        Field[] fields = FieldUtils.getFieldsWithAnnotation(s.getClass(), Id.class);

        ID id;
        try {
            PropertyDescriptor pd = new PropertyDescriptor(fields[0].getName(), s.getClass());
            @SuppressWarnings("unchecked")
            ID temp = (ID) pd.getReadMethod().invoke(s);
            id = temp;
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        store.put(id, s);

        return s;
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        List<S> saved = new ArrayList<>();
        entities.forEach(e -> {
            save(e);
            saved.add(e);
        });

        return saved;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public boolean existsById(ID id) {
        return store.get(id) != null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        return save(entity);
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAllInBatch() {
        store.clear();
    }

    @Override
    public T getOne(ID id) {
        return store.get(id);
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }

    public Map<ID, T> getStore() {
        return store;
    }

    public void setStore(Map<ID, T> store) {
        this.store = store;
    }
}
