package core.service;

import api.dto.FavoritesDTO;
import core.dao.FavoritesDAO;
import core.entity.FavoritesEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
