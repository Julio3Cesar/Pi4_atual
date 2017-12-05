/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmusical.userinterface.venda;

import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmuscial.exception.ProdutoException;
import br.com.senac.lojashowmuscial.exception.VendaException;
import br.com.senac.lojashowmusical.bean.ProdutoQtd;
import br.com.senac.lojashowmusical.dto.VendaDTO;
import br.com.senac.lojashowmusical.service.ClienteService;
import br.com.senac.lojashowmusical.service.ProdutoService;
import br.com.senac.lojashowmusical.service.VendaService;
import br.com.senac.lojashowmusical.service.impl.ClienteServiceImpl;
import br.com.senac.lojashowmusical.service.impl.ProdutoServiceImpl;
import br.com.senac.lojashowmusical.service.impl.VendaServiceImpl;
import br.com.senac.lojashowmusical.userinterface.cliente.CadastroClienteUI;
import br.com.senac.lojashowmusical.userinterface.produto.ConsultaProdutoUI;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendasUI extends javax.swing.JFrame {

    private final ClienteService serviceCliente;
    private final ProdutoService serviceProduto;
    private ConsultaProdutoUI pesquisarProduto;
    private final VendaService serviceVenda;
    public static VendaDTO venda;

    /**
     * Creates new form VendasUI
     */
    public VendasUI() {
        venda = new VendaDTO();
        this.serviceCliente = ClienteServiceImpl.getInstance();
        this.serviceProduto = ProdutoServiceImpl.getInstance();
        this.serviceVenda = VendaServiceImpl.getInstance();
        initComponents();
        lblNome.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        lblCodDeBarras = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtCodDeBarras = new javax.swing.JFormattedTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnFinalizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnQtdOk = new javax.swing.JToggleButton();
        btnCpfOk = new javax.swing.JToggleButton();
        lblNome = new javax.swing.JLabel();
        txtQtd = new javax.swing.JFormattedTextField();
        btnFechar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Vendas"));

        lblCpf.setText("CPF");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCodDeBarras.setText("CÓD. DE BARRAS");

        lblQuantidade.setText("Qtd");

        btnPesquisar.setText("Pesquisar Produto");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. de barras", "Produto", "Marca", "Modelo", "Cor", "Qtd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        btnFinalizar.setText("Finalizar Compra");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover do Carrinho");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnQtdOk.setText("OK");
        btnQtdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQtdOkActionPerformed(evt);
            }
        });

        btnCpfOk.setText("OK");
        btnCpfOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpfOkActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNome.setText("nome");

        txtQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtQtd.setText("0");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemover)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFinalizar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCpfOk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                .addComponent(lblCodDeBarras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblQuantidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnQtdOk)))))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtCodDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodDeBarras)
                    .addComponent(btnQtdOk)
                    .addComponent(btnCpfOk)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnRemover)
                    .addComponent(btnFechar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (lblNome.isVisible() && venda.getProdutosQtd().size() > 0) {
            FinalizarVendaDialogUI dialogoFinalizar = new FinalizarVendaDialogUI(this, true);
            venda.setPagamento(dialogoFinalizar.showDialog());
            for (ProdutoQtd p : venda.getProdutosQtd()) {
                venda.getPagamento().setPrecoTotalVenda(venda.getPagamento().getPrecoTotalVenda()
                        + (p.getProduto().getDescricao().getPreco() * p.getQuantidade()));
            }
            venda.setDataVenda(new Date());
            try {
                serviceVenda.insert(venda);
                JOptionPane.showMessageDialog(rootPane, venda.toString(), "Resumo da Venda", JOptionPane.INFORMATION_MESSAGE);
                venda = new VendaDTO();
                updateCarrinho();
                txtCpf.setText("");
                lblNome.setVisible(false);
            } catch (VendaException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error ao concluir a venda.");
                Logger.getLogger(VendasUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "É necessario informar o cliente e o(s) produto(s).");
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCpfOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpfOkActionPerformed
        String cpf = txtCpf.getText().replace(".", "").replace("-", "");
        if (cpf != null && !cpf.replace("           ", "").equals("")) {
            try {
                venda.setCliente(this.serviceCliente.getT(cpf));
                lblNome.setText(venda.getCliente().getNome().toUpperCase());
                lblNome.setVisible(true);
            } catch (ClienteException e) {
                if (venda.getCliente() == null) {
                    int resposta = JOptionPane.showConfirmDialog(rootPane,
                            "Cliente não encontrador, deseja cadastrar novo?",
                            "Não Encontrado", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        CadastroClienteUI novoCliente = new CadastroClienteUI();
                        novoCliente.pack();
                        novoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        novoCliente.setLocationRelativeTo(null);
                        novoCliente.setVisible(true);
                        novoCliente.toFront();
                    }
                }
                e.printStackTrace();
                Logger.getLogger(VendasUI.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Necessário digitar um CPF.");
        }

    }//GEN-LAST:event_btnCpfOkActionPerformed

    private void btnQtdOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQtdOkActionPerformed
        if (!txtCodDeBarras.getText().equals("")) {
            ProdutoQtd produto = null;
            try {
                produto = new ProdutoQtd(this.serviceProduto.getT(txtCodDeBarras.getText()));
                Boolean exist = venda.getProdutosQtd().contains(produto);
                if (exist) {
                    JOptionPane.showMessageDialog(rootPane, "Produto já adicionado, "
                            + "caso queira altere a quantidade no carrinho.");
                } else {
                    if (txtQtd.getText().equals("0") || txtQtd.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Digite a Quantidade.");
                    } else {
                        produto.setQuantidade(Integer.parseInt(txtQtd.getText()));
                        venda.getProdutosQtd().add(produto);
                        this.updateCarrinho();
                    }
                }
            } catch (ProdutoException e) {
                e.printStackTrace();
                if (produto == null) {
                    JOptionPane.showMessageDialog(rootPane, "Produto não encontrado, "
                            + "faça uma pesquisa.");
                }
                Logger.getLogger(VendasUI.class.getName()).log(Level.SEVERE, null, e);
            }
            txtCodDeBarras.setText("");
            txtQtd.setText("0");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o código de barras para pesquisa.");
        }
    }//GEN-LAST:event_btnQtdOkActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.updateCarrinho();
    }//GEN-LAST:event_formWindowActivated

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisarProduto = new ConsultaProdutoUI(true);
        pesquisarProduto.pack();
        pesquisarProduto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pesquisarProduto.setLocationRelativeTo(null);
        pesquisarProduto.setVisible(true);
        pesquisarProduto.toFront();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        final int row = table.getSelectedRow();
        if (row >= 0) {
            String codBarras = (String) table.getValueAt(row, 0);
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja remover o produto do carrinho?",
                    "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                ProdutoQtd produto;
                try {
                    produto = new ProdutoQtd(serviceProduto.getT(codBarras));
                    venda.getProdutosQtd().remove(produto);
                    updateCarrinho();
                } catch (ProdutoException e) {
                    e.printStackTrace();
                    Logger.getLogger(VendasUI.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Para Remover, selecione um produto.");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void updateCarrinho() {
        Object[] linha = new Object[6];
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        if (venda.getProdutosQtd() != null && !venda.getProdutosQtd().isEmpty()) {
            for (int i = 0; i < venda.getProdutosQtd().size(); i++) {
                linha[0] = venda.getProdutosQtd().get(i).getProduto().getCodBarras();
                linha[1] = venda.getProdutosQtd().get(i).getProduto().getNome();
                linha[2] = venda.getProdutosQtd().get(i).getProduto().getMarca().getMarca();
                linha[3] = venda.getProdutosQtd().get(i).getProduto().getDescricao().getModelo();
                linha[4] = venda.getProdutosQtd().get(i).getProduto().getDescricao().getCor();
                if (venda.getProdutosQtd().get(i).getQuantidade() == null) {
                    linha[5] = 0;
                } else {
                    linha[5] = venda.getProdutosQtd().get(i).getQuantidade();
                }
                model.addRow(linha);
                linha = new Object[6];
            }
        }
    }

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
            java.util.logging.Logger.getLogger(VendasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendasUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCpfOk;
    private javax.swing.JToggleButton btnFechar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JToggleButton btnQtdOk;
    private javax.swing.JButton btnRemover;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodDeBarras;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTable table;
    private javax.swing.JFormattedTextField txtCodDeBarras;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtQtd;
    // End of variables declaration//GEN-END:variables

}
