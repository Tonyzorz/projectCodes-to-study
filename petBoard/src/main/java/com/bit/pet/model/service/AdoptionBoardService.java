package com.bit.pet.model.service;

import java.util.List;

import com.bit.pet.model.dto.AdoptionBoardBean;

public interface AdoptionBoardService {

	List<AdoptionBoardBean> aMainBoard();
	
	void aCategoryBoard(AdoptionBoardBean aBoard);
	
	List<AdoptionBoardBean> aCategoryBoardSelect(String abCategory);

	AdoptionBoardBean aSelectBoard(int abNum);
	
	AdoptionBoardBean aModifyView(AdoptionBoardBean aBoard);
	
	void aWriterBoard(AdoptionBoardBean aBoard);
	
	void aModifyBoard(AdoptionBoardBean aBoard);
	
	void aDeleteBoard(AdoptionBoardBean aBoard);
	
	void aBoardHit(AdoptionBoardBean aBoard);
	
	//void aBoardLike(AdoptionBoardBean aBoard);
	void aBoardLike(int abNum);
}
