package com.rtiwari.sales.repository;

import com.rtiwari.sales.model.Dial;
import com.rtiwari.sales.model.Email;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rtiwari
 */
public interface EmailRepository extends CrudRepository<Email, Long> {
    
    Dial findById(Long id);

    public void delete(Long id);
    
    @Query("FROM Email ORDER BY date DESC")
    List<Email> findAllDateByRecentValue();
}
