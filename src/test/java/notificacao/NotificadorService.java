package notificacao;

import com.m4technology.m4foodapi.domain.enums.NivelUrgenciaEnum;
import com.m4technology.m4foodapi.domain.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificadorService {

    @TipoNotificador(NivelUrgenciaEnum.URGENTE)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent clienteAtivado){
        this.notificador.notificar(clienteAtivado.getCliente(),"Seu cadastro está ativo no sistema");
    }
}
