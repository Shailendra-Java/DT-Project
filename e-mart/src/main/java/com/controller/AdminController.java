
package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDao;
import com.dao.ProductsDao;
import com.dao.SupplierDao;
import com.model.Category;
import com.model.Products;
import com.model.Supplier;


@Controller
@RequestMapping("/admin")
public class AdminController
{

	@Autowired
	SupplierDao supplierDaoImpl;
	
	@Autowired
	CategoryDao categoryDaoImpl;
	
	@Autowired
	ProductsDao productDaoImpl;
	
	@RequestMapping(value="/adding", method= {RequestMethod.GET, RequestMethod.POST})
	public String adding()
	{
		return "AdminAdding";
	}
	
	@RequestMapping(value="/saveSupp", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveSuppData(@RequestParam("sid")String sId, @RequestParam("sname")String sname)
	{
		ModelAndView modelAndView = new ModelAndView();
		Supplier suplier = new Supplier();
		suplier.setsId(sId);
		suplier.setSupplierName(sname);
		supplierDaoImpl.insertSupplier(suplier);
		modelAndView.setViewName("status");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/saveCat", method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveCatData(@RequestParam("cid")String cid, @RequestParam("cname")String cname)
	{
		ModelAndView modelAndView = new ModelAndView();
		Category category = new Category();
		category.setCid(cid);
		category.setCategoryName(cname);
		categoryDaoImpl.insertCategory(category);
		modelAndView.setViewName("status");
		return modelAndView;
	}
	
	@RequestMapping(value="/saveProduct", method= RequestMethod.POST)
	public String saveProd(HttpServletRequest request, @RequestParam("file")MultipartFile file)
	{
		Products product = new Products();
		product.setProductName(request.getParameter("productName"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setDescription(request.getParameter("description"));
		product.setStock(Integer.parseInt(request.getParameter("stock")));
		product.setCategory(categoryDaoImpl.findByCatId(request.getParameter("pCategory")));
		product.setSupplier(supplierDaoImpl.findBySupplierId(request.getParameter("pSupplier")));

		String filepath = request.getSession().getServletContext().getRealPath("/"); 
		String filename = file.getOriginalFilename();
		product.setImgName(filename);
		productDaoImpl.insertProduct(product);

		System.out.println("File path"+ filepath);

		try{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));

			fos.write(imagebyte);
			fos.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return "status";
	}
			
	@ModelAttribute
	public void loadingDataInPage(Model model){
		model.addAttribute("satList", supplierDaoImpl.retrieve());
		model.addAttribute("catList", categoryDaoImpl.retrieve());
		model.addAttribute("prodList", productDaoImpl.retrieve());
	}
		
	@RequestMapping("/productList")
	public ModelAndView prodlist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("prodList", productDaoImpl.retrieve());	
		modelAndView.setViewName("productAdminList");
		return modelAndView;
	}

	@RequestMapping("/supplierList")
	public ModelAndView supplist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("satList", supplierDaoImpl.retrieve());
		modelAndView.setViewName("supplierAdminList");
		return modelAndView;
	}
			
	@RequestMapping("/categoryList")
	public ModelAndView catlist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("catList", categoryDaoImpl.retrieve());
		modelAndView.setViewName("categoryAdminList");
		return modelAndView;
	}
			
	@RequestMapping("/deleteProd/{pid}")
	public String deleteProduct(@PathVariable("pid")int pid){
		productDaoImpl.deleteProduct(pid);
		return "redirect:/productList?del";
	}
			
	@RequestMapping("/updateProd")
	public ModelAndView updateproduct(@RequestParam("pid") int pid){
				
		ModelAndView modelAndView = new ModelAndView();
		Products product = productDaoImpl.findByProductId(pid);
		modelAndView.addObject("prod", product);
		modelAndView.addObject("cList", categoryDaoImpl.retrieve());
		modelAndView.addObject("sList",supplierDaoImpl.retrieve());
		modelAndView.setViewName("updateProduct");
		return modelAndView;
	}
				
	@RequestMapping(value="/productUpdate", method= RequestMethod.POST)
	public String updateProd(HttpServletRequest request, @RequestParam("file")MultipartFile file){
				
		String pid = request.getParameter("pid");
		Products product = new Products();
		product.setProductId(Integer.parseInt(pid));

		product.setProductName(request.getParameter("pName"));
		product.setPrice(Float.parseFloat(request.getParameter("pPrice")));
		product.setDescription(request.getParameter("pDescription"));
		product.setStock(Integer.parseInt(request.getParameter("pStock")));

		String category = request.getParameter("pCategory");
		String supplier = request.getParameter("pSupplier");

		product.setCategory(categoryDaoImpl.findByCatId(category));
		product.setSupplier(supplierDaoImpl.findBySupplierId(supplier));

		String filepath = request.getSession().getServletContext().getRealPath("/"); 
		String filename = file.getOriginalFilename();
		product.setImgName(filename);
		productDaoImpl.update(product);

		System.out.println("File path"+ filepath);

		try{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));

			fos.write(imagebyte);
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return "redirect:/productList?update";
	}
			
}
