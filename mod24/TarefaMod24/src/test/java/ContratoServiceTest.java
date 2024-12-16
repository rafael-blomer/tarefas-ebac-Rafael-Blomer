import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dao.ContratoDao;
import dao.ContratoDaoMock;
import dao.IContratoDao;
import service.ContratoService;
import service.IContratoService;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        assertEquals("Sucesso", retorno);
    }
    
    @Test
    public void buscarTest() {
    	IContratoDao dao = new ContratoDaoMock();
    	IContratoService service = new ContratoService(dao);
    	String retorno = service.buscar();
    	assertEquals("Sucesso", retorno);
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        assertEquals("Sucesso", retorno);
    }
    
    @Test
    public void excluirTest() {
    	IContratoDao dao = new ContratoDaoMock();
    	IContratoService service = new ContratoService(dao);
    	String retorno = service.excluir();
    	assertEquals("Sucesso", retorno);
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirComBancoTest() {
    	IContratoDao dao = new ContratoDao();
    	IContratoService service = new ContratoService(dao);
    	String retorno = service.excluir();
    	assertEquals("Sucesso", retorno);
    }
    
    @Test
    public void atualizarTest() {
    	IContratoDao dao = new ContratoDaoMock();
    	IContratoService service = new ContratoService(dao);
    	String retorno = service.atualizar();
    	assertEquals("Sucesso", retorno);
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarComBancoTest() {
    	IContratoDao dao = new ContratoDao();
    	IContratoService service = new ContratoService(dao);
    	String retorno = service.excluir();
    	assertEquals("Sucesso", retorno);
    }

    //TODO
    //Fazer métodos de buscar, excluir e atualizar
}
