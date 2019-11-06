package com.ha.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ha.statefuldemo.LibraryStatefulRemote;

public class TestStatefulDemo {

	public static void main(String[] args) {

		Properties props = new Properties();
		InitialContext ctx;
		
		try {
			props.load(new FileInputStream("jndi.properties"));
			ctx = new InitialContext(props);
			LibraryStatefulRemote libraryBean = 
			         (LibraryStatefulRemote) ctx.lookup("LibraryStateful/remote");
			libraryBean.addBook("Testing EJB Stateful 1");
			System.out.println("Book Added ");
			
			List<String> books = libraryBean.getBooks();
			for(String s : books)
			{
				System.out.println(s);
			}

			LibraryStatefulRemote libraryBean2 = 
			         (LibraryStatefulRemote) ctx.lookup("LibraryStateful/remote");
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

		
	}

}
