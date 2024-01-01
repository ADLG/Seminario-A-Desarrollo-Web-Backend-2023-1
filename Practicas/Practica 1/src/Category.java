import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 * Clase Category.
 * @author ADLG.
 */
public class Category
{
    int category_id;
    String category;
    List<Category> category_list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /**
     * Metodo constructor Category.
     * @param category_id El id de la categoria.
     * @param category El nombre de la categoria.
     */
    public Category(int category_id,String category)
    {
        this.category_id = category_id;
        this.category = category;
    }

    /**
     * Regresa un objeto de tipo categoria con el id y nombre ingresados. Si se ingresa
     * un id que ya exista en la lista category_list entonces pedira un id valido.
     * @param category_id El id de la categoria.
     * @param category El nombre de la categoria.
     * @return El objeto de tipo categoria.
     */
    public Category crearCategoria(int category_id,String category)
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
        Category categoria = new Category(cat,category);
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
    public void getCategory(int category_id)
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
    public void deleteCategory(int category_id)
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
}