package lab.BaiTap.__11.Resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import lab.BaiTap.__11.Repository.CategoryRepository;
import lab.BaiTap.__11.entity.Category;

@Component
public class CategoryResolver {
    private final CategoryRepository categoryRepository;

    public CategoryResolver(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @QueryMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
