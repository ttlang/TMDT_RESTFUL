package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Chapter;

/**
 * <p>mapper cho table CHUONG_MUC</p>
 * @author ttlang
 *
 */
@Mapper
public interface ChapterMapper {
	public List<Chapter>getAllChapter();
	public Chapter	getChapterByChapterID(String chapterID);

}
