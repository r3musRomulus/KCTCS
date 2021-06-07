package com.ntier.streams.starters;

import com.ntier.streams.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.ntier.streams.Book.Category;

public class Library {
	private List<Book> books;

	public Library(String fileName) {
		super();
		books = new ArrayList<>();
		poulateBooksFromFile(fileName); 
	}
	
	private void poulateBooksFromFile(String fileName) {
		try (Stream<String> fileProcessor = Files.lines(Paths.get(fileName))) {
			fileProcessor.forEach(line -> {
				String[] bookFields = line.split(",");
				String title = bookFields[0];
				String author = bookFields[1];
				int numPages = Integer.parseInt(bookFields[2]);
				double price = Double.parseDouble(bookFields[3]);
				Category category = Category.valueOf(bookFields[4]);
				int yearPublished = Integer.parseInt(bookFields[5]);
				Book b = new Book(title, author, numPages, price, category, yearPublished);
				books.add(b);
			});
		} catch (IOException e) {
			System.out.println("File handling error");
		}		
	}

	public List<Book> getBooks() {
		return books;
	}
}
