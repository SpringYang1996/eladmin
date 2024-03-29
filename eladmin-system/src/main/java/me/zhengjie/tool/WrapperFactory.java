package me.zhengjie.tool;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xieshuang
 * @date 2019-07-14 20:30
 */
public class WrapperFactory<T> {

    private Logger log = LoggerFactory.getLogger(WrapperFactory.class);

    public QueryWrapper<T> dtoToQueryWrapper(Object dto, Class<T> tClass){
        QueryWrapper wrapper = new QueryWrapper<T>();
        dtoToWrapper(wrapper, dto);
        return wrapper;
    }

    public void dtoToWrapper(QueryWrapper wrapper, Object dto){
        Class<?> dtoClass = dto.getClass();
        Field[] declaredFields = dtoClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //打开私有访问
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(dto);
            } catch (IllegalAccessException e) {
                log.error("通过反射获取属性值出错：" + e);
            }
            QueryCondition query = field.getAnnotation(QueryCondition.class);
            if (query != null) {
                if (!query.condition().equals(QueryCondition.Condition.DEFAULT) && value != null) {
                    switch (query.condition()) {
                        case EQ:
                            wrapper.eq(getColumnName(field), value);
                            break;
                        case IN:
                            wrapper.in(getColumnName(field), value);
                            break;
                        case LIKE:
                            wrapper.like(getColumnName(field), value);
                            break;
                        case GE:
                            wrapper.ge(getColumnName(field), value);
                            break;
                        case LE:
                            wrapper.le(getColumnName(field), value);
                            break;
                        default:
                    }
                }
                if (!query.sort().equals(QueryCondition.Sort.DEFAULT)) {
                    if (query.sort().equals(QueryCondition.Sort.DESC)) {
                        wrapper.orderByDesc(getColumnName(field));
                    } else if (query.sort().equals(QueryCondition.Sort.ASC)) {
                        wrapper.orderByAsc(getColumnName(field));
                    } else if (value != null) {
                        if (value.equals("asc") || value.equals("ASC") || value.equals(0)) {
                            wrapper.orderByAsc(getColumnName(field));
                        } else {
                            wrapper.orderByDesc(getColumnName(field));
                        }
                    }
                }
            }
        }
    }

    private String getColumnName(Field field){
        QueryCondition annotation = field.getAnnotation(QueryCondition.class);
        if (annotation.field().isEmpty()){
            return humpToLine(field.getName());
        }
        return annotation.field();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下换线
     * @param str
     * @return
     */
    private String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
