package com.example.demo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.domain.model.User;

public class UsersDetails implements UserDetails{

	private User user;

	public UsersDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(Integer.toString(user.getAdmin_flag()), Integer.toString(1));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	@Override
	// アカウントが有効期限内であるか
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	// アカウントがロックされていないか
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	//	資格情報が有効期限内であるか
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	// 有効なアカウントであるか
	public boolean isEnabled() {
		return true;
	}

}
