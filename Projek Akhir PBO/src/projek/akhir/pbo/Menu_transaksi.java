package projek.akhir.pbo;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
        
public class Menu_transaksi extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    Koneksi k = new Koneksi();
    

    public Menu_transaksi() {
        initComponents();
        k.connect();
        refreshTable();
        refreshCombo();
    }
    
    class transaksi extends Menu_transaksi{
        int id_transaksi, id_masakan, harga, jumlah_beli, total_bayar;
        String nama_pelanggan, tanggal, nama_masakan;
        
        public transaksi(){
            this.nama_pelanggan = txt_nama_pelanggan.getText();
            String combo = combo_id_masakan.getSelectedItem().toString();
            String[] arr = combo.split(":");
            this.id_masakan = Integer.parseInt(arr[0]);
            try{
                Date date = txt_tanggal.getDate();
                DateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
                this.tanggal = dateformat.format(date);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            this.nama_masakan = arr[1];
            this.harga = Integer.parseInt(arr[2]);
            this.jumlah_beli = Integer.parseInt(txt_jumlah_beli.getText());
            this.total_bayar = this.harga * this.jumlah_beli;
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Masakan");
        model.addColumn("Tanggal");
        model.addColumn("Nama Masakan");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Bayar");
        table_transaksi.setModel(model);
        try{
            this.stat = k.getCon().prepareStatement("select * from transaksi");
            this.rs = this.stat.executeQuery();
            while (rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                };
                model.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        txt_id_transaksi.setText("");
        txt_nama_pelanggan.setText("");
        txt_jumlah_beli.setText("");
        txt_total_bayar.setText("");
    }

    public void refreshCombo(){
        try{
            this.stat = k.getCon().prepareStatement("select * from masakan " + "where status='Tersedia'");
            this.rs = this.stat.executeQuery();
            while (rs.next()){
                combo_id_masakan.addItem(rs.getString("id_masakan")+":"+
                rs.getString("nama_masakan")+":"+rs.getString("harga"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id_transaksi = new javax.swing.JTextField();
        txt_nama_pelanggan = new javax.swing.JTextField();
        combo_id_masakan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cetak_laporan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_jumlah_beli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_total_bayar = new javax.swing.JTextField();
        txt_tanggal = new com.toedter.calendar.JDateChooser();

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Transaksi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("ID Transaksi");
        jLabel3.setName(""); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ID Masakan");
        jLabel4.setName(""); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Nama Pelanggan");
        jLabel6.setName(""); // NOI18N

        txt_id_transaksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_id_transaksi.setEnabled(false);
        txt_id_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_transaksiActionPerformed(evt);
            }
        });

        txt_nama_pelanggan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nama_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_pelangganActionPerformed(evt);
            }
        });

        combo_id_masakan.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        combo_id_masakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_id_masakanActionPerformed(evt);
            }
        });

        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        table_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_transaksi);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn_input.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_input.setText("Input");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_cetak_laporan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cetak_laporan.setText("Cetak Laporan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btn_input)
                .addGap(10, 10, 10)
                .addComponent(btn_update)
                .addGap(10, 10, 10)
                .addComponent(btn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cetak_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_cetak_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Tanggal");
        jLabel7.setName(""); // NOI18N

        btn_menu.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_menu.setText("Lihat Menu");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Jumlah Beli");
        jLabel8.setName(""); // NOI18N

        txt_jumlah_beli.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_jumlah_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlah_beliActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Total Bayar");
        jLabel9.setName(""); // NOI18N

        txt_total_bayar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_bayar.setEnabled(false);
        txt_total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_bayarActionPerformed(evt);
            }
        });

        txt_tanggal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_jumlah_beli, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_id_transaksi)
                                    .addComponent(txt_nama_pelanggan)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combo_id_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                        .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_total_bayar)
                                    .addComponent(txt_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(combo_id_masakan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_jumlah_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_id_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_transaksiActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void txt_nama_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_pelangganActionPerformed

    private void combo_id_masakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_id_masakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_id_masakanActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        try{
            transaksi tran = new transaksi();
            txt_total_bayar.setText(""+tran.total_bayar);
            this.stat = k.getCon().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?)");            
            this.stat.setInt(1, 0);
            this.stat.setString(2, tran.nama_pelanggan);
            this.stat.setInt(3, tran.id_masakan);
            this.stat.setString(4, tran.tanggal);
            this.stat.setString(5, tran.nama_masakan);
            this.stat.setInt(6, tran.harga);
            this.stat.setInt(7, tran.jumlah_beli);
            this.stat.setInt(8, tran.total_bayar);
            int pilihan = JOptionPane.showConfirmDialog(null, 
                    "tanggal: "+tran.tanggal+
                    "\nNama Pelanggan: "+tran.nama_pelanggan+
                    "\nPembelian: "+tran.jumlah_beli+" "+tran.nama_masakan+
                    "\nTotal Bayar: "+tran.total_bayar+"\n",
                    "Tambahkan transaksi?",
                    JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION){
                this.stat.executeUpdate();
                refreshTable();
            } else if (pilihan == JOptionPane.NO_OPTION){
                refreshTable();
            }       
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try{
            transaksi tran = new transaksi();
            tran.id_transaksi = Integer.parseInt(txt_id_transaksi.getText());
            this.stat = k.getCon().prepareStatement("update transaksi set nama_pelanggan=?,"
                    + "id_masakan=?,tanggal=?,nama_masakan=?,harga=?,jumlah_beli=?,total_bayar=? "
                    + "where id_transaksi=?");
            this.stat.setString(1, tran.nama_pelanggan);
            this.stat.setInt(2, tran.id_masakan);
            this.stat.setString(3, tran.tanggal);
            this.stat.setString(4, tran.nama_masakan);
            this.stat.setInt(5, tran.harga);
            this.stat.setInt(6, tran.jumlah_beli);
            this.stat.setInt(7, tran.total_bayar);
            this.stat.setInt(8, tran.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }           
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try{
            transaksi tran = new transaksi();
            tran.id_transaksi = Integer.parseInt(txt_id_transaksi.getText());
            this.stat = k.getCon().prepareStatement("delete from transaksi "
                    + "where id_transaksi=?");
            this.stat.setInt(1, tran.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void txt_jumlah_beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlah_beliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlah_beliActionPerformed

    private void txt_total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_bayarActionPerformed

    private void table_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transaksiMouseClicked
        txt_id_transaksi.setText(model.getValueAt(table_transaksi.getSelectedRow(), 0).toString());
        txt_nama_pelanggan.setText(model.getValueAt(table_transaksi.getSelectedRow(), 1).toString());
        txt_jumlah_beli.setText(model.getValueAt(table_transaksi.getSelectedRow(), 6).toString());
        txt_total_bayar.setText(model.getValueAt(table_transaksi.getSelectedRow(), 7).toString());        
    }//GEN-LAST:event_table_transaksiMouseClicked

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_masakan masak = new Menu_masakan();
        masak.setVisible(true);
        this.setVisible(false);
        masak.btn_delete.setEnabled(true);
        masak.btn_input.setEnabled(true);
        masak.btn_update.setEnabled(true);
        masak.btn_transaksi.setEnabled(true);
    }//GEN-LAST:event_btn_menuActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cetak_laporan;
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_input;
    public javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_menu;
    public javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_id_masakan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable table_transaksi;
    private javax.swing.JTextField txt_id_transaksi;
    private javax.swing.JTextField txt_jumlah_beli;
    private javax.swing.JTextField txt_nama_pelanggan;
    private com.toedter.calendar.JDateChooser txt_tanggal;
    private javax.swing.JTextField txt_total_bayar;
    // End of variables declaration//GEN-END:variables
}
