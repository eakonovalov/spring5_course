package com.eakonovalov.spring5petclinic.data.repositories;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class MapRepository<T, ID> implements CrudRepository<T, ID> {

    private final AtomicLong sequence = new AtomicLong();
    private final Map<ID, T> store = new HashMap<>();

    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
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
    @SuppressWarnings("unchecked")
    public <S extends T> S save(S s) {
        Field[] fields = FieldUtils.getFieldsWithAnnotation(s.getClass(), Id.class);
        if (fields.length != 1) {
            throw new RuntimeException("Only 1 field should be annotated with @Id, but found " + fields.length);
        }

        ID id;
        try {
            PropertyDescriptor pd = new PropertyDescriptor(fields[0].getName(), s.getClass());
            Object temp = pd.getReadMethod().invoke(s);
            if (temp != null) {
                id = (ID) temp;
            } else {
                id = (ID) ((Object) sequence.getAndIncrement());
                pd.getWriteMethod().invoke(s, id);
            }
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

    public Map<ID, T> getStore() {
        return store;
    }
}
