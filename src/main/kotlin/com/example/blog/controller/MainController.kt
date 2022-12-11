package com.example.blog.controller

import com.example.blog.entity.AuthorRepository
import com.example.blog.entity.render
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class MainController(private val authorRepository: AuthorRepository) {

	private val logger: Logger = LogManager.getLogger(MainController::class.java)

	@GetMapping("/")
	fun blog(model: Model): String {

		val authors = authorRepository.findAll()
		// logger.info("Get authors: " + authors)

		model["title"] = "Hello blog!"
		model["authors"] = authors.map { it.render() }

		return "blog"
	}
}