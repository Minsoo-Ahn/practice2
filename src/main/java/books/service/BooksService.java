package books.service;

import java.util.List;

import books.vo.BooksVO;

public interface BooksService {
	public abstract List<BooksVO> list();
	public abstract void write(BooksVO booksVO);
	public abstract BooksVO read(int seq);
	public abstract List<BooksVO> search(String search);
}
