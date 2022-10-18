package ar.edu.unq.criptop2p.service.imp;

import ar.edu.unq.criptop2p.model.dto.CriptoMonedaDTO;
import ar.edu.unq.criptop2p.model.entity.CriptoMoneda;
import ar.edu.unq.criptop2p.persistence.interfaces.ICriptoModedaRepository;
import ar.edu.unq.criptop2p.service.interfaces.ICriptoMonedaService;
import ar.edu.unq.criptop2p.utility.AutoMapperComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CriptoMonedaServiceImp implements ICriptoMonedaService {
	@Autowired
	private AutoMapperComponent mapperComponent;
	@Autowired
	private ICriptoModedaRepository criptoModedaRepository;

	@Override
	public List<CriptoMonedaDTO> findAll() {
		List<CriptoMoneda> criptoMoneda = criptoModedaRepository.findAll();
		return mapperComponent.ToList(criptoMoneda, CriptoMonedaDTO.class);
	}

	@Override
	public void save(CriptoMonedaDTO criptoMonedaDTO) {
		CriptoMoneda criptoMoneda = mapperComponent.To(criptoMonedaDTO, CriptoMoneda.class);
		criptoModedaRepository.save(criptoMoneda);
	}

	@Override
	public CriptoMonedaDTO getById(long id) {
		CriptoMoneda criptoMoneda = criptoModedaRepository.getReferenceById(id);
		return mapperComponent.To(criptoMoneda, CriptoMonedaDTO.class);
	}
}
