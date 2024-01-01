package com.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CtrlProduct {

	@GetMapping("/category")
	public List<Category> lista()
	{
		List<Category> lista = new ArrayList<>();
		lista.add(new Category(1,"Basico"));
		lista.add(new Category(2,"Superior"));
		lista.add(new Category(3,"Medio Superior"));
		lista.add(new Category(4,"Maestria"));
		lista.add(new Category(5,"Doctorado"));
		return lista;
	}
}
