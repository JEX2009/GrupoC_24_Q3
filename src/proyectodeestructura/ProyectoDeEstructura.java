package proyectodeestructura;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema");
        System.out.print("Agrega tu tipo de usuario (bibliotecario, socio): ");
        String tipoUsuario = scanner.nextLine().toLowerCase();
        System.out.print("Agrega tu nombre de usuario. \nSi no tienes, ingresa '0': ");
        String usuario = scanner.nextLine();
        registrado = false;

        if (usuario.equals("0")) {
            if (tipoUsuario.equals("socio")) {
                agregarSocio(scanner);
                registradoSocio = true;
            } else if (tipoUsuario.equals("bibliotecario")) {
                registrarNuevoBiblio(scanner);
                registrado = true;
            }
        } else {
            registrado = iniciarSesion(scanner, usuario, tipoUsuario);
        }

        if (registrado) {
            terminado = false;
            while (!terminado) {
                System.out.println("Agrega la accion\n1.Prestamo\n2.Libros\n3.Salir");
                String eleccion = scanner.nextLine();
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
                System.out.println("Agrega la accion\n1.Ver historial\n2.Ver lista de espera\n3.Salir");
                String eleccion = scanner.nextLine();
                switch (eleccion) {
                    case "1":
                        verHistorial();
                        break;
                    case "2":
                        verListaEspera();
                        break;
                    case "3":
                        terminado = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 3.");
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
        Bibliotecario.bibliotecarios.add(new Bibliotecario(nuevoUsuario, nuevaContrasenia));
    }

    private static boolean iniciarSesion(Scanner scanner, String usuario, String tipoUsuario) {
        while (true) {
            if (tipoUsuario.equals("bibliotecario")) {
                System.out.println("Agrega tu contraseña: ");
                contrasenia = scanner.nextLine();
                seEncontroBibl = Bibliotecario.Encontrar(contrasenia);
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
                seEncontroUse = Socio.Encontrar(contrasenia);
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
        Socio seEncontroSoci = Socio.Encontrar(numSocio);
        if (seEncontroSoci == null) {
            System.out.println("No se encontró socio con este número.");
            return;
        }
        System.out.println("El socio " + seEncontroSoci.getNombre() + " se encontró");

        System.out.println("Qué libro quiere prestar, agrega el título: ");
        String titulo = scanner.nextLine();
        Libro libro = Libro.Encontrar(titulo);
        if (libro == null) {
            System.out.println("No se encontró libro o ya no quedan disponibles.");
            return;
        }
        System.out.println("El libro " + libro.getTitulo() + " se encontró");

        System.out.println("Qué fecha se realizó el préstamo (ej: 1 de julio del 2024): ");
        String fechaPrestado = scanner.nextLine();

        System.out.println("Qué fecha se devuelve el préstamo (ej: 1 de julio del 2024): ");
        String fechaDevolu = scanner.nextLine();

        Prestamo prestamo = new Prestamo(libro, seEncontroBibl, seEncontroSoci, fechaPrestado, fechaDevolu);
        libro.setDisponible(false);
        System.out.println(prestamo);
    }

    private static void agregarSocio(Scanner scanner) {
        System.out.println("Cual es el nombre del nuevo socio: ");
        String nombre = scanner.nextLine();
        System.out.println("Cual es la dirección del nuevo socio: ");
        String direccion = scanner.nextLine();
        System.out.println("Cual es el número del nuevo socio: ");
        int numero = scanner.nextInt();
        System.out.println("Cual es la edad del nuevo socio: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Socio nuevo = new Socio(nombre, direccion, numero, edad);
        Socio.socios.add(nuevo);
        System.out.println(nuevo);
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

    private static void verHistorial() {
        // Implementación de visualización del historial de búsqueda
        System.out.println("Visualizando historial...");
    }

    private static void verListaEspera() {
        // Implementación de visualización de la lista de espera
        System.out.println("Visualizando lista de espera...");
    }
}
