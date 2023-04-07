package com.example.KMA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.KMA.mapper.ProductMapper;
import com.example.KMA.model.Product;
import com.example.KMA.model.ProductExample;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductMapper productMapper;
	ProductExample example =new ProductExample();
	public List<Product> listAll(){
		return productMapper.selectByExample(example);
	}
	public void save(Product product) {
		productMapper.insertSelective(product);
	}
	public Product get(int id)
	{
		return productMapper.selectByPrimaryKey(id);
	}
	//chuc nang xoa san pham
	public void delete(int id)
	{
		productMapper.deleteByPrimaryKey(id);	}

}
