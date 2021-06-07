package com.ntier.streams.starters;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import com.ntier.streams.Book;
import com.ntier.streams.Book.Category;

public class BookTest2 {
	
	Library lib1 = new Library("books1.txt");
	List<Book> library1 = lib1.getBooks();

	Library lib2 = new Library("books2.txt");
	List<Book> libraryAdd = lib2.getBooks();
	
	int numberOfPagesInLongestBook() {
		OptionalInt maxPages = library1
			.stream()
			.mapToInt(p -> p.getNumPages())
			.max();
		return maxPages.getAsInt();
	}
	
	double costOfLeastExpensiveBook() {
		OptionalDouble maxPages = library1
			.stream()
			.mapToDouble(p -> p.getPrice())
			.min();
		return maxPages.getAsDouble();
	}
	
	double costOfAllBooks() {
		double maxPages = library1
			.stream()
			.mapToDouble(p -> p.getPrice())
			.sum();
		return maxPages;
	}
	
	boolean stringInTitleOrAuthorBoolean(List<Book> list, String search) {
		boolean found = list
				.stream()
				.anyMatch(b -> b.getTitle().contains(search) || b.getAuthor().contains(search));
		return found;
	}
	
	Optional<Book> stringInTitleOrAuthorPrint(List<Book> list, String search) {
		Optional<Book> listOfBooks = list
				.stream()
				.filter(b -> b.getTitle().contains(search) || b.getAuthor().contains(search))
				.findAny();
		return listOfBooks;
	}
	
	Optional<List<Book>> sortCategoryInNaturalOrder(List<Book> list, Category c) {
		List<Book> listOfBooks = list
				.stream()
				.filter(b -> b.getCategory().equals(c))
				.sorted()
				.collect(Collectors.toList());
		return Optional.ofNullable(listOfBooks);
	}
	
	Optional<List<Book>> sortPrice(List<Book> list, double price) {
		List<Book> listOfBooks = list
				.stream()
				.filter(b -> b.getPrice() <= price)
				.sorted((b1, b2) -> (int)(b2.getPrice() - b1.getPrice()))
				.collect(Collectors.toList());
		return Optional.ofNullable(listOfBooks);
	}
	
	Optional<List<Double>> uniqueBookPriceDescendingOrder(List<Book> list) {
		List<Double> listOfPrices = list
				.stream()
				.sorted((b1, b2) -> (int)(b2.getPrice() - b1.getPrice()))
				.map(b -> b.getPrice())
				.distinct()
				.collect(Collectors.toList());
		return Optional.ofNullable(listOfPrices);
	}

	public static void main(String[] args) {
		
		BookTest2 bt2 = new BookTest2();
		
		System.out.println("1a");
		System.out.println(bt2.numberOfPagesInLongestBook());
		System.out.println();
		
		System.out.println("1b");
		System.out.println(bt2.costOfLeastExpensiveBook());
		System.out.println();
		
		System.out.println("1c");
		System.out.println(bt2.costOfAllBooks());
		System.out.println();
		
		System.out.println("2");
		System.out.println(bt2.stringInTitleOrAuthorBoolean(bt2.library1, "of"));
		System.out.println();
		
		System.out.println("3");
		System.out.println(bt2.stringInTitleOrAuthorPrint(bt2.library1, "of"));
		System.out.println();
		
		System.out.println("5");
		System.out.println(bt2.sortCategoryInNaturalOrder(bt2.library1, Category.FICTION));
		System.out.println();
		
		System.out.println("6");
		System.out.println(bt2.sortPrice(bt2.library1, 10.00));
		System.out.println();
		
		System.out.println("7");
		System.out.println(bt2.uniqueBookPriceDescendingOrder(bt2.library1));
		System.out.println();

	}

}
