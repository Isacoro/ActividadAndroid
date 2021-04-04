package com.isabel.actividadandroid.beans;

import java.util.List;

public class MovieApiResult {

    private List<Movie> results;
    private Integer page;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
