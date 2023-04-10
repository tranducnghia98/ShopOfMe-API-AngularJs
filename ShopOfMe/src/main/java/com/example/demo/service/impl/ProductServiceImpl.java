package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductDAO;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{



	@Autowired
	ProductDAO productDAO;

	@Override
	public <S extends Product> S save(S entity) {
		return productDAO.save(entity);
	}

	@Override
	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
		return productDAO.saveAll(entities);
	}

	@Override
	public <S extends Product> Optional<S> findOne(Example<S> example) {
		return productDAO.findOne(example);
	}



	@Override
	public List<Product> findAll(Sort sort) {
		return productDAO.findAll(sort);
	}

	@Override
	public void flush() {
		productDAO.flush();
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDAO.findAll(pageable);
	}

	@Override
	public <S extends Product> S saveAndFlush(S entity) {
		return productDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productDAO.saveAllAndFlush(entities);
	}

	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	public List<Product> findAllById(Iterable<Integer> ids) {
		return productDAO.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Product> entities) {
		productDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productDAO.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch(Iterable<Product> entities) {
		productDAO.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return productDAO.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		productDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Product> long count(Example<S> example) {
		return productDAO.count(example);
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		productDAO.deleteAllInBatch();
	}

	@Override
	public Product getOne(Integer id) {
		return productDAO.getOne(id);
	}

	@Override
	public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return productDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return productDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		productDAO.deleteById(id);
		
	}

	@Override
	public Product getById(Integer id) {
		return productDAO.getById(id);
	}

	@Override
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	@Override
	public Product getReferenceById(Integer id) {
		return productDAO.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		productDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		productDAO.deleteAll(entities);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example) {
		return productDAO.findAll(example);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
		return productDAO.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		productDAO.deleteAll();
	}

	@Override
	public Product findById(Integer id) {

		return productDAO.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {

		return productDAO.findByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		
		return productDAO.save(product);
	}


}
