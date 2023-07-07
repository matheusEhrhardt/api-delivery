package notificacao;

import com.m4technology.m4foodapi.domain.enumns.NivelUrgenciaEnum;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoNotificador {

    NivelUrgenciaEnum value();
}

