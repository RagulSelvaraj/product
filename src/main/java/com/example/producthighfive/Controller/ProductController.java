package com.example.producthighfive.Controller;
import com.example.producthighfive.DTO.UserDetailsDTO;
import com.example.producthighfive.Mapper.UserDetailsMapper;
import com.example.producthighfive.Model.UserDetails;
import com.example.producthighfive.Repository.ProductRepository;
import com.example.producthighfive.Service.ProductService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")


public class ProductController {
    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public UserDetails UserDetail(@RequestBody UserDetails userDetails){
      return  productService.saveproduct(userDetails);
  }

  @GetMapping("/map")
    public List<UserDetails> removeDuplicate(){
       return (List<UserDetails>) productService.removeDuplicate();
  }

  @GetMapping("/")
  public List<UserDetails> allProduct(){
      return (List<UserDetails>) productService.fetchProduct();
  }

  @DeleteMapping("/{id}")
  public String deleteById (@PathVariable("id") Long id){
            productService.deleteProductById(id);
            return "Delete Successfully";
  }

  @PutMapping("/{id}")
    public UserDetails updateByProduct(@RequestBody UserDetailsDTO userDetailsDTO, @PathVariable("id") Long id){
        return  productService.updateById(userDetailsMapper.DTOtoModel(userDetailsDTO),id);
  }

    @GetMapping("/{field}")
    public ResponseEntity<List<UserDetails>> sortUserDetailsByField(@PathVariable String field) {
        List<UserDetails> sortedUserDetails = productService.sortUserDetailsByField(field);
        return new ResponseEntity<>(sortedUserDetails, HttpStatus.OK);
    }

    @GetMapping("page/{offset}")
    public Page<UserDetails> pagination(@PathVariable("offset") int offset){
      return productService.pagination(offset);
    }

//    @GetMapping("/specification")
//    public List<UserDetails> specs(@RequestParam("column") String column, @RequestParam("value") String value) {
//        return productService.specification(column,value);
//    }



    @GetMapping("/spec")
    public ResponseEntity<List<UserDetails>> getUserDetails(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "price", required = false) String price
    ) {
        List<UserDetails> userDetails = productService.getUserDetailsByDetails(name, description, price);
        return ResponseEntity.ok(userDetails);
    }

}
