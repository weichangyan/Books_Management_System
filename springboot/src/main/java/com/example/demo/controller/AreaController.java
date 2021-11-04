package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wcy
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    @Resource
    private AreaService areaService;

    @GetMapping("/tree")
    public Result<?> findAll() {
        List<Area> areas = areaService.list(null);
        // 第一级
        List<Area> pNodeList = areas.stream().filter(area -> area.getPid() == null).collect(Collectors.toList());
        for (Area area : pNodeList) {
            Integer pid = area.getId();
            // 第二级
            List<Area> secondNodeList = areas.stream().filter(a -> pid.equals(a.getPid())).collect(Collectors.toList());
            area.setChildren(secondNodeList);

            // 第三级
            for (Area secondArea : secondNodeList) {
                Integer secondPid = secondArea.getId();
                List<Area> thirdNodeList = areas.stream().filter(a -> secondPid.equals(a.getPid())).collect(Collectors.toList());
                secondArea.setChildren(thirdNodeList);
            }
        }
        return Result.success(pNodeList);
    }
}

