package books.dao;

import java.util.List;

import books.vo.BooksVO;

public interface BooksDao {
	public abstract List<BooksVO> list();
	public abstract void insert(BooksVO booksVO);
	public abstract BooksVO select(int seq);
	public abstract List<BooksVO> search(String search);
}
