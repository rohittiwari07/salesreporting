package com.rtiwari.sales.service.email;

import com.rtiwari.sales.model.Email;
import java.util.List;

/**
 *
 * @author rtiwari
 */
public interface EmailService {

    public void delete(Long id);

    public List getAllEmail();

    public void save(Email email);
    
    public List getWeeks();
    
    public List getClicks();
    
    public void saveedit(Email email);
    
    public Email findBydate(Long id);
}
