package com.bit.pet.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bit.pet.model.dto.JournalBoardBean;
import com.bit.pet.model.service.JournalBoardService;
import com.bit.pet.util.JBoardValid;

@Controller
public class JournalBoardController {
	@Autowired
	JournalBoardService journalBoardService;

	// 다뿌려
	@RequestMapping("/jMainBoard")
	public String jMainBoard(Model model, JournalBoardBean jBoard) {
		journalBoardService.jBoardHit(jBoard);
		model.addAttribute("allList", journalBoardService.jMainBoard());

		return "jBoard/jMainBoard";
	}

	// 글좀 보자 친구야
	@RequestMapping(value = "/jSelectBoard", method = RequestMethod.GET)
	public String jSelectBoard(Model model, JournalBoardBean jBoard) {
		// System.out.println(jBoard.getJbNum());
		journalBoardService.jBoardHit(jBoard);

		model.addAttribute("select", journalBoardService.jSelectBoard(jBoard.getJbNum()));

		return "jBoard/jSelectBoard";
	}

	@RequestMapping("/jWriterView")
	public String jWriterView(JournalBoardBean jBoard) {

		return "jBoard/jWriterBoard";
	}

	// 글좀 쓰자 친구야
	@RequestMapping(value = "/jWriterBoard", method = { RequestMethod.POST, RequestMethod.GET })
	public String jWriterBoard(HttpSession session, @Valid JournalBoardBean jBoard, BindingResult bindingResult) {
		
		JBoardValid jBoardValid = new JBoardValid();
		jBoardValid.validate(jBoard, bindingResult);

		if (bindingResult.hasErrors()) {
			return "redirect:/jWriterView";
		}
		String fileName = "Empty";
		if (!jBoard.getFiles().isEmpty()) {
			try {
				fileName = jBoard.getFiles().getOriginalFilename();
				String path = "C:\\Users\\USER\\Documents\\workspace-sts-3.9.7.RELEASE\\petBoard\\src\\main\\webapp\\resources\\images\\";
				jBoard.getFiles().transferTo(new File(path+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
		}
		jBoard.setJbPicUrl(fileName);
		jBoard.setJbWriter((String) session.getAttribute("userId"));
		journalBoardService.jWriteBoard(jBoard);
		return "redirect:jMainBoard";
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public void uploadFile(MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// �뾽濡쒕뱶�븷 �뤃�뜑 寃쎈줈
		String realFolder = request.getSession().getServletContext().getRealPath("resources/images/");
		UUID uuid = UUID.randomUUID();

		// �뾽濡쒕뱶�븷 �뙆�씪 �씠由�
		String org_filename = file.getOriginalFilename();
		String str_filename = uuid.toString().substring(0, 4) + org_filename;

		System.out.println("�썝蹂� �뙆�씪紐� : " + org_filename);
		System.out.println("���옣�븷 �뙆�씪紐� : " + str_filename);

		String filepath = realFolder + str_filename;
		System.out.println("�뙆�씪寃쎈줈 : " + filepath);

		File f = new File(filepath);
		if (!f.exists()) {
			f.mkdirs();
		}
		file.transferTo(f);
		out.println("resources/images/" + str_filename);
		out.close();

	}

	// 글수정하는곳으로 가는 친구가 필요함 글쓰기와 같은형식의 화면인데, 처음부터 데이터가 들어있어야해.
	@RequestMapping(value = "/jModifyView", method = RequestMethod.POST)
	public String jModifyView(JournalBoardBean jBoard, HttpSession session, Model model) {
		// 수정할곳임. 수정페이지를 세션과 비교해서 들어갈수있게 하려고 개삽질했지만, jsp에서 애초에 수정버튼을 안보여주면 되는거였다. -끗ㅌ-

		model.addAttribute("modify", journalBoardService.jSelectBoard(jBoard.getJbNum()));
		// JournalBoardBean bean = journalBoardService.jSelectBoard(jBoard);
//		System.out.println(bean.getJbWriter());
//		System.out.println(session.getAttribute("userId"));
//		 if(bean.getJbWriter().equals(session.getAttribute("userId")) ) {
//			 model.addAttribute("modify", journalBoardService.jSelectBoard(jBoard));
//				
//		return "jBoard/jModifyBoard";
//		}

		return "jBoard/jModifyBoard";
	}

	// 앤 걍 수정된거 실행해줄애야.
	@RequestMapping(value = "/jModifyBoard", method = RequestMethod.POST)
	public String jModifyBoard(JournalBoardBean jBoard, Model model) {
		String fileName = "Empty";
		if (!jBoard.getFiles().isEmpty()) {
			try {
				fileName = jBoard.getFiles().getOriginalFilename();
				String path = "C:\\Users\\USER\\Documents\\workspace-sts-3.9.7.RELEASE\\petBoard\\src\\main\\webapp\\resources\\images\\";
				jBoard.getFiles().transferTo(new File(path+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
		}
		jBoard.setJbPicUrl(fileName);
		journalBoardService.jModifyBoard(jBoard);
		System.out.println(jBoard.getJbNum());
		model.addAttribute("select", journalBoardService.jSelectBoard(jBoard.getJbNum()));
		return "jBoard/jSelectBoard";
	}

	// 지워줄애야
	@RequestMapping(value = "/jDeleteBoard", method = RequestMethod.POST)
	public String jDeleteBoard(JournalBoardBean jBoard) {
		System.out.println(jBoard.getJbNum());
		journalBoardService.jDeleteBoard(jBoard);
		return "redirect:jMainBoard";
	}

	@RequestMapping(value = "/jLikeBoard")
	public String jBoardLike(JournalBoardBean jBoard, Model model) {
		System.out.println(jBoard);
		journalBoardService.jBoardLike(jBoard);
		model.addAttribute("select", journalBoardService.jSelectBoard(jBoard.getJbNum()));
		return "jBoard/jSelectBoard";

	}

	// redirecting to jReplyBoard.jsp
	@RequestMapping(value = "jReplyBoard", method=RequestMethod.POST)
	public String jReplyBoard(Model model, JournalBoardBean jBoard) {
		System.out.println("reply View : " + jBoard);
		
		model.addAttribute("select", journalBoardService.jSelectBoard(jBoard));

		return "jBoard/jReplyBoard";
	}

	// adding reply
	@RequestMapping(value= "jReplyBoardReply", method = RequestMethod.POST)
	public String jReplyBoardReply(HttpSession session, JournalBoardBean jBoard) {
		jBoard.setJbWriter((String) session.getAttribute("userId"));
		// JournalBoardBean board= journalBoardService.jSelectBoard(jBoard);
		String fileName = "Empty";
		if (!jBoard.getFiles().isEmpty()) {
			try {
				fileName = jBoard.getFiles().getOriginalFilename();
				String path = "C:\\Users\\USER\\Documents\\workspace-sts-3.9.7.RELEASE\\petBoard\\src\\main\\webapp\\resources\\images\\";
				jBoard.getFiles().transferTo(new File(path+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
		}
		jBoard.setJbPicUrl(fileName);
		System.err.println("reply prs : " + jBoard);
		journalBoardService.jReplyBoardReply(jBoard);
		journalBoardService.jReplyBoardIndent(jBoard);
		System.out.println("reply process : " + jBoard);
		return "redirect:jMainBoard";
	}

}