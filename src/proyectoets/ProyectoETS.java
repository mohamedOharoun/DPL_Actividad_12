package proyectoets;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 *
 * @author Mohamed O. Haroun Zarkik
 */
public class ProyectoETS{
	static Scanner scan = new Scanner(System.in);

	static HashMap<Integer,Usuario> usuarios = new HashMap<Integer,Usuario>();//HashMap que contendrá a los usuarios.
	static HashSet<String> DNIs = new HashSet<String>(); //HashSet que contendrá los DNI, facilitirá las operaciones de comprobación
	static HashSet<Integer> NumCuentas = new HashSet<Integer>(); //HashSet que contendrá los números de cuenta, facilitirá las operaciones de comprobación
        
        /**
        * Función que comproborá que el número de cuenta está registrado.
        * @param num_c integer que guardará el número de cuenta a comproborá 
        * @return boolean que confirmará si existe el número de cuenta.
        */
	static boolean existeCuenta(int num_c){
		if(!(usuarios.containsKey(num_c))){
			System.out.println("Numero de cuenta no registrado");
			return false;
		}
		return true;
	}
        
        /**
        * Función que pedirá la cantidad a realizar en una transacción.
        * @param transaccion String que contendrá el nombre del tipo de transacción.
        * @return float que contendrá la cantidad de dinero en la transacción.
        */
	static float transaccion(String transaccion){
		float dinero = 0;
		boolean control;
		
		//Controlará que se introducen números aptos y no negativos
		do{
			control = true;
			try{
				System.out.print("Introduzca el dinero en su "+transaccion+": ");
				dinero = scan.nextFloat();
			}catch(InputMismatchException e){
				System.out.println("Solo introduzca números, por favor");
				scan.next();
				control = false;
			}
		}while(dinero <= 0 || control == false);

		return dinero;
	}
	
	/**
        *Procedimiento que mostrará la información sobre un usuario a elegir.
        */
	static void estado(){
		int num_c = setNumCuenta();
		if(existeCuenta(num_c)){
			System.out.println("Estado de cuenta: ");
			System.out.println("\t"+usuarios.get(num_c).getAllUsuario());
		}
	}

	/**
        *Procedimiento que realizará un cargo sobre un usuario a elegir.
        */
	static void cargo(){
		int num_c = setNumCuenta();
		if(existeCuenta(num_c)){
			float dinero = transaccion("cargo");

			boolean control = usuarios.get(num_c).cargo(dinero);

			if(!control) System.out.println("Saldo insuficiente");
		}
	}

	/**
        *Procedimiento que realizará un ingreso sobre un usuario a elegir.
        */
	static void ingreso(){
		int num_c = setNumCuenta();
		if(existeCuenta(num_c)){
			float dinero = transaccion("ingreso");
			usuarios.get(num_c).ingreso(dinero);
		}
	}

	/**
        *Función que pedirá y recogerá los apellidos del usurio
        * @return String que contendrá los apellidos del usuario.
        */
	static String setApell(){
		System.out.print("Introduzca los apellidos: ");
		String apel = scan.nextLine();
		return apel;
	}

	/**
        * Función que pedirá y recogerá el nombre del usurio
        * @return String que contendrá el nombre del usuario.
        */
	static String setNom(){
		System.out.print("Introduzca el nombre: ");
		String nom = scan.nextLine();
		return nom;
	}
	
	/**
        * Función que comproborá que el número de cuenta es único.
        * @return boolean que confirmará si el número de cuenta es único.
        */
	static boolean checkNumCuenta(int num_c){
		if(NumCuentas.contains(num_c)){
			System.out.println("Número de cuenta ya registrado");
			return false;
		}

		return true;
	}

	/**
        * Función que pedirá al usuario introducir un DNI al usuario y lo recogerá.
        * @return int que contendrá que el número de cuenta introducido por el usuario.
        */
	static int setNumCuenta(){
		boolean control;
		int num_c = 0;
		//Try-catch para evitar que el programa se detenga por introducir un tipo incorrecto
		do{
			control = true;
			try{
				System.out.print("Introduzca el número de cuenta: ");
				num_c = scan.nextInt();
			}catch(Exception e){
				System.out.println("Solo acepta números");
				scan.next();
				control = false;
			}
		}while(control == false);
		scan.nextLine();
		return num_c;
	}

