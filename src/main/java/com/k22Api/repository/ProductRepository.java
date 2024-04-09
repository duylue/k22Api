package com.k22Api.repository;

import com.k22Api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p.*, c.cname ,s.sname\n" +
            "from  product p, category c, status s\n" +
            "where p.cid = c.cid and s.sid = p.sid order by p.pid desc", nativeQuery = true)
    List<Map<String, Object>> getlist();

    @Query(value = "select p.*, c.cname ,s.sname\n" +
            "from  product p, category c, status s\n" +
            "where p.cid = c.cid and s.sid = p.sid and p.pid = ? ", nativeQuery = true)
  Map<String, Object> getProductDetail(int id);
    @Query(value = "select p.*, c.cname ,s.sname\n" +
            "from  product p, category c, status s\n" +
            "where p.cid = c.cid and s.sid = p.sid ? ", nativeQuery = true)
    Map<String, Object> getProductDetail(String id);
    List<Product> findByPidAndPname(int id, String pname);
    List<Product> findProductByPname(String pname);
    @Query(value = "select * from product where pid = :id and  cid = :cid and sid = :sid and pid = :id ",nativeQuery = true)
    Product findByPidAndPnameQuery(@Param("id") int id,@Param("cid") int cid, @Param("sid") int sid);

}
