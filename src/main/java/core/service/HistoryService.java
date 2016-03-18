package core.service;

import api.dto.HistoryDTO;
import core.dao.HistoryDAO;
import core.entity.HistoryEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.List;


@Service
public class HistoryService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private HistoryDAO HistoryDAO;

    public HistoryDTO findById(final Integer id) {

        HistoryEntity entity = HistoryDAO.findById(id);

        return mapper.map(entity, HistoryDTO.class);
    }

    public List<HistoryDTO> findByUserID(final Integer userId){
        List<HistoryEntity> entities = HistoryDAO.findByUserId(userId);
        List<HistoryDTO> historyDTOs = new ArrayList<HistoryDTO>(entities.size());
        for(HistoryEntity entity : entities){
            historyDTOs.add(mapper.map(entity, HistoryDTO.class));
        }
        return historyDTOs;
    }


    public void createHistory(final HistoryDTO History) {

        HistoryEntity entity = HistoryDAO.save(mapper.map(History, HistoryEntity.class));
    }
}
