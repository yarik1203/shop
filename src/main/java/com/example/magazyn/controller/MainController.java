package com.example.magazyn.controller;


import com.example.magazyn.model.Account;
import com.example.magazyn.model.BankAccount;
import com.example.magazyn.model.Order;
import com.example.magazyn.model.Product;
import com.example.magazyn.repository.*;
import com.example.magazyn.service.AccountService;
import com.example.magazyn.service.BankAccountService;
import com.example.magazyn.service.OrderSerivce;
import com.example.magazyn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("main")
public class MainController {

    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final BankAccountService bankAccountService;
    private final BankAccountRepository bankAccountRepository;
    private final CategoryRepository categoryRepository;
    private final DiscountRepository discountRepository;
    private final OrderSerivce orderSerivce;
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public MainController(AccountService accountService, AccountRepository accountRepository,
                          BankAccountService bankAccountService, BankAccountRepository bankAccountRepository,
                          CategoryRepository categoryRepository, DiscountRepository discountRepository,
                          OrderSerivce orderSerivce, OrderRepository orderRepository,
                          ProductService productService, ProductRepository productRepository) {

        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.bankAccountService = bankAccountService;
        this.bankAccountRepository = bankAccountRepository;
        this.categoryRepository = categoryRepository;
        this.discountRepository = discountRepository;
        this.orderSerivce = orderSerivce;
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.productRepository = productRepository;

    }

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody Account account) {

        accountRepository.save(account);

        HttpHeaders httpHeaders = new HttpHeaders();
        return ResponseEntity.ok().headers(httpHeaders).body("Account created");
    }

    @PostMapping("/add_money/{bankAccountId}")
    public ResponseEntity<String> createUser(@RequestBody int bankAccountId, int sum) {

        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId);
        bankAccountService.addMoney(sum);
        bankAccountRepository.save(bankAccount);
        HttpHeaders httpHeaders = new HttpHeaders();
        return ResponseEntity.ok().headers(httpHeaders).body("Money added");

    }

    @GetMapping("list/{categoryId}")
    public Page<Product> getAllProductsByCategoryId(@PathVariable(value = "categoryId") int categoryId,
                                                    @PageableDefault(size = 15, sort = "id") Pageable pageable) {
        return productRepository.findByCategoryId(categoryId, pageable);
    }


    @PostMapping("/pay")
    public ResponseEntity<String> payProducts(@RequestBody Account account, Product product) {

        Order order = new Order();
        order.setAccount(account);
        order.setProduct(product);

        orderRepository.save(order);

        HttpHeaders httpHeaders = new HttpHeaders();
        return ResponseEntity.ok().headers(httpHeaders).body("Pay for products");
    }

}
