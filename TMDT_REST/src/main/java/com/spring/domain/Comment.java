package com.spring.domain;

import java.time.OffsetDateTime;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * <p>
 * Domain class for table BINH_LUAN
 * </p>
 * 
 * @author ttlang
 *
 */

@ApiObject(name = "Comment", description = "Bình luận người dùng")
public class Comment {

	@ApiObjectField(name = "commentID", description = "Mã bình luận của người dùng", required = true)
	private String commentID;
	@ApiObjectField(name = "courseID", description = " Mã bài học", required = true)
	private String courseID;
	@ApiObjectField(name = "userCommment", description = "Thông tin người bình luận", required = true)
	private User userCommment;
	@ApiObjectField(name = "commentContent", description = "Nội dung bình luận", required = true)
	private String commentContent;
	@ApiObjectField(name = "commentDate", description = "Thời gian bình luận", required = true)
	private OffsetDateTime commentDate;
	@ApiObjectField(name = "commentStatut", description = "Trạng thái của bình luận", required = true)
	private Integer commentStatut;

	public Comment(String commentID, String courseID, User userCommment, String commentContent,
			OffsetDateTime commentDate, Integer commentStatut) {
		super();
		this.commentID = commentID;
		this.courseID = courseID;
		this.userCommment = userCommment;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentStatut = commentStatut;
	}

	public Comment() {
	}

	public String getCommentID() {
		return commentID;
	}

	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public User getUserCommment() {
		return userCommment;
	}

	public void setUserCommment(User userCommment) {
		this.userCommment = userCommment;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public OffsetDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(OffsetDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getCommentStatut() {
		return commentStatut;
	}

	public void setCommentStatut(Integer commentStatut) {
		this.commentStatut = commentStatut;
	}

	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", courseID=" + courseID + ", userCommment=" + userCommment
				+ ", commentContent=" + commentContent + ", commentDate=" + commentDate + ", commentStatut="
				+ commentStatut + "]";
	}

}
