package com.hly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hly.mapper.AttachmentMapper;
import com.hly.model.Attachment;
import com.hly.service.AttachmentService;
@Service
public class AttachmentServiceImpl implements AttachmentService{
	   @Autowired
	   public AttachmentMapper attachmentMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return attachmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Attachment record) {
		// TODO Auto-generated method stub
		return attachmentMapper.insert(record);
	}

	@Override
	public int insertSelective(Attachment record) {
		// TODO Auto-generated method stub
		return attachmentMapper.insertSelective(record);
	}

	@Override
	public Attachment selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return attachmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Attachment record) {
		// TODO Auto-generated method stub
		return attachmentMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Attachment record) {
		
		return attachmentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Attachment> select(Attachment attachment) {
		// TODO Auto-generated method stub
		return attachmentMapper.select(attachment);
	}
	    

}
