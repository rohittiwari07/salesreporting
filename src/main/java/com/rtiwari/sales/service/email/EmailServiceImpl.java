package com.rtiwari.sales.service.email;

import com.rtiwari.sales.model.Email;
import com.rtiwari.sales.repository.EmailRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author rtiwari
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    EmailRepository emailRepository;

    JdbcTemplate jdbcTemplate;

    @Override
    public void delete(Long id) {
        emailRepository.delete(id);
    }

    @Override
    public List getAllEmail() {
        return (List) emailRepository.findAll();
    }

    @Override
    public List getWeeks() {
        List<String> Week = new ArrayList<>();
        List<Email> email = emailRepository.findAllDateByRecentValue();
        for (Email ds : email) {
            int c = Integer.parseInt(ds.getClick());
            int o = Integer.parseInt(ds.getOpen());
            int s = Integer.parseInt(ds.getSent());
            LOGGER.debug(" Get Weekly Stats (Email) " + ds.getDate() + "," + c + "," + o + "," + s);
            Week.add(ds.getDate() + "," + c + "," + o + "," + s);
        }
        return Week;
    }

    @Override
    public List getClicks() {
        List<String> Click = new ArrayList<>();
        List<Email> email = emailRepository.findAllDateByRecentValue();
        for (Email ds : email) {
            LOGGER.debug(" -- " + ds.getClick());
            Click.add(ds.getClick());
        }
        return Click;
    }

    @Override
    public void save(Email email) {
        email.setDate(email.getDate());
        email.setClick(email.getClick());
        email.setOpen(email.getOpen());
        email.setSent(email.getSent());
        emailRepository.save(email);
    }

    @Override
    public void saveedit(Email email) {
        emailRepository.save(email);
    }
    
    @Override
    public Email findBydate(Long id) {
        return emailRepository.findOne(id);
    }
}
