import java.util.List;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.eclipse.persistence.annotations.AdditionalCriteria;
import org.junit.Assert;
import org.junit.Test;

import dao.DAOGenerico;
import modelo.EntidadeAdocao;

public class TestDAOGenerico {
	
	
	private DAOGenerico daoGenerico = new DAOGenerico();
	
	@Test
	public void testAddAdocao() throws Exception{
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
		//Verifica a Inclusao
		Assert.assertEquals(1, adocaoDao.size());
		
		adocao.setNomeAnimal("Totó");
		daoGenerico.alterar(adocao);
		//Verifica a Aleração
		Assert.assertEquals("Totó", adocao.getNomeAnimal());
		
		//Long id1 = adocao.getId();
		//daoGenerico.exluir(id1);
		//List<EntidadeAdocao> exclusaoAdocao = daoGenerico.listar(EntidadeAdocao.class);
		//Verifica a Exclusão
		//Assert.assertEquals(0, exclusaoAdocao.size());
	}
}
