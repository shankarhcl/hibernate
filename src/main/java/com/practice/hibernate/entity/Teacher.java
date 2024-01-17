package com.practice.hibernate.entity;



import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.practice.hibernate.model.Certificate;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) //NONE, READWRITE, TRANSACTIONAL, NONSTRICT_READ_WRITE, READ_ONLY
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name ="name")
	private String name;
	private String city;
	private Certificate certificate;
	public Teacher(String name, String city, Certificate certificate) {
		this.name=name;
		this.city=city;
		this.certificate=certificate;
	}

}
