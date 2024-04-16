package com.example.demo.Controllers;


import com.example.demo.dao.*;
import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    private final InventoryDAO inventoryDAO;
    private final PersonDAO personDAO;
    private final ReviewsDAO reviewsDAO;

    private final PromotionDAO promotionDAO;
    private final EmployeeDAO employeeDAO;

    @GetMapping("/")
    public String mainPage(){
        return "MainPAge";
    }

    @Autowired
    public MainController(InventoryDAO inventoryDAO, PersonDAO personDAO, ReviewsDAO reviewsDAO, PromotionDAO promotionDAO, EmployeeDAO employeeDAO){
        this.inventoryDAO = inventoryDAO;
        this.personDAO = personDAO;
        this.reviewsDAO = reviewsDAO;
        this.promotionDAO = promotionDAO;
        this.employeeDAO = employeeDAO;
    }
    @GetMapping("/inventoryPage")
    public String Inventory(Model model) {
        model.addAttribute("inventory", inventoryDAO.inventoryPage());
        return "InventoryPage";
    }

    @PostMapping("/addInventory")
    public String addInventory(@RequestParam("name") String name,
                               @RequestParam("type") String type,
                               @RequestParam("bladelength") String bladelength,
                               @RequestParam("price") String price) {
        int id = 0;
        Inventory inventory = new Inventory(id, name, type, bladelength, price);
        inventoryDAO.saveInventory(inventory);
        return "redirect:/inventoryPage";
    }

    @GetMapping("/editInventory/{id}")
    public String editInventoryForm(@PathVariable int id, Model model) {
        Inventory inventory = inventoryDAO.showInventory(id);
        model.addAttribute("inventory", inventory);
        return "editInventory";
    }

    @PostMapping("/editInventory/{id}")
    public String editInventory(@PathVariable int id, @ModelAttribute Inventory updatedInventory) {
        inventoryDAO.updateInventory(id, updatedInventory);
        return "redirect:/inventoryPage";
    }

    @GetMapping("/deleteInventory/{id}")
    public String deleteInventory(@PathVariable int id) {
        inventoryDAO.delete(id);
        return "redirect:/inventoryPage";
    }

    @GetMapping("/Persons")
    public String Persons(Model model) {
        model.addAttribute("persons", personDAO.index());
        return "Persons";
    }

    @PostMapping("/addPerson")
    public String addOrder(@RequestParam("username") String username,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {
        int id = 0;
        Person person = new Person(id, username, email, password);
        personDAO.save(person);
        return "redirect:/Persons";
    }

    @GetMapping("/editPerson/{id}")
    public String editPersonForm(@PathVariable int id, Model model) {
        Person person = personDAO.show(id);
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping("/editPerson/{id}")
    public String editPerson(@PathVariable int id, @ModelAttribute Person updatedPerson) {
        personDAO.update(id, updatedPerson);
        return "redirect:/Persons";
    }

    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id) {
        personDAO.delete(id);
        return "redirect:/Persons";
    }

    @GetMapping("/reviews")
    public String Reviews(Model model) {
        model.addAttribute("reviews", reviewsDAO.index());
        return "reviews";
    }

    @PostMapping("/addreviews")
    public String addOrder(@RequestParam("namecut") String namecut,
                           @RequestParam("clientname") String clientname,
                           @RequestParam("raiting") String raiting,
                           @RequestParam("comment") String comment) {
        int id = 0;
        Reviews reviews = new Reviews(id, namecut, clientname, raiting, comment);
        reviewsDAO.save(reviews);
        return "redirect:/reviews";
    }

    @GetMapping("/editreviews/{id}")
    public String editreviews(@PathVariable int id, Model model) {
        Reviews reviews = reviewsDAO.show(id);
        model.addAttribute("reviews", reviews);
        return "editreviews";
    }

    @PostMapping("/editreviews/{id}")
    public String editreviews(@PathVariable int id, @ModelAttribute Reviews updateReviews) {
        reviewsDAO.update(id, updateReviews);
        return "redirect:/reviews";
    }

    @GetMapping("/deletereviews/{id}")
    public String deletereviews(@PathVariable int id) {
        reviewsDAO.delete(id);
        return "redirect:/reviews";
    }

    @GetMapping("/promotion")
    public String Promotion(Model model) {
        model.addAttribute("promotion", promotionDAO.index());
        return "promotion";
    }

    @PostMapping("/addpromotion")
    public String addpromotion(@RequestParam("promotionname") String promotionname,
                           @RequestParam("promotiontime") String promotiontime,
                           @RequestParam("conditions") String conditions,
                           @RequestParam("pronocode") String pronocode) {
        int id = 0;
        Promotion promotion = new Promotion(id, promotionname, promotiontime, conditions, pronocode);
        promotionDAO.save(promotion);
        return "redirect:/promotion";
    }

    @GetMapping("/editpromotion/{id}")
    public String editpromotion(@PathVariable int id, Model model) {
        Promotion promotion = promotionDAO.show(id);
        model.addAttribute("promotion", promotion);
        return "editpromotion";
    }

    @PostMapping("/editpromotion/{id}")
    public String editreviews(@PathVariable int id, @ModelAttribute Promotion updatePromotion) {
        promotionDAO.update(id, updatePromotion);
        return "redirect:/promotion";
    }

    @GetMapping("/deletepromotion/{id}")
    public String deletepromotion(@PathVariable int id) {
        promotionDAO.delete(id);
        return "redirect:/promotion";
    }

    @GetMapping("/employee")
    public String Employee(Model model) {
        model.addAttribute("employee", employeeDAO.index());
        return "employee";
    }

    @PostMapping("/addpemployee")
    public String addemp(@RequestParam("name") String name,
                               @RequestParam("dolznost") String dolznost,
                               @RequestParam("zp") String zp,
                               @RequestParam("premiya") String premiya) {
        int id = 0;
        Employee employee = new Employee(id, name, dolznost, zp, premiya);
        employeeDAO.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/editemployee/{id}")
    public String editemployee(@PathVariable int id, Model model) {
        Employee employee = employeeDAO.show(id);
        model.addAttribute("employee", employee);
        return "editemployee";
    }

    @PostMapping("/editemployee/{id}")
    public String editemployee(@PathVariable int id, @ModelAttribute Employee updateEmployee) {
        employeeDAO.update(id, updateEmployee);
        return "redirect:/employee";
    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteemployee(@PathVariable int id) {
        employeeDAO.delete(id);
        return "redirect:/employee";
    }
}
