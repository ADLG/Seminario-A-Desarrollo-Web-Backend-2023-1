package com.product.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;

@RestController
@RequestMapping("/category")
public class CtrlCategory {

	@GetMapping("/categoryejemplo")
	public List<Category> lista()
	{
		List<Category> lista = new ArrayList<>();
		lista.add(new Category(1,"Basico",1));
		lista.add(new Category(2,"Superior",1));
		lista.add(new Category(3,"Medio Superior",1));
		lista.add(new Category(4,"Maestria",1));
		lista.add(new Category(5,"Doctorado",1));
		return lista;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategories()
	{
		Category categoria1 = new Category();
		categoria1.setCategory_id(1);
		categoria1.setCategory("Abarrotes");
		categoria1.setStatus(1);
		Category categoria2 = new Category();
		categoria2.setCategory_id(2);
		categoria2.setCategory("Electronica");
		categoria2.setStatus(1);
		
		List categorias = new ArrayList();
		categorias.add(categoria1);
		categorias.add(categoria2);
		
		return new ResponseEntity<>(categorias, HttpStatus.OK);
	}
	
	@GetMapping("/{category_id}")
	public ResponseEntity<Category> getCategory(@PathVariable int category_id)
	{
		Category categoria1 = new Category();
		categoria1.setCategory_id(1);
		categoria1.setCategory("Abarrotes");
		categoria1.setStatus(1);
		
		return new ResponseEntity<>(categoria1, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createCategory(@Valid @RequestBody Category category, BindingResult bindingResult){
		String message = "";
		if(bindingResult.hasErrors()) {
			message = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		message = "category created";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@PutMapping("/{category_id}")
	public ResponseEntity<String> updateCategory(@PathVariable int category_id, @Valid @RequestBody Category category, BindingResult bindingResult){
		String message = "";
		if(bindingResult.hasErrors()) {
			message = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		message = "category updated";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/{category_id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int category_id){
		String message = "";

		message = "category removed";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
