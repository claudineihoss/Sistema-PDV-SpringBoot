package com.pdv.service;

import com.pdv.dto.ProductDTO;
import com.pdv.dto.SaleDTO;
import com.pdv.entity.ItemSale;
import com.pdv.entity.Product;
import com.pdv.entity.Sale;
import com.pdv.entity.User;
import com.pdv.repository.ItemSaleRepository;
import com.pdv.repository.ProductRepository;
import com.pdv.repository.SaleRepository;
import com.pdv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    private final SaleRepository saleRepository;

    private final ItemSaleRepository itemSaleRepository;

    @Transactional
    public long save(SaleDTO saleDTO){
        User user=userRepository.findById(saleDTO.getUserid()).get();

        Sale newSale=new Sale();
        newSale.setUser(user);
        newSale.setDate(LocalDate.now());
        List<ItemSale> items=getItemSale(saleDTO.getItems());
        
        newSale =saleRepository.save(newSale);
        saveItemsSale(items,newSale);
        return newSale.getId();

    }


    private void saveItemsSale(List<ItemSale> items,Sale sale){
        for(ItemSale item:items){
            item.setSale(new Sale());
            itemSaleRepository.save(item);
        }
    }

    private List<ItemSale> getItemSale(List<ProductDTO> products){
        return products.stream().map(item->{
            Product product=productRepository.getReferenceById(item.getProductid());
            ItemSale itemSale=new ItemSale();
            itemSale.setProduct(product);
            itemSale.setQuantity(item.getQuantity());
            return itemSale;
        }).collect(Collectors.toList());
    }
}