	/**
        * Función que comproborá que el DNI es válido y que es único.
        * @param dni String que contendrá el DNI a comprobrar.
        * @return boolean que confirmará si el DNI es apto.
        */
	static boolean checkDNI(String dni){
                DNIchecker DNIchecker = new DNIchecker();
		if(DNIchecker.validarDNI(dni) == false){
                    System.out.println("DNI no válido");
                    return false;
                }else {
                    if(DNIs.contains(dni)){
                        System.out.println("DNI ya registrado");
                        return false;
                    }
                }
		return true;
	}

	/**
        * Función que pedirá al usuario introducir un DNI al usuario y lo recogerá.
        * @return String que contendrá el DNI introducido por el usuario
        */
	static String setDNI(){
		System.out.print("Introduzca el DNI: ");
		String dni = scan.nextLine();
		return dni;
	}

	/**
        * Procedimiento que realizará los pasos para crear un usuario
        */
	static void nuevoUsuario(){
		String s;
		do{
			boolean controlDNI;
			boolean controlNumCuenta;

			int num_c;
			String nom;
			String apell;
		
			String dni = setDNI();
			//Se controlará que el DNI sea único
			controlDNI = checkDNI(dni);
			
			if(controlDNI){
				num_c = setNumCuenta();
				//Se controlará que el número de cuenta sea único
				controlNumCuenta = checkNumCuenta(num_c);
				if(controlNumCuenta){
					//Se añadirán el DNI y el número de cuenta en los set para tenerlos registrados
					DNIs.add(dni);
					NumCuentas.add(num_c);
		
					nom = setNom();
					apell = setApell();
					
					//Se añadirá la cuenta, el número de cuenta será la key en el HashMap para la rápida obtención del usuario tras introducirlo
					usuarios.putIfAbsent(num_c, new Usuario(dni,nom,apell,num_c));
				}
			}
			
			//Se permitirá introducir varios usuarios
			System.out.print("Si desea agregar a un nuevo usuario, escriba si: ");
			s = scan.nextLine();
		}while(s.equalsIgnoreCase("si"));
	}

	/**
        * Procedimiento que redirigirá a la parte del programada que realice la función elegida por el usuario
        * @param choice byte que guarda la opción escogida
        */
	static void hub(byte choice){
		switch(choice){
			case 1:
				nuevoUsuario();
				break;
			//En los casos 2, 3 y 4 se controlará que la lista no esté vacía antes de ejecutarse
			case 2:
				if(!usuarios.isEmpty()) ingreso();
				else System.out.println("No hay usuarios registrados");
				break;
			case 3:
				if(!usuarios.isEmpty()) cargo();
				else System.out.println("No hay usuarios registrados");
				break;
			case 4:
				if(!usuarios.isEmpty()) estado();
				else System.out.println("No hay usuarios registrados");
				break;
			case 5:
				System.out.println("Fin del programa");
				break;
		}
	}
	
	/**
        *Procedimiento que mostrará al usuario las opciones a elegir y recogerá lo que responda
        * 
        */
	static void menu(){
		byte choice = 0;
		boolean control;
		//Bucle que mantendrá ejecutándose hasta que el usuario introduzca números
		do{
			System.out.println("Elija la opción 1 si quiere crear una nueva cuenta");
			System.out.println("Elija la opción 2 si quiere ingresar dinero en una cuenta");
			System.out.println("Elija la opción 3 si quiere realizar un cargo en una cuenta");
			System.out.println("Elija la opción 4 si quiere ver el estado de una cuenta");
			System.out.println("Elija la opción 5 si quiere finalizar el programa");
			//Bucle que se ejecutará en caso de no introducir una opción contemplada o por introducir un tipo de dato no apto
			do{
				control = true;
				try{
					System.out.print("Su opcion a elegir: ");
					choice = scan.nextByte();
				}catch(Exception e){
					System.out.println("Solo acepta numeros");
					scan.next();
					control = false;
				}
			}while((choice < 1 || choice > 5) && control == false);
			scan.nextLine();
			hub(choice);
		}while(choice != 5);
	}

    /**
     *
     * @param args
     */
    public static void main(String args[]){
		menu();
	}
}
