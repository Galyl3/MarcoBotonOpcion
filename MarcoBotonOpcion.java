
package marcobotonopcion;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class MarcoBotonOpcion extends JFrame {

    private JTextField campoTexto;// utiliza para mostrar os cambios en el tipo de letra
    //-----------------
    private Font tipoLetraSimple;//Utiliza el tipo de letra simple
    private Font tipoLetraNegrita;
    private Font tipoLetraCursiva;
    private Font tipoLetraNegritaCursiva;
    //---------------------
    private JRadioButton simpleRadioButton;//Seleccion texto simple
    private JRadioButton negritaRadioButton;//selecciona texto en negrita
    private JRadioButton cursivaRadioButton;//selecciona texto en cursiva
    private JRadioButton negritaCursivaRadioButton;//negrita y cursiva
    private ButtonGroup grupoOpciones;//grupo de botones que contiene los botones de opcion
    
    public MarcoBotonOpcion(){
    super("Prueba de RadioButton");
    setLayout(new FlowLayout());
    
    campoTexto=new JTextField("Observe el cambio en el estilo de letra", 28);
    add(campoTexto);
    //crea los botones de opcion
    simpleRadioButton= new JRadioButton("Simple", true);
    add(simpleRadioButton);
    
    negritaRadioButton=new JRadioButton("Negrita", false);
    add(negritaRadioButton);
    
    cursivaRadioButton=new JRadioButton("Cursiva", false);
    add(cursivaRadioButton);
    
    negritaCursivaRadioButton=new JRadioButton("Negrita/cursiva", false);
    add(negritaCursivaRadioButton);
    
    //crea una relacion logica ente los objetos de JRadioButton
    grupoOpciones=new ButtonGroup();//crea ButtonGroup
    grupoOpciones.add(simpleRadioButton);//agreaga simple al grupo
    grupoOpciones.add(negritaRadioButton);
    grupoOpciones.add(cursivaRadioButton);
    grupoOpciones.add(negritaCursivaRadioButton);
    
    //cra objetos tipo de letra
    tipoLetraSimple         = new Font("Serif", Font.PLAIN,14);
    tipoLetraNegrita        = new Font("Serif",Font.BOLD, 14);
    tipoLetraNegritaCursiva = new Font("Serif",Font.ITALIC,14);
    campoTexto.setFont(tipoLetraSimple);//establece el tipo letra inicial simple
    
    //Registra eventos para los objetos JRadioButton
    simpleRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraSimple));
    negritaRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraCursiva));
    cursivaRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegritaCursiva));
    negritaCursivaRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegritaCursiva));
    
    }//fin del contructor de marcoBotonOpcion
    
    //clase interna privada para manejar eventos de botones de opcion
    private class ManejadorBotonOpcion implements ItemListener{
            private Font tipoLetra;//Tipo de letra asociado con este componente de escucha
            public ManejadorBotonOpcion(Font f){
            tipoLetra=f;//Establede el tipo de letra de este componente escucha
            
            }
        //Maneja los eventos de botones de opcion
        public void itemStateChanged(ItemEvent ie) {
           campoTexto.setFont(tipoLetra); //establece el tpo de letra de campoTexto
        }
    }
    public static void main(String[] args) {
      MarcoBotonOpcion marcoBotonOpcion = new MarcoBotonOpcion();
 marcoBotonOpcion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  marcoBotonOpcion.setSize( 350, 100 ); // establece el tamaño del marco
 marcoBotonOpcion.setVisible( true ); // muestra el marco
        
    }
    
}
