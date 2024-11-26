package lab.BaiTap.__11.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.BaiTap.__11.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
