package com.bit.pet.model.dao;

import java.util.List;

import com.bit.pet.model.dto.AdoptionBoardBean;

public interface AdoptionBoardMapper {

	List<AdoptionBoardBean> aMainBoard();
	
	void aCategoryBoard(AdoptionBoardBean aBoard);
	
	AdoptionBoardBean aSelectBoard(int abNum);
	
	AdoptionBoardBean aModifyView(AdoptionBoardBean aBoard);
	
	List<AdoptionBoardBean> aCategoryBoardSelect(String abCategory);
	
	void aWriterBoard(AdoptionBoardBean aBoard);
	
	void aModifyBoard(AdoptionBoardBean aBoard);
	
	void aDeleteBoard(AdoptionBoardBean aBoard);
	
	void aBoardHit(AdoptionBoardBean aBoard);
	
//	void aBoardLike(AdoptionBoardBean aBoard);
	void aBoardLike(int abNum);
}
