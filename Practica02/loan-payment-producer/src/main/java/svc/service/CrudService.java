package svc.service;

import svc.model.Loan;

import java.util.List;

public interface CrudService<T, ID> {
    void create(T t);
    void update(T t);
    void delete(ID id);
    Loan findById(ID id);

    void delete(Integer id);

    Loan findById(Integer id);

    List<T> findAll();
}
