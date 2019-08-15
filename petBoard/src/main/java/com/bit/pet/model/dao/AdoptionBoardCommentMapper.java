package com.bit.pet.model.dao;

import java.util.List;

import com.bit.pet.model.dto.AdoptionBoardBean;
import com.bit.pet.model.dto.AdoptionBoardCommentBean;

public interface AdoptionBoardCommentMapper {
	
	List<AdoptionBoardCommentBean> aSelectBoardComment(int abcRef);
	
	void aWriterBoardComment(AdoptionBoardCommentBean abcBoard);
	
	void aDeleteBoardComment(AdoptionBoardCommentBean abcBoard);
	
	void aModifyBoardComment(AdoptionBoardCommentBean abcBoard);
}
