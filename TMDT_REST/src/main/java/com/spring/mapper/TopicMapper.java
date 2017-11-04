package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Topic;
@Mapper
public interface TopicMapper {
	public List<Topic>getAllTopic();
	public Topic getTopicBytopicID(String topicID);

}
