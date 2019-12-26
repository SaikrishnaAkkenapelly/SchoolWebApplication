package app.student.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sakkenapelly
 *
 */
public class Student implements Serializable {

	long id;
	String name;
	Date dob;
	String email;

	/**
	 * 
	 * @param id
	 * @param name
	 * @param dob
	 * @param email
	 */
	public Student(long id, String name, Date dob, String email) {
		this(name, dob, email);
		this.id = id;
	}

	/**
	 * 
	 * @param name
	 * @param dob
	 * @param email
	 */
	public Student(String name, Date dob, String email) {
		this.name = name;
		this.dob = dob;
		this.email = email;
	}

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

}
