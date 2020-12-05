package autores.vistas;

import autores.modelos.Alumno;
import interfaces.IControladorAMAlumno;
import java.util.ArrayList;
import javax.swing.JDialog;

public class VentanaAMAlumno extends JDialog {
    ArrayList<Alumno> alumnos = new ArrayList<>();
    
    private IControladorAMAlumno controlador;
    /**
     * Creates new form VentanaSalir
     */
    public VentanaAMAlumno(JDialog padre, boolean modal, IControladorAMAlumno controlador) {
        super(padre, modal);
        initComponents();
        this.controlador = controlador;
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtApellidosAlumno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombresAlumno = new javax.swing.JTextField();
        btnGuardarNuevoProfesor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDNIAlumno = new javax.swing.JTextField();
        txtClaveAlumno = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRepetirClaveAlumno = new javax.swing.JPasswordField();
        btnCancelarNuevoProfesor = new javax.swing.JButton();
        txtCX = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alumnos");
        setResizable(false);

        jLabel1.setText("Apellidos:");

        txtApellidosAlumno.setToolTipText("Apellidos del profesor");
        txtApellidosAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosPresionarTecla(evt);
            }
        });

        jLabel2.setText("Nombres:");

        txtNombresAlumno.setToolTipText("Nombres del profesor");
        txtNombresAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresPresionarTecla(evt);
            }
        });

        btnGuardarNuevoProfesor.setMnemonic('G');
        btnGuardarNuevoProfesor.setText("Guardar");
        btnGuardarNuevoProfesor.setToolTipText("");
        btnGuardarNuevoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNuevoAlumnoClic(evt);
            }
        });

        jLabel3.setText("CX:");

        jLabel4.setText("Documento:");

        txtDNIAlumno.setToolTipText("Documento del profesor");
        txtDNIAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoPresionarTecla(evt);
            }
        });

        txtClaveAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClavePresionarTecla(evt);
            }
        });

        jLabel6.setText("Clave:");

        jLabel7.setText("Repetir clave:");

        txtRepetirClaveAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRepetirPresionarTecla(evt);
            }
        });

        btnCancelarNuevoProfesor.setText("Cancelar");
        btnCancelarNuevoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarNuevoAlumnoClic(evt);
            }
        });

        txtCX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCXPresionarTecla(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jLabel5.setText("Grupos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRepetirClaveAlumno)
                            .addComponent(txtNombresAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                            .addComponent(txtDNIAlumno)
                            .addComponent(txtApellidosAlumno)
                            .addComponent(txtClaveAlumno)
                            .addComponent(txtCX)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarNuevoProfesor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarNuevoProfesor))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNIAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombresAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClaveAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepetirClaveAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarNuevoProfesor)
                    .addComponent(btnCancelarNuevoProfesor)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarNuevoAlumnoClic(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNuevoAlumnoClic
        this.controlador.btnGuardarClic(evt);
    }//GEN-LAST:event_btnGuardarNuevoAlumnoClic

    private void btnCancelarNuevoAlumnoClic(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarNuevoAlumnoClic
        this.controlador.btnCancelarClic(evt);
    }//GEN-LAST:event_btnCancelarNuevoAlumnoClic

    private void txtDocumentoPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoPresionarTecla
        this.controlador.txtDocumentoPresionarTecla(evt);
    }//GEN-LAST:event_txtDocumentoPresionarTecla

    private void txtApellidosPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosPresionarTecla
        this.controlador.txtApellidosPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidosPresionarTecla

    private void txtNombresPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresPresionarTecla
        this.controlador.txtNombresPresionarTecla(evt);
    }//GEN-LAST:event_txtNombresPresionarTecla

    private void txtClavePresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClavePresionarTecla
        this.controlador.passClavePresionarTecla(evt);
    }//GEN-LAST:event_txtClavePresionarTecla

    private void txtRepetirPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepetirPresionarTecla
        this.controlador.passRepetirClavePresionarTecla(evt);
    }//GEN-LAST:event_txtRepetirPresionarTecla

    private void txtCXPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCXPresionarTecla
        this.controlador.txtCXPresionarTecla(evt);
    }//GEN-LAST:event_txtCXPresionarTecla

    public int getDni(){
        Integer dni = Integer.parseInt(this.txtDNIAlumno.getText().trim());
        return dni;
    }
    
    public String getApellidos(){
        String apellidos = this.txtApellidosAlumno.getText().trim();
        return apellidos;
    }
    
    public String getNombres(){
        String nombres = this.txtNombresAlumno.getText().trim();
        return nombres;
    }
    
    public String getCX(){
        String CX = this.txtCX.getText().trim();
        return CX;
    }
    
    public String getClave(){
        String clave = new String(this.txtClaveAlumno.getPassword());
        return clave;
    }
    
    public String getClaveRepetida() {
        String claveRepetida = new String(this.txtRepetirClaveAlumno.getPassword());
        return claveRepetida;
    }
    
    public void dniEnabled(boolean enabled){
        this.txtDNIAlumno.setEnabled(enabled);
    }
    
    /*SET*/
    
    public void setDni(String dni){
        this.txtDNIAlumno.setText(dni);
    }
    
    public void setApellidos(String apellidos){
        this.txtApellidosAlumno.setText(apellidos);
    }
    
    public void setNombres(String nombres){
        this.txtNombresAlumno.setText(nombres);
    }
    
    public void setCX(String CX){
        this.txtCX.setText(CX);
    }
    
    public void setClave(String clave){
        this.txtClaveAlumno.setText(clave);
    }
    
    public void setClaveRepetida(String clave) {
        this.txtRepetirClaveAlumno.setText(clave);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarNuevoProfesor;
    private javax.swing.JButton btnGuardarNuevoProfesor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField txtApellidosAlumno;
    private javax.swing.JTextField txtCX;
    private javax.swing.JPasswordField txtClaveAlumno;
    private javax.swing.JTextField txtDNIAlumno;
    private javax.swing.JTextField txtNombresAlumno;
    private javax.swing.JPasswordField txtRepetirClaveAlumno;
    // End of variables declaration//GEN-END:variables
}
