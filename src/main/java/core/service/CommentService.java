package core.service;

import api.dto.CommentDTO;
import core.dao.CommentDAO;
import core.entity.CommentEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private CommentDAO commentDAO;

    public CommentDTO findById(final Integer id) {

        CommentEntity entity = commentDAO.findById(id);

        return mapper.map(entity, CommentDTO.class);
    }

    public void createComment(final CommentDTO comment) {

        CommentEntity entity = mapper.map(comment, CommentEntity.class);
        commentDAO.save(entity);
    }

    public void deleteComment(final CommentDTO comment){
        commentDAO.delete(mapper.map(comment, CommentEntity.class));
    }

    public List<CommentDTO> findbyVideoId(int videoId){
        List<CommentEntity> entities = commentDAO.findByVideoId(videoId);
        List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>(entities.size());
        for(CommentEntity entity : entities){
            commentDTOs.add(mapper.map(entity, CommentDTO.class));
        }
        return commentDTOs;
    }

    public List<CommentDTO> findbyVideoIdPaginated(int videoId, int page, int limit){
        page = page <= 1 ? 0 : page - 1;
        List<CommentEntity> entities = commentDAO.findByVideoIdPaginated(videoId, page, limit);
        List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>(entities.size());
        for(CommentEntity entity : entities){
            commentDTOs.add(mapper.map(entity, CommentDTO.class));
        }
        return commentDTOs;
    }

}
