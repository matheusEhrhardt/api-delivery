package notificacao;

import com.m4technology.m4foodapi.domain.enumns.NivelUrgenciaEnum;
import com.m4technology.m4foodapi.domain.model.Cliente;
import org.springframework.stereotype.Component;

@TipoNotificador(NivelUrgenciaEnum.NORMAL)
//@Profile("dev")
@Component
public class NotificadorSms implements Notificador{

    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificando %s por SMS através do contato %s: ",
                cliente.getNome(),cliente.getContato(),mensagem);
    }
}
