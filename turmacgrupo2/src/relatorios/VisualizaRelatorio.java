package relatorios;

import java.sql.Connection;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class VisualizaRelatorio {

    private Connection conn;
    
    public VisualizaRelatorio() throws Exception{
        try{
            this.conn = ConexaoRel.getConnection();
            
        }catch (Exception e){
            throw new Exception("Erro: \n" +e.getMessage());
        }
    }
    
    public void visualizar(){
        try {
            String arquivo = System.getProperty("user.dir") + "\\turmacgrupo2\\src\\relatorios\\relatorioCompra.jasper";
            JasperPrint jp = JasperFillManager.fillReport(arquivo, null, conn);
            JasperViewer.viewReport(jp, false);
        }catch (JRException e){
            e.printStackTrace();
        }finally{
            try{
                if (!conn.isClosed()){
                    conn.close();
                }
            }catch(SQLException ex){}
        }
    }
    
}
