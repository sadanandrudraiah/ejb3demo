package com.ha.demo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class LibrarySession
 */
@Stateless
public class LibrarySession implements LibrarySessionRemote, LibrarySessionLocal {

	List<String> bookShelf;  
	
    /**
     * Default constructor. 
     */
    public LibrarySession() {
    	bookShelf = new ArrayList<String>();
    }

	@Override
	public void addBook(String bookName) {
		bookShelf.add(bookName);
		
	}

	@Override
	public List<String> getBooks() {
		return bookShelf;
	}

}
