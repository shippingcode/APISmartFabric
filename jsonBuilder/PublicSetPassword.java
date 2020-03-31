package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PublicSetPassword {
	private String password;
	private String repeatPassword;
	private String token;
	private String invalidPassword;
}
