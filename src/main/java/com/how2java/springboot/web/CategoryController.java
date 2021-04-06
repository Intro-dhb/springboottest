package com.how2java.springboot.web;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.springboot.dao.CategoryDAO;
//import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category;
  
//@Controller

@RestController
public class CategoryController {
//	@Autowired CategoryMapper categoryMapper;
//    
//    @RequestMapping("/listCategory")
//    public String listCategory(Model m) throws Exception {
//        List<Category> cs=categoryMapper.findAll();
//          
//        m.addAttribute("cs", cs);
//          
//        return "listCategory";
//    }
    @Autowired CategoryDAO categoryDAO;
     
//    @RequestMapping("/listCategory")
//    public String listCategory(Model m) throws Exception {
//        List<Category> cs=categoryDAO.findAll();
//         
//        m.addAttribute("cs", cs);
//         
//        return "listCategory";
//    }
     
//    @RequestMapping("/listCategory")
//    @GetMapping("/categories")
    @GetMapping("/category")
    public String listCategory(Model m,@RequestParam(value="start",defaultValue="0")int start,@RequestParam(value="size",defaultValue="5")int size) {
    start=start<=0?0:start;
    Sort sort=new Sort(Sort.Direction.DESC,"id");
    Pageable pageable=new PageRequest(start,size,sort);
    Page<Category> page=categoryDAO.findAll(pageable);
    m.addAttribute("page",page);
    return "listCategory";
    }
    
////    @RequestMapping("/addCategory")
//    @PostMapping("/categories")
//    public String addCategory(Category c) throws Exception {
//    	categoryDAO.save(c);
////    	return "redirect:/listCategory";
//    	return "redirect:/categories";
//		    	
//    }
    
//    @RequestMapping("/editCategory")
//    public String getCategory(int id,Model m) throws Exception {
//    	Category c=categoryDAO.getOne(id);
//    	m.addAttribute("c",c);
//    	return "editCategory";
//		    	
//    }
    
//    @GetMapping("/categories/{id}")
//    public String getCategory(@PathVariable("id") int id,Model m) throws Exception {
//        Category c= categoryDAO.getOne(id);
//        m.addAttribute("c", c);
//        return "editCategory";
//    }
    
//    @RequestMapping("/deleteCategory")
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
    	categoryDAO.delete(c);
//    	return "redirect:/listCategory";
    	return "redirect:/categories";
		    	
    }
    
//    @RequestMapping("/updateCategory")
    @PutMapping("/categories/{id}")
    public String updateCategory(Category c) throws Exception {
    	categoryDAO.save(c);
//    	return "redirect:/listCategory";
    	return "redirect:/categories";
		    	
    }
    
    //JSON相关，替换了add和get方法
    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") int id) throws Exception {
        Category c= categoryDAO.getOne(id);
        System.out.println(c);
        return c;
    }
    @PutMapping("/category")
    public void addCategory(@RequestBody Category category) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }
    
}
