package com.zed.dingtalk.util;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.collection.CollUtil;

import java.lang.reflect.Method;
import java.util.*;

public class BeanUtils {

	/**
	 * 将 bean 转化为 MultiValuMap
	 *
	 * @param bean
	 * @return
	 */
	public static Map<String, List<Object>> BeanToMultiValueMap(Object bean) {
		Map<String, List<Object>> targetMap = new LinkedHashMap();
		if (bean == null) {
			return null;
		}

		final Collection<BeanDesc.PropDesc> props = cn.hutool.core.bean.BeanUtil.getBeanDesc(bean.getClass()).getProps();

		String key;
		Method getter;
		Object value = null;
		for (BeanDesc.PropDesc prop : props) {
			key = prop.getFieldName();
			// 过滤class属性
			// 得到property对应的getter方法
			getter = prop.getGetter();
			if (null != getter) {
				// 只读取有getter方法的属性
				try {
					value = getter.invoke(bean);
				} catch (Exception ignore) {
					continue;
				}
			}
			if (null != value && false == value.equals(bean)) {
				if (null != key) {
					if (value instanceof List) {
						value = CollUtil.join((List<String>) value, ",");
					}
					List values = new LinkedList();
					values.add(value);
					targetMap.put(key, values);
				}
			}
		}
		return targetMap;
	}
}
