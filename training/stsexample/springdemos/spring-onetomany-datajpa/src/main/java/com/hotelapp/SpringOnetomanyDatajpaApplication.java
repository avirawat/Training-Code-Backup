package com.hotelapp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.model.Hotel;
import com.hotelapp.model.Menu;
import com.hotelapp.service.IHotelService;
import com.hotelapp.service.IMenuService;

@SpringBootApplication
public class SpringOnetomanyDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetomanyDatajpaApplication.class, args);
	}

	@Autowired
	IHotelService hotelService;
	
	@Autowired
	IMenuService menuService;

	public void setHotelService(IHotelService hotelService) {
		this.hotelService = hotelService;
	}

	@Override
	public void run(String... args) throws Exception {
		// add
//	Menu menu1=new Menu("fried rice","breakfast","SI",80);
//	Menu menu2=new Menu("pinapple","starters","NI",30);
//	Menu menu3=new Menu("kaju-Katli","dessert","Indian",120);
//	Set<Menu> menuList=new HashSet(Arrays.asList(menu1,menu2,menu3));
//	Hotel hotel=new Hotel("President-Dhaba","veg","Hitechcity",4.6,menuList);
//	hotelService.addHotel(hotel);
//		System.out.println("-------Get All hotel with menu----");
//		hotelService.getAll().forEach(System.out::println);
//
//		System.out.println("-------Get All hotel with Name/city/MenuList----");
//		hotelService.getAll().stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------update any Value Hotel By Hotel ID----");
//		Hotel onHotel = hotelService.getById(102);
//		//System.out.println(onHotel);
//		onHotel.setRating(3.0);
//		//hotelService.updateHotel(onHotel);
//		
//		Set<Menu>menuList=onHotel.getMenuList();
//		for(Menu menu:menuList) {
//			String menuName=menu.getMenuName();
//			if(menuName.equals("fried rice")) {
//				menu.setMenuName("paneer tikka");
//				menu.setPrice(110);
//			}
//		}
//		onHotel.setMenuList(menuList);
//		//hotelService.updateHotel(onHotel);
//		
//		System.out.println("-------Add new Menu Of Hotel By Hotel ID----");
//		Hotel newMenu = hotelService.getById(102);
//		Menu menu1 = new Menu("Paratha","breakfast","NI",90);
//		Menu menu2 = new Menu("Ice cream","desserts","NI",90);
//		Set<Menu>addMenuList = newMenu.getMenuList();
//		addMenuList.add(menu1);
//		addMenuList.add(menu2);
//		newMenu.setMenuList(addMenuList);
//		hotelService.updateHotel(newMenu);
//	
//		
//		System.out.println("-------Get By city----");
//		hotelService.getByCity("Hyderabad").stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Type----");
//		hotelService.getByCity("veg").stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Type----");
//		hotelService.getByRating(4.5).stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Menu Name----");
//		hotelService.getByMenuName("Dosa").stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Menu And type----");
//		hotelService.getByMenuAndType("Idaly", "breakfast").stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Cuisine----");
//		hotelService.getByCuisine("SI").stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Menu Type----");
//		hotelService.getByMenuType("breakfast").stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Cuisine And type----");
//		hotelService.getByCuisineAndType("NI", "veg").stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//
//		System.out.println("-------Get By Menu Name And Less Price----");
//		hotelService.getByMenuNameLessPrice("pinapple", 50).stream().forEach((nhotel) -> {
//			System.out.println(nhotel.getName());
//			System.out.println(nhotel.getCity());
//			System.out.println(nhotel.getMenuList());
//		});
//		
		System.out.println("-------Get By Hotel Name----");
		menuService.findByHotel("Ibis").stream().forEach((nhotel) -> {
			System.out.println(nhotel.getMenuName());
			System.out.println(nhotel.getMenuType());
			System.out.println(nhotel.getPrice());
			System.out.println(nhotel.getCuisine());
		});
	 
		System.out.println("-------Get By Hotel And Cuisine----");
		menuService.findByHotelAndCuisine("Ibis","SI").stream().forEach((nhotel) -> {
			System.out.println(nhotel.getMenuName());
			System.out.println(nhotel.getMenuType());
			System.out.println(nhotel.getPrice());
			System.out.println(nhotel.getCuisine());
		});
	}

}
