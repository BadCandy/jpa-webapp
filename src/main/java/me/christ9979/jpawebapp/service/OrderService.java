package me.christ9979.jpawebapp.service;

import me.christ9979.jpawebapp.domain.OrderSearch;
import me.christ9979.jpawebapp.entity.*;
import me.christ9979.jpawebapp.repository.MemberRepository;
import me.christ9979.jpawebapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemService itemService;

    public Long order(Long memberId, Long itemId, int count) {

        Member member = memberService.findOne(memberId);
        Item item = itemService.findOne(itemId);

        Delivery delivery = new Delivery(member.getAddress());
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.fineOne(orderId);
        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
}
