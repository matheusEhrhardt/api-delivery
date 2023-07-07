package notificacao;

import com.m4technology.m4foodapi.domain.enumns.NivelUrgenciaEnum;
import com.m4technology.m4foodapi.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@TipoNotificador(NivelUrgenciaEnum.URGENTE)
//@Profile("prod")
@Component
public class NotificadorEmail implements Notificador{

    private boolean caixaAlta;

    @Autowired
    private NotificadorProperties properties;

//    @Value("${notificador.email.host-Servidor}")
//    private String host;
//
//    @Value("${notificador.email.port-Servidor}")
//    private Integer porta;

    @Override
    public void notificar(Cliente cliente,String mensagem){
        if (this.caixaAlta) {
            mensagem = mensagem.toUpperCase();
        }
        System.out.printf("Notificando %s através do E-mail %s: %s",
                cliente.getNome(),cliente.getEmail(),mensagem);
        System.out.println();
        System.out.println("Host: " + properties.getHostServidor() + " Port: " + properties.getPortServidor());
    }

    public boolean isCaixaAlta() {
        return caixaAlta;
    }

    public void setCaixaAlta(boolean caixaAlta) {
        this.caixaAlta = caixaAlta;
    }
}
