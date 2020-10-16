package jpabook.start.domainrelationshipexample.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class AlbumTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ItemRepository itemRepository;

    @Test
    void test() {
        Album album = new Album();
        album.setArtist("artist");
        album.setName("name");
        album.setPrice(100);

        Album save = albumRepository.save(album);

        Optional<Album> byId = albumRepository.findById(save.getId());
        System.out.println(byId.get().getName());
    }

}