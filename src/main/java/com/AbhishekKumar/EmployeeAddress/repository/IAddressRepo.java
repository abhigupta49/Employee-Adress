package com.AbhishekKumar.EmployeeAddress.repository;

import com.AbhishekKumar.EmployeeAddress.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address,Long> {
    Address findByAddressId(Long addId);
}
