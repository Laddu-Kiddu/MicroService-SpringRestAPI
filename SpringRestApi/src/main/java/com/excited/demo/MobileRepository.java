package com.excited.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends CrudRepository<Mobile, Integer>{

}
