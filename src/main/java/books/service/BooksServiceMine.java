package books.service;

import java.util.List;

import org.springframework.stereotype.Service;

import books.dao.BooksDao;
import books.vo.BooksVO;

@Service
public class BooksServiceMine implements BooksService{
	private BooksDao booksDao;
	public BooksDao getBooksDao() {
		return booksDao;
	}

	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	@Override
	public List<BooksVO> list() {
		return booksDao.list();
	}

	@Override
	public void write(BooksVO booksVO) {
		booksDao.insert(booksVO);
		
	}

	@Override
	public BooksVO read(int seq) {
		return booksDao.select(seq);
	}

	@Override
	public List<BooksVO> search(String search) {
		return booksDao.search(search);
	}
	
}
