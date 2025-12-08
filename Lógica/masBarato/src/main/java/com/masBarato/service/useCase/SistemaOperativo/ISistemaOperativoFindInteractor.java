package com.masBarato.masBarato.service.useCase.SistemaOperativo;

import com.masBarato.masBarato.model.classes.Procesador;
import com.masBarato.masBarato.model.classes.SistemaOparativo;

public interface ISistemaOperativoFindInteractor {
     SistemaOparativo findSOByIdSO(Integer idProcesador);
}
