package com.adriana.GerenciadorTreinamentos.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriana.GerenciadorTreinamentos.domain.Certificado;
import com.adriana.GerenciadorTreinamentos.repository.CertificadoRepository;
import com.adriana.GerenciadorTreinamentos.service.exception.ConstraintViolationExcep;
import com.adriana.GerenciadorTreinamentos.service.exception.ObjetoNaoEncontradoException;


@Service
public class CertificadoService {

	@Autowired
	private CertificadoRepository repo;
	
	public Certificado getCertificado (Integer id) {
		Optional<Certificado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + " , Tipo: " + Certificado.class.getName()));
	}
	
	public Certificado addCertificado (Certificado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Certificado editCertificado (Certificado obj) {
		getCertificado(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteCertificado (Integer id) {
		getCertificado(id);
		try {
			repo.deleteById(id);
		} catch (ConstraintViolationException e){
			throw new ConstraintViolationExcep("Não é possível deletar Certificado, pois existem referências externas a utilizando.");
		}
	} 
	
	public List<Certificado> getCertificados() {
		return repo.findAll();
	}
}
