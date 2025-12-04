public class App {

    public static final int CAPACIDAD = 4;
    public static void main(String[] args) throws Exception {

        int ocupacion[] = generaOcupacion(10);
        int comensales;
        do {
            muestraOcupacion(ocupacion);
            comensales = pideComensales();
            System.out.println(asignaMesa(comensales, ocupacion));
        } while (comensales != -1);
    }
    
    public static String asignaMesa(int comensales, int ocupacion[]) {
        String mensaje;
        if (comensales < -1)
            mensaje = "El número comensales introducido no es correcto.";
        else if (comensales == -1)
            mensaje = "Gracias, hasta pronto.";
        else if (comensales > CAPACIDAD)
            mensaje = String.format("Lo siento, no admitimos grupos de %d, haga grupos de 4 personas como máximo e intente de nuevo.", comensales);
        else 
            mensaje = buscaMesa(comensales, ocupacion);
        return mensaje;
    }

    public static String buscaMesa(int comensales, int ocupacion[]) {
        int mesa = 0;
        // int mesaPosible = -1;
        // int mesaVacia = -1;
        while(mesa < ocupacion.length) {
            if (ocupacion[mesa] != 0) 
                mesa++;
            else {
                ocupacion[mesa] += comensales;
                return String.format("Por favor, siéntense en la mesa número %d.", mesa + 1);
            }
        }
        mesa = 0;
        while (mesa < ocupacion.length) {
            if (ocupacion[mesa] + comensales <= CAPACIDAD) {
                ocupacion[mesa] += comensales;
                return String.format("Tendrán de compatir mesa. Por favor, siéntense en la mesa número %d", mesa + 1);
            }
            else 
                mesa++;
        }
        return "Lo siento, en estos momentos no queda sitio.";
    }

    public static int pideComensales() {
        int comensales = 0;
        System.out.print("¿Cuantos son? (Introduzca -1 para salir del programa): ");
        try {
            comensales = Integer.parseInt(System.console().readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Debe introducir un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        return comensales;
    }

    public static void muestraOcupacion(int array[]) {
        repeatBorde("┌─────────", "┬────", "┐", array.length);
        repeatContenido("│Mesa nº  ", "│%3d ", "│", array);
        repeatBorde("├─────────", "┼────", "┤", array.length);
        repeatContenido("│Ocupacion", "│%3d ", "│",array);
        repeatBorde("└─────────", "┴────", "┘", array.length);
    }

    public static void repeatBorde(String izq, String centro, String dcha, int len) {
        System.out.print(izq);
        for (int i = 0; i < len; i++)
            System.out.print(centro);
        System.out.println(dcha);
    }

    public static void repeatContenido(String izq, String centro, String dcha, int array[]) {
        System.out.print(izq);
        for (int i = 0; i < array.length; i++)
            System.out.printf(centro, array[i]);
        System.out.println(dcha);
    }

    public static int[] generaOcupacion(int mesas) {
        int ocupacion[] = new int[mesas];
        for (int i = 0; i < ocupacion.length; i++)
            ocupacion[i] = (int)(Math.random() * 5);
        return ocupacion;
    }
}
