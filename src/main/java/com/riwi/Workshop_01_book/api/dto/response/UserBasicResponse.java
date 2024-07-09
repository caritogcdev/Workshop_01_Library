package com.riwi.Workshop_01_book.api.dto.response;

import com.riwi.Workshop_01_book.util.enums.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private RoleUser role;

}
