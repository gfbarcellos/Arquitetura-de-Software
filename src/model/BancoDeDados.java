/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class BancoDeDados implements interfaces.IArmazenamento{
    
    @Override
    public boolean VerificaTorneio( String valor ) throws IOException
    {   
        //Faz a verificação da situação do arquivo
        int info_tab = VerificaDado(valor);
        
        if(info_tab == 1)
        {
            JOptionPane.showMessageDialog(null, "Tabela de "+ valor +" está vazia", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            return true;
        }

    }
    
    @Override
    public int VerificaDado(String valor) throws FileNotFoundException, IOException
    {
         
        ConexaoBanco conexao = new ConexaoBanco();
        Connection conn = conexao.Conexao();
        PreparedStatement ps =  null;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement("select * from "+valor);
            rs = ps.executeQuery();
            while (rs.next())
            {
                
                return 0;
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 1;
    }
    
    @Override
    public ArrayList<String> MontaListaTimes() throws FileNotFoundException, IOException
    {
        
        ArrayList<String> retorno = new ArrayList<String>();

        ConexaoBanco conexao = new ConexaoBanco();
        Connection conn = conexao.Conexao();
        PreparedStatement ps =  null;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement("select * from times");
            rs = ps.executeQuery();
            while (rs.next())
            {
                retorno.add(rs.getString("time"));
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
        
    }
    
    @Override
    public void ArmazenaConfrontos(List<Confrontos> listaConfrontos) throws IOException
    {
        ConexaoBanco conexao = new ConexaoBanco();
        Connection conn = conexao.Conexao();
        
        PreparedStatement ps =  null;
        ResultSet rs = null;
        String query = new String();
        
        try {
            ps = conn.prepareStatement("delete from confrontos");
            ps.executeUpdate();

            for(Confrontos linha: listaConfrontos)
            { 

                query = "insert into confrontos(data, rodada, timeMandante,golMandante,timeVisitante,golVisitante,rodadaValida)"
                       + "values("+"\""+linha.getData()+"\","+linha.getRodada()+",\""+linha.getTimeMandante()+"\","+linha.getGolMandante()+",\""+linha.getTimeVisitante()+"\","+linha.getGolVisitante()+","+linha.getJogoRealizado()+")";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public ArrayList<Confrontos> DadosConfrontos() throws FileNotFoundException, IOException
    {
        ArrayList<Confrontos> retorno = new ArrayList<>();
        
        ConexaoBanco conexao = new ConexaoBanco();
        Connection conn = conexao.Conexao();
        
        PreparedStatement ps =  null;
        ResultSet rs = null;
        String query = new String();
        
        try {
            ps = conn.prepareStatement("select * from confrontos");
            rs = ps.executeQuery();
            while (rs.next())
            {
                LocalDate data = LocalDate.parse(rs.getString("data")); 
                int rodada = Integer.parseInt(rs.getString("rodada"));
                int golsM  = Integer.parseInt(rs.getString("golMandante"));
                int golsV  = Integer.parseInt(rs.getString("golVisitante"));
                boolean jogo = true;
                if(rs.getString("rodadaValida").equals("0"))
                {
                    jogo = false;
                }
                Confrontos confrontos = new Confrontos(data, rodada, rs.getString("timeMandante"), golsM, rs.getString("timeVisitante"), golsV, jogo);
                
                //Adiciona o time no vetor
                retorno.add(confrontos); 
            } 
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return retorno;
    }
    
}
