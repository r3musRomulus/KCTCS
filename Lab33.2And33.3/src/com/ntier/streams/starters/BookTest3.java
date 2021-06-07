package com.ntier.streams.starters;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.ntier.streams.Book;
import com.ntier.streams.Book.Category;

public class BookTest3 {
	
	Library lib1 = new Library("books1.txt");
	List<Book> library1 = lib1.getBooks();

	Library lib2 = new Library("books2.txt");
	List<Book> libraryAdd = lib2.getBooks();

	public static void main(String[] args) {
		
		BookTest3 bt3 = new BookTest3();
		
		Map<Category, Double> averagePriceByCategory = bt3.library1
				.stream()
				.collect(Collectors.groupingBy(Book::getCategory, Collectors.averagingDouble(Book::getPrice)));
		for(Entry<Book.Category, Double> e : averagePriceByCategory.entrySet()) {
			System.out.printf("The average price for the %s category is $%.2f. %n", e.getKey().toString(), e.getValue());
		}

	}

}
