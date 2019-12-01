/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.Confrontos;
import java.util.List;

public interface IArmazenamento {
    
    void ArmazenaConfrontos(List<Confrontos> listaConfrontos) throws IOException;
    ArrayList<String> MontaListaTimes() throws FileNotFoundException, IOException;
    ArrayList<Confrontos> DadosConfrontos() throws FileNotFoundException, IOException; 
    int VerificaDado(String valor) throws FileNotFoundException, IOException;
    boolean VerificaTorneio( String valor ) throws IOException;
}
