package com.example.speedco.DAO.utils;

import com.example.speedco.DAO.specifications.UserSpecification;
import com.example.speedco.entities.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

public class SearchUtils {

    public static Specification<User> getSpec(UserFilter userFilter) {
        List<SearchCriteria> searchCriteria = userFilter.getSearchCriteria();
        if (searchCriteria == null || searchCriteria.isEmpty()) {
            return null;
        }
        List<UserSpecification> specifications = searchCriteria.stream()
                .map(UserSpecification::new).collect(Collectors.toList());
        Specification<User> finalSepc = specifications.get(0);
        for(int i = 1; i<specifications.size(); i++) {
            finalSepc = finalSepc.or(specifications.get(i));
        }
        return finalSepc;
    }
}
