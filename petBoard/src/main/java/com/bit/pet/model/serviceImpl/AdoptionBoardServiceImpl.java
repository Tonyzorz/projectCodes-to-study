package com.bit.pet.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.pet.model.dao.AdoptionBoardMapper;
import com.bit.pet.model.dto.AdoptionBoardBean;
import com.bit.pet.model.service.AdoptionBoardService;

@Service("adoptionBoardService")
public class AdoptionBoardServiceImpl implements AdoptionBoardService {

	@Autowired
	AdoptionBoardMapper adoptionBoardMapper;
	
	@Override
	public List<AdoptionBoardBean> aMainBoard() {
		List<AdoptionBoardBean> beans = adoptionBoardMapper.aMainBoard();
		
		return beans;
	}

	@Override
	public void aCategoryBoard(AdoptionBoardBean aBoard) {
		
		adoptionBoardMapper.aCategoryBoard(aBoard);
	}

	@Override
	public AdoptionBoardBean aSelectBoard(int abNum) {

		AdoptionBoardBean selectBoard = adoptionBoardMapper.aSelectBoard(abNum);
		
		return selectBoard;
	}


	@Override
	public void aWriterBoard(AdoptionBoardBean aBoard) {

		adoptionBoardMapper.aWriterBoard(aBoard);
	}

	@Override
	public AdoptionBoardBean aModifyView(AdoptionBoardBean aBoard) {
		
		AdoptionBoardBean beans = adoptionBoardMapper.aModifyView(aBoard);
		
		return beans;
	}
	
	@Override
	public void aModifyBoard(AdoptionBoardBean aBoard) {
		
		adoptionBoardMapper.aModifyBoard(aBoard);
	}

	@Override
	public void aDeleteBoard(AdoptionBoardBean aBoard) {
		
		adoptionBoardMapper.aDeleteBoard(aBoard);
	}

	@Override
	public void aBoardHit(AdoptionBoardBean aBoard) {
		
		adoptionBoardMapper.aBoardHit(aBoard);
	}

//	@Override
//	public void aBoardLike(AdoptionBoardBean aBoard) {
//		
//		adoptionBoardMapper.aBoardLike(aBoard);
//	}
	@Override
	public void aBoardLike(int abNum) {
		
		adoptionBoardMapper.aBoardLike(abNum);
	}
	@Override
	public List<AdoptionBoardBean> aCategoryBoardSelect(String abCategory) {
		return adoptionBoardMapper.aCategoryBoardSelect(abCategory);
	}

	


}
