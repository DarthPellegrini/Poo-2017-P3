/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecladoswipe;

import java.util.ArrayList;

/**
 *
 * @author super
 */
public class ExtendedKeys extends javax.swing.JPanel {

    public ArrayList<javax.swing.JButton> jl;
    public String letters[];
    /**
     * Creates new form SubPanel
     */
    public ExtendedKeys(String l) {
        initComponents();
        int size = 4;
        switch(l){
            case "A":
                size = 5;
                letters = new String[size];
                letters[0] = "Á";
                letters[1] = "À";
                letters[2] = "Â";
                letters[3] = "Ã";
                letters[4] = "Ä";
                break;
            case "E":
                letters = new String[size];
                letters[0] = "É";
                letters[1] = "È";
                letters[2] = "Ê";
                letters[3] = "Ë";
                break;
            case "I":
                letters = new String[size];
                letters[0] = "Í";
                letters[1] = "Ì";
                letters[2] = "Î";
                letters[3] = "Ï";
                break;
            case "O":
                size = 5;
                letters = new String[size];
                letters[0] = "Ó";
                letters[1] = "Ò";
                letters[2] = "Ô";
                letters[3] = "Õ";
                letters[4] = "Ö";
                break;
            case "U":
                letters = new String[size];
                letters[0] = "Ú";
                letters[1] = "Ù";
                letters[2] = "Û";
                letters[3] = "Ü";
                break;
        }
        initList(size);
        this.setSize((size*40), 30);
    }
    
    
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void changeCase(){
        //if it's already lower
        if(jl.get(0).getText().toLowerCase().equals(jl.get(0).getText()))
            for(javax.swing.JButton jb : jl)
                jb.setText(jb.getText().toUpperCase());
        else
            for(javax.swing.JButton jb : jl)
                jb.setText(jb.getText().toLowerCase());
    }
    
    private void initList(int size){
        jl = new ArrayList<>();
        jl.add(jl1); jl.add(jl2);
        jl.add(jl3); jl.add(jl4);
        if(size == 5)
            jl.add(jl5);
        for(int i = 0; i < size; i++)
            jl.get(i).setText(letters[i]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl1 = new javax.swing.JButton();
        jl2 = new javax.swing.JButton();
        jl3 = new javax.swing.JButton();
        jl4 = new javax.swing.JButton();
        jl5 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);
        add(jl1);
        jl1.setBounds(0, 0, 40, 30);
        add(jl2);
        jl2.setBounds(40, 0, 40, 30);
        add(jl3);
        jl3.setBounds(80, 0, 40, 30);
        add(jl4);
        jl4.setBounds(120, 0, 40, 30);
        add(jl5);
        jl5.setBounds(160, 0, 40, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jl1;
    private javax.swing.JButton jl2;
    private javax.swing.JButton jl3;
    private javax.swing.JButton jl4;
    private javax.swing.JButton jl5;
    // End of variables declaration//GEN-END:variables
}
