package com.wiedenman.b_plate.dao;

import com.wiedenman.b_plate.web.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TestDao extends CrudRepository<Test, Integer>{
}
