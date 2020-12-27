package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.BookRepository;
import jpabook.jpashop.web.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final BookRepository bookRepository;

    public Book saveItem(BookRequest request) {
        Book book = new Book();
        book.setName(request.getName());
        book.setPrice(request.getPrice());
        book.setStockQuantity(request.getStockQuantity());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        return bookRepository.save(book);
    }

    public Book addStock(long id, int quantity) {
        Book book = bookRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        book.addStock(quantity);
        return book;
    }

    public Book removeStock(long id, int quantity) {
        Book book = bookRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        book.removeStock(quantity);
        return book;
    }

}
