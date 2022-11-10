
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcercaDeRepository extends JpaRepository <AcercaDe,Long> {
        
}
