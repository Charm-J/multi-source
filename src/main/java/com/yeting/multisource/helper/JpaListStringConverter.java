package com.yeting.multisource.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Converter
public class JpaListStringConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> meta) {
        return JSON.toJSONString(CollectionUtils.isEmpty(meta) ? Collections.emptyList() : meta);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return StringUtils.isBlank(dbData) ? new ArrayList<>() : JSON.parseObject(dbData, new TypeReference<List<String>>() {
        });
    }
}
