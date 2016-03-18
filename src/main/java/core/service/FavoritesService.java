package core.service;

import api.dto.FavoritesDTO;
import core.dao.FavoritesDAO;
import core.entity.FavoritesEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FavoritesService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private FavoritesDAO favoritesDAO;

    public FavoritesDTO findById(final Integer id) {

        FavoritesEntity entity = favoritesDAO.findById(id);

        return mapper.map(entity, FavoritesDTO.class);
    }

    public void createFavorites(final FavoritesDTO favorites) {

        FavoritesEntity entity = favoritesDAO.save(mapper.map(favorites, FavoritesEntity.class));
    }

    public List<FavoritesDTO> findByUserID(final Integer userId){
        List<FavoritesEntity> entities = favoritesDAO.findByUserId(userId);
        List<FavoritesDTO> favoritesDTOs = new ArrayList<FavoritesDTO>(entities.size());
        for(FavoritesEntity entity : entities){
            favoritesDTOs.add(mapper.map(entity, FavoritesDTO.class));
        }
        return favoritesDTOs;
    }

    public FavoritesDTO findByVideoId(final Integer id){
        FavoritesEntity entity = favoritesDAO.findByVideoId(id);
        return mapper.map(entity, FavoritesDTO.class);
    }

    public void deleteFromFavorites(final int id){
        favoritesDAO.delete(favoritesDAO.findByVideoId(id));
    }
}
