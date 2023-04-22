package com.example.KMA.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.KMA.mapper.ProductMapper;
import com.example.KMA.model.Product;
import com.example.KMA.model.ProductExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ch.qos.logback.core.util.FileUtil;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductMapper productMapper;
	@Autowired
	private SqlSession sqlSession;
	ProductExample example = new ProductExample();

	public List<Product> listAll() {
		return productMapper.selectByExample(example);
	}

	public void save(Product product , MultipartFile imageFile) throws IOException {
		 // Lưu ảnh vào thư mục trên server
		String imageName = imageFile.getOriginalFilename();
		File imageFileOnDisk = new File("src/main/resources/static/images/"+ imageName);
		FileUtils.writeByteArrayToFile(imageFileOnDisk, imageFile.getBytes());
		//laays duong dan cua anh va luu vao doi tuong product
		String imagePathString ="/images/"+ imageName;
		product.setImage(imagePathString);
		productMapper.insertSelective(product);
	}

	public Product get(int id) {
		return productMapper.selectByPrimaryKey(id);
	}

	// chuc nang xoa san pham
	public void delete(int id) {
		productMapper.deleteByPrimaryKey(id);
	}

	public ProductService(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	public List<Product> getProducts(int page) {
		int pageSize = 4;
		int offset = (page - 1) * pageSize;

		PageHelper.startPage(page, pageSize);
		List<Product> products = productMapper.findAllWithLimit(offset, pageSize);

		PageInfo<Product> pageInfo = new PageInfo<>(products);
		long totalItems = pageInfo.getTotal();
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		return products;
	}

	public long getTotalProducts() {
		return productMapper.count(); // Assumes that ProductMapper has a method called countAll() that returns the
										// total number of products
	}

};
