import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;

import dao.DAOGenerico;
import modelo.EntidadeAdocao;

public class TestDAOGenerico {
	
	
	private DAOGenerico daoGenerico = new DAOGenerico();
	
	@Test
	public void testAddAdocao(){
		EntidadeAdocao adocao = new EntidadeAdocao();
		adocao.setNomeAnunciante("Rafael");
		adocao.setCpfAnunciante("00596860900");
		adocao.setCidade("Paranavaí");
		adocao.setInformacaoContato("abc");
		
		adocao.setNomeAnimal("Rex");
		adocao.setDescricaoAnimal("Sem pelo");
		adocao.setEspecieAnimal("Vira-Lata");
		adocao.setIdadeAnimal(23);
		adocao.setPorteAnimal("gigante");
		adocao.setCastrado(false);
		adocao.setSexoAnimal("Macho");
		adocao.setVacinado(true);
		
		daoGenerico.inserir(adocao);
		List<EntidadeAdocao> adocaoDao = daoGenerico.listar(EntidadeAdocao.class);
		
		Assert.assertEquals(1, adocaoDao.size());
	}
	

}
