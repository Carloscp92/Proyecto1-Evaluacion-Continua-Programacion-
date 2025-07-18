import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        GestionClientes gClientes = new GestionClientes();
        GestionVentas gVentas = new GestionVentas();
        GestionInstrumentos gInstrumentos= new GestionInstrumentos();

        int opcion= -1;
        do{
            System.out.println("===MENU PRINCIPAL===");
            System.out.println("0.Salir");
            System.out.println("1.Gestión de Clientes");
            System.out.println("2.Gestión de Instrumentos");
            System.out.println("3.Gestión de Ventas");
            System.out.println("Introduce una opción:");

                try {
                    opcion = sc.nextInt();
                    sc.nextLine();
                    switch (opcion) {
                        case 0 -> System.out.println("Finalizado");

                        case 1 -> {
                            submenuClientes(sc, gClientes);

                        }
                        case 2 -> {
                            submenuInstrumentos(sc, gInstrumentos);

                        }
                        case 3 -> {
                            submenuVentas(sc, gVentas, gClientes, gInstrumentos);

                        }
                        default -> System.out.println("La opción no es válida");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("No es válido: Debes introducir un número.");
                    sc.nextLine();
                }
        }while(opcion!=0);
        sc.close();
    }

//Funciones con los submenus
private static void submenuClientes(Scanner sc, GestionClientes gClientes){

    int opcion=-1;
    do {
        System.out.println("MENU GESTIÓN DE CLIENTES");
        System.out.println("0.Volver al Menú Principal");
        System.out.println("1.Alta de Cliente");
        System.out.println("2.Baja de Cliente");
        System.out.println("3.Buscar Cliente por DNI");
        System.out.println("4.Modificar Datos de Cliente");
        System.out.println("5.Mostrar Listado de Clientes");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 0 -> System.out.println("Volviendo al Menu Principal");

                    case 1 -> {
                        System.out.println("===ALTA CLIENTE===");
                        System.out.print("Introduce un nombre:");
                        String nombre = sc.nextLine();
                        System.out.print("Introduce télefono:");
                        String telefono = sc.nextLine();
                        System.out.print("Introduce email:");
                        String email = sc.nextLine();
                        System.out.print("Introduce dni:");
                        String dni ="";
                        boolean entrada = false;
                        while(!entrada){
                            dni= sc.nextLine();
                            if(gClientes.existeDni(dni)){
                                System.out.println("ya existe un cliente con ese dni");
                                System.out.println("Introduce uno Válido:");
                            }else {
                                entrada = true;
                            }
                        }
                        Cliente nuevoCliente = new Cliente(nombre, dni, telefono, email);
                        gClientes.altaCliente(nuevoCliente);
                    }
                    case 2 -> {
                        System.out.println("===BAJA CLIENTE===");
                        System.out.print("Introduce dni:");
                        String dni = sc.nextLine();
                        boolean bajaExitosa = gClientes.bajaCliente(dni);
                        if (bajaExitosa) {
                            System.out.println("Cliente dado de baja con éxito");
                        } else {
                            System.out.println("Cliente no encontrado");
                        }
                    }
                    case 3 -> {
                        System.out.println("===BUSCAR CLIENTE===");
                        System.out.print("Introduce dni:");
                        String dni = sc.nextLine();
                        Cliente clienteBuscado = gClientes.buscarClienteporDni(dni);
                        if (clienteBuscado == null) {
                            System.out.println("Cliente no encontrado en el registro");
                        } else {
                            System.out.println(clienteBuscado);
                        }
                    }
                    case 4 -> {
                        System.out.println("===MODIFICAR DATOS DEL CLIENTE===");
                        System.out.print("Introduce dni:");
                        String dni = sc.nextLine();
                        Cliente modificarCliente = gClientes.modificarCliente(dni);
                        if (modificarCliente == null) {
                            System.out.println("El cliente no se encuentra registrado");
                        } else {
                            int opcionSubmenu = -1;
                            do {
                                System.out.println("¿Que dato quiere modificar:?");
                                System.out.println("0.Volver");
                                System.out.println("1.Nombre");
                                System.out.println("2.Télefono");
                                System.out.println("3.Email");

                                    try {
                                        opcionSubmenu = sc.nextInt();
                                        sc.nextLine();
                                        switch (opcionSubmenu) {
                                            case 0 -> System.out.println("Volviendo");
                                            case 1 -> {
                                                System.out.println("Introduce nuevo nombre:");
                                                String nuevoNombre = sc.nextLine();
                                                modificarCliente.setNombre(nuevoNombre);
                                                System.out.println("Nombre modificado con éxito");
                                            }
                                            case 2 -> {
                                                System.out.println("Introduce nuevo telefono:");
                                                String nuevoTelefono = sc.nextLine();
                                                modificarCliente.setTelefono(nuevoTelefono);
                                                System.out.println("Telefono modificado con éxito");
                                            }
                                            case 3 -> {
                                                System.out.println("Introduce nuevo email:");
                                                String nuevoEmail = sc.nextLine();
                                                modificarCliente.setEmail(nuevoEmail);
                                                System.out.println("Email modificado con éxito");
                                            }
                                            default -> System.out.println("La opción no es válida");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("No es válido: Debes introducir un número ");
                                        sc.nextLine();
                                    }
                            } while (opcionSubmenu != 0);
                        }
                    }
                    case 5 -> {
                        System.out.println("===LISTADO DE CLIENTES===");
                        gClientes.listarClientes();
                    }
                    default -> System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("No es válido: Debes introducir un número.");
                sc.nextLine();
            }
    }while(opcion!=0);
}
private static void submenuInstrumentos(Scanner sc, GestionInstrumentos gInstrumentos){

        int opcion=-1;
        do {
            System.out.println("MENU GESTIÓN DE INSTRUMENTOS");
            System.out.println("0.Volver al Menu Principal");
            System.out.println("1.Alta de Instrumento");
            System.out.println("2.Baja de Instrumento");
            System.out.println("3.Buscar Instrumento por ID");
            System.out.println("4.Modificar Datos de Instrumento");
            System.out.println("5.Mostrar Listado de Instrumentos");

                try {
                    opcion = sc.nextInt();
                    sc.nextLine();
                    switch (opcion) {
                        case 0 -> System.out.println("Volviendo al Menú Principal");

                        case 1 -> {
                            System.out.println("===ALTA INSTRUMENTO===");
                            System.out.println("Introduce nombre:");
                            String nombre = sc.nextLine();
                            System.out.println("Introduce marca:");
                            String marca = sc.nextLine();
                            System.out.println("Introduce modelo:");
                            String modelo = sc.nextLine();
                            System.out.println("Introduce identificador:");
                            boolean idValido= false;
                            String identificador="";
                            while(!idValido) {
                                identificador = sc.nextLine();
                                if (gInstrumentos.existeIdentificador(identificador)) {
                                    System.out.println("Ya existe un instrumento con ese identificador");
                                    System.out.println("Introduce uno válido:");
                                } else {
                                    idValido = true;
                                }
                            }
                            boolean entradaInterior= false;
                            while(!entradaInterior) {
                            System.out.println("Introduce precio:");
                                try {
                                    double precio = sc.nextDouble();
                                    if (precio < 0) {
                                        System.out.println("El precio no puede ser negativo");
                                    }else {
                                        entradaInterior= true;
                                        Instrumento nuevoInstrumento = new Instrumento(nombre, marca, modelo, identificador, precio);
                                        boolean altaExitosa = gInstrumentos.altaInstrumento(nuevoInstrumento);
                                        if (altaExitosa) {
                                            System.out.println("Intrumento registrado con éxito");
                                        } else {
                                            System.out.println("El instrumento ya esta registrado");
                                        }
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("No es valido: Debes Introducir un precio");
                                }
                                sc.nextLine();
                            }
                        }
                        case 2 -> {
                            System.out.println("===BAJA INSTRUMENTO===");
                            System.out.println("Introduce el identificador:");
                            String identificador = sc.nextLine();
                            boolean bajaExitosa = gInstrumentos.bajaInstrumento(identificador);
                            if (bajaExitosa) {
                                System.out.println("Instrumento eliminado del registro con éxito");
                            } else {
                                System.out.println("El instrumento no se encuentra en el registro");
                            }
                        }
                        case 3 -> {
                            System.out.println("===BUSCAR INSTRUMENTO===");
                            System.out.println("Introduce el identificador:");
                            String identificador = sc.nextLine();
                            Instrumento itBuscado = gInstrumentos.buscarInstrumentoPorId(identificador);
                            if (itBuscado == null) {
                                System.out.println("Instrumento no encontrado en el registro");
                            } else {
                                System.out.println(itBuscado);
                            }
                        }
                        case 4 -> {
                            System.out.println("===MODIFICAR DATOS INSTRUMENTO===");
                            System.out.print("Introduce identificador:");
                            String identificador = sc.nextLine();
                            Instrumento modificarInstrumento = gInstrumentos.modificarInstrumento(identificador);
                            if (modificarInstrumento == null) {
                                System.out.println("El instrumento no se encuentra registrado");
                            } else {
                                System.out.println("¿Que dato quieres modificar:?");
                                int opcionSubmenu=-1;
                                do {
                                    System.out.println("0.Volver");
                                    System.out.println("1.Nombre");
                                    System.out.println("2.Marca");
                                    System.out.println("3.Modelo");
                                    System.out.println("4.precio");
                                        try {
                                            opcionSubmenu = sc.nextInt();
                                            sc.nextLine();
                                            switch (opcionSubmenu) {
                                                case 0 -> System.out.println("Volviendo");
                                                case 1 -> {
                                                    System.out.println("Introduce nuevo nombre:");
                                                    String nuevoNombre = sc.nextLine();
                                                    modificarInstrumento.setNombreInstrumento(nuevoNombre);
                                                    System.out.println("Nombre modificado con éxito");
                                                }
                                                case 2 -> {
                                                    System.out.println("Introduce nueva marca:");
                                                    String nuevaMarca = sc.nextLine();
                                                    modificarInstrumento.setMarca(nuevaMarca);
                                                    System.out.println("Marca modificada con éxito");
                                                }
                                                case 3 -> {
                                                    System.out.println("Introduce nuevo modelo:");
                                                    String nuevoModelo = sc.nextLine();
                                                    modificarInstrumento.setModelo(nuevoModelo);
                                                    System.out.println("Modelo modificado con éxito");
                                                }
                                                case 4 -> {
                                                    boolean entradaInterior=false;
                                                    while(!entradaInterior) {
                                                        try {
                                                            System.out.println("Introduce nuevo precio:");
                                                            double nuevoPrecio = sc.nextDouble();
                                                            if (nuevoPrecio < 0) {
                                                                System.out.println("El precio no puede ser negativo");
                                                            } else {
                                                                entradaInterior= true;
                                                                modificarInstrumento.setPrecio(nuevoPrecio);
                                                                System.out.println("Precio modificado con éxito");
                                                            }
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("No es válido: Debes introducir un precio");
                                                        }
                                                        sc.nextLine();
                                                    }
                                                }
                                                default -> System.out.println("La opcion no es válida");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("No es válido: Debes introducir un número");
                                            sc.nextLine();
                                        }
                                } while (opcionSubmenu != 0);
                            }
                        }
                        case 5 -> {
                            System.out.println("===LISTADO DE INSTRUMENTOS===");
                            gInstrumentos.listarInstrumentos();
                        }
                        default -> System.out.println("Opción no válida");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("No es válido: Debes introducir un número.");
                    sc.nextLine();
                }
        }while(opcion!=0);
    }
private static void submenuVentas(Scanner sc, GestionVentas gVentas, GestionClientes gClientes, GestionInstrumentos gInstrumentos){
    int opcion=-1;
    do {
        System.out.println("MENU GESTIÓN DE VENTAS");
        System.out.println("0.Volver al Menu Principal");
        System.out.println("1.Realizar Venta");
        System.out.println("2.Mostrar Ventas Realizadas");
        System.out.println("3.Mostrar Ventas Por Cliente");
        System.out.println("4.Eliminar venta por Id");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 0 -> System.out.println("Volviendo al Menú Principal");

                    case 1 -> {
                        System.out.println("===REALIZAR VENTA===");
                        System.out.println("Introduce el dni del cliente:");
                        String dniCliente = sc.nextLine();
                        Cliente clienteVenta = gClientes.buscarClienteporDni(dniCliente);
                        if (clienteVenta == null) {
                            System.out.println("Cliente no encontrado en el registro");
                            break;
                        }
                        System.out.println("Introduce la fecha de venta: ");
                        String fechaVenta = sc.nextLine();
                        System.out.println("Introduce un identificador de Venta, (tiene que tener una letra y un número)");
                        boolean entrada = false;
                        String idVenta= "";
                        while(!entrada) {
                         idVenta = sc.nextLine().toLowerCase();
                            if (gVentas.existeIdVenta(idVenta)) {
                                System.out.println("Ya existe una venta con ese identificador");
                                System.out.println("Introduce nuevo Id de venta:");
                            }else {
                                entrada = true;
                            }
                        }
                        Venta nuevaVenta = new Venta(clienteVenta, fechaVenta, idVenta);
                        String continuar;
                        do {
                            System.out.println("Introduce el identificador del instrumento vendido:");
                            String identificadorInstrumento = sc.nextLine();
                            Instrumento instrumentoParaVenta = gInstrumentos.buscarInstrumentoPorId(identificadorInstrumento);
                            if (instrumentoParaVenta == null) {
                                System.out.println("Instrumento no encontrado en el registro");
                                System.out.println("¿Desea añadir otro?  (si/no)");
                                do {
                                    continuar = sc.nextLine();
                                    if (!continuar.trim().equalsIgnoreCase("si") && !continuar.trim().equalsIgnoreCase("no")) {
                                        System.out.println("Respuesta no válida, escriba si o no");
                                    }
                                }while(!continuar.trim().equalsIgnoreCase("si") && !continuar.trim().equalsIgnoreCase("no"));
                                if (continuar.trim().equalsIgnoreCase("no")){
                                    break;
                                }
                            } else {
                                nuevaVenta.anhadirInstrumento(instrumentoParaVenta);
                                System.out.println("Instrumento añadido a la venta");
                                System.out.println("¿Desea añadir otro?  (si/no)");
                                do {
                                    continuar = sc.nextLine();
                                    if (!continuar.trim().equalsIgnoreCase("si") && !continuar.trim().equalsIgnoreCase("no")) {
                                        System.out.println("Respuesta no válida, escriba si o no");
                                    }
                                }while(!continuar.trim().equalsIgnoreCase("si") && !continuar.trim().equalsIgnoreCase("no"));
                                if (continuar.trim().equalsIgnoreCase("no")){
                                    break;
                                }
                            }
                        } while (continuar.trim().equalsIgnoreCase("si"));
                         if(nuevaVenta.tieneInstrumentos()) {
                             gVentas.realizarVenta(nuevaVenta);
                             System.out.println("Venta realizada con éxito. Total: " + nuevaVenta.getTotal());
                         }else {
                             System.out.println("No se añadieron instrumentos. Venta cancelada.");
                         }
                    }
                    case 2 -> {
                        System.out.println("===MOSTRAR VENTAS REALIZADAS===");
                        if (gVentas.noHayventas()) {
                            System.out.println("No hay ventas realizadas en este momento");
                        } else {
                            gVentas.mostrarVentasRealizadas();
                        }
                    }
                    case 3 -> {
                        System.out.println("===MOSTRAR VENTAS POR CLIENTE===");
                        System.out.println("Introduce el dni del cliente:");
                        String dniCliente = sc.nextLine();
                        Cliente clienteBuscado = gClientes.buscarClienteporDni(dniCliente);
                        if (clienteBuscado==null) {
                            System.out.println("Cliente no encontrado en el registro");
                        } else if (gVentas.noHayventas()) {
                            System.out.println("No hay ventas realizadas para este cliente en este momento");
                        } else {
                            gVentas.mostrarVentasPorCliente(dniCliente);
                        }
                    }
                    case 4 ->{
                        System.out.println("===ELIMINAR VENTA===");
                        System.out.println("Introduce el identificador de venta:");
                        String idVenta = sc.nextLine();
                        if(gVentas.eliminarVenta(idVenta)==null){
                            System.out.println("No hay niguna venta con este idenficador");
                        }else {
                            System.out.println("Venta eliminada con éxito");
                        }
                    }
                    default -> System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("No es válido: debes introducir un número.");
                sc.nextLine();
            }
    }while(opcion!=0);
    }
}

