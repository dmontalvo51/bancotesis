package pe.edu.unmsm.modelo;


import java.io.InputStream;  
import javax.faces.context.FacesContext;  
import javax.servlet.ServletContext;  
  
import org.primefaces.model.DefaultStreamedContent;  
import org.primefaces.model.StreamedContent;  
  
public class DescargarBosquejo{  
  
    private StreamedContent file;  
      
    public DescargarBosquejo() {          
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/images/optimusprime.jpg");  
        file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");  
    }  
  
    public StreamedContent getFile() {  
        return file;  
    }    
}  