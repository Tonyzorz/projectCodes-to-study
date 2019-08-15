package com.bit.pet.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.pet.model.dao.AdoptionBoardCommentMapper;
import com.bit.pet.model.dto.AdoptionBoardBean;
import com.bit.pet.model.dto.AdoptionBoardCommentBean;
import com.bit.pet.model.service.AdoptionBoardCommentService;

@Service("adoptionBoardCommentService")
public class AdoptionBoardCommentServiceImpl implements AdoptionBoardCommentService {

	@Autowired
	AdoptionBoardCommentMapper adoptionBoardCommentMapper;
	
	@Override
	public List<AdoptionBoardCommentBean> aSelectBoardComment(int abcRef) {

		List<AdoptionBoardCommentBean> beans = adoptionBoardCommentMapper.aSelectBoardComment(abcRef);
		
		return beans;
	}

	@Override
	public void aWriterBoardComment(AdoptionBoardCommentBean abcBoard) {
		
		adoptionBoardCommentMapper.aWriterBoardComment(abcBoard);
		
	}

	@Override
	public void aDeleteBoardComment(AdoptionBoardCommentBean abcBoard) {
		
		adoptionBoardCommentMapper.aDeleteBoardComment(abcBoard);
		
	}

	@Override
	public void aModifyBoardComment(AdoptionBoardCommentBean abcBoard) {
		
		adoptionBoardCommentMapper.aModifyBoardComment(abcBoard);
		
	}

}
