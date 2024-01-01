package com.product.api.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Clase Category.
 * @author ADLG.
 */
@Entity
@Table(name = "categoria")
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
    private Integer category_id;
	
	@NotNull
	@Column(name = "category")
    private String category;
    
	
	@Column(name = "status")
	@Min(value = 0, message="status must be 0 or 1")
	@Max(value = 1, message="status must be 0 or 1")
	@JsonIgnore
    private Integer status;
    List<Category> category_list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /**
     * Metodo constructor Category.
     * @param category_id El id de la categoria.
     * @param category El nombre de la categoria.
     */
    public Category(Integer category_id,String category,Integer status)
    {
        this.category_id = category_id;
        this.category = category;
        this.status = status;
    }
    
    /**
     * Metodo constructor vacio Category.
     */
    public Category()
    {

    }

    /**
     * Regresa un objeto de tipo categoria con el id y nombre ingresados. Si se ingresa
     * un id que ya exista en la lista category_list entonces pedira un id valido.
     * @param category_id El id de la categoria.
     * @param category El nombre de la categoria.
     * @return El objeto de tipo categoria.
     */
    public Category crearCategoria(Integer category_id,String category,Integer status)
    {
        int cat=category_id; boolean b = true;
        for (Category c:category_list)
        {
            if (c.category_id==category_id)
            {
                while (b)
                {
                    if (c.category_id==cat)
                    {
                        System.out.println("Ya esta registrado el ID:"+category_id+"\n*Ingrese un id valido");
                        cat = sc.nextInt();
                    }
                    else
                    {
                        b = false;
                        System.out.println("Se creara una Categoria");
                    }
 
                }
            }
        }
        Category categoria = new Category(cat,category,status);
        return categoria;
    }

    /**
     * Agrega una categoria a la lista category_list.
     * @param cat el objeto Categoria.
     */
    public void createCategory(Category cat)
    {
        category_list.add(cat);
    }

    /**
     * Muestra la lista con todas las categorias registradas, si es que hay elementos en la lista category_list,
     * de lo contrario imprimira que No existen categorias registradas.
     */
    public void getCategories()
    {
        if (category_list.size()==0)
        {
            System.out.println("No existen categorias registradas.");
        }
        else
        {
            System.out.println("Lista de categorias:");
            for (Category c:category_list)
            {
                mostrar_Categoria(c);
            }
        }
    }

    /**
     * Recibe un id de una categoria y muestra sus datos. Si no existe la categoria se imprime
     * No esta registrada la categoria con el ID: nombre_categoria. Si la lista esta vacia se imprime
     * No existen categorias registradas
     * @param category_id el id de la Categoria.
     */
    public void getCategory(Integer category_id)
    {
        int cat = -1;
        for (Category c:category_list)
        {
            if (c.category_id==category_id)
            {
                cat = c.category_id;
                System.out.println("Los datos de la categoria son los siguientes:");
                mostrar_Categoria(c);
            }
        }
        if (cat == -1)
            System.out.println("No esta registrada la categoria con el ID:"+category_id);
        else if (category_list.size()==0)
            System.out.println("No existen categorias registradas."); 
    }

    /**
     * Recibe un id de una categoria y elimina su registro de la lista. Si no existe
     * la categoria se imprime No existe una categoria con el id ingresado. Si la lista
     * de categorias esta vacia entonces imprime No existen categorias registradas.
     * @param category_id el id de la Categoria.
     */
    public void deleteCategory(Integer category_id)
    {
        int cat = -1;
        int num_lista=0, elemendel=0;
        for (Category c:category_list)
        {
            if (c.category_id==category_id)
            {
                cat = category_id;
                elemendel = num_lista;
            }
            num_lista++;
        }
            if (cat == -1)
                System.out.println("No existe una categoria con el id ingresado");
            else if (category_list.size()==0)            
                System.out.println("No existen categorias registradas.");
            else
                {category_list.remove(elemendel); System.out.println("La categoria ha sido eliminada.");}
    }

    /**
     * Imprime los datos de una categoria.
     * @param cat el objeto Categoria.
     */
    public void mostrar_Categoria(Category cat)
    {
        System.out.println("ID:"+cat.category_id+"  "+"Categoria:"+cat.category);
    }

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category=" + category + ", status=" + status + "]";
	}
    
	
    
}