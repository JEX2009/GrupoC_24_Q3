package proyectodeestructura;

import java.util.Scanner;

public class ProyectoDeEstructura {
    static String NuevaContrasenia;
    static String NuevoUsuario;
    static String Contrasenia;
    static Boolean Registrado;
    static Boolean RegistradoSocio;
    static Boolean Terminado;
    static Bibliotecario SeEncontroBibl;
    static Socio SeEncontroUse;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema");
        System.out.print("Agrega tu tipo de usuario (bibliotecario, socio): ");
        String TipoUseer = scanner.nextLine();
        TipoUseer = TipoUseer.toLowerCase();
        System.out.print("Agrega tu nombre de usuario. \nSi no tienes, ingresa '0': ");
        String Usuario = scanner.nextLine();
        Registrado = false;

        if (Usuario.equals("0")) {
            if (TipoUseer == "socio") {
                agregarSocio(scanner);
                RegistradoSocio = true;
            }else if (TipoUseer == "bibliotecario") { //Aca hay un problema de seguridad por el tema de que cualquiera puede ser bibliotecario pero en un caso perfecto, el socio no usa esto 
                registrarNuevoBiblio(scanner);
                Registrado = true;
            }
            
        } else {
            Registrado = iniciarSesion(scanner, Usuario, TipoUseer);
        }

        if (Registrado) {
            Terminado = false;
            while (!Terminado) {
                System.out.println("Agrega la accion\n1.Prestamo\n2.Libros\n3.Salir");
                String Eleccion = scanner.nextLine();
                switch (Eleccion) {
                    case "1":
                        realizarPrestamo(scanner);
                        break;
                    case "2":
                        agregarLibro(scanner);
                        break;
                    case "3":
                        Terminado = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 4.");
                }
            }
        }else if (RegistradoSocio) {
            Terminado = false;
            while (!Terminado) {
                System.out.println("Agrega la accion\n1.Ver historial\n2.Ver lista de espera\n3.Salir");
                String Eleccion = scanner.nextLine();
                switch (Eleccion) {
                    case "1":
                        ultimosPrestamos(scanner);
                        break;
                    case "2":
                        listaEspera(scanner);
                        break;
                    case "3":
                        Terminado = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 4.");
                }
            }
        }
    }

    // En el proximo avance daremos la parte de como lo ve un usuario socio
    private static void registrarNuevoBiblio(Scanner scanner) {
        System.out.println("Agrega tu nuevo nombre de usuario: ");
        NuevoUsuario = scanner.nextLine();
        Boolean Continuar = true;
        while (Continuar) {
            System.out.println("Agrega tu nueva contrasenia: ");
            NuevaContrasenia = scanner.nextLine();
            System.out.println("Ingresa de nuevo la contrasenia: ");
            String ConfirmaContrasenia = scanner.nextLine();
            if (NuevaContrasenia.equals(ConfirmaContrasenia)) {
                Continuar = false;
            } else {
                System.out.println("Las contraseñas no coinciden. Inténtalo de nuevo.");
            }
        }
        Bibliotecario.bibliotecarios.add(new Bibliotecario(NuevoUsuario, NuevaContrasenia));
    }

    private static Boolean iniciarSesion(Scanner scanner, String Usuario, String TipoUseer) {
        while (true) {
            if (TipoUseer == "bibliotecario") {
                System.out.println("Agrega tu contrasenia: ");
                Contrasenia = scanner.nextLine();
                SeEncontroBibl = Bibliotecario.Encontrar(Contrasenia);
                if (SeEncontroBibl != null) {
                    System.out.println("El bibliotecario " + SeEncontroBibl.getNombre() + " se encontró");
                    return true;
                } else {
                    System.out.println(
                            "No se encontró bibliotecario con esta contraseña. ¿Deseas intentarlo de nuevo? (s/n)");
                    if (!scanner.nextLine().equalsIgnoreCase("s")) {
                        return false;
                    }
                }
            }else if (TipoUseer == "socio") {
                System.out.println("Agrega tu contrasenia: ");
                Contrasenia = scanner.nextLine();
                SeEncontroUse = Socio.Encontrar(Contrasenia);
                if (SeEncontroUse != null) {
                    System.out.println("El usuario " + SeEncontroUse.getNombre() + " se encontró");
                    return true;
                } else {
                    System.out.println(
                            "No se encontró usuario con esta contraseña. ¿Deseas intentarlo de nuevo? (s/n)");
                    if (!scanner.nextLine().equalsIgnoreCase("s")) {
                        return false;
                    }
                }
            }else{
                System.out.println("No es un tipo valido");
            }
        }
    }

    private static void realizarPrestamo(Scanner scanner) {
        System.out.println("Que socio pide el tramite, escribe su número de socio: ");
        int NumSocio = scanner.nextInt();
        Socio SeEncontroSoci = Socio.Encontrar(NumSocio);
        if (SeEncontroSoci == null) {
            System.out.println("No se encontró socio con este número.");
            return;
        }
        System.out.println("El socio " + SeEncontroSoci.getNombre() + " se encontró");

        System.out.println("Qué libro quiere prestar, agrega el título: ");
        String Titulo = scanner.nextLine();
        Libro libro = Libro.Encontrar(Titulo);
        if (libro == null) {
            System.out.println("No se encontró libro o ya no quedan disponibles.");
            return;
        }
        System.out.println("El libro " + libro.getTitulo() + " se encontró");

        System.out.println("Qué fecha se realizó el préstamo (ej: 1 de julio del 2024): ");
        String FechaPrestado = scanner.nextLine();

        System.out.println("Qué fecha se devuelve el préstamo (ej: 1 de julio del 2024): ");
        String FechaDevolu = scanner.nextLine();

        Prestamo prestamo = new Prestamo(libro, SeEncontroBibl, SeEncontroSoci, FechaPrestado, FechaDevolu);
        libro.setDisponible(false);
        System.out.println(prestamo);
    }

    private static void agregarSocio(Scanner scanner) {

        System.out.println("Cual es el nombre del nuevo socio: ");
        String nombre = scanner.nextLine();
        System.out.println("Cual es la direccion del nuevo socio: ");
        String direccion = scanner.nextLine();
        System.out.println("Cual es el numero del nuevo socio: ");
        int numero = scanner.nextInt();
        System.out.println("Cual es la edad del nuevo socio: ");
        int edad = scanner.nextInt();

        Socio nuevo = new Socio(nombre, direccion, numero, edad);
        System.out.println(nuevo);

    }

    private static void agregarLibro(Scanner scanner) {

        System.out.println("Cual es el nombre del libro: ");
        String titulo = scanner.nextLine();
        System.out.println("Cual es el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.println("Cual es el ISB (idnetificador) del libro: ");
        String isb = scanner.nextLine();
        System.out.println("Cual es el anio de publicacion eje(2 de septiembre del 1990): ");
        String anioPublicacion = scanner.nextLine();

        Libro libro = new Libro(titulo, autor, isb, anioPublicacion);
        System.out.println(libro);

    }
}
