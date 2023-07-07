package notificacao;

import com.m4technology.m4foodapi.domain.model.Cliente;

public interface Notificador {

    public void notificar(Cliente cliente, String mensagem);
}
