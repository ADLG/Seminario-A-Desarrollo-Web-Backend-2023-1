import java.util.Scanner;
/**
 * Main para probar el funcionamiento correcto de la practica 1.
 * @author ADLG.
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Category catOBJ = new Category(1,"A");
        int category_id;
        String category;
        while (true){
        System.out.println("\n\t\t\t\t Practica 1\n\t\t\t\t*Categorias*\n1.Crear categoria\n2.Lista de categorias\n3.Buscar categoria\n4.Borrar categoria\n5.Salir");
        int i = sc.nextInt();
        switch (i)
        {
            case 1:
                System.out.println("Digite el id de la categoria");
                category_id = sc.nextInt();
                System.out.println("Digite el nombre de la categoria");
                category = sc.next();
                catOBJ.createCategory(catOBJ.crearCategoria(category_id,category));
            break;

            case 2:
                catOBJ.getCategories();
            break;

            case 3:
                System.out.println("Digite el id de la categoria a buscar");
                category_id = sc.nextInt();
                catOBJ.getCategory(category_id);
            break;

            case 4:
                System.out.println("Digite el id de la categoria a borrar");
                category_id = sc.nextInt();
                catOBJ.deleteCategory(category_id);
            break;

            case 5: System.exit(0);
            break;

            default:System.out.println("Digite un numero valido del menu");
            break;
            }
        }
    }
}