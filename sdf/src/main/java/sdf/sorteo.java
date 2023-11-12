package sdf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class sorteo {
    public static void main(String[] args) {
//    	ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();
//    	System.out.println("Hola, bienvenido al sorteo del amigo invisible");
//    	int valor = 0;
//    	do {
//    		menu();
//    		Scanner scanner = new Scanner(System.in);
//    		valor = scanner.nextInt();
//    		elegirOpcion(valor,listaParticipantes);
//    		
//    	}while(valor!=3 || valor!=4);
    	 
    	
    	Participante p1 = new Participante("Pepito", "De Los Palotes", "juanpibu99@gmail.com", null, false);
    	Participante p = new Participante("Juan", "Piñero Burguera", "juanpibu99@gmail.com", p1, false);
    	
    	EmailSender generarCorreo = new EmailSender();
    	generarCorreo.sendEmail(p);
    }
    
    private static void elegirOpcion(int valor,ArrayList<Participante> listaParticipantes) {
    	switch (valor) {
        case 1:
        	addParticipante(listaParticipantes);
            break;
        case 2:
            deleteParticipante(listaParticipantes);
            break;
        case 3:
        	asignarAmigoInvisible(listaParticipantes);
        	for (Participante participante:listaParticipantes) {
				System.out.println(participante.getNombre()+"---"+participante.getParticipanteTocado().getNombre());
			}
            break;
        case 4:
            listarSorteo(listaParticipantes);
            break;
        case 5:
            cancelarSorteo();
            break;
        default:
        	System.out.println("No has introducido un número válido");
            break;
    	}
		
	}


	private static void listarSorteo(ArrayList<Participante> listaParticipantes) {
		for(Participante p:listaParticipantes) {
			System.out.println(p.getNombre()+" "+p.getApellidos());
			System.out.println(p.getCorreo());
			System.out.println();
		}
		
	}

	private static void cancelarSorteo() {
		System.exit(0);
		
	}
	// Método para realizar el sorteo del amigo invisible
    private static void asignarAmigoInvisible(ArrayList<Participante> listaParticipantes) {
     
        // Verificar y asignar amigo invisible a cada participante
        for (Participante part:listaParticipantes) {
            

            // Obtener la posición del amigo invisible en la lista
            int indiceAmigoInvisible = obtenerAmigoInvisible(part, listaParticipantes);

            while (esMismoCorreo(part, listaParticipantes.get(indiceAmigoInvisible))) {
                // Si el correo coincide, obtener una nueva posición para el amigo invisible
            	indiceAmigoInvisible = obtenerAmigoInvisible(part, listaParticipantes);
            }

            Participante amigoInvisible = listaParticipantes.get(indiceAmigoInvisible);
            part.setParticipanteTocado(amigoInvisible);
            amigoInvisible.setEsTocado(true);
        }
    }

    // Método para obtener un índice de amigo invisible que cumple con las restricciones
    private static int obtenerAmigoInvisible(Participante part, ArrayList<Participante> tamañoLista) {
        Random random = new Random();
        int indiceAmigoInvisible = random.nextInt(tamañoLista.size());

        return indiceAmigoInvisible;
    }

    // Método para verificar si dos participantes tienen el mismo correo
    private static boolean esMismoCorreo(Participante participante1, Participante participante2) {
    	if(participante1.getCorreo().equals(participante2.getCorreo())||participante2.getEsTocado())
    		return true;
    	else
    		return false;
    }

	private static void deleteParticipante(ArrayList<Participante> listaParticipantes) {
		System.out.println("Listado de participantes:");
		for(Participante participante:listaParticipantes) {
			System.out.println(participante.getNombre()+" "+participante.getApellidos());
			System.out.println(participante.getCorreo());
			System.out.println();
		}
		System.out.println("Introduce por favor el correo del participante que quieres eliminar, si quieres salir escribe Salir");
		Scanner scanner = new Scanner(System.in);
		String correo = scanner.nextLine();
		if(correo=="Salir".toUpperCase()) {
			System.out.println("Has salido");
		}else {
			boolean encontrado=false;
			Iterator<Participante> iterator = listaParticipantes.iterator();
	        while (iterator.hasNext()) {
	        	Participante persona = iterator.next();
	            if (persona.getCorreo().equals(correo)) {
	            	encontrado=true;
	                iterator.remove(); 
	                System.out.println(persona.getNombre()+" "+persona.getApellidos()+" ha sido eliminada");
	                System.out.println();
	            }
	        }
	        if(encontrado) {
	        	System.out.println("No se ha encontrado ese correo entre los participantes");
	        	System.out.println();
	        }
	        
		}
	}

	private static void addParticipante(ArrayList<Participante> listaParticipantes) {
		System.out.println("Introduce por favor el nombre del participante");
		Scanner scanner = new Scanner(System.in);
		String nombre = scanner.nextLine();
		System.out.println("Introduce por favor el/los apellidos del participante");
		String apellidos = scanner.nextLine();
		System.out.println("Introduce por favor correo electrónico del participante");
		String correo = scanner.nextLine();
		listaParticipantes.add(new Participante(nombre,apellidos,correo,null,false));
		System.out.println("participante añadido correctamente");
		System.out.println();
	}

	public static void menu() {
    	System.out.println("----------------------MENU----------------------");
    	System.out.println("---------Escribe la opción que necesites--------");
    	System.out.println("-------------1- Añadir participante-------------");
    	System.out.println("------------2- Eliminar participante------------");
    	System.out.println("---------------3- Realizar sorteo---------------");
    	System.out.println("------------4- Listar Participantes-------------");
    	System.out.println("--------------------5- Salir--------------------");
    }
}
