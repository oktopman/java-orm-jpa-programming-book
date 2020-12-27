package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.BookRepository;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.ItemRepository;
import jpabook.jpashop.web.request.BookRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void save_book_item() {
        //given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setName("jpa 프로그래밍 책");
        bookRequest.setPrice(31000);
        bookRequest.setStockQuantity(190);
        bookRequest.setAuthor("김영한");
        bookRequest.setIsbn("123-14t2-123");
        //when
        Book book = itemService.saveItem(bookRequest);
        //then
        assertThat(book.getName()).isEqualTo("jpa 프로그래밍 책");
        assertThat(book.getStockQuantity()).isEqualTo(190);
    }

    @Test
    void book_add_stock() {
        Item item = itemRepository.findByName("jpa 프로그래밍 책");
        Book book = itemService.addStock(item.getId(), 10);
        assertThat(book.getStockQuantity()).isEqualTo(200);
    }

    @Test
    void book_remove_stock() {
        Item item = itemRepository.findByName("jpa 프로그래밍 책");
        Book book = itemService.removeStock(item.getId(), 10);
        assertThat(book.getStockQuantity()).isEqualTo(200);
    }

}