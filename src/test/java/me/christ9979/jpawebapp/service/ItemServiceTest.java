package me.christ9979.jpawebapp.service;

import me.christ9979.jpawebapp.entity.Album;
import me.christ9979.jpawebapp.entity.Book;
import me.christ9979.jpawebapp.entity.Movie;
import me.christ9979.jpawebapp.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void saveItemTest() {

        // given
        Album album = new Album();
        album.setName("앨범");
        album.setPrice(1000);
        album.setStockQuantity(5);
        album.setArtist("먼데이키즈");

        Book book = new Book();
        book.setName("책");
        book.setPrice(10000);
        book.setAuthor("정윤철");
        book.setIsbn("1234");
        book.setStockQuantity(7);

        Movie movie = new Movie();
        movie.setName("반지의제왕");
        movie.setActor("정윤철");
        movie.setDirector("윤철정");
        movie.setPrice(100000);
        movie.setStockQuantity(3);

        // when
        Long saveId1 = itemService.saveItem(album);
        Long saveId2 = itemService.saveItem(book);
        Long saveId3 = itemService.saveItem(movie);

        // then
        assertEquals(album, itemRepository.findOne(saveId1));
        assertEquals(book, itemRepository.findOne(saveId2));
        assertEquals(movie, itemRepository.findOne(saveId3));

    }
}