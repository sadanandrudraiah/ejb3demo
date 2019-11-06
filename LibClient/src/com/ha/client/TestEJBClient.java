package com.ha.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ha.demo.LibrarySessionRemote;

public class TestEJBClient {

	public static void main(String[] args) {
		
		Properties props = new Properties();
		InitialContext ctx;
		
		try {
			props.load(new FileInputStream("jndi.properties"));
			ctx = new InitialContext(props);
			LibrarySessionRemote libraryBean = 
			         (LibrarySessionRemote) ctx.lookup("LibrarySession/remote");
			libraryBean.addBook("Testing EJB 4");
			System.out.println("Book Added ");
			
			List<String> books = libraryBean.getBooks();
			for(String s : books)
			{
				System.out.println(s);
			}

			LibrarySessionRemote libraryBean2 = 
			         (LibrarySessionRemote) ctx.lookup("LibrarySession/remote");
			List<String> books2 = libraryBean2.getBooks();
			System.out.println("Second Loop");
			for(String s : books2)
			{
				System.out.println(s);
			}			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		/*
		 * 
		 * 
		 * In case, a single stateless EJB object is maintained, you may see the same list of books after each lookup.

			EJB Container may return the same stateless EJB object for every lookup.

			Stateless EJB bean is keeping value of instance variable till the server is not restarted.
		 * 
		 * 
		 * 
		 */

	}
	
	

}
