package proyectodeestructura;

import java.util.Scanner;

import proyectodeestructura.models.Bibliotecario;
import proyectodeestructura.models.Libro;
import proyectodeestructura.models.Prestamo;
import proyectodeestructura.models.Socio;

public class ProyectoDeEstructura {
    static String nuevaContrasenia;
    static String nuevoUsuario;
    static String contrasenia;
    static boolean registrado;
    static boolean registradoSocio;
    static boolean terminado;
    static Bibliotecario seEncontroBibl;
    static Socio seEncontroUse;

    public static void main(String[] args) {
        // Datos quemados para probar aunque en un proyecto estos saldrian de la base de
        // datos
        // El que cambie la lista porfavor agregue estos datos
        Bibliotecario.bibliotecarios.add(new Bibliotecario("Admin", "123"));
        Socio socioDefault = new Socio("Socio", "123", 8902020, 19);
        Socio.socios.add(socioDefault);
        socioDefault.getHistorialBusqueda().add("3 noches");
        Libro.libros.add(new Libro("3 noches", "Paulo", "12ehdqw", "9/11/1990"));
        Libro.libros.add(new Libro("3 noches", "Paulo", "12ehdqw", "9/11/1990"));
        //
        Scanner scanner = new Scanner(System.in);
        String eleccion = "";
        while (!eleccion.equals("4")) {
            System.out.println("Bienvenido al sistema");

            System.out.print("Agrega tu tipo de usuario (bibliotecario, socio): ");
            String tipoUsuario = scanner.nextLine().toLowerCase();

            System.out.print("Agrega tu nombre de usuario. \nSi no tienes, ingresa '0': ");
            String usuario = scanner.nextLine();
            registrado = false;

            // Si el usuario pone 0 se le redirecciona al crear una cuenta
            if (usuario.equals("0")) {
                if (tipoUsuario.equals("socio")) {
                    agregarSocio(scanner);
                    registradoSocio = true;
                } else if (tipoUsuario.equals("bibliotecario")) {
                    registrarNuevoBiblio(scanner);
                    registrado = true;
                } else {
                    // Se puede hacer un metodo que vuelva a preguntar para ahorrar volver a correr
                    // el programa
                    System.out.println("No se ingreso correctamente");
                }
            } else {
                // Dependiendo del usuario se usa una variable o otra, se puede quitar la
                // variable tipode usuario de iniciar sesion
                // pero no cambia mucho
                if (tipoUsuario.equals("bibliotecario")) {
                    registrado = iniciarSesion(scanner, usuario, tipoUsuario);
                } else {
                    registradoSocio = iniciarSesion(scanner, usuario, tipoUsuario);
                }
            }

            // Se tienen 2 variables para iniciar de una manera o otra para simplificar la
            // corraboracion
            if (registrado) {
                terminado = false;
                while (!terminado) {
                    System.out.println("Agrega la accion\n1.Prestamo\n2.Libros\n3.Salir");
                    eleccion = scanner.nextLine();
                    switch (eleccion) {
                        case "1":
                            realizarPrestamo(scanner);
                            break;
                        case "2":
                            agregarLibro(scanner);
                            break;
                        case "3":
                            terminado = true;
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 3.");
                    }
                }
            } else if (registradoSocio) {
                terminado = false;
                while (!terminado) {
                    System.out.println("Agrega la accion\n1.Buscar libro\n2.Salir");
                    eleccion = scanner.nextLine();
                    switch (eleccion) {
                        case "1":
                            Busqueda(scanner);
                            break;
                        case "2":
                            terminado = true;
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 3.");
                    }
                }
            }
        }
        scanner.close();
    }

