package com.cafe24.cat24.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.cat24.config.AppConfig;
import com.cafe24.cat24.vo.CategoriesVo;
import com.cafe24.config.web.TestWebConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class CategoriesDaoTest 
{
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private CategoriesDao categoriesdao;
	
	@Test
	@Transactional
	public void 카테고리등록테스트() 
	{
		CategoriesVo categoriesvo = new CategoriesVo();
		
		categoriesvo.setCategory_depth(0);
		categoriesvo.setParent_category_no(0);
		categoriesvo.setCategory_name("테스트");
		categoriesvo.setFull_category_name("테스트");
		categoriesvo.setFull_category_no("0");
		categoriesvo.setRoot_category_no(0);
		categoriesvo.setDisplay_order(0);
		categoriesvo.setReg_id("test");
		categoriesvo.setUpdate_id("test");
		
		Boolean test = categoriesdao.add(categoriesvo);
		
		assertEquals(test,true);

	}
}
