package com.practice.hibernate.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Geek {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="g_id")
	private int geekId;
	private String gname;
	@ManyToMany
	@JoinTable(                              //@JoinTable is optional
			name="third_table_geek_project", // Change the name of third table that will be created in db  geek_project-->> third_table_geek_project
			joinColumns = {@JoinColumn(name="gid")},   //optional: In third table it will replace column geeks_gid-->>gid
			inverseJoinColumns = {@JoinColumn(name="pid")} //optional: In third table it will replace column projects_pid-->>pid
			) 
	private List<Project>  projects;
}