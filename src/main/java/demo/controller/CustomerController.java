package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import demo.model.Customer;
import demo.repository.CustomerRepository;
@Controller
public class CustomerController {

	//สร้าง object Repository สำหรับเรียกใช้ในคลาส 
	//Dependency injection
	@Autowired
	private CustomerRepository customerRepository;

	
	@GetMapping("/customers")//ใช้แสดงข้อมูลลูกค้าทั้งหมด
	public String getCustomerList(Model model) {
		List<Customer> customerList = customerRepository.findAll();
		model.addAttribute("customerList",customerList);
		return "/list";
	}
	
	@GetMapping("/customer/{id}")//ใช้แสดงลูกค้า 1 คนตามรหัส
	public String getCustomer(@PathVariable Integer id,Model model) {
		Customer customer = customerRepository.findById(id);
		model.addAttribute("customer",customer);
		return "/detail";

	}
	
	@PostMapping("/customer/create")//ใช้เพิ่มข้อมูลลูกค้า
	public String create(@ModelAttribute Customer customer,Model model) {
		customerRepository.save(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/customer/editform/{id}")
	public String load(@PathVariable Integer id,Model model) {
		Customer customer = customerRepository.findById(id);
		model.addAttribute("customer", customer);
		return "/edit-form";
	}
	
	@PostMapping("/customer/edit")
	public String update(@ModelAttribute Customer editCustomer,Model model) {
		Customer oldCustomer = customerRepository.findById(editCustomer.getId());
		oldCustomer.setFirstName(editCustomer.getFirstName());
		oldCustomer.setLastName(editCustomer.getLastName());
		customerRepository.save(oldCustomer);
		return "redirect:/customers";
	}
	
	@GetMapping("/customer/delete/{id}")
	public String delete(@PathVariable Integer id) {
		customerRepository.delete(id);
		return "redirect:/customers";
	}
}
