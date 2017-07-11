package com.pb.controller;

import javax.annotation.Resource;

import com.pb.services.admin.AdminService;
import com.pb.services.applicationTable.TableService;
import com.pb.services.cart.CartsService;
import com.pb.services.item.ItemService;
import com.pb.services.template.TemplateService;
import com.pb.services.testService.TestService;
import com.pb.services.userRelated.InstitutionService;
import com.pb.services.userRelated.UserService;
import com.pb.services.users.UserRelatedService;
import com.pb.services.orders.OrdersService;
import com.pb.services.projectRelated.ProjectService;

public class BaseController {

    @Resource
    public InstitutionService institutionService;
    @Resource
    public TableService tableService;
    @Resource
    public TemplateService templateService;
    @Resource
    public ProjectService projectService;
    @Resource
    public UserService userService;
    @Resource
    public TestService testService;
    @Resource
    public UserRelatedService userRelatedService;
    @Resource
    public CartsService cartsService;
    @Resource
    public ItemService itemService;
    @Resource
    public OrdersService ordersService;
    @Resource
    public AdminService adminService;
}
