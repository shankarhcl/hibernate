package com.practice.hibernate.entity;


import java.util.Date;

import com.practice.hibernate.model.Certificate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name ="name")
	private String name;
	private String city;
	@Transient
	private boolean isEnable;
	@Temporal(value = TemporalType.DATE)
	private Date date;
	private Certificate certificate;
	public Student(String name, String city, Boolean isEnable, Date date) {
		this.isEnable=isEnable;
		this.name=name;
		this.city=city;
		this.date=date;
	}

	public Student(String name, String city, Boolean isEnable, Date date,Certificate certificate) {
		this.isEnable=isEnable;
		this.name=name;
		this.city=city;
		this.date=date;
		this.certificate=certificate;
	}

}
