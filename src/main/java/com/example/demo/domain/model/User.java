package com.example.demo.domain.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private Timestamp created_at;

	@Getter
	@Setter
	private Timestamp updated_at;

	@Getter
	@Setter
	private Timestamp deleted_at;

	@Getter
	@Setter
	private byte deleteflag;

	@Getter
	@Setter
	private byte admin_flag;


}
