package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.ItemExecucao;
import com.projetojpa.repository.ItemExecucaoRepository;

@Service
public class ItemExecucaoService {
	private final ItemExecucaoRepository itemExecucaoRepository;

    @Autowired
    public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) {
        this.itemExecucaoRepository = itemExecucaoRepository;
    }
    
    public List<ItemExecucao> buscaTodosItemExecucao() {
        return itemExecucaoRepository.findAll();
    }
    
    public ItemExecucao buscaItemExecucaoId(Long id) {
    	Optional <ItemExecucao> itemExecucao = itemExecucaoRepository.findById(id);
    	return itemExecucao.orElse(null);
    }
    
    public ItemExecucao salvaItemExecucao(ItemExecucao itemExecucao) {
    	return itemExecucaoRepository.save(itemExecucao);
    }
    
    public ItemExecucao alterarItemExecucao(Long id, ItemExecucao alterarItem) {
    	Optional <ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
    	if (existeItemExecucao.isPresent()) {
    		alterarItem.setId(id);
    		return itemExecucaoRepository.save(alterarItem);
    	}
    	return null;
    }
    
    public boolean apagarItemExecucao(Long id) {
    	Optional <ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
    	if (existeItemExecucao.isPresent()) {
    		itemExecucaoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}
