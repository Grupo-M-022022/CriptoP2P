package ar.edu.unq.criptop2p.service.interfaces;

import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import java.util.List;

public interface ICriptoMonedaService {
	List<CriptoMonedaDTO> findAll();
	void save(CriptoMonedaDTO criptoMoneda);
	CriptoMonedaDTO getById(long id);
}