    private static void registrarNuevoBiblio(Scanner scanner) {
        System.out.println("Agrega tu nuevo nombre de usuario: ");
        nuevoUsuario = scanner.nextLine();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Agrega tu nueva contraseña: ");
            nuevaContrasenia = scanner.nextLine();
            System.out.println("Ingresa de nuevo la contraseña: ");
            String confirmaContrasenia = scanner.nextLine();
            if (nuevaContrasenia.equals(confirmaContrasenia)) {
                continuar = false;
            } else {
                System.out.println("Las contraseñas no coinciden. Inténtalo de nuevo.");
            }
        }
        seEncontroBibl = new Bibliotecario(nuevoUsuario, nuevaContrasenia);
        Bibliotecario.bibliotecarios.add(seEncontroBibl);
    }

    private static boolean iniciarSesion(Scanner scanner, String usuario, String tipoUsuario) {
        while (true) {
            if (tipoUsuario.equals("bibliotecario")) {
                System.out.println("Agrega tu contraseña: ");
                contrasenia = scanner.nextLine();
                seEncontroBibl = Bibliotecario.bibliotecarios.EncontrarB(contrasenia);
                if (seEncontroBibl != null) {
                    System.out.println("El bibliotecario " + seEncontroBibl.getNombre() + " se encontró");
                    return true;
                } else {
                    System.out.println(
                            "No se encontró bibliotecario con esta contraseña. ¿Deseas intentarlo de nuevo? (s/n)");
                    if (!scanner.nextLine().equalsIgnoreCase("s")) {
                        return false;
                    }
                }
            } else if (tipoUsuario.equals("socio")) {
                System.out.println("Agrega tu contraseña: ");
                contrasenia = scanner.nextLine();
                seEncontroUse = Socio.socios.Encontrar(contrasenia);
                if (seEncontroUse != null) {
                    System.out.println("El usuario " + seEncontroUse.getNombre() + " se encontró");
                    return true;
                } else {
                    System.out
                            .println("No se encontró usuario con esta contraseña. ¿Deseas intentarlo de nuevo? (s/n)");
                    if (!scanner.nextLine().equalsIgnoreCase("s")) {
                        return false;
                    }
                }
            } else {
                System.out.println("No es un tipo valido");
            }
        }
    }

    private static void realizarPrestamo(Scanner scanner) {
        System.out.println("Que socio pide el trámite, escribe su número de socio: ");
        int numSocio = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Socio seEncontroSoci = Socio.socios.Encontrar(numSocio);
        if (seEncontroSoci == null) {
            System.out.println("No se encontró socio con este número.");
            return;
        }
        System.out.println("El socio " + seEncontroSoci.getNombre() + " se encontró");

        System.out.println("Qué libro quiere prestar, agrega el título: ");
        String titulo = scanner.nextLine();
        Libro libro = Libro.libros.EncontrarL(titulo);
        if (libro == null) {
            System.out.println("No se encontró libro o ya no quedan disponibles.");
            return;
        }
        System.out.println("El libro " + libro.getTitulo() + " se encontró");
        System.out.println("Qué fecha se realizó el préstamo (ej: 1 de julio del 2024): ");
        String fechaPrestado = scanner.nextLine();

        System.out.println("Qué fecha se devuelve el préstamo (ej: 1 de julio del 2024): ");
        String fechaDevolu = scanner.nextLine();
        if (libro.getDisponible()) {
            Prestamo prestamo = new Prestamo(libro, seEncontroBibl, seEncontroSoci, fechaPrestado, fechaDevolu);
            libro.setDisponible(false);
            Prestamo.PrestamosActivos.add(prestamo);
            System.out.println(prestamo);
        } else {
            System.out.println("Se agrega el socio a la cola de este libro");
            Prestamo prestamo = new Prestamo(libro, seEncontroBibl, seEncontroSoci, fechaPrestado, fechaDevolu);
            Libro.listaEspera.encolar(prestamo);
        }
    }

    private static void agregarSocio(Scanner scanner) {
        System.out.println("Cual es el nombre del nuevo socio: ");
        String nombre = scanner.nextLine();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Agrega tu nueva contraseña: ");
            nuevaContrasenia = scanner.nextLine();
            System.out.println("Ingresa de nuevo la contraseña: ");
            String confirmaContrasenia = scanner.nextLine();
            if (nuevaContrasenia.equals(confirmaContrasenia)) {
                continuar = false;
            } else {
                System.out.println("Las contraseñas no coinciden. Inténtalo de nuevo.");
            }
        }
        System.out.println("Cual es el número del nuevo socio: ");
        int numero = scanner.nextInt();
        System.out.println("Cual es la edad del nuevo socio: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        seEncontroUse = new Socio(nombre, nuevaContrasenia, numero, edad);
        Socio.socios.add(seEncontroUse);
        System.out.println(seEncontroUse);
    }

    private static void agregarLibro(Scanner scanner) {
        System.out.println("Cual es el nombre del libro: ");
        String titulo = scanner.nextLine();
        System.out.println("Cual es el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.println("Cual es el ISB (identificador) del libro: ");
        String isb = scanner.nextLine();
        System.out.println("Cual es el año de publicación (ej: 2 de septiembre del 1990): ");
        String anioPublicacion = scanner.nextLine();

        Libro libro = new Libro(titulo, autor, isb, anioPublicacion);
        Libro.libros.add(libro);
        System.out.println(libro);
    }

    // se aniade las colas y las pilas pero se le dara un mayor uso mas adelante
    private static void Busqueda(Scanner scanner) {
        System.out.println("Que libro quieres buscar: ");
        String Busqueda = scanner.nextLine();
        seEncontroUse.getHistorialBusqueda().add(Busqueda);
        Libro libro = Libro.libros.EncontrarL(Busqueda);
        if (libro != null) {
            System.out.println(libro);
            System.out.println("Lista de espera: ");
            Libro.listaEspera.mostrar(); // Aca hay un pequenio error dado que las fechas probablemente no se actualicen
                                         // pero en un caso perfecto el bibliotecario pone la fecha de prestamo de los
                                         // de la lista de espera
        } else {
            System.out.println("No se encontro el libro");
        }
    }

}
