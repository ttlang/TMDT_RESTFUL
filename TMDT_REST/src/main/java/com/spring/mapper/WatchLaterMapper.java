package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.WatchLater;

@Mapper
public interface WatchLaterMapper {
	List<WatchLater> getAllWatchLater();
}
