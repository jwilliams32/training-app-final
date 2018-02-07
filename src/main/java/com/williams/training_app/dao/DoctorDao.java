package com.williams.training_app.dao;

import com.williams.training_app.web.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DoctorDao extends CrudRepository<Doctor, Integer> {
}
