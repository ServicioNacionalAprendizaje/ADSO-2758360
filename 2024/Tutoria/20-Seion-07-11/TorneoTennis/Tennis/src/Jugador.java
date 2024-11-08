import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Jugador extends JFrame {
    private JPanel JPanelTitulo;
    private JLabel lblTitulo;
    private JPanel JPanelJugador;
    private JPanel JPanelDataJugador;
    private JPanel JPnalCerrarJugador;
    private JButton cerrarJugadorButton;
    private JButton regristrarJugadorButton;
    private JButton modificarJugadorButton;
    private JButton eliminarJugadorButton;
    private JButton consultarJugadorButton;
    private JPanel JPanelFormualrioJugador;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDocumento;
    private JTable tableJugador;

    private int selectedIndex = -1; // Índice del jugador encontrado para modificar o eliminar

    public Jugador(ArrayList<String[]> listaJugadores) {
        setTitle("Gestionar Jugadores");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(JPanelJugador);

        configurarTablaJugador();
        cargarDatos(listaJugadores);

        regristrarJugadorButton.addActionListener(e -> agregarJugador(listaJugadores));
        consultarJugadorButton.addActionListener(e -> buscarJugador(listaJugadores));
        modificarJugadorButton.addActionListener(e -> modificarJugador(listaJugadores));
        eliminarJugadorButton.addActionListener(e -> eliminarJugador(listaJugadores));
        cerrarJugadorButton.addActionListener(e -> cerrarFormularioJugador(listaJugadores));

        setVisible(true);
    }

    // Configurar columnas de la tabla
    private void configurarTablaJugador() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Documento");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        tableJugador.setModel(modelo);
    }

    // Cargar datos en la tabla
    private void cargarDatos(ArrayList<String[]> listaJugadores) {
        DefaultTableModel modelo = (DefaultTableModel) tableJugador.getModel();
        for (String[] jugador : listaJugadores) {
            modelo.addRow(jugador);
        }
    }

    // Agregar un nuevo jugador
    private void agregarJugador(ArrayList<String[]> listaJugadores) {
        String documento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();

        if (documento.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tableJugador.getModel();
        modelo.addRow(new Object[]{documento, nombre, apellido});
        listaJugadores.add(new String[]{documento, nombre, apellido});

        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
    }

    // Buscar jugador por documento
    private void buscarJugador(ArrayList<String[]> listaJugadores) {
        String documento = txtDocumento.getText();
        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de documento para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        selectedIndex = -1; // Reiniciar índice
        for (int i = 0; i < listaJugadores.size(); i++) {
            String[] jugador = listaJugadores.get(i);
            if (jugador[0].equals(documento)) {
                txtNombre.setText(jugador[1]);
                txtApellido.setText(jugador[2]);
                selectedIndex = i; // Guardar el índice del jugador encontrado
                JOptionPane.showMessageDialog(this, "Jugador encontrado y cargado en los campos.");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Jugador no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    // Modificar jugador
    private void modificarJugador(ArrayList<String[]> listaJugadores) {
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Primero busque un jugador para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String documento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();

        if (documento.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar datos en el ArrayList
        listaJugadores.set(selectedIndex, new String[]{documento, nombre, apellido});

        // Actualizar datos en la tabla
        DefaultTableModel modelo = (DefaultTableModel) tableJugador.getModel();
        modelo.setValueAt(documento, selectedIndex, 0);
        modelo.setValueAt(nombre, selectedIndex, 1);
        modelo.setValueAt(apellido, selectedIndex, 2);

        JOptionPane.showMessageDialog(this, "Jugador modificado exitosamente.");

        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        selectedIndex = -1; // Reiniciar índice
    }

    // Eliminar jugador
    private void eliminarJugador(ArrayList<String[]> listaJugadores) {
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Primero busque un jugador para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        listaJugadores.remove(selectedIndex); // Eliminar del ArrayList

        DefaultTableModel modelo = (DefaultTableModel) tableJugador.getModel();
        modelo.removeRow(selectedIndex); // Eliminar de la tabla

        JOptionPane.showMessageDialog(this, "Jugador eliminado exitosamente.");

        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        selectedIndex = -1; // Reiniciar índice
    }

    // Cerrar formulario
    private void cerrarFormularioJugador(ArrayList<String[]> listaJugadores) {
        dispose();
    }
}
