import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JPanel JpanelPrincipal;
    private JLabel JLabelPNombre;
    private JTextField JtextFieldPNombre;
    private JLabel JLabelSNombre;
    private JTextField JtextFieldSNombre;
    private JLabel JLabelPApellido;
    private JTextField JtextFieldPApellido;
    private JLabel JLabelSApellido;
    private JTextField JtextFieldSApellido;
    private JLabel JLabelGenero;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femeninoRadioButton;
    private JRadioButton noBinarioRadioButton;
    private JRadioButton lgbtiqRadioButton;
    private JLabel JLabelTipoI;
    private JComboBox JcomboBoxTipo;
    private JLabel JLabelNumeroI;
    private JTextField JtextFieldNumeroI;
    private JLabel JLabelDias;
    private JCheckBox lunesCheckBox;
    private JCheckBox martesCheckBox;
    private JCheckBox miercolesCheckBox;
    private JCheckBox juevesCheckBox;
    private JCheckBox viernesCheckBox;
    private JLabel JLabelVHora;
    private JTextField JtextFieldVHora;
    private JLabel JLabelTotHoras;
    private JTextField JtextFieldTHoras;
    private JLabel JLabelObserv;
    private JTextArea JtextAreaObserv;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JScrollPane JscrollTabla;
    private JTable tabla;
    private JTextField individualNetBeansCommittersMayTextField;
    private JTextArea individualNetBeansCommittersMayTextArea;

    public Principal(){
        //configuración del JFrame
        setTitle("Datos Personales");
        //tamaño de la ventana ancho y alto
        setSize(1000, 600);
        //agregar las opciones de minimizar, maximizar y cerrar a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //agregar contenido al panel principal
        setContentPane(JpanelPrincipal);

        //Crear la configuración para la tabla
        String [] nomColumnas={"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
                                "Género", "Tipo ID", "Número ID","Días", "Valor Hora","Total Hora",
                                "Observaciones"};
        //Crear el modelo de la tabla - con encabezados
        DefaultTableModel model = new DefaultTableModel(nomColumnas, 0);
        //asignar a la tabla el modelo completo
        tabla.setModel(model);
        //Asignar el scrollpane con la vista de datos
        JscrollTabla.setViewportView(tabla);

        //Activar el ACTION LISTENER - BOTONES
        guardarButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String primerNombre = JtextFieldPNombre.getText();
                        String segundoNombre = JtextFieldSNombre.getText();
                        String primerApellido = JtextFieldPApellido.getText();
                        String segundoApellido = JtextFieldSApellido.getText();

                        String genero = "";

                        if(masculinoRadioButton.isSelected()){
                            genero= "Masculino";
                        }else if(femeninoRadioButton.isSelected()){
                            genero = "Femenino";
                        }else if(noBinarioRadioButton.isSelected()){
                            genero = "No Binario";
                        } else if (lgbtiqRadioButton.isSelected()) {
                            genero = "LGBTIQ+";
                        }

                        //capturar el tipo de ID

                        String tipoID = (String) JcomboBoxTipo.getSelectedItem();
                        String numID = JtextFieldNumeroI.getText();

                        //Capturas los días de la semana
                        StringBuilder dias = new StringBuilder();

                        if(lunesCheckBox.isSelected())
                            dias.append("Lunes");

                        if(martesCheckBox.isSelected())
                            dias.append("Martes");

                        if(miercolesCheckBox.isSelected())
                            dias.append("Miercoles");

                        if(juevesCheckBox.isSelected())
                            dias.append("Jueves");

                        if(viernesCheckBox.isSelected())
                            dias.append("Viernes");

                        //Capturar valor hora y el total
                        String valorHora = JtextFieldVHora.getText();
                        String totalHora = JtextFieldTHoras.getText();

                        //Observaciones
                        String observ = JtextAreaObserv.getText();

                        //Crear una fila de datos, objeto para la tabla
                        Object [] nuevaFila = {
                          primerNombre, segundoNombre, primerApellido, segundoApellido,
                          genero, tipoID, numID, dias.toString().trim(), valorHora,
                          totalHora, observ
                        };

                        //agregar valores a la tabla
                        model.addRow(nuevaFila);

                        //Limpiar componentes
                        limpiarDatos();

                    }
                }
        );
        //hacer visible el jframe
        setVisible(true);
    }

    //método de limpiar para los componentes
    private void limpiarDatos(){
        JtextFieldPNombre.setText("");
        JtextFieldSNombre.setText("");
        JtextFieldPApellido.setText("");
        JtextFieldSApellido.setText("");

        masculinoRadioButton.setSelected(false);
        femeninoRadioButton.setSelected(false);
        noBinarioRadioButton.setSelected(false);
        lgbtiqRadioButton.setSelected(false);

        JcomboBoxTipo.setSelectedIndex(0);

        JtextFieldNumeroI.setText("");

        lunesCheckBox.setSelected(false);
        martesCheckBox.setSelected(false);
        miercolesCheckBox.setSelected(false);
        juevesCheckBox.setSelected(false);
        viernesCheckBox.setSelected(false);

        JtextFieldVHora.setText("");
        JtextFieldTHoras.setText("");
        JtextAreaObserv.setText("");
    }

    //Metodo principal de ejecución
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Principal());
    }

}
