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

public class EditarAluno extends javax.swing.JFrame {


    public EditarAluno() {
        initComponents();
        carregarAlunos();
    }
    
    private void carregarAlunos() {
    try {
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> alunos = dao.listarTodos();// ou listarAtivos(), se tiver
        
        cmbAluno.removeAllItems();
        cmbAluno2.removeAllItems();
        
        for (Aluno aluno : alunos) {
            cmbAluno.addItem(aluno);
            cmbAluno2.addItem(aluno);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar alunos: " + e.getMessage());
    }
    }

    
    private void alterarStatusAluno(boolean status) {
    Aluno alunoSelecionado = (Aluno) cmbAluno.getSelectedItem();

    if (alunoSelecionado == null) {
        JOptionPane.showMessageDialog(this, "Selecione um aluno.");
        return;
    }

    alunoSelecionado.setAtivo(status);

    try {
        AlunoDAO dao = new AlunoDAO();
        dao.atualizarStatus(alunoSelecionado);
        JOptionPane.showMessageDialog(this, "Status atualizado com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar status: " + e.getMessage());
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbAluno = new javax.swing.JComboBox<>();
        btnHabilitar = new javax.swing.JButton();
        btnDesabilitar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        cmbAluno2 = new javax.swing.JComboBox<>();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Editar Aluno");

        jLabel3.setText("Aluno:");

        cmbAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlunoActionPerformed(evt);
            }
        });

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

        jLabel4.setText("Aluno:");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnHabilitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesabilitar)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAluno2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnExcluir)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHabilitar)
                    .addComponent(btnDesabilitar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        // TODO add your handling code here:
        alterarStatusAluno(true);
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void cmbAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAlunoActionPerformed

    private void btnDesabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesabilitarActionPerformed
        // TODO add your handling code here:
        alterarStatusAluno(false);
    }//GEN-LAST:event_btnDesabilitarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Aluno alunoSelecionado = (Aluno) cmbAluno2.getSelectedItem();

    if (alunoSelecionado == null) {
        JOptionPane.showMessageDialog(this, "Selecione um aluno para excluir.");
        return;
    }

    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir o aluno \"" + alunoSelecionado.getNome() + "\"?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.excluir(alunoSelecionado.getId());
            JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");
            carregarAlunos(); // Atualiza os combos
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir aluno: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesabilitar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JComboBox<modelo.Aluno> cmbAluno;
    private javax.swing.JComboBox<modelo.Aluno> cmbAluno2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
