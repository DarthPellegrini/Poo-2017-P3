package tecladoswipe;

/**
 *
 * @author m78159
 */
import java.util.ArrayList;

public class Panel extends javax.swing.JPanel {
    public ArrayList<javax.swing.JButton> jSug;
    public ArrayList<javax.swing.JButton> jl;
    /**
     * Creates new form Graphics
     */
    public Panel() {
        initComponents();
        this.setSize(500,340);
        initializeArrays();
    }
    
    public void changeCase(){
        //caps lock functionality
        if(jl.get(0).getText().equals("Q"))
            for(javax.swing.JButton jb : jl)
                jb.setText(jb.getText().toLowerCase());
        else
            for(javax.swing.JButton jb : jl)
                jb.setText(jb.getText().toUpperCase());
        this.revalidate();
    }
    
    public void clearSuggestions(){
        for(javax.swing.JButton js : jSug){
            js.setText("");
        }
    }
    
    private void initializeArrays(){
        //initialize jButton's arrays
        jSug = new ArrayList<>(); jl = new ArrayList<>();
        jSug.add(jSug1); jSug.add(jSug2);
        jSug.add(jSug3); jSug.add(jSug4);
        int k[] = {50,50,110};
        int kf[] = {410,410,350};
        for (int i = 0; i < 3; i++){
            int kl = 140+(i*30);
            for (int j = k[i]; j <= kf[i]; j+=40) 
                jl.add((javax.swing.JButton) this.getComponentAt(j, kl));
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

        jTextField1 = new javax.swing.JTextField();
        jSug1 = new javax.swing.JButton();
        jSug2 = new javax.swing.JButton();
        jSug3 = new javax.swing.JButton();
        jSug4 = new javax.swing.JButton();
        jl1 = new javax.swing.JButton();
        jl2 = new javax.swing.JButton();
        jl3 = new javax.swing.JButton();
        jl4 = new javax.swing.JButton();
        jl5 = new javax.swing.JButton();
        jl6 = new javax.swing.JButton();
        jl7 = new javax.swing.JButton();
        jl8 = new javax.swing.JButton();
        jl9 = new javax.swing.JButton();
        jl10 = new javax.swing.JButton();
        jl11 = new javax.swing.JButton();
        jl12 = new javax.swing.JButton();
        jl13 = new javax.swing.JButton();
        jl14 = new javax.swing.JButton();
        jl15 = new javax.swing.JButton();
        jl16 = new javax.swing.JButton();
        jl17 = new javax.swing.JButton();
        jl18 = new javax.swing.JButton();
        jl19 = new javax.swing.JButton();
        jl20 = new javax.swing.JButton();
        jl21 = new javax.swing.JButton();
        jl22 = new javax.swing.JButton();
        jl23 = new javax.swing.JButton();
        jl24 = new javax.swing.JButton();
        jl25 = new javax.swing.JButton();
        jl26 = new javax.swing.JButton();
        jl27 = new javax.swing.JButton();
        jlspace = new javax.swing.JButton();
        jlshift = new javax.swing.JButton();
        jldelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);
        add(jTextField1);
        jTextField1.setBounds(120, 250, 260, 50);
        add(jSug1);
        jSug1.setBounds(20, 40, 220, 30);
        add(jSug2);
        jSug2.setBounds(260, 40, 220, 30);
        add(jSug3);
        jSug3.setBounds(20, 80, 220, 30);
        add(jSug4);
        jSug4.setBounds(260, 80, 220, 30);

        jl1.setText("Q");
        add(jl1);
        jl1.setBounds(50, 120, 40, 30);

        jl2.setText("W");
        add(jl2);
        jl2.setBounds(90, 120, 40, 30);

        jl3.setText("E");
        add(jl3);
        jl3.setBounds(130, 120, 40, 30);

        jl4.setText("R");
        add(jl4);
        jl4.setBounds(170, 120, 40, 30);

        jl5.setText("T");
        add(jl5);
        jl5.setBounds(210, 120, 40, 30);

        jl6.setText("Y");
        add(jl6);
        jl6.setBounds(250, 120, 40, 30);

        jl7.setText("U");
        add(jl7);
        jl7.setBounds(290, 120, 40, 30);

        jl8.setText("I");
        add(jl8);
        jl8.setBounds(330, 120, 40, 30);

        jl9.setText("O");
        add(jl9);
        jl9.setBounds(370, 120, 40, 30);

        jl10.setText("P");
        add(jl10);
        jl10.setBounds(410, 120, 40, 30);

        jl11.setText("A");
        add(jl11);
        jl11.setBounds(50, 150, 40, 30);

        jl12.setText("S");
        add(jl12);
        jl12.setBounds(90, 150, 40, 30);

        jl13.setText("D");
        add(jl13);
        jl13.setBounds(130, 150, 40, 30);

        jl14.setText("F");
        add(jl14);
        jl14.setBounds(170, 150, 40, 30);

        jl15.setText("G");
        add(jl15);
        jl15.setBounds(210, 150, 40, 30);

        jl16.setText("H");
        add(jl16);
        jl16.setBounds(250, 150, 40, 30);

        jl17.setText("J");
        add(jl17);
        jl17.setBounds(290, 150, 40, 30);

        jl18.setText("K");
        add(jl18);
        jl18.setBounds(330, 150, 40, 30);

        jl19.setText("L");
        add(jl19);
        jl19.setBounds(370, 150, 40, 30);

        jl20.setText("Ç");
        add(jl20);
        jl20.setBounds(410, 150, 40, 30);

        jl21.setText("Z");
        add(jl21);
        jl21.setBounds(110, 180, 40, 30);

        jl22.setText("X");
        add(jl22);
        jl22.setBounds(150, 180, 40, 30);

        jl23.setText("C");
        add(jl23);
        jl23.setBounds(190, 180, 40, 30);

        jl24.setText("V");
        add(jl24);
        jl24.setBounds(230, 180, 40, 30);

        jl25.setText("B");
        add(jl25);
        jl25.setBounds(270, 180, 40, 30);

        jl26.setText("N");
        add(jl26);
        jl26.setBounds(310, 180, 40, 30);

        jl27.setText("M");
        add(jl27);
        jl27.setBounds(350, 180, 40, 30);

        jlspace.setText(" ");
        add(jlspace);
        jlspace.setBounds(150, 210, 200, 30);

        jlshift.setText("/\\");
            add(jlshift);
            jlshift.setBounds(70, 180, 40, 30);

            jldelete.setText("<-");
            add(jldelete);
            jldelete.setBounds(390, 180, 40, 30);

            jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Teclado Swipe");
            add(jLabel1);
            jLabel1.setBounds(170, 0, 160, 40);
        }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jSug1;
    private javax.swing.JButton jSug2;
    private javax.swing.JButton jSug3;
    private javax.swing.JButton jSug4;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JButton jl1;
    private javax.swing.JButton jl10;
    private javax.swing.JButton jl11;
    private javax.swing.JButton jl12;
    private javax.swing.JButton jl13;
    private javax.swing.JButton jl14;
    private javax.swing.JButton jl15;
    private javax.swing.JButton jl16;
    private javax.swing.JButton jl17;
    private javax.swing.JButton jl18;
    private javax.swing.JButton jl19;
    private javax.swing.JButton jl2;
    private javax.swing.JButton jl20;
    private javax.swing.JButton jl21;
    private javax.swing.JButton jl22;
    private javax.swing.JButton jl23;
    private javax.swing.JButton jl24;
    private javax.swing.JButton jl25;
    private javax.swing.JButton jl26;
    private javax.swing.JButton jl27;
    private javax.swing.JButton jl3;
    private javax.swing.JButton jl4;
    private javax.swing.JButton jl5;
    private javax.swing.JButton jl6;
    private javax.swing.JButton jl7;
    private javax.swing.JButton jl8;
    private javax.swing.JButton jl9;
    public javax.swing.JButton jldelete;
    public javax.swing.JButton jlshift;
    public javax.swing.JButton jlspace;
    // End of variables declaration//GEN-END:variables

}
