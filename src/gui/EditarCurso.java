package gui;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

import modelo.Curso;
import modelo.Aluno;
import dao.AlunoDAO;
import dao.CursoDAO;
import factory.ConnectionFactory;

public class EditarCurso extends javax.swing.JFrame {

    
    public EditarCurso() {
        initComponents();
        carregarCursos();
    }
    
    
    private void carregarCursos() {
     try {
        CursoDAO dao = new CursoDAO();
        List<Curso> cursos = dao.listarTodos();// ou listarAtivos()
        
        cmbCurso.removeAllItems();
        cmbCurso2.removeAllItems();
        
        for (Curso curso : cursos) {
                cmbCurso.addItem(curso);
                cmbCurso2.addItem(curso);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar cursos: " + e.getMessage());
    }
   }
    
    
    private void excluirCurso(){
    Curso cursoSelecionado = (Curso) cmbCurso2.getSelectedItem();

    if (cursoSelecionado == null) {
        JOptionPane.showMessageDialog(this, "Selecione um curso para excluir.");
        return;
    }

    int confirmacao = JOptionPane.showConfirmDialog(this,
        "Tem certeza que deseja excluir o curso \"" + cursoSelecionado.getNome() + "\"?",
        "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            CursoDAO dao = new CursoDAO();
            dao.excluir(cursoSelecionado.getId());

            JOptionPane.showMessageDialog(this, "Curso excluído com sucesso!");
            carregarCursos(); // Atualiza os combos
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir curso: " + e.getMessage());
        }
    }
  }
    
    private void alterarStatusCurso(boolean status) {
    Curso cursoSelecionado = (Curso) cmbCurso.getSelectedItem();

    if (cursoSelecionado == null) {
        JOptionPane.showMessageDialog(this, "Selecione um curso.");
        return;
    }

    cursoSelecionado.setAtivo(status);

    try {
        CursoDAO dao = new CursoDAO();
        dao.atualizarStatus(cursoSelecionado);
        JOptionPane.showMessageDialog(this, "Status do curso atualizado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar status do curso: " + e.getMessage());
    }
}


    


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        cmbCurso2 = new javax.swing.JComboBox<>();
        btnHabilitar = new javax.swing.JButton();
        btnDesabilitar = new javax.swing.JButton();
        Excluircurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Editar Curso");

        jLabel2.setText("Curso:");

        jLabel3.setText("Curso:");

        btnHabilitar.setText("Habilitar");
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        btnDesabilitar.setText("Desabilitar");
        btnDesabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesabilitarActionPerformed(evt);
            }
        });

        Excluircurso.setText("Excluir");
        Excluircurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluircursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCurso2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(87, 87, 87)
                                    .addComponent(btnHabilitar)
                                    .addGap(38, 38, 38)
                                    .addComponent(btnDesabilitar))))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Excluircurso)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHabilitar)
                    .addComponent(btnDesabilitar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCurso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Excluircurso)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExcluircursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluircursoActionPerformed
        // TODO add your handling code here:
        excluirCurso();
    }//GEN-LAST:event_ExcluircursoActionPerformed

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        // TODO add your handling code here:
         alterarStatusCurso(true);
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void btnDesabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesabilitarActionPerformed
        // TODO add your handling code here:
        alterarStatusCurso(false);
    }//GEN-LAST:event_btnDesabilitarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Excluircurso;
    private javax.swing.JButton btnDesabilitar;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JComboBox<modelo.Curso> cmbCurso;
    private javax.swing.JComboBox<modelo.Curso> cmbCurso2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
