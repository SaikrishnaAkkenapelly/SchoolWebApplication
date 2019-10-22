package com.infor.student.pojo;

import java.io.Serializable;
import java.util.Date;


/**

 *---Begin Copyright Notice---

 * 

 *NOTICE

 * 

 *THIS SOFTWARE IS THE PROPERTY OF AND CONTAINS CONFIDENTIAL INFORMATION OF

 *INFOR AND/OR ITS AFFILIATES OR SUBSIDIARIES AND SHALL NOT BE DISCLOSED

 *WITHOUT PRIOR WRITTEN PERMISSION. LICENSED CUSTOMERS MAY COPY AND ADAPT

 *THIS SOFTWARE FOR THEIR OWN USE IN ACCORDANCE WITH THE TERMS OF THEIR

 *SOFTWARE LICENSE AGREEMENT. ALL OTHER RIGHTS RESERVED.

 * 

 *(c) COPYRIGHT 2019 INFOR. ALL RIGHTS RESERVED. THE WORD AND DESIGN MARKS

 *SET FORTH HEREIN ARE TRADEMARKS AND/OR REGISTERED TRADEMARKS OF INFOR

 *AND/OR ITS AFFILIATES AND SUBSIDIARIES. ALL RIGHTS RESERVED. ALL OTHER

 *TRADEMARKS LISTED HEREIN ARE THE PROPERTY OF THEIR RESPECTIVE OWNERS.

 * 

 *---End Copyright Notice---

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
		this(name,dob,email);
		this.id = id;
	}
	
	/**
	 * 
	 * @param name
	 * @param dob
	 * @param email
	 */
	public Student(String name, Date dob, String email)
	{
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
