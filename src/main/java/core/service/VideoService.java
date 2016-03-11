package core.service;

import api.dto.VideoDTO;
import core.dao.VideoDAO;
import core.entity.VideoEntity;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VideoService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private VideoDAO videoDAO;

    public VideoDTO findById(final Integer id) {

        VideoEntity entity = videoDAO.findById(id);

        return mapper.map(entity, VideoDTO.class);
    }

    public void createVideo(final VideoDTO video) {

        VideoEntity entity = videoDAO.save(mapper.map(video, VideoEntity.class));
    }
    public List<VideoDTO> getAllVideos()
    {
        List<VideoDTO> videoDTOs = new ArrayList<VideoDTO>();
        for( VideoEntity entity : videoDAO.findAll())
        {
            videoDTOs.add(mapper.map(entity, VideoDTO.class));
        }
        return videoDTOs;
    }
    public List<VideoDTO> getVideosByQuery(String params)
    {
        List<VideoDTO> videoDTOs = new ArrayList<VideoDTO>();
        for( VideoEntity entity : videoDAO.getVideosByQuery(params))
        {
            videoDTOs.add(mapper.map(entity, VideoDTO.class));
        }
        return videoDTOs;
    }
}
