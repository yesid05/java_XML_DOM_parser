package mundo;

public class Estudiante {

    // ==========================
    // Atributos
    // ==========================

    // Constante que representa el atributo roll del estudiante
    public static String ROLL_NO = "rollno";

    // Constante que representa el atributo nombre del estudiante
    public static String NOMBRE = "nombre";

    // Constante que representa el atributo apellido del estudiante
    public static String APELLIDO = "apellido";

    // Constante que representa el atributo codigo del estudiante
    public static String CODIGO = "codigo";

    // Roll de un estudiante
    private String rollNo;

    // Nombre de un estudiante
    private String nombre;

    // Apellido de un estudiante
    private String apellido;

    // Codigo de un estudiante
    private String codigo;

    // ==========================
    // Metodos
    // ==========================
    /**
     * Contruye un estudiante sin caracteristicas
     */
    public Estudiante() {
	// TODO Auto-generated constructor stub
    }

    /**
     * Contruye un estudiante con sus caracteristicas
     * 
     * @param rollNo
     *            Roll de un estudiante, tipo <b>String</b> rollNo != null
     * @param nombre
     *            Nombre de un estudiante, tipo <b>String</b> nombre != null
     * @param apellido
     *            Apellido de un estudiante, tipo <b>String</b> apellido != null
     * @param codigo
     *            Codigo de un estudiante, tipo <b>String</b> codigo != null
     */
    public Estudiante(String rollNo, String nombre, String apellido, String codigo) {
	super();
	this.rollNo = rollNo;
	this.nombre = nombre;
	this.apellido = apellido;
	this.codigo = codigo;
    }

    /**
     * Retorna el roll del estudiante
     * 
     * @return rollNo tipo <b>String</b>
     */
    public String getRollNo() {
	return rollNo;
    }

    /**
     * Modifica o agrega un roll del estudiante
     * 
     * @param rollNo
     *            tipo <b>String</b>, rollNo != null
     */
    public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
    }

    /**
     * Retorna el nombre del estudiante
     * 
     * @return nombre tipo <b>String</b>
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * Modifica o agrega un nombre al estudiante
     * 
     * @param nombre
     *            tipo <b>String</b>, nombre != null
     */
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    /**
     * Retorna el apellido del estudiante
     * 
     * @return apellido tipo <b>String</b>
     */
    public String getApellido() {
	return apellido;
    }

    /**
     * Modifica o agrega un apellido al estudiante
     * 
     * @param apellido
     *            tipo <b>String</b>, apellido != null
     */
    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    /**
     * Retorna el codigo del estudiante
     * 
     * @return codigo tipo <b>String</b>
     */
    public String getCodigo() {
	return codigo;
    }

    /**
     * Modifica o agrega el codigo del estudiante
     * 
     * @param codigo
     *            tipo <b>String</b>, codigo != null
     */
    public void setCodigo(String codigo) {
	this.codigo = codigo;
    }

}
