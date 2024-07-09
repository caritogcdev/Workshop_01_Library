package com.riwi.Workshop_01_book.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 0, max = 50, message = "The Username field exceeds the number of characters")
    private String username;
    @NotBlank(message = "Password is required")
    @Size(min = 0, max = 100, message = "The Password field exceeds the number of characters")
    private String password;
    @NotBlank(message = "Email is required")
    @Size(min = 0, max = 100, message = "The Password field exceeds the number of characters")
    @Email(message = "Email is invalid")
    private String email;
    @NotBlank(message = "FullName is required")
    @Size(min = 0, max = 100, message = "The FullName field exceeds the number of characters")
    private String fullName;
}
