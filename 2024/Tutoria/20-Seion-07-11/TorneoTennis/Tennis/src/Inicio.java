import javax.swing.*;
import java.util.ArrayList;

public class Inicio extends JFrame{
    private JLabel lblTitulo;
    private JPanel JPanelTitulo;
    private JPanel JPanelPrincipal;
    private JPanel JPanelMenu;
    private JButton gestionarJugadoresButton;
    private JButton gestionarTorneosButton;
    private JButton gestionarPartidosButton;
    private JPanel JPanelCerrarPrograma;
    private JButton cerrarProgramaButton;

    // ArrayList para almacenar datos de jugadores
    private ArrayList<String[]> listaJugadores;

    // ArrayList para almacenar datos de jugadores
    private ArrayList<String[]> listaTorneos;

    // ArrayList para almacenar datos de jugadores
    private ArrayList<String[]> listaPartidos;


    public Inicio(){

        /***********************
         * Configurar el JFrame
         ***********************/
        setTitle("Inicio");
        setSize(600, 200);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize().width, 600);
        //setSize(600, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        /***********************
         * Visualizar formulario
         ***********************/
        add(JPanelPrincipal);


        /***********************
         * Listas para trasladar datos entre los formualarios
         ***********************/
        // Inicializar la lista de jugadores
        listaJugadores = new ArrayList<>();

        // Inicializar la lista de jugadores
        listaTorneos = new ArrayList<>();

        // Inicializar la lista de jugadores
        listaPartidos = new ArrayList<>();


        /**********************************
         * Generar acciones en los botones
         **********************************/

        // Añadir acción al botón para abrir el formulario Jugador
        gestionarJugadoresButton.addActionListener(e -> abrirFormularioJugador());

        // Añadir acción al botón para abrir el formulario Tornetos
        gestionarTorneosButton.addActionListener(e -> abrirFormularioTorneo());

        // Añadir acción al botón para abrir el formulario Partidos
        gestionarPartidosButton.addActionListener(e -> abrirFormularioPartido());

        // Añadir acción al botón para cerrar programa
        cerrarProgramaButton.addActionListener(e -> cerrarPrograma());


    }

    /***********************
     * Inicio de la aplicación
     ***********************/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Inicio());
    }

    // Método para abrir el formulario Jugador
    private void abrirFormularioJugador() {
        new Jugador(listaJugadores);
    }

    // Método para abrir el formulario Torneos
    private void abrirFormularioTorneo(){
        //new Torneo(listaTorneos);
    }

    // Método para abrir el formulario Partidos
    private void abrirFormularioPartido(){
        //new Patido(listaPartidos);
    }

    // Método para cerrar Programa
    private void cerrarPrograma(){
        System.exit(0);
    }

}
