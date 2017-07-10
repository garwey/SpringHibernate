package booksys.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import booksys.domain.Book;
import booksys.service.BookService;

public class BookAction extends ActionSupport {
	private BookService bookService;

	// ����ע��BookService��������setter������
	// �÷����ķ�����Ҫ��BookService������id��Ӧ
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	private Book book;
	private List<Book> books;
	private int id;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// �������ͼ���add()����
	public String add() {
		// ����ҵ���߼������addBook()�����������û�����
		int result = bookService.addBook(book);
		if (result > 0) {
			addActionMessage("��ϲ����ͼ����ӳɹ���");
			return SUCCESS;
		}
		addActionError("ͼ�����ʧ�ܣ����������룡");
		return ERROR;
	}

	public String list() {
		setBooks(bookService.getAllBooks());
		return SUCCESS;
	}

	public String delete() {
		bookService.deleteBook(id);
		return SUCCESS;
	}
}
