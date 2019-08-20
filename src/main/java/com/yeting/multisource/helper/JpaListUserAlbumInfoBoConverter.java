package com.yeting.multisource.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yeting.multisource.model.UserAlbumInfoBo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.List;

@Converter
public class JpaListUserAlbumInfoBoConverter implements AttributeConverter<List<UserAlbumInfoBo>, String> {

    @Override
    public String convertToDatabaseColumn(List<UserAlbumInfoBo> meta) {
        return JSON.toJSONString(CollectionUtils.isEmpty(meta) ? Collections.emptyList() : meta);
    }

    @Override
    public List<UserAlbumInfoBo> convertToEntityAttribute(String dbData) {
        return JSON.parseObject(StringUtils.isBlank(dbData) ? "[]" : dbData, new TypeReference<List<UserAlbumInfoBo>>() {
        });
    }
}
