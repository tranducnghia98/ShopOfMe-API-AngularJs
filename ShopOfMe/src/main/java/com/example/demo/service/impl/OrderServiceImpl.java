package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.OrderDAO;
import com.example.demo.repository.OrderDetailDAO;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderServiceImpl  implements OrderService{

	@Autowired
	OrderDAO orderDAO;

	@Autowired
	OrderDetailDAO detailDAO;


	@Override
	public Order create(JsonNode orderData) {

		ObjectMapper mapper = new ObjectMapper();

		Order order = mapper.convertValue(orderData, Order.class);
		orderDAO.save(order);

		TypeReference<List<OrderDetail>> type= new TypeReference<>() {
		};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d-> d.setOrder(order)).collect(Collectors.toList());


		detailDAO.saveAll(details);



		return order;
	}








	@Override
	public <S extends Order> S save(S entity) {
		return orderDAO.save(entity);
	}

	@Override
	public <S extends Order> Optional<S> findOne(Example<S> example) {
		return orderDAO.findOne(example);
	}

	@Override
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderDAO.findAll(pageable);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return orderDAO.findAll(sort);
	}

	@Override
	public List<Order> findAllById(Iterable<Long> ids) {
		return orderDAO.findAllById(ids);
	}

	@Override
	public <S extends Order> List<S> saveAll(Iterable<S> entities) {
		return orderDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		orderDAO.flush();
	}

	@Override
	public <S extends Order> S saveAndFlush(S entity) {
		return orderDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
		return orderDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderDAO.findAll(example, pageable);
	}

	@Override
	public Order findById(Long id) {
		return orderDAO.findById(id).get();
	}

	@Override
	public void deleteInBatch(Iterable<Order> entities) {
		orderDAO.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return orderDAO.existsById(id);
	}

	@Override
	public <S extends Order> long count(Example<S> example) {
		return orderDAO.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Order> entities) {
		orderDAO.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Order> boolean exists(Example<S> example) {
		return orderDAO.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		orderDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return orderDAO.count();
	}

	@Override
	public void deleteAllInBatch() {
		orderDAO.deleteAllInBatch();
	}

	@Override
	public void deleteById(Long id) {
		orderDAO.deleteById(id);
	}

	@Override
	public Order getOne(Long id) {
		return orderDAO.getOne(id);
	}

	@Override
	public void delete(Order entity) {
		orderDAO.delete(entity);
	}

	@Override
	public Order getById(Long id) {
		return orderDAO.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		orderDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		orderDAO.deleteAll(entities);
	}

	@Override
	public Order getReferenceById(Long id) {
		return orderDAO.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		orderDAO.deleteAll();
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example) {
		return orderDAO.findAll(example);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
		return orderDAO.findAll(example, sort);
	}

	@Override
	public List<Order> findbyUsername(String username) {

		return orderDAO.findbyUsername(username);
	}




}










