package tecladoswipe;

import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;

/**
 *
 * @author m78159
 */
public class ActionController implements ActionListener,MouseListener,MouseMotionListener{
    Keyboard k; Timer timer;
    private boolean firstDrag = false,dragged = false;
    
    ActionController(Keyboard k){
        this.k = k;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //normalmente pressionado
        if(k.dc.isVisible()){
            if(e.getSource() == k.dc.jButton1){
                k.dc.jButton1.setEnabled(false);
                String password = "";
                for(char c : k.dc.jPasswordField1.getPassword())
                    password+=c;
                createConnTimer(k.dc.jTextField1.getText(), k.dc.jTextField2.getText(), password);
            }else
                if(e.getSource() == k.dc.jButton2){
                    k.dc.setVisible(false);
                    k.lp.setVisible(true);
                }
        }else
            if(e.getSource() == k.lp.p.jlshift){
                k.lp.p.changeCase();
                k.lp.sp.forEach((ek) -> {ek.changeCase();});
            }else
                if(e.getSource() == k.lp.p.jlspace){
                    //saves the last word and activates the update table algorithm
                    if(k.lp.p.jTextField1.getText().endsWith(" ") || k.lp.p.jTextField1.getText().isEmpty())
                        k.lp.p.jTextField1.setText(k.lp.p.jTextField1.getText() + " ");
                    else
                        saveWordTimer(false);
                }else
                    if(e.getSource() == k.lp.p.jldelete){
                        //will only delete if the string is not null
                        if(!k.lp.p.jTextField1.getText().isEmpty())
                            k.lp.p.jTextField1.setText(k.lp.p.jTextField1.getText().substring(0,k.lp.p.jTextField1.getText().length()-1));
                        //will disable the FirstDrag if the String is either null or ends with a blank space
                        if(k.lp.p.jTextField1.getText().isEmpty() || k.lp.p.jTextField1.getText().endsWith(" "))
                            firstDrag = false;
                        resultSetTimer();
                    }else
                        if(!dragged){
                            for (JButton jSug : k.lp.p.jSug) {
                                if(e.getSource() == jSug && !jSug.getText().isEmpty()){
                                    //old string is saved 'till nWordP
                                    //jSug substitutes the old charSequence
                                    int nWordP = 1+k.lp.p.jTextField1.getText().lastIndexOf(" ");
                                    if(nWordP == 1) nWordP = 0;
                                    k.lp.p.jTextField1.setText(k.lp.p.jTextField1.getText().substring(0, nWordP) + jSug.getText() + k.lp.p.jlspace.getText());
                                    updateTimer(jSug.getText()); //adds ocurrence to database
                                    k.lp.p.clearSuggestions();
                                }
                            }
                            for(JButton jl : k.lp.p.jl){
                                if(e.getSource() == jl)
                                    k.lp.p.jTextField1.setText(k.lp.p.jTextField1.getText() + jl.getText());
                            }
                            for(ExtendedKeys ex : k.lp.sp)
                                for(JButton jl: ex.jl)
                                    if(e.getSource() == jl){
                                        k.lp.p.jTextField1.setText(k.lp.p.jTextField1.getText() + jl.getText());
                                        resultSetTimer();
                                        ex.setVisible(false);
                                    }
                        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Would only be relevant if ActionPerformed wasn't being used
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        k.lp.p.jTextField1.setEditable(true);
        try{
            //stops the option timer
            timer.cancel();
        }catch(Exception ex){
            //so it won't interrupt the execution
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        k.lp.p.jTextField1.setEditable(false);
        if(!k.lp.p.jTextField1.getText().endsWith(" ") && !k.lp.p.jTextField1.getText().isEmpty())
            firstDrag = true;
        dragged = false;
        resultSetTimer();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //hides ExtendedKey Panel
        for(ExtendedKeys ex :k.lp.sp)
                        ex.setVisible(false);
        for(int i = 0; i < k.lp.p.jl.size(); i++)
            if(e.getSource() == k.lp.p.jl.get(i))
                if(dragged){
                    writeTimer(k.lp.p.jl.get(i));
                }else
                    //to each letter, a different ExtendedKeyboard will be displayed
                    if(i == 2)
                        subTimer(i-2);
                    else    
                        if(i >= 6 && i <= 8) 
                            subTimer(i-5);
                        else
                            if(i == 10)
                            subTimer(i-6);
    }

    @Override
    public void mouseExited(MouseEvent e){
        for(JButton jl : k.lp.p.jl)
            if(e.getSource() == jl){
                try{
                    //stops the write timer
                    timer.cancel();
                }catch(Exception ex){
                    //so it won't interrupt the execution
                }
            }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dragged = true;
        //in the first drag, this algorithm will automatically save the last word
        if(firstDrag && !k.lp.p.jTextField1.getText().endsWith(" ") )
            saveWordTimer(true);
        firstDrag = false; //always set to false
        if(k.lp.p.jTextField1.getText().endsWith(" ") || k.lp.p.jTextField1.getText().isEmpty())
            for(JButton jl : k.lp.p.jl)
                if(e.getSource() == jl)
                    k.lp.p.jTextField1.setText(k.lp.p.jTextField1.getText() + jl.getText());
        resultSetTimer();
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        //unused
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Database Timers and Keyboard Timers">
    private void writeTimer(JButton jl){
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    //writes a letter on the TextField
                    k.lp.p.jTextField1.setText(k.lp.p.jTextField1.getText() + jl.getText());
                });
            }
        },400);
    }
    
    private void subTimer(int index){
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    //displays the ExtendedKeyboard for the given letter
                    k.lp.sp.get(index).setVisible(true);
                });
            }
        },500);
    }
        
    private void createConnTimer(String conn, String user, String password){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    //MessageDialog for Connection Attempt
                    try {
                        k.db.creatConn(conn,user,password);
                        javax.swing.JOptionPane.showMessageDialog(k, "Conexão estabelecida!", "Status de conexão",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        k.dc.jButton2.setEnabled(true);
                    } catch (Exception ex) {
                        javax.swing.JOptionPane.showMessageDialog(k, "Os dados inseridos estão incorretos.", "Status de conexão",javax.swing.JOptionPane.ERROR_MESSAGE);
                        k.dc.jButton1.setEnabled(true);
                    }
                });
            }
        },1);
    }
    
    private void resultSetTimer(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    if(!k.lp.p.jTextField1.getText().isEmpty()){
                        //will update the Suggestion Fields to the digited word
                        int nWordP = 1+k.lp.p.jTextField1.getText().lastIndexOf(" ");
                        if(nWordP == 1) nWordP = 0;
                        String rs[] = k.db.getResults(k.lp.p.jTextField1.getText().substring(nWordP));
                        for(int i = 0; i<rs.length;i++)
                            if(rs[i] != null)
                                k.lp.p.jSug.get(i).setText(rs[i]);
                            else
                                k.lp.p.jSug.get(i).setText("");
                    }else
                        k.lp.p.clearSuggestions();
                });
            }
        },1);
    }
    
    private void saveWordTimer(boolean overwrite){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    //will save the word on the database if all the condicions are met
                    String oldS = k.lp.p.jTextField1.getText(),word = null;
                    int nWordP = 1+oldS.lastIndexOf(" ");
                    if(nWordP == 1) nWordP = 0;
                    if(!overwrite || k.lp.p.jSug.get(0).getText().isEmpty())
                        word = oldS.substring(nWordP,k.lp.p.jTextField1.getText().length());
                    else
                        word = k.lp.p.jSug.get(0).getText();
                    oldS = oldS.substring(0,nWordP);
                    if(word != null && (!k.lp.p.jTextField1.getText().endsWith(" ") || !k.lp.p.jSug.get(0).getText().isEmpty())){
                        k.lp.p.jTextField1.setText(oldS+word+" ");
                        updateTimer(word);
                    }
                    k.lp.p.clearSuggestions();
                });
            }
        },1);
    }
    
    private void updateTimer(String word){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    //saves or update a word on the database
                    k.db.updateTable(word);
                });
            }
        },1);
    }
    
    private void templateTimer(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    //add timer code here
                });
            }
        },1);
    }
    //</editor-fold>
}