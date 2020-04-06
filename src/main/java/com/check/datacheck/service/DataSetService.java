package com.check.datacheck.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.dto.RespDto;
import com.github.pagehelper.PageInfo;

/**
 * @author 谢森
 * @Description 数据集服务接口
 * @className com.check.datacheck.service.DataSetService
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/4 9:54 星期三
 */
public interface DataSetService extends IService<DataSet> {
    /**
     * 根据数据集名称查询
     *
     * @param name 数据集名称
     * @return
     */
    RespDto selectByName(String name);

    /**
     * 根据 ID 删除
     *
     * @param id ID
     * @return
     */
    RespDto deleteById(Long id);

    /**
     * 创建数据集
     *
     * @param dataSet 数据集对象
     * @return
     */
    RespDto createDataSet(DataSet dataSet);

    /**
     * 检查数据集名称是否存在
     *
     * @param name 数据集名称
     * @return
     */
    Boolean checkNameIsExist(String name);

    /**
     * 根据 ID 进行查询
     *
     * @param id ID
     * @return
     */
    RespDto selectById(Long id);

    /**
     * 更新数据集
     * @param dataSet
     * @return
     */
    int updateDataset(DataSet dataSet);

    /**
     * 分页查询
     *
     * @param pageNum  当前是第几页
     * @param pageSize 当前页一共几条记录
     * @return {@link PageInfo}
     */
    PageInfo<DataSet> searchByPage(int pageNum, int pageSize);

}
