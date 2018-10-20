package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Board;
import org.zerock.domain.PageParam;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;

	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("pageObj") PageParam pageParam, Model model) {
		log.info("list page...");
		
		model.addAttribute("board", service.get(pageParam) );
	}
	
	@PostMapping("/modify")
	public String modify(PageParam pageParam, Board board, RedirectAttributes rttr) {
				
		rttr.addFlashAttribute("result", service.modify(board)==1?"SUCCESS":"FAIL");
		
		return pageParam.getLink("redirect:/board/read");
	}
	
	@PostMapping("/remove")
	public String remove(PageParam pageParam, RedirectAttributes rttr) {
		
		int count = service.remove(pageParam);
		
		rttr.addFlashAttribute("result", count==1?"SUCCESS":"FAIL");
		
		return "redirect:/board/list?page="+pageParam.getPage();
		
	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("pageObj") PageParam pageParam, Model model) {
		log.info("list page...");
		pageParam.setTotal(service.getTotal());
		model.addAttribute("list", service.getList(pageParam) );
	}
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	@PostMapping("/register")
	public String registerPost(Board board, RedirectAttributes rttr) {
		log.info(board);
		int result = service.register(board);
		log.info(result);
		
		rttr.addFlashAttribute("result", result==1?"SUCCESS":"FAIL");
		
		return "redirect:/board/list";
	}
}













