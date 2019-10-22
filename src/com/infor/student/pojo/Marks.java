/**
 * 
 */
package com.infor.student.pojo;

/**
 * @author sakkenapelly
 *
 */
public class Marks {
	long id;
	String subname;
	long subjectmarks;

	public Marks(long id, String subname, long subjectmarks) {
		super();
		this.id = id;
		this.subname = subname;
		this.subjectmarks = subjectmarks;
	}

	public Marks(String subname, long subjectmarks) {
		// TODO Auto-generated constructor stub
		this.subname = subname;
		this.subjectmarks = subjectmarks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public long getSubjectMarks() {
		return subjectmarks;
	}

	public void setMarks(long subjectmarks) {
		this.subjectmarks = subjectmarks;
	}

}
