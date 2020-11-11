package com.bes.mapper;

import com.bes.pojo.Blog;
import com.bes.utils.IdUtils;
import com.bes.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {
    @Test
    public void insertBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("大家一起学习");
        blog.setAuthor("彭小弟123");
        blog.setCreateTime(new Date());
        blog.setViews(2345);
        blogMapper.insertBlog(blog);
        sqlSession.close();
    }

    @Test
    public void getBlogs() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> blogsParams = new HashMap<String, Object>();
        blogsParams.put("author", "彭高历");
        blogsParams.put("title", "日");
        List<Blog> blogs = blogMapper.getBlogs(blogsParams);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void getBlogs2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> blogsParams = new HashMap<String, Object>();
        blogsParams.put("author", "彭高历");
        blogsParams.put("title", "%高兴%");
        List<Blog> blogs = blogMapper.getBlogs2(blogsParams);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void getBlogs3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> blogsParams = new HashMap<String, Object>();
        blogsParams.put("author", "彭高历");
//        blogsParams.put("title", "日");
        blogsParams.put("views", 1000);
        List<Blog> blogs = blogMapper.getBlogs3(blogsParams);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlogs() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> blogsParams = new HashMap<String, Object>();
        blogsParams.put("author", "12345");
        blogsParams.put("title", "let's go home!");
        blogsParams.put("id", "1");
        int result = blogMapper.updateBlogs(blogsParams);
        sqlSession.close();
    }

    @Test
    public void getBlogsByIds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<String> blogIds = new ArrayList<String>();
        blogIds.add("1");
        blogIds.add("2");
        blogIds.add("3");
        List<Blog> blogs = blogMapper.getBlogsByIds(blogIds);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
