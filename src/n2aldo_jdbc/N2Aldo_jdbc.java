package n2aldo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class N2Aldo_jdbc {

    public static void main(String[] args) throws SQLException {
        //testaConexao();
        //criaTabela();
        addAluno();
    }

    public static void testaConexao() throws SQLException {
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "postgres";
        String url = "jdbc:postgresql://localhost:5432/escola";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " " + ex);
        }
    }
    public static void criaTabela(){
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "postgres";
        String url = "jdbc:postgresql://localhost:5432/escola";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,senha);
            String sql = "create table aluno (ra int, nome varchar(50),n1 float,n2 float, sexo char(1));";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
    }
    public static void addAluno(){
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "postgres";
        String url = "jdbc:postgresql://localhost:5432/escola";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,senha);
            String sql = "insert into aluno values(69696,'Brunna surfistinha',2.0,1.5,'F')";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            stm.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e);
        }
    }
}
