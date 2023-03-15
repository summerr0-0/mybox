package com.numble.mybox.common.controller.response;


public record Paging(Long totalCount, Integer currentPage, Integer perPage, Integer totalPage) {
}
