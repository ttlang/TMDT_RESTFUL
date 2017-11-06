package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.domain.Chapter;
import com.spring.repository.ChapterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChapterTest.class);

	@Autowired
	ChapterRepository chapterRepository;
	@Test
	public void testGetAllChapter() {
		assertEquals(4, chapterRepository.getAllChapter().size());
	}
	@Test
	public void testGetChapterByChapterId() {
		Chapter chapter = chapterRepository.getChapterByChapterID("CH001");
		LOGGER.info(chapter.toString());
		
	}
}
