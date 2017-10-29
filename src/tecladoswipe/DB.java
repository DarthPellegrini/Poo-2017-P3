package tecladoswipe;

import java.sql.*;

/**
 *
 * @author m78159
 */
public class DB {
    private PreparedStatement pstmt;
    private Connection conn;
    private ResultSet rs;
    private String connect;
    
    public void creatConn(String connection,String user,String password) throws Exception{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connect = connection+"user="+user+"&password="+password;
        conn = DriverManager.getConnection(connect);
        conn.close();
    }
    
    private void startConn() throws Exception{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(connect);
    }
    
    private void endConn() throws SQLException{
        conn.close();
    }
    
    private boolean wordNotIn(String word, String[] srs){
        //will return true if the word is contained in the srs String array
        for(String s : srs)
            if(s != null && word.equals(s))
                return false;
        return true;
    }
    
    @SuppressWarnings({"FinallyDiscardsException", "CallToPrintStackTrace"})
    public String[] getResults(String word){
        String[] srs = {null,null,null,null}; String aux = ""; int i = 0;
        try {
            //return the results of a search for the specified word
            startConn();
            //case 1: searching the full word
            pstmt = conn.prepareStatement("select palavra from palavras where palavra LIKE(?) order by score desc");
            pstmt.setString(1, word);
            rs = pstmt.executeQuery();
            while(rs.next())
                srs[i++] = rs.getString(1);
            //case 2: searching words with matching beginning and ending + equal size
            aux+= word.charAt(0);
            for(int j = 0; j < (word.length()-2); j++)
                aux += "_";
            aux+= word.charAt(word.length()-1);
            pstmt.setString(1,aux);
            rs = pstmt.executeQuery();
            while(rs.next() && i < 2)
                if(wordNotIn(rs.getString(1),srs))
                    srs[i++] = rs.getString(1);
            //case 3: searching words that contain this word's char sequence
            pstmt.setString(1,word+"%");
            rs = pstmt.executeQuery();
            while(rs.next() && i < 4)
                if(wordNotIn(rs.getString(1),srs))
                    srs[i++] = rs.getString(1);
            //case 4: searching words with the first and last char matching this word's ones
            pstmt.setString(1,word.charAt(0)+"%%"+word.charAt(word.length()-1));
            rs = pstmt.executeQuery();
            while(rs.next() && i < 4)
                if(wordNotIn(rs.getString(1),srs))
                    srs[i++] = rs.getString(1);
            
        } catch (Exception ex) {
        } finally{
            try{
                endConn();
                return srs;
            }catch(SQLException ex){
                ex.printStackTrace();
                return null;
            }
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public void updateTable(String word){
        try {
            startConn();
            pstmt = conn.prepareStatement("select id,score from palavras where palavra = ?");
            pstmt.setString(1, word);
            rs = pstmt.executeQuery();  
            if(rs.next()){
                //if the word exists, it's score will go up
                int id = rs.getInt(1),score = (rs.getInt(2)+1);
                pstmt = conn.prepareStatement("update palavras "
                                            + "set score = ? "
                                            + "where id = ?");
                pstmt.setInt(1,score); pstmt.setInt(2, id);
            }else{
                //if not, the word will be added to the database
                rs = pstmt.executeQuery("select COUNT(*) from palavras");
                rs.next();
                int count = (1+rs.getInt(1));
                pstmt = conn.prepareStatement("insert into palavras values(?,?,?)");
                pstmt.setInt(1, count);
                pstmt.setString(2, word);
                pstmt.setInt(3, 0);
            }
            pstmt.execute();
        } catch (Exception ex) {
        } finally{
            try{
                endConn();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
