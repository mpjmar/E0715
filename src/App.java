public class App {
    public static void main(String[] args) throws Exception {

        int ocupacion[] = generaOcupacion(10);
        muestraOcupacion(ocupacion);
        int comensales = pideComensales();
        asignaMesa(comensales, ocupacion);
    }

    public static String buscaMesa(int comensales, int ocupacion[]) {
        boolean estaLibre = true;
        String mensaje = "";
        int mesa = 0;
        for (mesa = 0; mesa < ocupacion.length && !estaLibre; mesa++) {
            if (ocupacion[mesa] + comensales <= 4)
                return String.format("Por favor, siéntense en la mesa número %d.", mesa + 1);

        }
        return "Lo siento, en estos momentos no queda sitio.";
    }

    public static void asignaMesa(int comensales, int ocupacion[]) {
        if (comensales < -1)
            System.out.println("El número comensales introducido no es correcto.");
        else if (comensales == -1)
            System.out.println("Gracias, hasta pronto.");
        else if (comensales > 4)
            System.out.printf("Lo siento, no admitimos grupos de %d, haga grupos de 4 personas como máximo e intente de nuevo.", comensales);
        else {
            buscaMesa(comensales, ocupacion);
        }
    }

    public static int pideComensales() {
        int comensales = 0;
        do {
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
        } while (comensales == -1);
        return comensales;
    }

    public static void muestraOcupacion(int array[]) {
        System.out.print("┌─────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┬────");
        System.out.println("┐");

        System.out.print("│Mesa nº  ");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%3s ", i + 1);
        System.out.println("│");

        System.out.print("├─────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┼────");
        System.out.println("┤");

        System.out.print("│Ocupacion");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%3s ", array[i]);
        System.out.println("│");

        System.out.print("└─────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┴────");
        System.out.println("┘");
        System.out.println();

    }

    public static int[] generaOcupacion(int mesas) {
        int ocupacion[] = new int[mesas];
        for (int i = 0; i < ocupacion.length; i++)
            ocupacion[i] = (int)(Math.random() * 5);
        return ocupacion;
    }
}
