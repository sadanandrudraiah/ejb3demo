package com.ha.statefuldemo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LibraryStatefulLocal {
	void addBook(String bookName);
	public List<String> getBooks();

}
