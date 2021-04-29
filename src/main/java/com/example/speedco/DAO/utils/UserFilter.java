package com.example.speedco.DAO.utils;

import java.util.List;

public class UserFilter {
    private List<SearchCriteria> searchCriteria;

    public List<SearchCriteria> getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(List<SearchCriteria> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public void addSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria.add(searchCriteria);
    }

}
