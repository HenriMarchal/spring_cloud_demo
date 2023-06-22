package edu.marchal.scd_01_withoutspringcloud.dao;

import edu.marchal.scd_01_withoutspringcloud.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
