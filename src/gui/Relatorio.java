package gui;

import dao.AlunoDAO;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

import dao.CursoDAO;
import gui.AlunoGUI;
import gui.Lista;
import gui.CursoGUI;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import modelo.Aluno;
import modelo.Curso;

public class Relatorio extends javax.swing.JFrame {

    
    public Relatorio() {
        initComponents();
        carregarCursos();
        //gerarRelatorio();
    }
    
    private void carregarCursos() {
    try {
        CursoDAO dao = new CursoDAO();
        List<Curso> cursos = dao.listarTodos(); // ou listarAtivos()
        cmbCurso.removeAllItems();
        for (Curso curso : cursos) {
            if (curso.isAtivo()) {
                cmbCurso.addItem(curso);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar cursos: " + e.getMessage());
    }
 }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        GerarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Relatório");

        jLabel2.setText("Curso:");

        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        GerarRelatorio.setText("Enviar");
        GerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(GerarRelatorio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(GerarRelatorio)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPerformed
        // TODO add your handling code here:
         try {
        Curso cursoSelecionado = (Curso) cmbCurso.getSelectedItem();
        if (cursoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um curso!");
            return;
        }

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.listarPorCurso(cursoSelecionado.getId());

        String nomeArquivo = "relatorio_" + cursoSelecionado.getNome().replaceAll("\\s+", "_") + ".txt";
        FileWriter writer = new FileWriter(nomeArquivo);

        writer.write("Relatório do Curso: " + cursoSelecionado.getNome() + "\n\n");

        for (Aluno aluno : alunos) {
            writer.write("Nome: " + aluno.getNome() + "\n");
            writer.write("CPF: " + aluno.getCpf() + "\n");
            writer.write("Email: " + aluno.getEmail() + "\n");
            writer.write("Data de Nascimento: " + aluno.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n");
            writer.write("Status: " + (aluno.isAtivo() ? "Habilitado" : "Desabilitado") + "\n");
            writer.write("---------------------------------------------\n");
        }

        writer.close();
        JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso!\nArquivo: " + nomeArquivo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_ActionPerformed

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
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarRelatorio;
    private javax.swing.JComboBox<modelo.Curso> cmbCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
