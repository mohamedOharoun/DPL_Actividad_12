/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoets;

/**
 *
 * @author Mohamed O. Haroun Zarkik
 */
public class Usuario{
	//Atributos que definirá nuestra clase
	private String dni;
	private String nombre;
	private String apellidos;
	private int num_cuenta;
	private float saldo;
	
	//Se crean los getters y setters, y constructores

    /**
     * Constructor sin párametros.
     */
	public Usuario(){}
	
    /**
     * Constructor con todos los párametros menos el saldo.
     * @param dni String con el DNI del usuario
     * @param nombre String con el nombre del usuario
     * @param apellidos String con los apellidos del usuario
     * @param num_cuenta int con el número de cuenta del usuario
     */
    public Usuario(String dni, String nombre, String apellidos, int num_cuenta){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.num_cuenta = num_cuenta;
		this.saldo = 0;
	}
	
    /**
     * Setter para el atributo DNI del usuario
     * @param dni String con el DNI del usuario
     */
    public void set_dni(String dni){
		this.dni = dni;
	}
	
    /**
     * Setter para el atributo nombre del usuario
     * @param nombre String con el nombre del usuario
     */
    public void set_nombre(String nombre){
		this.nombre = nombre;
	}
	
    /**
     * Setter para el atributo apellidos del usuario
     * @param apellidos String con los apellidos I del usuario
     */
    public void set_apellidos(String apellidos){
		this.apellidos = apellidos;
	}
	
    /**
     * Setter para el atributo num_cuenta del usuario
     * @param num_cuenta int con el número de cuenta del usuario
     */
    public void set_num_cuenta(int num_cuenta){
		this.num_cuenta = num_cuenta;
	}
	
    /**
     * Getter para el atributo DNI del usuario
     * @return String con el DNI del usuario.
     */
    public String get_dni(){
		return this.dni;
	}
	
    /**
     * Getter para el atributo nombre del usuario
     * @return String con el nombre del usuario.
     */
    public String get_nombre(){
		return this.nombre;
	}
	
    /**
     * Getter para el atributo apellidos del usuario
     * @return String con los apellidos del usuario.
     */
    public String get_apellidos(){
		return this.apellidos;
	}
	
    /**
     * Getter para el atributo num_cuenta del usuario
     * @return integer con el número de cuenta del usuario.
     */
    public int get_num_cuenta(){
		return this.num_cuenta;
	}
	
    /**
     * Getter para el atributo saldo del usuario
     * @return float con el saldo del usuario.
     */
    public float get_saldo(){
		return this.saldo;
	}

    /**
     * Procedimiento que sumará un ingreso al saldo.
     * @param ingreso float que contendrá el dinero a ingresar
     */
	public void ingreso(float ingreso){
		this.saldo += ingreso;
	}

    /**
     * Procedimiento que restará un ingreso al saldo, siempre que se tengan fondos.
     * @param cargo float que contendrá el dinero como cargo.
     * @return boolean que devolverá true en caso de que se haya realizado el cargo, para ello debe haber suficiente dinero en cuenta.
     */
	public boolean cargo(float cargo){
		boolean correcto = true;
		
		if(this.saldo > cargo) this.saldo -= cargo;
		else correcto = false;
		
		return correcto;
	}	

    /**
     * Función que dará toda la información del usuario.
     * @return String con toda la información del usuario en un momento.
     */
	public String getAllUsuario(){
		return "DNI: "+this.dni+
				"\tNombre: "+this.nombre+"\tApellidos: "+this.apellidos+
				"\tNumero de cuenta: "+this.num_cuenta+"\tSaldo: "+this.saldo+"€";
	}
}
