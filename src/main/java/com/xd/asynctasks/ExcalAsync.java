package com.xd.asynctasks;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @description: 关于excal的导入导出的方法
 * @author: xudong
 * @email: 15673687783@163.com
 * @date: 2022/8/21 23:22
 */
@Component
@Slf4j
public class ExcalAsync {
    /**
     * @param path
     */
    @Async
    public void excalExport(String path, String headerRow, Collection collection) {
        FileUtil.del(new File(path));
        List<List<String>> rows = CollUtil.newArrayList(collection);
        //通过工具类创建writer
        BigExcelWriter writer = ExcelUtil.getBigWriter(path);
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //合并单元格后的标题行，使用默认标题样式
        writer.merge(collection.size() - 1, headerRow);
        //一次性写出内容，强制输出标题
        writer.write(rows, true);
        //关闭writer，释放内存
        writer.close();
        excalToLead("12",null);
    }

    /**
     * 读取excal文件
     * @param path 文件路径
     * @param aClass 映射的实体类 为空则返回
     * @return
     */
    public  Collection excalToLead(String path,Class aClass) {
        if (!FileUtil.exist(new File(path))) {
            log.info("该路径不存在该文件");
        }
        ExcelReader reader = ExcelUtil.getReader(path);
        List list = reader.readAll(aClass);
        return list;
    }

    /**
     * 读取excal文件
     * @param path 文件路径
     * @return
     */
    public  Collection excalToLead(String path) {
        if (!FileUtil.exist(new File(path))) {
            log.info("该路径不存在该文件");
        }
        ExcelReader reader = ExcelUtil.getReader(path);
        List<Map<String, Object>> list = reader.readAll();
        return list;
    }
}
