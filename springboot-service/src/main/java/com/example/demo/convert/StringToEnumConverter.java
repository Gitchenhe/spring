package com.example.demo.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by chenhe on 2018/3/5.
 */
public class StringToEnumConverter implements Converter<String, GenderEnum> {

    Logger LOGGER = LoggerFactory.getLogger(StringToEnumConverter.class);

    @Override
    public GenderEnum convert(String s) {
        LOGGER.info("convert {} to enum",s);
        if (GenderEnum.get(s) != null){
            return GenderEnum.get(s);
        }else {
            LOGGER.warn("没有发现相应枚举类型");
            return null;
        }
    }
}
