package com.jili.hadmin.controller;

import com.jili.hadmin.entity.SysMenu;
import com.jili.hadmin.json.ErrorMsg;
import com.jili.hadmin.json.TreeTableData;
import com.jili.hadmin.service.RoleUserService;
import com.jili.hadmin.service.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单权限表(SysMenu)表控制层
 *
 * @author makejava
 * @since 2019-03-08 13:24:58
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private RoleUserService roleUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysMenu selectOne(Integer id) {
        return this.sysMenuService.queryById(id);
    }

    @GetMapping("getMenuList")
    public Object getMenuList(){
        List<Object> list = new ArrayList<>();
        List<SysMenu> sysMenus = getSysMenus();
        if(ObjectUtils.isEmpty(sysMenus)){
            list.add(new ArrayList<>());
        }
        list.add(sysMenus);

        return list;
    }

    @GetMapping("gettreeMenuList")
    public Object gettreeMenuList(){
        List<SysMenu> sysMenus = getSysMenus();
        List<TreeTableData> dataList = new ArrayList<>();
        for(SysMenu sysMenu:sysMenus){
            TreeTableData data = new TreeTableData();
            data.setId(sysMenu.getId());
            data.setPid(sysMenu.getParentId());
            data.setTitle(sysMenu.getTitle());
            data.setUrl(sysMenu.getHref());
            if(sysMenu.getList().size() > 0){
                for(SysMenu child:sysMenu.getList()){
                    TreeTableData childdata = new TreeTableData();
                    childdata.setId(child.getId());
                    childdata.setTitle(child.getTitle());
                    childdata.setPid(child.getParentId());
                    childdata.setUrl(child.getHref());
                    dataList.add(childdata);
                }
            }
            dataList.add(data);
        }
        return dataList;
    }

    private List<SysMenu> getSysMenus() {
        List<SysMenu> sysMenus = new ArrayList<>();

        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("ROLE_ADMIN")) {
            sysMenus = sysMenuService.getMenuList(1);
        } else if (subject.hasRole("ROLE_USER")) {
            sysMenus = sysMenuService.getMenuList(2);
        }
        return sysMenus;
    }

    @PostMapping("addMenu")
    public Object addMenu(String title,Integer parent_id,String href,String icon,String menu_type,Integer sort){
        ErrorMsg msg = new ErrorMsg();
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("ROLE_ADMIN")){
            msg.setErrmsg("添加菜单");
            msg.setErrcode(0);
            SysMenu menu = new SysMenu();
            menu.setTitle(title);
            menu.setHref(href);
            menu.setParentId(parent_id);
            menu.setIcon(icon);
            menu.setMenuType(menu_type);
            menu.setSort(sort);
            msg.setData(this.sysMenuService.insert(menu));
        }else{
            msg.setData(null);
            msg.setErrcode(200);
            msg.setErrmsg("您没有添加的权限");
        }
        return msg;

    }

}