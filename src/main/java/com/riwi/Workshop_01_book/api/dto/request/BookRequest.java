package com.riwi.Workshop_01_book.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 0, max = 100, message = "The Title field exceeds the number of characters")
    private String title;
    @NotBlank(message = "Author is required")
    @Size(min = 0, max = 100, message = "The Author field exceeds the number of characters")
    private String author;
    @NotNull(message = "Publication Year is required")
    private Integer publicationYear;
    @NotBlank(message = "Genre is required")
    @Size(min = 0, max = 50, message = "The Genre field exceeds the number of characters")
    private String genre;
    @NotBlank(message = "isbn is required")
    @Size(min = 0, max = 20, message = "The isbn field exceeds the number of characters")
    private String isbn;
}
