package com.ha.statefuldemo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class LibraryStateful
 */
@Stateful
public class LibraryStateful implements LibraryStatefulLocal, LibraryStatefulRemote {

	List<String> bookShelf; 
	
    /**
     * Default constructor. 
     */
    public LibraryStateful() {
    	bookShelf = new ArrayList<String>();
    }

	@Override
	public void addBook(String bookName) {
		bookShelf.add(bookName);		
	}

	@Override
	public List<String> getBooks() {
		// TODO Auto-generated method stub
		return bookShelf;
	}

}
