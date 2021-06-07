package com.ntier.streams.starters;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.ntier.streams.Book;
import com.ntier.streams.Book.Category;

public class BookTest {

	Library lib1 = new Library("books1.txt");
	List<Book> library1 = lib1.getBooks();

	Library lib2 = new Library("books2.txt");
	List<Book> libraryAdd = lib2.getBooks();

	void titlesInSingleCategory() {
		library1
			.stream()
			.filter(b -> b.getCategory().equals(Category.FICTION))
			.map(b -> b.getTitle())
			.forEach(System.out::println);
	}

	void titlesInTwoCategories() {
		library1
			.stream()
			.filter(b -> b.getCategory().equals(Category.FICTION) || b.getCategory().equals(Category.TECHNICAL))
			.map(b -> b.getTitle())
			.forEach(System.out::println);
	}

	void priceOver20() {
		library1
			.stream()
			.filter(b -> b.getPrice() > 20)
			.map(b -> b.getTitle())
			.forEach(System.out::println);
	}

	void publishedBefore1999() {
		library1
			.stream()
			.filter(b -> b.getYearPublished() < 1999)
			.map(b -> b.getTitle())
			.forEach(System.out::println);
	}

	OptionalDouble average() {
		OptionalDouble averagePrice = library1
				.stream()
				.mapToDouble(p -> p.getPrice())
				.average();
		averagePrice.ifPresent(p -> System.out.printf("%.2f", p));
		return averagePrice;
	}

	OptionalDouble averagePriceInFiction() {
		OptionalDouble averagePrice = library1
				.stream()
				.filter(b -> b.getCategory().equals(Category.FICTION))
				.mapToDouble(p -> p.getPrice())
				.average();
		averagePrice.ifPresent(p -> System.out.printf("%.2f", p));
		return averagePrice;
	}
	
	Optional<List<Book>> booksInAnyCategoryAveragePrice(List<Book> list, Category c) {
		List<Book> listOfBooks = list
				.stream()
				.filter(b -> b.getCategory().equals(c))
				.collect(Collectors.toList());
		if(listOfBooks.size() == 0) {
			System.out.println("There are no books in this category.");
			return Optional.empty();
		}
		else {
			OptionalDouble averagePrice = null;
			averagePrice = library1
					.stream()
					.filter(b -> b.getCategory().equals(c))
					.mapToDouble(p -> p.getPrice())
					.average();
			averagePrice.ifPresent(p -> System.out.printf("%.2f", p));
			return Optional.ofNullable(listOfBooks);
		}
	}
	
	OptionalDouble averagePages() {
		OptionalDouble averagePages = library1
				.stream()
				.mapToInt(p -> p.getNumPages())
				.average();
		averagePages.ifPresent(p -> System.out.printf("%.0f", p));
		return averagePages;
	}
	
	Optional<List<Book>> listOfBooksInCategory(List<Book> list, Category c) {
		List<Book> listOfBooks = list
				.stream()
				.filter(b -> b.getCategory().equals(c))
				.collect(Collectors.toList());
		if(listOfBooks.size() == 0) {
			System.out.println("The specified list is empty. ");
			return Optional.empty();
		} else {
			return Optional.ofNullable(listOfBooks);
		}
	}
	
	OptionalDouble averagePriceOfAnyCategory(List<Book> list, Category c) {
		return library1
			.stream()
			.mapToDouble(b -> b.getPrice())
			.average();
	}

	public static void main(String[] args) {

		BookTest bt = new BookTest();

		System.out.println("1.");
		bt.titlesInSingleCategory();
		System.out.println();
		
		System.out.println("2.");
		bt.titlesInTwoCategories();
		System.out.println();
		
		System.out.println("3.");
		bt.priceOver20();
		System.out.println();
		
		System.out.println("4.");
		bt.publishedBefore1999();
		System.out.println();
		
		System.out.println("5.");
		bt.average();
		System.out.println();
		System.out.println();
		
		System.out.println("6.");
		bt.averagePriceInFiction();
		System.out.println();
		System.out.println();
		
		System.out.println("7.");
		bt.booksInAnyCategoryAveragePrice(bt.library1, Category.COMIC);
		System.out.println();
		
		System.out.println("8.");
		bt.averagePages();
		System.out.println();
		System.out.println();
		
		System.out.println("9.");
		System.out.println(bt.averagePriceOfAnyCategory(bt.library1, Category.TECHNICAL));
		System.out.println();
		
		System.out.println("10.");
		System.out.println(bt.listOfBooksInCategory(bt.library1, Category.TECHNICAL));

	}

}
