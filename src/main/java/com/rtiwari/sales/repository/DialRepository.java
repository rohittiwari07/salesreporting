package com.rtiwari.sales.repository;

import com.rtiwari.sales.model.Dial;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rtiwari
 */
public interface DialRepository extends CrudRepository<Dial, Long> {

    Dial findByValue(String value);

    Dial findById(Long id);
    
    @Query("FROM Dial ORDER BY date DESC")
    List<Dial> findAllDateByRecentValue();
}
