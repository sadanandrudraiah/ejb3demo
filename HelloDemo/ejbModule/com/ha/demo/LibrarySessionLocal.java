package com.ha.demo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LibrarySessionLocal {

	void addBook(String bookName);
	public List<String> getBooks();
}
