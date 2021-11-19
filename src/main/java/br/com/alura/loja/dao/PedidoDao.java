package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVO;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "select sum(p.valorTotal) from Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVendasVO> relatorioDeVendas(){
		String jpql = "select new br.com.alura.loja.vo.RelatorioDeVendasVO("
				+ "produto.nome, "
				+ "sum(item.quantidade), "
				+ "max(pedido.dataCriacao)) "
				+ "from Pedido pedido "
				+ "join pedido.itens item "
				+ "join item.produto produto "
				+ "group by produto.nome "
				+ "order by item.quantidade desc";
		return em.createQuery(jpql, RelatorioDeVendasVO.class).getResultList();
	}
	
	public Pedido buscarPedidoComCliente(Long id) {
		return em.createQuery("select p from Pedido p join fetch p.cliente where p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
