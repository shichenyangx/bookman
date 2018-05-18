package cn.edu.nyist.bookmanv1.biz.impl;

import java.util.Date;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.dao.BookDao;
import cn.edu.nyist.bookmanv1.dao.impl.BookDaoJdbcImpl;

public class BookBizImpl implements BookBiz {

	@Override
	public int saveBook(String name, String descri,double price, String author, int tid, String newFileName,Date pubDate) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(name,descri,price,author,tid,newFileName,pubDate);
	}

}
