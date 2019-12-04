package com.check.datacheck.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.check.datacheck.constants.DataSetConstant;
import com.check.datacheck.dao.DataSetMapper;
import com.check.datacheck.model.DataSet;
import com.check.datacheck.model.dto.RespDto;
import com.check.datacheck.service.DataSetService;
import com.check.datacheck.utils.RespHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢森
 * @Description 数据集服务接口实现类
 * @className com.check.datacheck.service.impl.DataSetServiceImpl
 * @Email xiesen@zork.com.cn
 * @Date 2019/12/4 9:55 星期三
 */
@Service
public class DataSetServiceImpl extends ServiceImpl<DataSetMapper, DataSet> implements DataSetService {
    @Autowired
    private DataSetMapper dataSetMapper;

    @Override
    public RespDto selectByName(String name) {
        String columnName = "name";
        QueryWrapper<DataSet> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like(columnName, name);
        }
        List<DataSet> dataSetList = dataSetMapper.selectList(queryWrapper);
        return RespHelper.ok(dataSetList);
    }

    @Override
    public RespDto deleteById(Long id) {
        int rows = dataSetMapper.deleteById(id);
        if (rows >= 1) {
            return RespHelper.ok(rows, "删除 id 为 " + id + " 数据集成功");
        }
        return RespHelper.fail(DataSetConstant.DATASET_DELETE_FAIL, "数据集删除失败");
    }

    @Override
    public RespDto createDataSet(DataSet dataSet) {
        String name = dataSet.getName();
        if (ObjectUtil.isNotNull(name)) {
            // 判断数据集名称是否存在
            Boolean isExist = checkNameIsExist(name);
            if (!isExist) {
                int rows = dataSetMapper.insert(dataSet);
                if (rows > 0) {
                    return RespHelper.ok(rows, "创建数据集成功");
                } else {
                    return RespHelper.fail(DataSetConstant.DATASET_INSERT_FAIL, "数据集插入失败");
                }
            } else {
                return RespHelper.fail(DataSetConstant.DATASET_NAME_IS_EXIST, "数据集名称已存在");
            }

        }
        return RespHelper.fail(DataSetConstant.DATASET_NAME_IS_NULL, "数据集名称不能为空");
    }

    @Override
    public Boolean checkNameIsExist(String name) {
        DataSet dataSet = dataSetMapper.selectByName(name);
        if (null == dataSet) {
            return false;
        }
        return true;
    }

    @Override
    public RespDto selectById(Long id) {
        if (ObjectUtil.isNotNull(id)) {
            DataSet dataSet = dataSetMapper.selectById(id);
            if (ObjectUtil.isNotNull(dataSet)) {
                return RespHelper.ok(dataSet);
            } else {
                return RespHelper.fail(DataSetConstant.DATASET_ID_NOT_EXIST, "数据集 ID " + id + " 不存在");
            }
        } else {
            return RespHelper.fail(DataSetConstant.DATASET_ID_IS_NULL, "数据集 ID 不能为空");
        }
    }
}