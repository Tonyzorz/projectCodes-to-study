package com.bit.pet.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.pet.model.dao.JournalBoardMapper;
import com.bit.pet.model.dto.JournalBoardBean;
import com.bit.pet.model.service.JournalBoardService;
@Service("journalBoardService")
public class JournalBoardServiceImpl implements JournalBoardService {
	
	@Autowired
	JournalBoardMapper journalBoardMapper;
	
	@Override
	public List<JournalBoardBean> jMainBoard() {
		List<JournalBoardBean> allBoard	= journalBoardMapper.jMainBoard();
		return allBoard;
	}

	@Override
	public JournalBoardBean jSelectBoard(int jBoard) {
		
		JournalBoardBean selectBoard = journalBoardMapper.jSelectBoard(jBoard);
		return selectBoard;
	}
	@Override
	public JournalBoardBean jSelectBoard(JournalBoardBean jBoard) {
		
		JournalBoardBean selectBoard = journalBoardMapper.jSelectBoard(jBoard);
		return selectBoard;
	}
	@Override
	public void jWriteBoard(JournalBoardBean jBoard) {
		journalBoardMapper.jWriteBoard(jBoard);
	}

	@Override
	public void jModifyBoard(JournalBoardBean jBoard) {
		journalBoardMapper.jModifyBoard(jBoard);
	}

	@Override
	public void jDeleteBoard(JournalBoardBean jBoard) {
		journalBoardMapper.jDeleteBoard(jBoard);
	}

	@Override
	public void jBoardHit(JournalBoardBean jBoard) {
		journalBoardMapper.jBoardHit(jBoard);
		
	}

	@Override
	public void jBoardLike(JournalBoardBean jBoard) {
		journalBoardMapper.jBoardLike(jBoard);
		
	}

	@Override
	public void jReplyBoardReply(JournalBoardBean jBoard) {
		journalBoardMapper.jReplyBoardReply(jBoard);
	}

	@Override
	public void jReplyBoardIndent(JournalBoardBean jBoard) {
		journalBoardMapper.jReplyBoardIndent(jBoard);
	}

}
