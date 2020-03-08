package com.rtiwari.sales.service.dials;

import com.rtiwari.sales.model.Dial;
import com.rtiwari.sales.repository.DialRepository;
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
public class DialServiceImpl implements DialService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DialServiceImpl.class);

    @Autowired
    DialRepository dialRepository;
    
    JdbcTemplate jdbcTemplate;

    @Override
    public void delete(Long id) {
        dialRepository.delete(id);
    }

    @Override
    public List getAllDial() {
        return (List) dialRepository.findAll();
    }

    @Override
    public void save(Dial dial) {

    }

    @Override
    public Integer getRecentValue() {
        int recDial = 0;
        List<Dial> dial = dialRepository.findAllDateByRecentValue();
        for (Dial ds : dial) {
            LOGGER.info("=====================");
            LOGGER.debug(" -- " + ds.getValue());
            recDial += ds.getValue();
        }
        return recDial;
    }

    @Override
    public Integer getRecentAIP() {
        int recAIP = 0;
        List<Dial> dial = dialRepository.findAllDateByRecentValue();
        for (Dial ds : dial) {
            LOGGER.info("=====================");
            LOGGER.debug(" -- " + ds.getAip());
            recAIP += ds.getAip();
        }
        return recAIP;
    }

    @Override
    public Integer getRecentAGG() {
        int recAGG = 0;
        List<Dial> dial = dialRepository.findAllDateByRecentValue();
        for (Dial ds : dial) {
            LOGGER.info("=====================");
            LOGGER.debug(" -- " + ds.getValue());
            int x = ds.getValue();
            int y = ds.getAip();
            int recintAGG = y * 100 / x;
            recAGG = recintAGG;
        }
        return recAGG;
    }

    @Override
    public List getWeeks() {
        List<String> Week = new ArrayList<>();
        List<Dial> dial = dialRepository.findAllDateByRecentValue();
        for (Dial ds : dial) {
            int c = ds.getValue();
            int o = ds.getAip();
            LOGGER.info("=====================");
            LOGGER.debug(" Weekly Dials Data -- [ " + ds.getDate() + "," + c + "," + o + " ]");
            Week.add(ds.getDate() + "," + c + "," + o);
        }
        return Week;
    }

    @Override
    public void saveedit(Dial dial) {
        dialRepository.save(dial);
    }

    @Override
    public Dial findBydate(Long id) {
        return dialRepository.findOne(id);
    }
}
