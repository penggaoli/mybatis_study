package com.bes.mapper;

import com.bes.pojo.Blog;
import javafx.beans.binding.ObjectExpression;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int insertBlog(Blog blog);

    List<Blog> getBlogs(Map<String, Object> blogParams);

    List<Blog> getBlogs2(Map<String, Object> blogParams);

    int updateBlogs(Map<String, Object> blogParams);

    List<Blog> getBlogs3(Map<String, Object> blogParams);

    List<Blog> getBlogsByIds(List<String> blogIds);
}
