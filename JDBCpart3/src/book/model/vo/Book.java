package book.model.vo;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6211947466970626743L;
	private int bid;		// 도서 아이디
	private String title;	// 도서명
	private String author;	// 작가명
	private String pub;		// 출판사명
	private String pub_date;// 출판일
	private int price;		// 가격
	
	public Book() {
		super();
	}
	public Book(int bid, String title, String author, String pub, String pub_date, int price) {
		super();
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.pub = pub;
		this.pub_date = pub_date;
		this.price = price;
	}
	
	public Book(String title, String author, String pub, String pub_date, int price) {
		super();
		this.title = title;
		this.author = author;
		this.pub = pub;
		this.pub_date = pub_date;
		this.price = price;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", pub=" + pub + ", pub_date="
				+ pub_date + ", price=" + price + "]";
	}

}
