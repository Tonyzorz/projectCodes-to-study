package com.bit.pet.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.pet.model.dto.AdoptionBoardBean;
import com.bit.pet.model.dto.AdoptionBoardCommentBean;
import com.bit.pet.model.service.AdoptionBoardCommentService;
import com.bit.pet.model.service.AdoptionBoardService;

@Controller
public class AdoptionBoardController {

	public static final Logger logger = LoggerFactory.getLogger(AdoptionBoardController.class);

	@Autowired
	AdoptionBoardService adoptionBoardService;

	@Autowired
	AdoptionBoardCommentService adoptionBoardCommentService;

	@RequestMapping("aMainBoard")
	public String aMainBoard(Model model) {

		model.addAttribute("allList", adoptionBoardService.aMainBoard());

		return "aBoard/aMainBoard";
	}

	@RequestMapping("aCategoryBoardSelect")
	public String aCategoryBoardSelect(String abCategory, Model model) {
		logger.info(abCategory);
		List<AdoptionBoardBean> list = adoptionBoardService.aCategoryBoardSelect(abCategory);
		model.addAttribute("allList", list);
		return "aBoard/aMainBoard";
	}

	@RequestMapping(value = "aCategoryBoard", method = RequestMethod.POST)
	public String aCategoryBoard(AdoptionBoardBean aBoard) {

		adoptionBoardService.aCategoryBoard(aBoard);

		return "redirect:aMainBoard";
	}

	@RequestMapping(value = "aSelectBoard")
	public String aSelectBoard(AdoptionBoardBean aBoard, Model model) {

		adoptionBoardService.aBoardHit(aBoard);

		System.out.println(adoptionBoardCommentService.aSelectBoardComment(aBoard.getAbNum()));
		model.addAttribute("select", adoptionBoardService.aSelectBoard(aBoard.getAbNum()));
		model.addAttribute("selectC", adoptionBoardCommentService.aSelectBoardComment(aBoard.getAbNum()));

		return "aBoard/aSelectBoard";
	}

	@RequestMapping(value = "aWriterView")
	public String aWriterView(AdoptionBoardBean aBoard, Model model) {

		adoptionBoardService.aModifyView(aBoard);

		model.addAttribute("select", adoptionBoardService.aSelectBoard(aBoard.getAbNum()));

		return "aBoard/aWriterBoard";
	}

	@RequestMapping(value = "aWriterBoard", method = RequestMethod.POST)
	public String aWriterBoard(AdoptionBoardBean aBoard, HttpSession session) {
		String fileName = "Empty";
		if (!aBoard.getFiles().isEmpty()) {
			try {
				fileName = aBoard.getFiles().getOriginalFilename();
				String path = "C:\\Users\\USER\\Documents\\workspace-sts-3.9.7.RELEASE\\petBoard\\src\\main\\webapp\\resources\\images\\";
				aBoard.getFiles().transferTo(new File(path+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
		}

		aBoard.setAbPicUrl(fileName);
		System.out.println((String) session.getAttribute("userId"));
		aBoard.setAbWriter((String) session.getAttribute("userId"));
		adoptionBoardService.aWriterBoard(aBoard);

//		return "redirect:aSelectBoard?abNum=" + aBoard.getAbNum();
		return "redirect:aMainBoard";
	}

	@RequestMapping(value = "aModifyView")
	public String aModifyView(AdoptionBoardBean aBoard, Model model) {

		AdoptionBoardBean Board = adoptionBoardService.aModifyView(aBoard);

		adoptionBoardService.aSelectBoard(aBoard.getAbNum());
		model.addAttribute("ab", adoptionBoardService.aModifyView(Board));
		System.out.println(Board.getAbWriter());
		return "aBoard/aModifyBoard";
	}

	@RequestMapping(value = "aModifyBoard", method = RequestMethod.POST)
	public String aModifyBoard(AdoptionBoardBean aBoard) {
		String fileName = "Empty";
		System.out.println("did it arrive?");
		if (!aBoard.getFiles().isEmpty()) {
			try {
				fileName = aBoard.getFiles().getOriginalFilename();
				String path = "C:\\Users\\USER\\Documents\\workspace-sts-3.9.7.RELEASE\\petBoard\\src\\main\\webapp\\resources\\images\\";
				aBoard.getFiles().transferTo(new File(path+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
		}
		aBoard.setAbPicUrl(fileName);
		adoptionBoardService.aModifyBoard(aBoard);

		return "redirect:aSelectBoard?abNum=" + aBoard.getAbNum();
	}

	@RequestMapping(value = "aDeleteBoard")
	public String aDeleteBoard(AdoptionBoardBean aBoard) {

		adoptionBoardService.aDeleteBoard(aBoard);

		return "redirect:aMainBoard";
	}

//	@RequestMapping(value = "aBoardLike")
//	public String aBoardLike(AdoptionBoardBean aBoard) {
//
//		adoptionBoardService.aBoardLike(aBoard);
//
//		return "redirect:aSelectBoard?abNum=" + aBoard.getAbNum();
//	}
	@RequestMapping(value = "aBoardLike")
	@ResponseBody
	public String aBoardLike(int abNum) {
		adoptionBoardService.aBoardLike(abNum);
		
		return "recommendation +1";
	}

	@RequestMapping(value = "aWriterBoardComment")
	public String aWriterBoardComment(AdoptionBoardCommentBean abcBoard, AdoptionBoardBean aBoard) {
		System.out.println(aBoard.getAbNum());
		int Num = aBoard.getAbNum();
		abcBoard.setAbcRef(Num);
		System.out.println("abcBoard is : " + abcBoard);
		adoptionBoardCommentService.aWriterBoardComment(abcBoard);

		return "redirect:aSelectBoard?abNum=" + aBoard.getAbNum();
	}

	@RequestMapping(value = "aDeleteBoardComment")
	public String aDeleteBoardComment(AdoptionBoardCommentBean abcBoard, AdoptionBoardBean aBoard) {
		abcBoard.setAbcNum(aBoard.getAbNum());
		adoptionBoardCommentService.aDeleteBoardComment(abcBoard);
		System.out.println(abcBoard);

		return "redirect:aSelectBoard?abNum=" + abcBoard.getAbcNum();

	}

	@RequestMapping(value = "aModifyBoardComment")
	public String aModifyBoardComment(AdoptionBoardCommentBean abcBoard) {

		adoptionBoardCommentService.aModifyBoardComment(abcBoard);

		return "aBoard/aSelectBoard";
	}
	
	
}
