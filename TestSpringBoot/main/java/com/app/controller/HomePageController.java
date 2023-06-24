package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	public HomePageController() {
		System.out.println(" -----< Inside HomePageConstructor >----- ");
	}
	@GetMapping("/")
	public LocalDateTime timestampgeneration() {
		System.out.println(" -----< Inside Timestampgeneration Method >----- ");
		return LocalDateTime.now();
	}
}
