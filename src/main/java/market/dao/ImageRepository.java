package market.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import market.domain.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
