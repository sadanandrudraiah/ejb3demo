package com.ha.demo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibrarySessionRemote {
	void addBook(String bookName);
	public List<String> getBooks();

}
