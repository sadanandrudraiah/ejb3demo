package com.ha.statefuldemo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibraryStatefulRemote {
	void addBook(String bookName);
	public List<String> getBooks();

}
