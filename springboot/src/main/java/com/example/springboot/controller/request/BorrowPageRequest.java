package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class BorrowPageRequest extends BaseRequest{
	
    private String isbn;
    private String name; // book_name
    private String uid;
}
