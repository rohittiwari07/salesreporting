package com.rtiwari.sales.service.dials;

import com.rtiwari.sales.model.Dial;
import java.util.List;

/**
 *
 * @author rtiwari
 */
public interface DialService {

    public void delete(Long id);

    public List getAllDial();
    
    public List getWeeks();

    public void save(Dial dial);
    
    public Integer getRecentValue();
    
    public Integer getRecentAIP();
    
    public Integer getRecentAGG();
    
    public void saveedit(Dial email);
    
    public Dial findBydate(Long id);
}
