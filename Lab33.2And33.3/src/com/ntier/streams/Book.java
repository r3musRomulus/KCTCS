package com.ntier.streams;

public class Book implements Comparable<Book>{
	
	public enum Category {
		FICTION,
		TECHNICAL,
		SELF_HELP,
		HOW_TO,
		EXERCISE,
		COOKING,
		COMIC;
	}
	
	private String title;
	private String author;
	private int numPages;
	private double price;
	private Category category;
	private int yearPublished;
	
	public Book(String title, String author, int numPages, double price, Category category, int yearPublished) {
		super();
		this.title = title;
		this.author = author;
		this.numPages = numPages;
		this.price = price;
		this.category = category;
		this.yearPublished = yearPublished;
	}

	public Book() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getNumPages() {
		return numPages;
	}

	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	@Override
	public String toString() {
		return String.format("Book [title=%s, author=%s, numPages=%s, price=%s, category=%s, yearPublished=%s]", 
				title, author, numPages, price, category, yearPublished);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + numPages;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearPublished;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category != other.category)
			return false;
		if (numPages != other.numPages)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearPublished != other.yearPublished)
			return false;
		return true;
	}

	@Override
	public int compareTo(Book o) {
		return title.compareTo(o.getTitle());
	}

}
