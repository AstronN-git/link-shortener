package com.max.urlshortener;

import com.max.urlshortener.hash.Hash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrlShortenerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void hashTest() {
		Assertions.assertEquals("ab", Hash.hashLongToString(26L));
		Assertions.assertEquals(26L, Hash.hashStringToLong("ab"));
		Assertions.assertEquals("asdf", Hash.hashLongToString(Hash.hashStringToLong("asdf")));
	}

}
