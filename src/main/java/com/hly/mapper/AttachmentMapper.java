package com.hly.mapper;

import java.util.List;

import com.hly.model.Attachment;

public interface AttachmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
    
    List<Attachment> select(Attachment attachment);
    
}