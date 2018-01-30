package com.wiedenman.b_plate.dao;

import com.wiedenman.b_plate.web.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DoctorDao extends CrudRepository<Doctor, Integer> {
}
