
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Header;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends CrudRepository <Header, Long>{
    
}
