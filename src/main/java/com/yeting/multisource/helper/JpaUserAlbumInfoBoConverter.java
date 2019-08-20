package com.yeting.multisource.helper;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yeting.multisource.model.UserAlbumInfoBo;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JpaUserAlbumInfoBoConverter implements AttributeConverter<UserAlbumInfoBo, String> {

    @Override
    public String convertToDatabaseColumn(UserAlbumInfoBo meta) {
        return null == meta ? null : JSON.toJSONString(meta);
    }

    @Override
    public UserAlbumInfoBo convertToEntityAttribute(String dbData) {
        return StringUtils.isBlank(dbData) ? null : JSON.parseObject(dbData, new TypeReference<UserAlbumInfoBo>() {
        });
    }
}
