package az.coders.grouppersonal.dao.repository;

import az.coders.grouppersonal.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "select * from product where " +
            "name like :name " +
            "and createad_at after :createdAt " +
            "and price < :price", nativeQuery = true)
    List<ProductEntity> findAllByNameLikeAndCreatedAtAfterAndPriceLessThan(String name,
                                                                           LocalDateTime createdAt,
                                                                           BigDecimal price);
}