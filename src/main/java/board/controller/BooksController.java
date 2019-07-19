package board.controller;



import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import books.service.BooksService;
import books.vo.BooksVO;

@Controller
public class BooksController {
	private BooksService booksService;

	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(@ModelAttribute("booksVO")SearchCommand searchCommand,Model model) {
		model.addAttribute("booksList", booksService.list());
		return "/books/list";
	}
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String list2(@ModelAttribute("booksVO")SearchCommand searchCommand,Model model) {
		if( !searchCommand.getSearch().equals("")) {
			model.addAttribute("booksList",booksService.search(searchCommand.getSearch()) );
			return "/books/list";
		}
		model.addAttribute("booksList", booksService.list());
		return "/books/list";
	}
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("booksVO", new BooksVO());
		return "/books/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpServletRequest rq, BooksVO booksVO, @RequestParam("fileName")MultipartFile mf) throws IllegalStateException, IOException {
		String path = rq.getSession().getServletContext().getRealPath("/image");
		booksVO.setImage(mf.getOriginalFilename());
		mf.transferTo(new File(path , mf.getOriginalFilename()));
		booksService.write(booksVO);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("booksVO", booksService.read(seq));
		return "/books/read";
	}
	
}
